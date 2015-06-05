package servlets.userServlets;

import domain.User;
import listeners.Data;
import services.UserController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by InteNs on 05.jun.2015.
 */
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        UserController userController = ((Data) servletContext.getAttribute("data")).getUserController();
        synchronized (userController){
            userController.removeUser(req.getParameter("user"));
        }
        req.getRequestDispatcher("/secure/admin.jsp").forward(req,resp);
    }
}
