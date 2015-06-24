<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="right">
        <a href="<c:url value="/secure/product/addproduct.jsp"/>"><input type="button" class="button" value="Product Toevoegen" /></a>
    </div>
    <div class="right">
        <a href="<c:url value="/secure/user/homepage.jsp"/>"><input type="button" class="button" value="Terug" /></a>
    </div>
    <table>
        <tr>
            <th>Naam</th>
            <th>Aantal</th>
            <th>Prijs</th>
            <th><span class="smalltext">Details</span></th>
            <th><span class="smalltext">Bewerk</span></th>
            <th><span class="smalltext">Verwijder</span></th>
        </tr>
        <c:forEach items="${requestScope.products}" var="product">
            <tr>
                <td>${product.getName()}</td>
                <td>${product.getAmount()}</td>
                <td>${product.getPrice()}</td>

                    <%-- Productdetails --%>
                <td><form action="<c:url value="/secure/product/detailsproduct.jsp"/>" method="post">
                    <input type="submit" name="button" class="buttonsmall" value="&#9636;"/>
                    <input type="hidden" name="name" value="${product.getName()}"/>
                    <input type="hidden" name="amount" value="${product.getAmount()}"/>
                    <input type="hidden" name="price" value="${product.getPrice()}"/>
                </form></td>

                    <%-- Ammend product --%>
                <td><form action="<c:url value="/secure/product/ammendproduct.jsp"/>" method="post">
                    <input type="submit" name="button" class="buttonsmall" value="&#x270E;"/>
                    <input type="hidden" name="name" value="${product.getName()}"/>
                    <input type="hidden" name="amount" value="${product.getAmount()}"/>
                    <input type="hidden" name="price" value="${product.getPrice()}"/>
                </form></td>

                    <%-- Remove product --%>
                <td><form action="<c:url value="/removeproduct"/>" id="/removeproduct" method="post">
                    <input type="submit" name="button" class="buttonsmall" value="&#10005;"/>
                    <input type="hidden" name="name" value="${product.getName()}"/>
                </form></td>
            </tr>
        </c:forEach>
    </table>
</div>
