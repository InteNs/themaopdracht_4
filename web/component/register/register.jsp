<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/form.css"/>"/>
<div class="container">
    <form action="<c:url value="/register"/>"  method="post">
        <fieldset name="Registreren">
            <legend>Registreren</legend>
            <div class="p">
                <label class="formlabel" for="email">Email:</label>
                <input class="text" type="text" name="email" id="email" placeholder="Vul email in" required/>
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${requestScope.email_error}"/></label>
            </div>
            <div class="p">
                <label class="formlabel" for="emailrepeat">Herhaal:</label>
                <input class="text" type="text" name="email_repeat" id="emailrepeat" placeholder="Herhaal email" required/>
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${requestScope.email_repeat_error}"/></label>
            </div>
            <div class="p">
                <label class="formlabel" for="password">Wachtwoord:</label>
                <input class="text" type="password" name="password" id="password" placeholder="Vul wachtwoord in" required/>
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${requestScope.password_error}"/></label>
            </div>
            <div class="p">
                <label class="formlabel" for="passwordrepeat">Herhaal:</label>
                <input class="text" type="password" name="password_repeat" id="passwordrepeat" placeholder="Herhaal wachtwoord" required/>
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${requestScope.password_repeat_error}"/></label>
            </div>
            <div class="p">
                <label class="formlabel" for="realname">Naam:</label>
                <input class="text" type="text" name="realname" id="realname" placeholder="Vul voor- en achternaam in" required/>
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${requestScope.realname_error}"/></label>
            </div>
            <div class="p">
                <label class="formlabel" for="date">Geboortedatum:</label>
                <input class="text" type="date" name="date" id="date" value="" required/>
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${requestScope.dateofbirth_error}"/></label>

            </div>
            <div class="p">
                <label class="formlabel" for="address">Adres:</label>
                <input class="text" type="text" name="address" id="address" placeholder="Vul uw adres in" required/>
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${requestScope.address_error}"/></label>
            </div>
            <div class="p">
                <label class="formlabel" for="postalcode">Postcode:</label>
                <input class="text" type="text" name="postal" id="postalcode" placeholder="Vul postcode in" required/>
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${requestScope.postal_error}"/></label>
            </div>
            <div class="p">
                <label class="formlabel" for="phonenumber">Telefoonnummer:</label>
                <input class="text" type="tel" name="phonenumber" id="phonenumber" placeholder="Vul hier uw telefoonnummer in." required/>
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${requestScope.phonenumber_error}"/></label>
            </div>
            <div class="p">
                <a href="<c:url value="/secure/users/admin.jsp"/>"><input type="button" class="button" value="Terug" /></a>
                <input type="reset" class="button" name="reset" value="Reset"/>
                <input type="submit" class="button" name="button" value="Registreren"/>
            </div>
        </fieldset>
    </form>
</div>
