package servlets.productServlets;

import listeners.Data;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewProductServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products",((Data)req.getServletContext().getAttribute("data")).getProductController().getAllProducts());
        req.getRequestDispatcher("/secure/product/product.jsp").forward(req, resp);
    }
}
