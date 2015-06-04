<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/navigation/navigation.css"/>"/>
<div class="container">

    <%--container--%>
        <span class="navigationtitle">
            <h3>AutoTotaalDienst</h3>
        </span>


    <c:if test="${empty username}">
        <%--TODO login--%>
        <form action="login" id="login" method="post">
        <span class="navigationitem">
            Login:
            </span>
            <span class="navigationitem">
                 <input type="text" name="username" placeholder="gebruikersnaam"/>
            </span>
            <span class="navigationitem">
                 <input type="text" name="button" placeholder="wachtwoord"/>
            </span>
            <span class="navigationitem">
                 <input type="submit" name="button" value="login"/>
            </span>
            <span class="navigationitem">
                 Registreren:
            </span>
            <span class="navigationitem">
                 <input type="submit" name="button" value="registreren"/>
            </span>
        </form>
    </c:if>


    <c:if test="${not empty username}">
    <form action="navigation" id="navigation" method="post">
        <span class="navigationitem">
            <%--button welkom--%>
            <input type="submit" name="button" value="hoofdmenu"/>
        </span>
        </c:if>
        <%----------------------------------%>
        <c:if test="${userrole == 'manager'}">
            <%--TODO manager--%>
        <span class="navigationitem">
            <%--klanten--%>
            <input type="submit" name="button" value="klanten"/>
        </span>
        <span class="navigationitem">
            <%--werkplaats--%>
            <input type="submit" name="button" value="werkplaats"/>
        </span>
        <span class="navigationitem">
            <%--parkeerplaats--%>
            <input type="submit" name="button" value="parkeerplaats"/>
        </span>
        <span class="navigationitem">
            <%--voorraad--%>
            <input type="submit" name="button" value="voorraad"/>
        </span>
        <span class="navigationitem">
            <%--financieel--%>
            <input type="submit" name="button" value="financien"/>
        </span>
        </c:if>
        <c:if test="${userrole == 'werknemer'}">
            <%--TODO werknemer--%>
        <span class="navigationitem">
            <%--werkplaats--%>
            <input type="submit" name="button" value="werkplaats"/>
        </span>
        <span class="navigationitem">
            <%--parkeerplaats--%>
            <input type="submit" name="button" value="parkeerplaats"/>
        </span>
        <span class="navigationitem">
            <%--voorraad met beperkingen--%>
            <input type="submit" name="button" value="voorraad"/>
        </span>
        <span class="navigationitem">
            <%--financieel met beperkingen--%>
            <input type="submit" name="button" value="financien"/>
        </span>
        </c:if>
        <c:if test="${userrole == 'klant'}">
            <%--TODO gebruiker--%>
        <span class="navigationitem">
            <%--account--%>
            <input type="submit" name="button" value="account"/>
        </span>
        <span class="navigationitem">
            <%--onderhoud--%>
            <input type="submit" name="button" value="onderhoud"/>
        </span>
        <span class="navigationitem">
            <%--parkeren--%>
            <input type="submit" name="button" value="parkeren"/>
        </span>
        <span class="navigationitem">
            <%--facturen--%>
            <input type="submit" name="button" value="facturen"/>
        </span>
        </c:if>



        <%----------------------------------%>
        <c:if test="${not empty username}">
        <span class="navigationitem">
            <%--contact--%>
            <input type="submit" name="button" value="contact"/>
        </span>
        <span class="navigationitem">
            <%--logout button--%>
            <input type="submit" name="button" value="uitloggen"/>
        </span>
    </form>
    </c:if>
</div>

