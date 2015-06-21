package servlets.userServlets;

import listeners.Data;
import services.UserController;
import services.exceptions.ValidateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by HogeschoolUtrecht on 21/06/15.
 */
public class ammenduserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserController userController = ((Data)req.getServletContext().getAttribute("data")).getUserController();
        String email = req.getParameter("email");
        String emailRepeat = req.getParameter("email_repeat");
        String password = req.getParameter("password");
        String passwordRepeat = req.getParameter("password_repeat");
        String realName = req.getParameter("realname");
        String dateOfBirth = req.getParameter("date");
        String address = req.getParameter("address");
        String postal = req.getParameter("postal");
        String phoneNumber = req.getParameter("phonenumber");
        String originalEmail = req.getParameter("originalemail");
        System.out.println(originalEmail+email+password+realName+dateOfBirth+address+postal+phoneNumber);

        synchronized (userController) {
            try {
                userController.ammendUser(originalEmail, email, emailRepeat, password, passwordRepeat, dateOfBirth, realName, address, postal, phoneNumber);
            } catch (ValidateException e) {
                for (Map.Entry<String, String> entry : e.getErrorMap().entrySet())
                    req.setAttribute(entry.getKey(), entry.getValue());
                req.getRequestDispatcher("/secure/ammenduser.jsp").forward(req,resp);
            }
        }
        req.getRequestDispatcher("/viewusers").forward(req, resp);
    }
}
