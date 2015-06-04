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
                <table>
                    <c:forEach items="${paramValues}" var="p">
                        <tr>
                            <td>${p.key}</td>
                            <td>${p.value}</td>
                        </tr>
                    </c:forEach>
                </table>
                <%--<c:forEach items="${data.getUserController().getUsers()}" var="${user}">--%>
                <%--<tr>--%>
                    <%--<td>${user.getUserType()}</td>--%>
                    <%--<td>${user.getEmail()}</td>--%>
                    <%--<td>${user.getRealName()}</td>--%>
                    <%--<td>${user.getPostal()}</td>--%>
                    <%--<td>${user.getDateOfBirth()}</td>--%>
                    <%--<td>${user.getPhone()}</td>--%>
                    <%--<form action="/edituser" id="edituser" method="post">--%>
                    <%--<td><input type="submit" name="button" value="Verwijderen"/></td>--%>
                    <%--<td><input type="submit" name="button" value="Aanpassen"/></td>--%>
                    <%--</form>--%>
                <%--</tr>--%>
                <%--</c:forEach>--%>
            </table>
        </div>