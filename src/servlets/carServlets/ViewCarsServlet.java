package servlets.carServlets;

import domain.users.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by InteNs on 21.jun.2015.
 */
public class ViewCarsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = (Customer)request.getSession().getAttribute("current_user");
        request.setAttribute("cars",customer.getCars());
        request.getRequestDispatcher("/secure/customer.jsp").forward(request,response);

    }

}
