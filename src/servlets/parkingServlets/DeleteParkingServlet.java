package servlets.parkingServlets;

import listeners.Data;
import services.ParkingController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jorrit Meulenbeld on 24-6-2015.
 */
public class DeleteParkingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ParkingController parkingController = ((Data)req.getServletContext().getAttribute("data")).getParkingController();
        int ID = Integer.parseInt(req.getParameter("reservationid"));
        parkingController.removeReservation(ID);
        req.getRequestDispatcher("/viewparking").forward(req,resp);
    }
}
