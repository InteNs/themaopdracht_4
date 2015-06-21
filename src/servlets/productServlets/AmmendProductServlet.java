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
 */
public class AmmendProductServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductController productController = ((Data)req.getServletContext().getAttribute("data")).getProductController();

        String originalProductName =    req.getParameter("originalproductname");
        String productName =            req.getParameter("productname");
        int productamount =             Integer.parseInt(req.getParameter("productamount"));
        double productprice =           Double.parseDouble(req.getParameter("productprice"));

        synchronized (req.getParameter("productprice")) {
            productController.ammendProduct(originalProductName, productName, productamount, productprice);
        }

        req.setAttribute("products",((Data)req.getServletContext().getAttribute("data")).getProductController().getAllProducts());

        req.getRequestDispatcher("/viewproducts").forward(req, resp);
    }
}
