<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.current_user.getUserType() == 'OWNER'}">
    <div class="container logRegContainter">
        <h2>Welkom ${sessionScope.current_user.getRealName()},</h2>
        <p>
            Kies een van de rubrieken om in aan het werk te gaan.
        </p>
        <form class="formMainmenu" action="<c:url value="/viewusers"/>" method="post">
            <input type="submit" class="mainmenu button" name="button" value="Gebruikers"/>
        </form>

        <form class="formMainmenu" action="<c:url value="/viewproducts"/>" method="post">
            <input type="submit" class="mainmenu button" name="button" value="Producten"/>
        </form>
        <form class="formMainmenu" action="<c:url value="/viewparking"/>" method="post">
            <input type="submit" class="mainmenu button" name="button" value="Parkeren"/>
        </form>
        <p>
            U kunt ten alle tijden uitloggen met de knop in de menubalk aan de top van de pagina.
        </p>
    </div>
</c:if>
<c:if test="${sessionScope.current_user.getUserType() == 'CUSTOMER'}">
    <div class="container">
        <form class="formMainmenu" action="<c:url value="/viewcars"/>" method="post">
            <input action="submit" class="mainmenu button" name="button" value="Autos"/>
        </form>

        <form class="formMainmenu" action="<c:url value="/ammendcustomer"/>" method="post">
            <input type="submit" class="mainmenu button" name="button" value="Autos"/>
        </form>
    </div>
</c:if>
<%--<form class="formMainmenu" action="<c:url value="/logout"/>" method="post">--%>
<%--<span class="navigationitem">--%>
<%--<input type="submit" class="mainmenu button" name="button" value="Uitloggen"/>--%>
<%--</span>--%>
<%--</form>--%>
<%--</div>--%>