package servlets.sessionServlets;

import listeners.Data;
import services.UserController;
import services.exceptions.LoginException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserController userController = ((Data) req.getServletContext().getAttribute("data")).getUserController();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            userController.isLoginValid(email, password);
            req.getSession().setAttribute("current_user", userController.findUser(email));
            requestDispatcher = req.getRequestDispatcher("/secure/user/homepage.jsp");
            if (req.getAttribute("keep_email") != null) resp.addCookie(new Cookie("c_email", email));
        } catch (LoginException e) {
            req.setAttribute("login_error", e.getMessage());
        }
        requestDispatcher.forward(req, resp);
    }
}
