<%--
  Created by IntelliJ IDEA.
  User: Jorrit Meulenbeld
  Date: 18/06/15
  Time: 10:46
  TODO: Table Summary Products + Links to add, ammend & details
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/global.css"/>"/>
<link rel="stylesheet" href="<c:url value="/component/table.css"/>"/>
<div class="container">
  <table>

    <tr>
      <th>Naam</th>
      <th>Aantal</th>
      <th>Prijs</th>
      <th>Details</th>
      <th>Verwijderen</th>
      <th>Aanpassen</th>
    </tr>

    <c:forEach items="${products}" var="product">
      <tr>
        <td>${product.getName()}</td>
        <td>${product.getAmount()}</td>
        <td>${product.getPrice()}</td>

          <%-- Productdetails --%>
        <form action="/productdetails" id="/productdetails" method="post">
          <td><input type="submit" name="button" value="Details"/></td>
          <input type="hidden" name="product" value="${product}"/>
        </form>

        <%-- Ammend product --%>
        <form action="/editproduct" id="/editproduct" method="post">
          <td><input type="submit" name="button"  value="Aanpassen"/></td>
          <input type="hidden" name="product" value="${product}"/>
        </form>

          <%-- Remove product --%>
        <form action="/removeproduct" id="/removeproduct" method="post">
          <td><input type="submit" name="button" value="Verwijderen"/></td>
          <input type="hidden" name="name" value="${product.getName()}"/>
        </form>

      </tr>
      </c:forEach>
    </table>
</div>
