<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/global.css"/>"/>
<link rel="stylesheet" href="<c:url value="/component/customerTable.css"/>"/>
< class="container">
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

    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.getUserType()}</td>
            <td>${user.getEmail()}</td>
            <td>${user.getRealName()}</td>
            <td>${user.getPostal()}</td>
            <td>${user.getDateOfBirth()}</td>
            <td>${user.getPhoneNumber()}</td>
            <form action="/removeuser" id="/removeuser" method="post">
                <td><input type="submit" name="button" value="Verwijderen"/></td>
                <input type="hidden" name="user" value="${user}"/>
            </form>
            <form action="/edituser" id="/edituser" method="post">
                <td><input type="submit" name="button"  value="Aanpassen"/></td>
                <input type="hidden" name="user" value="${user}"/>
            </form>
        </tr>
    </c:forEach>
    <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>
            <form action="/adduser" id="/adduser" method="post">
                &nbsp;<input type="submit" name="button" value="toevoegen"/>
            </form>
        </td>
    </tr>
</table>


</div>