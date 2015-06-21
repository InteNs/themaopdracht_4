<%--
  Created by IntelliJ IDEA.
  User: HogeschoolUtrecht
  Date: 18/06/15
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/form.css"/>"/>
<form action="<c:url value="/viewproducts"/>" method="post">
            <span class="navigationitem">
              <input type="submit" name="button" value="Producten"/>
            </span>
</form>
<div class="container">
  <form action="<c:url value="/addproduct"/>" id="addProduct" method="post">
    <fieldset name="Product toevoegen">
      <legend>Product toevoegen</legend>
      <div class="p">
        <label class="formlabel" for="productname">Productnaam:</label>
        <input class="text" type="text" name="productname" id="productname" placeholder="Vul de Productnaam in"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.name_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="amount">Aantal:</label>
        <input class="text" type="text" name="amount" id="amount" placeholder="Vul het aantal in"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.amount_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="price">Prijs:</label>
        <input class="text" type="text" name="price" id="price" placeholder="Vul de prijs in"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.price_error}"/></label>
      </div>

      <div class="p">
        <input type="reset" name="reset" class="button" value="Reset"/>
        <input type="submit" name="button" class="button" value="Toevoegen"/>
      </div>

    </fieldset>
  </form>
</div>
