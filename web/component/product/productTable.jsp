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

        <c:forEach items="${requestScope.products}" var="product">
            <tr>
                <td>${product.getName()}</td>
                <td>${product.getAmount()}</td>
                <td>${product.getPrice()}</td>

                    <%-- Productdetails --%>
                <td><form action="<c:url value="/productdetails"/>" id="/productdetails" method="post">
                    <input type="submit" name="button" value="Details"/>
                    <input type="hidden" name="product" value="${product}"/>
                </form></td>

                    <%-- Ammend product --%>
                <td><form action="<c:url value="/editproduct"/>" id="/editproduct" method="post">
                    <input type="submit" name="button"  value="Aanpassen"/>
                    <input type="hidden" name="product" value="${product}"/>
                </form></td>

                    <%-- Remove product --%>
                <td><form action="<c:url value="/removeproduct"/>" id="/removeproduct" method="post">
                    <input type="submit" name="button" value="Verwijderen"/>
                    <input type="hidden" name="name" value="${product.getName()}"/>
                </form></td>
            </tr>
        </c:forEach>
    </table>
</div>
