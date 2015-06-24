<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="blankContainer logRegContainter">
    <form action="<c:url value="/login"/>" id="/login" method="post">
        <fieldset name="INLOGGEN">
            <legend>Inloggen</legend>
            <div class="p">
                <label class="formlabel" for="email">Email
                    <span class="requiredColor"> *</span>
                </label>
                <input class="text" type="email" name="email" id="email" placeholder="Vul hier uw email in." required/>
            </div>
            <div class="p">
                <label class="formlabel" for="password">Wachtwoord
                    <span class="requiredColor"> *</span>
                </label>
                <input class="text" type="password" name="password" id="password" placeholder="Vul hier uw wachtwoord in."required/>
            </div>
            <div class="p">
                <label class="formlabel" for="login">&nbsp;</label>
                <div class="checkboxContainer">
                    <div class="checkbox" id="customcheckbox">
                        <input type="checkbox" type="checkbox" name="staylogged" id="remindMe" name="keep_email" />
                        <label for="remindMe" id="remindMeToo"></label>
                    </div>
                    <div class="checkboxLabel">Onthoud mij!</div>
                </div>
                <input class="button" type="submit" name="button" id="login" value="Login"/>
                <a href="<c:url value="/register.jsp"/>"><input type="button" class="button" value="Registreren" /></a>
            </div>
        </fieldset>
    </form>
</div>