<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container table">
    <div class="right">
        <a href="<c:url value="/secure/user/adduser.jsp"/>">
            <input type="button" class="button" value="Gebruiker Toevoegen" />
        </a>
    </div>
    <div class="right">
        <a href="<c:url value="/secure/user/homepage.jsp"/>">
            <input type="button" class="button" value="Terug" />
        </a>
    </div>

    <table>
        <tr>
            <th>Email</th>
            <th>Naam</th>
            <th>Adres</th>
            <th>Postcode</th>
            <th>Telefoonnummer</th>
            <th><span class="smalltext">Details</span></th>
            <th><span class="smalltext">Bewerk</span></th>
            <th><span class="smalltext">Verwijder</span></th>
        </tr>
        <c:forEach items="${requestScope.users}" var="user">
            <tr>
                <td>${user.getEmail()}</td>
                <td>${user.getRealName()}</td>
                <td>${user.getAddress()}</td>
                <td>${user.getPostal()}</td>
                <td>${user.getPhoneNumber()}</td>
                <td>
                    <form class="buttonform" action="<c:url value="/secure/user/detailsuser.jsp"/>" method="post">
                        <input type="submit" name="button" class="buttonsmall" value="&#9636;"/>
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
                    <form class="buttonform" action="<c:url value="/secure/user/ammenduser.jsp"/>" method="post">
                        <input type="submit" name="button" class="buttonsmall" value="&#x270E;"/>
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
                    <form class="buttonform" action="<c:url value="/removeuser"/>" method="post">
                        <input type="submit" name="button" class="buttonsmall" value="&#10005;"/>
                        <input type="hidden" name="user" value="${pageScope.user}"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>


</div>