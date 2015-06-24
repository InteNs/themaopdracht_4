package servlets.maintenance;

import listeners.Data;
import services.MaintenanceController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewMaintenanceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MaintenanceController maintenanceController = ((Data)req.getServletContext().getAttribute("data")).getMaintenanceController();
        req.setAttribute("sessions",maintenanceController.getMaintenanceSessions());
        req.getRequestDispatcher("/viewsessions").forward(req,resp);
    }
}
