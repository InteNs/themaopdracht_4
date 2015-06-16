package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by InteNs on 04.jun.2015.
 */
public class ServerContextListener implements ServletContextListener {
    private String file, errorLogFile;
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

        // Read object file
        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file));
            servletContext.setAttribute("data", reader.readObject());
            reader.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (servletContext.getAttribute("data") == null){
            System.out.println("no data object found, making a new one...");
                servletContext.setAttribute("data",new Data());
        }
        else System.out.println("data found, loading...");

        if (!((Data)servletContext.getAttribute("data")).getUserController().userExists("admin@admin.nl")) {
            ((Data)servletContext.getAttribute("data")).getUserController().newAdmin();
            System.out.println("admin added");

        }

        // Initialize logger
        try{
            FileHandler fh = new FileHandler(servletContext.getRealPath("/")+"blogLog.xml", true);
            logger.addHandler(fh);
        } catch (IOException ioe) { ioe.printStackTrace(); }
        logger.setLevel(Level.ALL);
        logger.info("Logger initialized");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));
            writer.writeObject(servletContext.getAttribute("data"));
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
