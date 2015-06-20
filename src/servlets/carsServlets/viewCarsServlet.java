package servlets.carsServlets;

import domain.users.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by InteNs on 20.jun.2015.
 */
public class viewCarsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("cars", ((Customer)req.getSession().getAttribute("current_user")).getCars());
        req.getRequestDispatcher("/secure/customer.jsp").forward(req,resp);
    }
}
