package servlets.parkingServlets;

import domain.users.Car;
import domain.users.Customer;
import listeners.Data;
import services.ParkingController;
import services.UserController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by Jorrit Meulenbeld on 24-6-2015.
 */
// todo write and link with parking service
public class NewParkingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ParkingController parkingController = ((Data)req.getServletContext().getAttribute("data")).getParkingController();
        UserController userController = ((Data)req.getServletContext().getAttribute("data")).getUserController();

        LocalDate date = LocalDate.parse(req.getParameter("date"));
        Car car = userController.findCar(req.getParameter("licenseplate"));
        Customer customer = (Customer) req.getSession().getAttribute("current_user");

        parkingController.addReservation(date,parkingController.getAvailableParkingSpots(date).get(0),customer,car);

        req.getRequestDispatcher("/viewparking").forward(req,resp);

    }
}