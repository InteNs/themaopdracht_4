<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/navigation.css"/>"/>
<div class="container">

    <%--container--%>
        <span class="navigationTitle">
            <h3>AutoTotaalDienst</h3>
        </span>


    <c:if test="${empty username}">
        <%--TODO login--%>
        <form action="login" id="login" method="post">
        <span class="navigationItem">
            Login:
            </span>
            <span class="navigationItem">
                 <input type="text" name="username" placeholder="gebruikersnaam"/>
            </span>
            <span class="navigationItem">
                 <input type="text" name="button" placeholder="wachtwoord"/>
            </span>
            <span class="navigationItem">
                 <input type="submit" name="button" value="login"/>
            </span>
            <span class="navigationItem">
                 Registreren:
            </span>
            <span class="navigationItem">
                 <input type="submit" name="button" value="registreren"/>
            </span>
        </form>
    </c:if>


    <c:if test="${not empty username}">
    <form action="navigation" id="navigation" method="post">
        <span class="navigationItem">
            <%--button welkom--%>
            <input type="submit" name="button" value="hoofdmenu"/>
        </span>
        </c:if>
        <%----------------------------------%>
        <c:if test="${userrole == 'manager'}">
            <%--TODO manager--%>
        <span class="navigationItem">
            <%--klanten--%>
            <input type="submit" name="button" value="klanten"/>
        </span>
        <span class="navigationItem">
            <%--werkplaats--%>
            <input type="submit" name="button" value="werkplaats"/>
        </span>
        <span class="navigationItem">
            <%--parkeerplaats--%>
            <input type="submit" name="button" value="parkeerplaats"/>
        </span>
        <span class="navigationItem">
            <%--voorraad--%>
            <input type="submit" name="button" value="voorraad"/>
        </span>
        <span class="navigationItem">
            <%--financieel--%>
            <input type="submit" name="button" value="financien"/>
        </span>
        </c:if>
        <c:if test="${userrole == 'werknemer'}">
            <%--TODO werknemer--%>
        <span class="navigationItem">
            <%--werkplaats--%>
            <input type="submit" name="button" value="werkplaats"/>
        </span>
        <span class="navigationItem">
            <%--parkeerplaats--%>
            <input type="submit" name="button" value="parkeerplaats"/>
        </span>
        <span class="navigationItem">
            <%--voorraad met beperkingen--%>
            <input type="submit" name="button" value="voorraad"/>
        </span>
        <span class="navigationItem">
            <%--financieel met beperkingen--%>
            <input type="submit" name="button" value="financien"/>
        </span>
        </c:if>
        <c:if test="${userrole == 'klant'}">
            <%--TODO gebruiker--%>
        <span class="navigationItem">
            <%--account--%>
            <input type="submit" name="button" value="account"/>
        </span>
        <span class="navigationItem">
            <%--onderhoud--%>
            <input type="submit" name="button" value="onderhoud"/>
        </span>
        <span class="navigationItem">
            <%--parkeren--%>
            <input type="submit" name="button" value="parkeren"/>
        </span>
        <span class="navigationItem">
            <%--facturen--%>
            <input type="submit" name="button" value="facturen"/>
        </span>
        </c:if>



        <%----------------------------------%>
        <c:if test="${not empty username}">
        <span class="navigationItem">
            <%--contact--%>
            <input type="submit" name="button" value="contact"/>
        </span>
        <span class="navigationItem">
            <%--logout button--%>
            <input type="submit" name="button" value="uitloggen"/>
        </span>
    </form>
    </c:if>
</div>

