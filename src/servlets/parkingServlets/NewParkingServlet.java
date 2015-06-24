package servlets.parkingServlets;

import listeners.Data;
import services.ParkingController;

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
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        String licensePlate = req.getParameter("licenseplate");

    }
}