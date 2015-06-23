<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/global.css"/>"/>
<link rel="stylesheet" href="<c:url value="/component/table.css"/>"/>
<a href="<c:url value="/secure/users/admin.jsp"/>"><input type="button" class="button" value="Terug" /></a>
<a href="<c:url value="/secure/users/adduser.jsp"/>"><input type="button" class="button" value="Gebruiker Toevoegen" /></a>
<div class="container">
    <table>
        <tr>
            <th>Gebruikerstype</th>
            <th>Email</th>
            <th>Naam</th>
            <th>Adres</th>
            <th>Postcode</th>
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
                    <form action="<c:url value="/secure/users/detailsuser.jsp"/>" method="post">
                        <input type="submit" name="button" value="Details"/>
                        <input type="hidden" name="usertype" value="${user.getUserType()}"/>
                        <input type="hidden" name="email" value="${user.getEmail()}"/>
                        <input type="hidden" name="name" value="${user.getRealName()}"/>
                        <input type="hidden" name="address" value="${user.getAddress()}"/>
                        <input type="hidden" name="postal" value="${user.getPostal()}"/>
                        <input type="hidden" name="dateofbirth" value="${user.getDateOfBirth()}"/>
                        <input type="hidden" name="phonenumber" value="${user.getPhoneNumber()}"/>
                    </form>
                </td>
                <td>
                    <form action="<c:url value="/secure/users/ammenduser.jsp"/>" method="post">
                        <input type="submit" name="button" value="Aanpassen"/>
                        <input type="hidden" name="usertype" value="${user.getUserType()}"/>
                        <input type="hidden" name="email" value="${user.getEmail()}"/>
                        <input type="hidden" name="name" value="${user.getRealName()}"/>
                        <input type="hidden" name="address" value="${user.getAddress()}"/>
                        <input type="hidden" name="postal" value="${user.getPostal()}"/>
                        <input type="hidden" name="dateofbirth" value="${user.getDateOfBirth()}"/>
                        <input type="hidden" name="phonenumber" value="${user.getPhoneNumber()}"/>
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