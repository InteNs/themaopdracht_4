package servlets.carsServlets;

import domain.User;
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
        String carType = req.getParameter("car_type");
        String carPlate= req.getParameter("car_Plate");
        User user = (User)req.getSession().getAttribute("current_user");
        synchronized (userController) {
            userController.newCar(user.getEmail(), carType, carPlate);
        }

    }
}
