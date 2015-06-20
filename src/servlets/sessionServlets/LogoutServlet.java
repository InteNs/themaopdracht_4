package servlets.sessionServlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by InteNs on 29.mei.2015.
 */
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        System.out.println("logging "+req.getSession().getAttribute("current_user")+" out");
        req.setAttribute("logout_info","U bent nu uitgelogd");
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
