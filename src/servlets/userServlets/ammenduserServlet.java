package servlets.userServlets;

import listeners.Data;
import services.UserController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by HogeschoolUtrecht on 21/06/15.
 */
public class ammenduserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserController userController = ((Data)req.getServletContext().getAttribute("data")).getUserController();
        String originalProductName = req.getParameter("originalproductname");
        String productName = req.getParameter("productname");
        int productamount = Integer.parseInt(req.getParameter("productamount"));
        double productprice = Double.parseDouble(req.getParameter("productprice"));
        synchronized (req.getParameter("productprice")) {
//            TODO make ammendUser in controller
//            userController.ammendUser(originalEmail, email, repeatEmail, password, repeatPassword, name, address, postalcode, phoneNumber, usertype);
        }
        req.setAttribute("products",((Data)req.getServletContext().getAttribute("data")).getProductController().getAllProducts());
        req.getRequestDispatcher("/viewproducts").forward(req, resp);
    }
}
