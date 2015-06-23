package servlets.userServlets;

import listeners.Data;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by InteNs on 18.jun.2015.
 */
public class ViewUsersServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",((Data)req.getServletContext().getAttribute("data")).getUserController().getUsers());
        req.getRequestDispatcher("/secure/user/user.jsp").forward(req,resp);
    }
}
