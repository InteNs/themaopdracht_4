<%--
  Created by IntelliJ IDEA.
  User: Jorrit Meulenbeld
  Date: 18/06/15
  Time: 12:08
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
  <fieldset name="Product Details">
    <div class="buttonBoxLeft">
      <form action="<c:url value="/viewproducts"/>" method="post">
            <span class="navigationitem">
              <input type="submit" name="button" class="button" value="Terug naar Productenoverzicht"/>
            </span>
      </form>
      </div>
      <div class="p">
          <label class="formlabel">Productnaam
            <span class="requiredColor"> *</span>
          </label>
          <input class="text" readonly id="productname" value="${param.name}"/>
      </div>
      <legend>Product details</legend>
      <div class="p">
        <label class="formlabel">Aantal
          <span class="requiredColor"> *</span>
        </label>
        <input class="text" readonly id="productamount" value="${param.amount}"/>
      </div>
      <div class="p">
        <label class="formlabel">Prijs
          <span class="requiredColor"> *</span>
        </label>
        <input class="text" readonly id="productprice" value="${param.price}"/>
      </div>
      <div class="buttonBox">
        <form action="<c:url value="/secure/product/ammendproduct.jsp"/>" method="post">
          <input type="submit" name="button" class="button" value="Aanpassen"/>
          <input type="hidden" name="name" value="${param.name}"/>
          <input type="hidden" name="amount" value="${param.amount}"/>
          <input type="hidden" name="price" value="${param.price}"/>
        </form>
      </div>
    </fieldset>
</div>