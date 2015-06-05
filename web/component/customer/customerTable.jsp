<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/global.css"/>"/>
        <div class="container">
            <table>

                <tr>
                    <th>Gebruikerstype</th>
                    <th>Email</th>
                    <th>Naam</th>
                    <th>Postcode</th>
                    <th>Geboortedatum</th>
                    <th>Telefoonnummer</th>
                </tr>

                <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.getUserType()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getRealName()}</td>
                    <td>${user.getPostal()}</td>
                    <td>${user.getDateOfBirth()}</td>
                    <td>${user.getPhoneNumber()}</td>
                    <form action="/removeuser" id="edituser" method="post">
                         <td><input type="submit" name="button" value="Verwijderen"/></td>
                    </form>
                    <form action="/edituser" id="edituser" method="post"> >
                         <td><input type="submit" name="button" value="Aanpassen"/></td>
                    </form>
                </tr>
                </c:forEach>
            </table>
            <form action="/adduser" id="edituser" method="post">
                <td><input type="submit" name="button" value="toevoegen"/></td>
            </form>

        </div>