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
 * Created by Jorrit Meulenbeld & Oussama Aalili on 18/06/15.
 */
public class NewProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductController productController = ((Data)req.getServletContext().getAttribute("data")).getProductController();
        String productName = req.getParameter("productname");
        int amount = Integer.parseInt(req.getParameter("amount"));
        double price = Double.parseDouble(req.getParameter("price"));
        synchronized (productController) {
            try {
                productController.addProduct(productName, amount, price);
            } catch (ValidateException e) {
                for(Map.Entry<String, String> entry : e.getErrorMap().entrySet())
                    req.setAttribute(entry.getKey(),entry.getValue());
                req.getRequestDispatcher("/secure/product/addproduct.jsp").forward(req,resp);
            }
        }
        req.getRequestDispatcher("/viewproducts").forward(req,resp);
    }
}
