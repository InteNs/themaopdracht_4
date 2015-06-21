package listeners;

import domain.users.Customer;
import domain.users.Owner;
import domain.users.User;
import services.exceptions.ValidateException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.time.LocalDate;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerContextListener implements ServletContextListener {
    private String file;
    private ServletContext servletContext;
    private final Logger logger = Logger.getLogger("listener.SessionCounterListener");


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // Set servlet context
        servletContext = servletContextEvent.getServletContext();

        // Get real path
        file = servletContext.getRealPath("/")+"data.obj";

        // Create file
        new File(file);
        // Initialize logger
        try{
            FileHandler fh = new FileHandler(servletContext.getRealPath("/")+"blogLog.xml", true);
            logger.addHandler(fh);
        } catch (IOException ioe) { ioe.printStackTrace(); }
        logger.setLevel(Level.ALL);
        logger.info("Logger initialized");

        try {
            logger.info("reading data...");
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file));
            servletContext.setAttribute("data", reader.readObject());
            reader.close();
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        if (servletContext.getAttribute("data") == null){
            logger.warning("no data object found, making a new one...");
            servletContext.setAttribute("data", new Data());
        }
        else {
            logger.info("data found, loading...");
            for (User user:((Data)servletContext.getAttribute("data")).getUserController().getUsers()){
                if(user instanceof Customer){
                    System.out.println("Customer: "+user+" has "+((Customer) user).getCars().size()+" cars");
                }
                if (user instanceof Owner)
                    System.out.println("Owner: "+user.getEmail()+" - "+user.getPassword());
            }

        }
        if (((Data)servletContext.getAttribute("data")).getUserController().findUser("admin@admin.nl")==null)
            try {
                ((Data)servletContext.getAttribute("data")).getUserController().newOwner("admin@admin.nl", "admin@admin.nl", "admin", "admin", "admin", LocalDate.of(1990, 11, 10), "admin", "1111AA", "0000000");
                logger.info("admin account created");
            } catch (ValidateException ignored) {}
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));
            writer.writeObject(servletContext.getAttribute("data"));
            logger.info("data saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Destroy logger
        for(Handler handler : logger.getHandlers()){
            handler.close();
        }

    }
}
