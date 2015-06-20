package servlets.productServlets;

import listeners.Data;
import services.ProductController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jorrit Meulenbeld on 18/06/15.
 * TODO: AmmendProductServlet
 */
public class AmmendProductServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductController productController = ((Data)req.getServletContext().getAttribute("data")).getProductController();
        String originalProductName = req.getParameter("originalproductname");
        int originalamount = Integer.parseInt(req.getParameter("originalamount"));
        double originalprice = Double.parseDouble(req.getParameter("originalprice"));
        String productName = req.getParameter("productname");
        int amount = Integer.parseInt(req.getParameter("amount"));
        double price = Double.parseDouble(req.getParameter("price"));
        synchronized (productController) {
            productController.ammendProduct(originalProductName, productName, amount, price);
        }
        req.setAttribute("products",((Data)req.getServletContext().getAttribute("data")).getProductController().getAllProducts());
        req.getRequestDispatcher("./secure/product.jsp").forward(req, resp);
    }
}
