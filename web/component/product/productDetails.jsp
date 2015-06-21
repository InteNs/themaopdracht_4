<%--
  Created by IntelliJ IDEA.
  User: Jorrit Meulenbeld
  Date: 18/06/15
  Time: 12:08
  TODO: Ammend Product Page
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/form.css"/>"/>
<%--TODO: FIX THIS SHIT YO; Jorrit: YES SIR!--%>
<form action="<c:url value="/viewproducts"/>" method="post">
            <span class="navigationitem">
              <input type="submit" name="button" value="Producten"/>
            </span>
</form>
<div class="container">
    <fieldset name="Product Details">
      <legend>Product details</legend>
      <div class="p">
        <label class="formlabel">Productnaam:</label>
        <label class="text" id="productname">${param.name}</label>
        <label class="formlabel">&nbsp;</label>
        <%--<label class="text"><c:out value="${requestScope.name_error}"/></label>--%>
      </div>
      <div class="p">
        <label class="formlabel">Aantal:</label>
        <label class="text" id="productamount">${param.amount}</label>
        <label class="formlabel">&nbsp;</label>
        <%--<label class="text"><c:out value="${requestScope.amount_error}"/></label>--%>
      </div>
      <div class="p">
        <label class="formlabel">Prijs:</label>
        <label class="text" id="productamount">${param.price}</label>
        <label class="formlabel">&nbsp;</label>
        <%--<label class="text"><c:out value="${requestScope.price_error}"/></label>--%>
      </div>
      <div class="p">
        <form action="<c:url value="/secure/ammendproduct.jsp"/>" method="post">
          <input type="submit" name="button"  value="Aanpassen"/>
          <input type="hidden" name="name" value="${param.name}"/>
          <input type="hidden" name="amount" value="${param.amount}"/>
          <input type="hidden" name="price" value="${param.price}"/>
        </form>
      </div>
    </fieldset>
</div>