<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/navigation/navigation.css"/>"/>
<div class="containernavigation">
        <span class="navigationtitle">
            <h3>AutoTotaalDienst</h3>
        </span>
    <c:if test="${not empty current_user}">
        <form action="navigation" id="navigation" method="post">
        <span class="navigationitem">
            <input type="submit" name="button" value="Contact"/>
        </span>
        <span class="navigationitem">
            <input type="submit" name="button" value="Uitloggen"/>
        </span>
        </form>
    </c:if>
</div>


<%--<c:if test="${not empty username}">--%>
<%--<form action="navigation" id="navigation" method="post">--%>
<%--<span class="navigationitem">--%>
<%--&lt;%&ndash;button welkom&ndash;%&gt;--%>
<%--<input type="submit" name="button" value="hoofdmenu"/>--%>
<%--</span>--%>
<%--</c:if>--%>
<%--&lt;%&ndash;------------------------------&ndash;%&gt;--%>
<%--<c:if test="${userrole == 'manager'}">--%>
<%--&lt;%&ndash;TODO manager&ndash;%&gt;--%>
<%--<span class="navigationitem">--%>
<%--&lt;%&ndash;klanten&ndash;%&gt;--%>
<%--<input type="submit" name="button" value="klanten"/>--%>
<%--</span>--%>
<%--<span class="navigationitem">--%>
<%--&lt;%&ndash;werkplaats&ndash;%&gt;--%>
<%--<input type="submit" name="button" value="werkplaats"/>--%>
<%--</span>--%>
<%--<span class="navigationitem">--%>
<%--&lt;%&ndash;parkeerplaats&ndash;%&gt;--%>
<%--<input type="submit" name="button" value="parkeerplaats"/>--%>
<%--</span>--%>
<%--<span class="navigationitem">--%>
<%--&lt;%&ndash;voorraad&ndash;%&gt;--%>
<%--<input type="submit" name="button" value="voorraad"/>--%>
<%--</span>--%>
<%--<span class="navigationitem">--%>
<%--&lt;%&ndash;financieel&ndash;%&gt;--%>
<%--<input type="submit" name="button" value="financien"/>--%>
<%--</span>--%>
<%--</c:if>--%>
<%--<c:if test="${userrole == 'werknemer'}">--%>
<%--&lt;%&ndash;TODO werknemer&ndash;%&gt;--%>
<%--<span class="navigationitem">--%>
<%--&lt;%&ndash;werkplaats&ndash;%&gt;--%>
<%--<input type="submit" name="button" value="werkplaats"/>--%>
<%--</span>--%>
<%--<span class="navigationitem">--%>
<%--&lt;%&ndash;parkeerplaats&ndash;%&gt;--%>
<%--<input type="submit" name="button" value="parkeerplaats"/>--%>
<%--</span>--%>
<%--<span class="navigationitem">--%>
<%--&lt;%&ndash;voorraad met beperkingen&ndash;%&gt;--%>
<%--<input type="submit" name="button" value="voorraad"/>--%>
<%--</span>--%>
<%--<span class="navigationitem">--%>
<%--&lt;%&ndash;financieel met beperkingen&ndash;%&gt;--%>
<%--<input type="submit" name="button" value="financien"/>--%>
<%--</span>--%>
<%--</c:if>--%>
<%--<c:if test="${userrole == 'klant'}">--%>
<%--&lt;%&ndash;TODO gebruiker&ndash;%&gt;--%>
<%--<span class="navigationitem">--%>
<%--&lt;%&ndash;account&ndash;%&gt;--%>
<%--<input type="submit" name="button" value="account"/>--%>
<%--</span>--%>
<%--<span class="navigationitem">--%>
<%--&lt;%&ndash;onderhoud&ndash;%&gt;--%>
<%--<input type="submit" name="button" value="onderhoud"/>--%>
<%--</span>--%>
<%--<span class="navigationitem">--%>
<%--&lt;%&ndash;parkeren&ndash;%&gt;--%>
<%--<input type="submit" name="button" value="parkeren"/>--%>
<%--</span>--%>
<%--<span class="navigationitem">--%>
<%--&lt;%&ndash;facturen&ndash;%&gt;--%>
<%--<input type="submit" name="button" value="facturen"/>--%>
<%--</span>--%>
<%--</c:if>--%>

