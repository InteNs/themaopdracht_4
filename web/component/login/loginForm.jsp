<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/form.css"/>"/>

<div class="container">
    <form action="<c:url value="/login"/>" id="/login" method="post">
        <fieldset name="Login">
            <legend>Login</legend>
            <div class="p">
                <label class="formlabel" for="email">Email:</label>
                <input class="text" type="email" name="email" id="email" placeholder="Vul hier uw email in."/>
            </div>
            <div class="p">
                <label class="formlabel" for="password">Wachtwoord:</label>
                <input class="text" type="password" name="password" id="password" placeholder="Vul hier uw wachtwoord in."/>
            </div>
            <div class="p">
                <label class="formlabel" for="staylogged">&nbsp;</label>
                <input class="checkbox" type="checkbox" name="staylogged" id="staylogged"/>onthoud mij
            </div>
            <div class="p">
                <label class="formlabel" for="login">&nbsp;</label>
                <input class="button" type="submit" name="button" id="login" value="Login"/>
                <a href="<c:url value="/component/register/register.jsp"/>"><input type="button" class="button" value="Registreren" /></a>
            </div>
        </fieldset>
    </form>
</div>