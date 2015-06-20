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
 * TODO: DeleteProductServlet
 */
public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ProductController productController = ((Data)req.getServletContext().getAttribute("data")).getProductController();
        synchronized (productController) {
                productController.removeProduct(req.getParameter("name"));
            }
        req.getRequestDispatcher("/secure/admin.jsp").forward(req, resp);
        }
}