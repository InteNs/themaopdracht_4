package servlets;

import services.controllers.UserController;
import domain.User;
import listeners.Data;
import services.controllers.ValidateException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.Override;import java.lang.String;import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class RegisterServlet extends HttpServlet {
    String email;
    String password;
    String realName;
    LocalDate dateOfBirth;
    String address;
    String postal;
    String phoneNumber;
    String emailRepeat;
    String passwordRepeat;
    ServletContext servletContext;
    RequestDispatcher requestDispatcher;
    UserController userController;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        servletContext = req.getServletContext();
        userController = ((Data)servletContext.getAttribute("Data")).getUserController();
        email 	= req.getParameter("email");
        emailRepeat = req.getParameter("emailRepeat");
        password = req.getParameter("password");
        passwordRepeat = req.getParameter("passwordRepeat");
        realName = req.getParameter("realname");
        dateOfBirth = LocalDate.parse(req.getParameter("date"));
        address = req.getParameter("address");
        postal = req.getParameter("postal");
        phoneNumber = req.getParameter("phonenumber");
        try {
            userController.newCustomer(email,emailRepeat,password,passwordRepeat,realName,dateOfBirth,address,postal,phoneNumber);
            requestDispatcher = req.getRequestDispatcher("/index.jsp");
        } catch (ValidateException e) {
            requestDispatcher = req.getRequestDispatcher("/registration.jsp");
            for(Map.Entry<String, String> entry : e.getErrorMap().entrySet())
                req.setAttribute(entry.getKey(),entry.getValue());
        }
        requestDispatcher.forward(req,resp);
    }
}
