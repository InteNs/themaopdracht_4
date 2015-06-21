package servlets.userServlets;

import listeners.Data;
import services.UserController;
import services.exceptions.ValidateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class newUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserController userController = ((Data)req.getServletContext().getAttribute("data")).getUserController();

        String email = req.getParameter("email");
        String emailRepeat = req.getParameter("email_repeat");
        String password = req.getParameter("password");
        String passwordRepeat = req.getParameter("password_repeat");
        String realName = req.getParameter("realname");
        String dateOfBirth = req.getParameter("date");
        String address = req.getParameter("address");
        String postal = req.getParameter("postal");
        String phoneNumber = req.getParameter("phonenumber");
        String userType = req.getParameter("usertype");
        System.out.println(userType);
         try {
             switch (userType){
                 case "OWNER":
                     userController.newOwner(email,emailRepeat,password,passwordRepeat,realName,dateOfBirth,address,postal,phoneNumber);
                     System.out.println("made new owner");
                     break;
                 case "CUSTOMER":
                     userController.newCustomer(email, emailRepeat, password, passwordRepeat, realName, dateOfBirth, address, postal, phoneNumber);
                     System.out.println("made new customer");
                     break;
                 case "MECHANIC":
                     userController.newMechanic(email, emailRepeat, password, passwordRepeat, realName, dateOfBirth, address, postal, phoneNumber);
                     System.out.println("made new mechanic");
                     break;
             }
        } catch (ValidateException e) {
            for(Map.Entry<String, String> entry : e.getErrorMap().entrySet())
                req.setAttribute(entry.getKey(),entry.getValue());
             req.getRequestDispatcher("/secure/adduser.jsp").forward(req,resp);
        }
        req.getRequestDispatcher("/viewusers").forward(req,resp);
    }
}
