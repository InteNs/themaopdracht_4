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

        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.getUserType()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getRealName()}</td>
                <td>${user.getAddress()}</td>
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
        <form action="/adduser" id="/adduser" method="post">
            <tr>

                <td>
                    <input type="checkbox" name="usertype" id="usertype"/> Monteur
                </td>
                <td>
                    <input type="text" name="email" id="email" placeholder="Email"/>
                </td>
                <td>
                    <input type="text" name="realname" id="realname" placeholder="Naam"/>
                </td>
                <td>
                    <input type="text" name="address" id="address" placeholder="Adres"/>
                </td>
                <td>
                    <input type="text" name="postal" id="postalcode" placeholder="Postcode"/>
                </td>
                <td>
                <input type="date" name="date" id="date" value=""/>
                </td>
                <td>
                    <input type="tel" name="phonenumber" id="phonenumber" placeholder="Telefoonnummer" />
                </td>
                <td>
                    <input type="submit" name="button" value="Toevoegen" /></td>

            </tr>
        </form>
    </table>


</div>