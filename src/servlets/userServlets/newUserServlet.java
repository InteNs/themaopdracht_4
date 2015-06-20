package servlets.userServlets;

import listeners.Data;
import services.UserController;
import services.exceptions.ValidateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

/**
 * Created by InteNs on 05.jun.2015.
 * TODO: rewrite for seperate form
 */
public class newUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserController userController = ((Data)req.getServletContext().getAttribute("data")).getUserController();
        boolean mechanic;
        if(req.getParameter("usertype") == null) mechanic = true;
        else mechanic = false;
        String email = req.getParameter("email");
        String realName = req.getParameter("realname");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("date"));
        String address = req.getParameter("address");
        String postal = req.getParameter("postal");
        String phoneNumber = req.getParameter("phonenumber");
         try {
             if(mechanic) userController.newMechanic(email,"default",realName,dateOfBirth,address,postal,phoneNumber);
             //todo implement newcustomer
        } catch (ValidateException e) {
            for(Map.Entry<String, String> entry : e.getErrorMap().entrySet())
                req.setAttribute(entry.getKey(),entry.getValue());
                //TODO error handling
        }

    }
}
