package servlets.carsServlets;

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
public class DeleteCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserController userController = ((Data)req.getServletContext().getAttribute("data")).getUserController();
        synchronized (userController) {
            userController.removeCar(req.getParameter("user"), req.getParameter("car"));
        }
        req.getRequestDispatcher("/secure/admin.jsp").forward(req,resp);
    }
}
