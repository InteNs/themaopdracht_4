package servlets.userServlets;

import listeners.Data;
import services.UserController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ConcurrentModificationException;

/**
 * Created by InteNs on 05.jun.2015.
 */
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        UserController userController = ((Data) servletContext.getAttribute("data")).getUserController();
        synchronized (userController){
            try {
                userController.removeUser(req.getParameter("user"));
            } catch (ConcurrentModificationException e) {
            }
        }
        req.getRequestDispatcher("/viewusers").forward(req,resp);
    }
}
