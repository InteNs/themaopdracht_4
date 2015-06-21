<%--
  Created by IntelliJ IDEA.
  User: Jorrit Meulenbeld
  Date: 18/06/15
  Time: 12:08
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/form.css"/>"/>
<form action="<c:url value="/viewproducts"/>" method="post">
            <span class="navigationitem">
              <input type="submit" name="button" value="Producten"/>
            </span>
</form>
<c:if test="${not empty param.name}">
<form action="<c:url value="/secure/detailsproduct.jsp"/>" method="post">
  <input type="submit" name="button" value="Details"/>
  <input type="hidden" name="name" value="${param.name}"/>
  <input type="hidden" name="amount" value="${param.amount}"/>
  <input type="hidden" name="price" value="${param.price}"/>
</form>
</c:if>
<div class="container">
  <form action="<c:url value="/ammendproduct"/>" id="ammendProduct" method="post">
    <fieldset name="Product Aanpassen">
      <legend>Product aanpassen</legend>
      <div class="p">
        <label class="formlabel" for="productname">Productnaam:</label>
        <input type="hidden" name="originalproductname" value="${param.name}"/>
        <input class="text" type="text" name="productname" id="productname" value="${param.name}"/>
        <label class="formlabel">&nbsp;</label>
        <%--<label class="text"><c:out value="${requestScope.name_error}"/></label>--%>
      </div>
      <div class="p">
        <label class="formlabel" for="productamount">Aantal:</label>
        <input class="text" type="number" name="productamount" id="productamount" value="${param.amount}"/>
        <label class="formlabel">&nbsp;</label>
        <%--<label class="text"><c:out value="${requestScope.amount_error}"/></label>--%>
      </div>
      <div class="p">
        <label class="formlabel" for="productprice">Prijs:</label>
        <input class="text" type="number" step="0.01" name="productprice" id="productprice" value="${param.price}"/>
        <label class="formlabel">&nbsp;</label>
        <%--<label class="text"><c:out value="${requestScope.price_error}"/></label>--%>
      </div>
      <div class="p">
        <label class="formlabel" for="check">Bevestig:</label>
        <input class="text" type="checkbox" name="check" id="check" required/>
      </div>

      <div class="p">
        <input type="reset" name="reset" class="button" value="Reset"/>
        <input type="submit" name="button" class="button" value="Aanpassen"/>
      </div>

    </fieldset>
  </form>
</div>