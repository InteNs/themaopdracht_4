<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/navigation/navigation.css"/>"/>
<div class="containernavigation">
        <span class="navigationtitle">
            <h3>AutoTotaalDienst</h3>
            <c:if test="${not empty sessionScope.current_user}" >
                <caption> - Gebruiker: ${sessionScope.current_user.getRealName()}</caption>
            </c:if>
        </span>
    <c:if test="${not empty sessionScope.current_user}">
        <form action="<c:url value="/logout"/>" id="navigation" method="post">
        <span class="navigationitem">
            <input type="submit" name="button" value="Contact"/>
        </span>
        <span class="navigationitem">
            <input type="submit" name="button" value="Uitloggen"/>
        </span>
        </form>
        <span class="floatright">
            </span>
    </c:if>
</div>


