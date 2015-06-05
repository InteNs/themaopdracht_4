package servlets.userServlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by InteNs on 05.jun.2015.
 */
public class newUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String realName = req.getParameter("realname");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("date"));
        String address = req.getParameter("address");
        String postal = req.getParameter("postal");
        String phoneNumber = req.getParameter("phonenumber");
    }
}
