<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/form.css"/>"/>


<div class="containerform">
    <form action="register" id="register" method="post">
        <fieldset name="Registreren">
            <legend>Registreren</legend>
            <div class="p">
                <label class="formlabel" for="email">Email:</label>
                <input class="text" type="text" name="email" id="email" placeholder="Vul email in"/>
                <c:out value="email_error"/>
            </div>
            <div class="p">
                <label class="formlabel" for="emailrepeat">Herhaal:</label>
                <input class="text" type="text" name="email_repeat" id="emailrepeat" placeholder="Herhaal email"/>
                <c:out value="email_repeat_error"/>
            </div>
            <div class="p">
                <label class="formlabel" for="password">Wachtwoord:</label>
                <input class="text" type="password" name="password" id="password" placeholder="Vul wachtwoord in"/>
                <c:out value="password_error"/>
            </div>
            <div class="p">
                <label class="formlabel" for="passwordrepeat">Herhaal:</label>
                <input class="text" type="password" name="password_repeat" id="passwordrepeat" placeholder="Herhaal wachtwoord"/>
                <c:out value="password_repeat_error"/>
            </div>
            <div class="p">
                <label class="formlabel" for="realname">Voor- en achternaam:</label>
                <input class="text" type="text" name="realname" id="realname" placeholder="Vul voor- en achternaam in"/>
                <c:out value="realname_error"/>
            </div>
            <div class="p">
                <label class="formlabel" for="date">Geboortedatum:</label>
                <input class="text" type="date" name="date" id="date" value=""/>
                <c:out value="dateofbirth_error"/>
                <link rel="stylesheet" href="jquery.ui.datepicker.mobile.css" />
                <script src="jQuery.ui.datepicker.js"/>
                <script src="jquery.ui.datepicker.mobile.js"/>
                <script>
                    //reset type=date inputs to text
                    $( document ).bind( "mobileinit", function(){
                        $.mobile.page.prototype.options.degradeInputs.date = true;
                    });
                </script>
            </div>
            <div class="p">
                <label class="formlabel" for="address">Adres:</label>
                <input class="text" type="text" name="address" id="address" placeholder="Vul uw adres in"/>
                <c:out value="address_error"/>
            </div>
            <div class="p">
                <label class="formlabel" for="postalcode">Postcode:</label>
                <input class="text" type="text" name="postal" id="postalcode" placeholder="Vul postcode in"/>
                <c:out value="postal_error"/>
            </div>
            <div class="p">
                <label class="formlabel" for="phonenumber">Telefoonnummer:</label>
                <input class="text" type="tel" name="phonenumber" id="phonenumber" placeholder="Vul hier uw telefoonnummer in."/>
                <c:out value="phonenumber_error"/>
            </div>
            <div class="p">
                <input type="reset" name="reset" value="Reset formulier"/>
                <input type="submit" name="button" value="Registreren"/>
            </div>
        </fieldset>
    </form>
</div>


<%--<div class="p">--%>
<%--<input type="submit" name="button" value="Nieuw"/>--%>
<%--<input type="submit" name="button" value="Aanpassen"/>--%>
<%--<input type="submit" name="button" value="Verwijderen"/>--%>
<%--</div>--%>

<%--<c:if test="${userrole == 'manager'}">--%>
<%--<div class="p">--%>
<%--<label class="formlabel" for="blacklist">Blacklist:</label>--%>
<%--<input type="checkbox" name="blacklist" id="blacklist"/>--%>
<%--</div>--%>
<%--</c:if>--%>
