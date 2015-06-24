<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">

    <fieldset name="Product Aanpassen">
        <legend>Product Bewerken</legend>
        <div class="buttonBoxLeftAmmend">
            <c:if test="${not empty param.name}">
                <form action="<c:url value="/secure/product/detailsproduct.jsp"/>" method="post">
          <span class="navigationitem">
          <input class="button" type="submit" name="button" value="Terug naar de Productdetails"/>
          </span>
                    <input type="hidden" name="name" value="${param.name}"/>
                    <input type="hidden" name="amount" value="${param.amount}"/>
                    <input type="hidden" name="price" value="${param.price}"/>
                </form>
            </c:if>
        </div>
        <div class="buttonBoxLeftAmmend">
            <form action="<c:url value="/viewproducts"/>" method="post">
            <span class="navigationitem">
              <input class="button" type="submit" name="button" value="Terug naar het Productenoverzicht"/>
            </span>
            </form>
        </div>
        <form action="<c:url value="/ammendproduct"/>" id="ammendProduct" method="post">
            <div class="p">
                <label class="notice"><c:out value="${requestScope.name_error}"/></label>
                <input type="hidden" name="originalproductname" value="${param.name}"/>
                <label class="formlabel" for="productname">Productnaam
                    <span class="requiredColor"> *</span>
                </label>
                <input class="text" type="text" name="productname" id="productname" value="${param.name}" required/>
            </div>
            <div class="p">
                <label class="formlabel" for="productamount">Aantal
                    <span class="requiredColor"> *</span>
                </label>
                <input class="text" type="number" min="0" step="1" name="productamount" id="productamount" value="${param.amount}" required/>
            </div>
            <div class="p">
                <label class="formlabel" for="productprice">Prijs
                    <span class="requiredColor"> *</span>
                </label>
                <input class="text" type="number" min="0" step="0.01" name="productprice" id="productprice" value="${param.price}" required/>
            </div>
            <div class="buttonBox">
                <div class="checkboxContainer">
                    <div class="checkbox" id="customcheckbox">
                        <input type="checkbox" type="checkbox" name="check" id="check" name="keep_email" required/>
                        <label for="check" id="checkMeToo"></label>
                    </div>
                    <div class="checkboxLabel">Bevestig Aanpassing
                        <span class="requiredColor"> *</span>
                        </label>
                    </div>
                </div>
                <input type="reset" name="reset" class="button" value="Reset"/>
                <input type="submit" name="button" class="button" value="Aanpassen"/>
            </div>
        </form>
    </fieldset>
</div>