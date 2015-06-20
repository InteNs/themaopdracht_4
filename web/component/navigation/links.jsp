<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jorrit Meulenbeld
  Date: 20/06/15
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<div>
    <c:if test="${sessionScope.current_user.getUserType() == 'OWNER'}">
        <form action="<c:url value="/viewusers"/>" method="post">
            <span class="navigationitem">
              <input type="submit" name="button" value="Gebruikers"/>
            </span>
        </form>

        <form action="<c:url value="/viewproducts"/>" method="post">
            <span class="navigationitem">
              <input type="submit" name="button" value="Producten"/>
            </span>
        </form>
    </c:if>
    <c:if test="${sessionScope.current_user.getUserType() == 'CUSTOMER'}">
    <form action="<c:url value="/viewcars"/>" method="post">
            <span class="navigationitem">
              <input type="submit" name="button" value="Autos"/>
            </span>
    </form>
    </c:if>
    <form action="<c:url value="/logout"/>" method="post">
        <span class="navigationitem">
          <input type="submit" name="button" value="Uitloggen"/>
        </span>
    </form>
</div>