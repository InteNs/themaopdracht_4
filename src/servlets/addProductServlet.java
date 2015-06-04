package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.Override;import java.lang.String;import java.util.Objects;

public class addProductServlet extends HttpServlet {
    String naam;
    String aantal;
    String minAantal;
    String prijs;
    String inkoopPrijs;
    String leverancier;
    String adres;
    String postcode;
    String plaats;
    ServletContext servletContext;
    RequestDispatcher requestDispatcher;
    //ProductService controller;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletContext = req.getServletContext();
        naam = req.getParameter("naam");
        aantal = req.getParameter("aantal");
        minAantal = req.getParameter("minAantal");
        prijs = req.getParameter("prijs");
        inkoopPrijs = req.getParameter("inkoopPrijs");
        leverancier = req.getParameter("leverancier");
        adres = req.getParameter("adres");
        postcode = req.getParameter("postcode");
        plaats = req.getParameter("plaats");
        if (!Objects.equals(naam,"")
                && !Objects.equals(aantal,"")
                && !Objects.equals(minAantal,"")
                && !Objects.equals(prijs,"")
                && !Objects.equals(inkoopPrijs,"")
                && !Objects.equals(leverancier,"")
                && !Objects.equals(adres,"")
                && !Objects.equals(postcode,"")
                && !Objects.equals(plaats,"")
                ){
            //controller.newPart();
                    ///newProduct(aantal, minAantal, prijs, inkoopPrijs, leverancier, adres, postcode, plaats);
            ///controller.removeProduct();

            requestDispatcher = req.getRequestDispatcher("/voorraad.jsp");
        }
        else requestDispatcher = req.getRequestDispatcher("/voorraad.jsp");
        requestDispatcher.forward(req,resp);
    }
}
