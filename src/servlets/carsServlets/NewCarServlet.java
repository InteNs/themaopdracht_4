package servlets.carsServlets;

import domain.users.Customer;
import domain.users.User;
import listeners.Data;
import services.UserController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by InteNs on 05.jun.2015.
 */
public class NewCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserController userController = ((Data)req.getServletContext().getAttribute("data")).getUserController();
        String carType = req.getParameter("cartype");
        String carPlate= req.getParameter("numberplate");
        User user = (User)req.getSession().getAttribute("current_user");
        synchronized (userController) {
            //todo: check if exists
            if (userController.findCar(carPlate)==null) {
                userController.newCar(user.getEmail(), carType, carPlate);
                System.out.println("car doesn't exist");
            }
            else {
                System.out.println("car exists");
                req.setAttribute("car_error","kenteken bestaat al");
            }
            req.setAttribute("cars", ((Customer) user).getCars());
        }
        req.getRequestDispatcher("/viewcars").forward(req,resp);

    }
}
