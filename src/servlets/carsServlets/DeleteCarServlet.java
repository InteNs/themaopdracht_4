package servlets.carsServlets;

import domain.users.User;
import listeners.Data;
import services.UserController;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ConcurrentModificationException;

/**
 * Created by InteNs on 05.jun.2015.
 */
public class DeleteCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserController userController = ((Data)req.getServletContext().getAttribute("data")).getUserController();
        synchronized (userController) {
            try {
                userController.removeCar(((User)req.getSession().getAttribute("current_user")).getEmail(), req.getParameter("car"));
            } catch (ConcurrentModificationException e) {
            }
        }
        req.getRequestDispatcher("/secure/customer.jsp").forward(req,resp);
    }
}
