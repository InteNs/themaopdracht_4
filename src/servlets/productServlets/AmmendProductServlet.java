package servlets.productServlets;

import listeners.Data;
import services.ProductController;
import services.exceptions.ValidateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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

        synchronized (productController) {
            try {
                productController.ammendProduct(originalProductName, productName, productamount, productprice);
            } catch (ValidateException e) {
                for(Map.Entry<String, String> entry : e.getErrorMap().entrySet())
                    req.setAttribute(entry.getKey(),entry.getValue());
                req.getRequestDispatcher("/secure/product/ammendproduct.jsp").forward(req, resp);
            }
        }
        req.getRequestDispatcher("/viewproducts").forward(req, resp);
    }
}
