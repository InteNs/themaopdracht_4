<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container logRegContainter">
<h2>Welkom ${sessionScope.current_user.getRealName()},</h2>
<p>
    Kies een van de rubrieken om in aan het werk te gaan.
</p>
<c:if test="${sessionScope.current_user.getUserType() == 'OWNER'}">
        <form class="formMainmenu" action="<c:url value="/viewusers"/>" method="post">
            <input type="submit" class="mainmenu button" name="button" value="Gebruikers&#10;Beheren"/>
        </form>

        <form class="formMainmenu" action="<c:url value="/viewproducts"/>" method="post">
            <input type="submit" class="mainmenu button" name="button" value="Producten&#10;Beheren"/>
        </form>
        <form class="formMainmenu" action="<c:url value="/viewparking"/>" method="post">
            <input type="submit" class="mainmenu button" name="button" value="Reserveringen&#10;Parkeergarage"/>
        </form>
        <p>
            U kunt ten alle tijden uitloggen met de knop in de menubalk aan de top van de pagina.
        </p>
    </div>
</c:if>
<c:if test="${sessionScope.current_user.getUserType() == 'CUSTOMER'}">
        <form class="formMainmenu" action="<c:url value="/viewcars"/>" method="post">
            <input type="submit" class="mainmenu button" name="button" value="Auto's&#10;Beheren"/>
        </form>
        <form class="formMainmenu" action="<c:url value="/secure/user/detailsuser.jsp"/>" method="post">
            <input type="submit" class="mainmenu button" name="button" value="Persoonsgegeven&#10;Beheren"/>
            <%--current_user param's--%>
            <input type="hidden" name="usertype" value="${sessionScope.current_user.getUserType()}"/>
            <input type="hidden" name="email" value="${sessionScope.current_user.getEmail()}"/>
            <input type="hidden" name="name" value="${sessionScope.current_user.getRealName()}"/>
            <input type="hidden" name="address" value="${sessionScope.current_user.getAddress()}"/>
            <input type="hidden" name="postal" value="${sessionScope.current_user.getPostal()}"/>
            <input type="hidden" name="dateofbirth" value="${sessionScope.current_user.getDateOfBirth()}"/>
            <input type="hidden" name="phonenumber" value="${sessionScope.current_user.getPhoneNumber()}"/>
        </form>
    <p>
        U kunt ten alle tijden uitloggen met de knop in de menubalk aan de top van de pagina.
    </p>
    </div>
</c:if>