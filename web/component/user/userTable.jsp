<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/global.css"/>"/>
<link rel="stylesheet" href="<c:url value="/component/table.css"/>"/>
<div class="container">
    <table>
        <tr>
            <th>Gebruikerstype</th>
            <th>Email</th>
            <th>Naam</th>
            <th>Postcode</th>
            <th>Geboortedatum</th>
            <th>Telefoonnummer</th>
            <th>Verwijderen</th>
            <th>Aanpassen</th>
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
                    <form action="<c:url value="/removeuser"/>" method="post">
                        <input type="submit" name="button" value="Verwijderen"/>
                        <input type="hidden" name="user" value="${pageScope.user}"/>
                    </form>
                </td>
                <td>
                    <form action="<c:url value="/edituser"/>" method="post">
                        <input type="submit" name="button"  value="Aanpassen"/>
                        <input type="hidden" name="user" value="${pageScope.user}"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>


</div>