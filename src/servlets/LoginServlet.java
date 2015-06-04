package servlets;

import listeners.Data;
import services.controllers.exceptions.LoginException;
import services.controllers.UserController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by InteNs on 29.mei.2015.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        ServletContext servletContext = req.getServletContext();
        UserController userController = ((Data) servletContext.getAttribute("Data")).getUserController();
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            userController.isLoginValid(email,password);
            if(req.getAttribute("keepemail") != null){
                Cookie c = new Cookie("c_email", email);
                c.setMaxAge(2000);
                resp.addCookie(c);
            }
            req.getSession().setAttribute("currentuser",userController.findUser(email));
            requestDispatcher = req.getRequestDispatcher("/secure/welcome.jsp");

        } catch (LoginException e) {
            req.setAttribute("login_error",e.getMessage());
            requestDispatcher = req.getRequestDispatcher("/index.jsp");
        }
        requestDispatcher.forward(req, resp);

    }
}
