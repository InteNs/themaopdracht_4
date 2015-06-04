package servlets;

import services.controllers.UserController;
import domain.User;
import listeners.Data;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.Override;import java.lang.String;import java.time.LocalDate;
import java.util.Objects;

public class RegisterServlet extends HttpServlet {
    String email;
    String password;
    String realName;
    LocalDate dateOfBirth;
    String address;
    String postal;
    String phoneNumber;
    ServletContext servletContext;
    RequestDispatcher requestDispatcher;
    UserController userController;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        servletContext = req.getServletContext();
        UserController userController = ((Data)servletContext.getAttribute("Data")).getUserController();
        email 	= req.getParameter("email");
        password = req.getParameter("password");
        realName = req.getParameter("realname");
        dateOfBirth = LocalDate.parse(req.getParameter("date"));
        address = req.getParameter("address");
        postal = req.getParameter("postal");
        phoneNumber = req.getParameter("phonenumber");
        //TODO: move to validateService
//        if (){
//            userController.newCustomer(email,password,realName,dateOfBirth,address,postal,phoneNumber);
//
//            requestDispatcher = req.getRequestDispatcher("/index.jsp");
//        }
//        else requestDispatcher = req.getRequestDispatcher("/registration.jsp");
        requestDispatcher.forward(req,resp);
    }
    private boolean doesExist(String email){
        for(User user : userController.getUsers())
            if (user.getEmail().equals(email))return true;
        return false;
    }
}
