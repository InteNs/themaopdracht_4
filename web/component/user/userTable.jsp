<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/global.css"/>"/>
<link rel="stylesheet" href="<c:url value="/component/table.css"/>"/>
<a href="<c:url value="/secure/admin.jsp"/>"><input type="button" class="button" value="Terug" /></a>
<a href="<c:url value="/secure/adduser.jsp"/>"><input type="button" class="button" value="Gebruiker Toevoegen" /></a>
<div class="container">
    <table>
        <tr>
            <th>Gebruikerstype</th>
            <th>Email</th>
            <th>Naam</th>
            <th>Postcode</th>
            <th>Adres</th>
            <th>Geboortedatum</th>
            <th>Telefoonnummer</th>
            <th>Details</th>
            <th>Aanpassen</th>
            <th>Verwijderen</th>
        </tr>
        <c:forEach items="${requestScope.users}" var="user">
            <tr>
                <td>${user.getUserType()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getRealName()}</td>
                <td>${user.getAddress()}</td>
                <td>${user.getPostal()}</td>
                <td>${user.getDateOfBirth()}</td>
                <td>${user.getPhoneNumber()}</td>
                <td>
                    <%--TODO XML + servlet aanpassen--%>
                    <form action="<c:url value="/userdetails"/>" method="post">
                        <input type="submit" name="button" value="Details"/>
                        <input type="hidden" name="user" value="${pageScope.user}"/>
                    </form>
                </td>
                <td>
                    <%--TODO XML + servlet aanpassen--%>
                    <form action="<c:url value="/ammenduser"/>" method="post">
                        <input type="submit" name="button"  value="Aanpassen"/>
                        <input type="hidden" name="user" value="${pageScope.user}"/>
                    </form>
                </td>
                <td>
                    <form action="<c:url value="/removeuser"/>" method="post">
                        <input type="submit" name="button" value="Verwijderen"/>
                        <input type="hidden" name="user" value="${pageScope.user}"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>


</div>