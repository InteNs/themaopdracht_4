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
        UserController userController = ((Data) req.getServletContext().getAttribute("data")).getUserController();
        String button = req.getParameter("button");
        System.out.println(button);
        switch (button) {
            case "Registreren":
                System.out.println("registreren");
                req.setAttribute("register", "register");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
                break;
            case "Inloggen":
                System.out.println("inloggen");
                String email = req.getParameter("email");
                String password = req.getParameter("password");

                try {
                    userController.isLoginValid(email, password);
                    req.getSession().setAttribute("current_user", userController.findUser(email));
                    if (req.getAttribute("keep_email") != null) resp.addCookie(new Cookie("c_email", email));
                } catch (LoginException e) {
                    req.setAttribute("login_error", e.getMessage());
                }
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
                break;
        }
    }
}
