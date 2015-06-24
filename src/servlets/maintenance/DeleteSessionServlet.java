package servlets.maintenance;

import listeners.Data;
import services.MaintenanceController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteSessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MaintenanceController maintenanceController = ((Data)req.getServletContext().getAttribute("data")).getMaintenanceController();
        int ID = Integer.parseInt(req.getParameter("sessionid"));
        maintenanceController.removeSession(ID);
        req.getRequestDispatcher("/viewsessions").forward(req,resp);
    }
}
