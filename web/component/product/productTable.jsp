<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/global.css"/>"/>
<link rel="stylesheet" href="<c:url value="/component/table.css"/>"/>
<a href="<c:url value="/secure/users/admin.jsp"/>"><input type="button" class="button" value="Terug" /></a>
<a href="<c:url value="/secure/product/addproduct.jsp"/>"><input type="button" class="button" value="Product Toevoegen" /></a>
<div class="container">
    <table>

        <tr>
            <th>Naam</th>
            <th>Aantal</th>
            <th>Prijs</th>
            <th>Details</th>
            <th>Aanpassen</th>
            <th>Verwijderen</th>
        </tr>

        <c:forEach items="${requestScope.products}" var="product">
            <tr>
                <td>${product.getName()}</td>
                <td>${product.getAmount()}</td>
                <td>${product.getPrice()}</td>

                    <%-- Productdetails --%>
                <td><form action="<c:url value="/secure/product/detailsproduct.jsp"/>" method="post">
                    <input type="submit" name="button" value="Details"/>
                    <input type="hidden" name="name" value="${product.getName()}"/>
                    <input type="hidden" name="amount" value="${product.getAmount()}"/>
                    <input type="hidden" name="price" value="${product.getPrice()}"/>
                </form></td>

                    <%-- Ammend product --%>
                <td><form action="<c:url value="/secure/product/ammendproduct.jsp"/>" method="post">
                    <input type="submit" name="button"  value="Aanpassen"/>
                    <input type="hidden" name="name" value="${product.getName()}"/>
                    <input type="hidden" name="amount" value="${product.getAmount()}"/>
                    <input type="hidden" name="price" value="${product.getPrice()}"/>
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
