package servlets.sessionServlets;

import listeners.Data;
import services.UserController;
import services.exceptions.ValidateException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class RegisterServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        UserController userController = ((Data)servletContext.getAttribute("data")).getUserController();
        String email = req.getParameter("email");
        String emailRepeat = req.getParameter("email_repeat");
        String password = req.getParameter("password");
        String passwordRepeat = req.getParameter("password_repeat");
        String realName = req.getParameter("realname");
        String dateOfBirth = req.getParameter("date");
        String address = req.getParameter("address");
        String postal = req.getParameter("postal");
        String phoneNumber = req.getParameter("phonenumber");
        RequestDispatcher requestDispatcher;
        try {
            synchronized (userController){userController.newCustomer(email, emailRepeat, password, passwordRepeat, realName, dateOfBirth, address, postal, phoneNumber);}
            requestDispatcher = req.getRequestDispatcher("/index.jsp");
        } catch (ValidateException e) {
            requestDispatcher = req.getRequestDispatcher("/register.jsp");
            for(Map.Entry<String, String> entry : e.getErrorMap().entrySet())
                req.setAttribute(entry.getKey(),entry.getValue());
        }
        requestDispatcher.forward(req, resp);
    }
}
