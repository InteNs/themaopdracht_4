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
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${email_error}"/></label>
            </div>
            <div class="p">
                <label class="formlabel" for="emailrepeat">Herhaal:</label>
                <input class="text" type="text" name="email_repeat" id="emailrepeat" placeholder="Herhaal email"/>
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${email_repeat_error}"/></label>
            </div>
            <div class="p">
                <label class="formlabel" for="password">Wachtwoord:</label>
                <input class="text" type="password" name="password" id="password" placeholder="Vul wachtwoord in"/>
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${password_error}"/></label>
            </div>
            <div class="p">
                <label class="formlabel" for="passwordrepeat">Herhaal:</label>
                <input class="text" type="password" name="password_repeat" id="passwordrepeat" placeholder="Herhaal wachtwoord"/>
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${password_repeat_error}"/></label>
            </div>
            <div class="p">
                <label class="formlabel" for="realname">Naam:</label>
                <input class="text" type="text" name="realname" id="realname" placeholder="Vul voor- en achternaam in"/>
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${realname_error}"/></label>
            </div>
            <div class="p">
                <label class="formlabel" for="date">Geboortedatum:</label>
                <input class="text" type="date" name="date" id="date" value=""/>
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${dateofbirth_error}"/></label>
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
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${address_error}"/></label>
            </div>
            <div class="p">
                <label class="formlabel" for="postalcode">Postcode:</label>
                <input class="text" type="text" name="postal" id="postalcode" placeholder="Vul postcode in"/>
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${postal_error}"/></label>
            </div>
            <div class="p">
                <label class="formlabel" for="phonenumber">Telefoonnummer:</label>
                <input class="text" type="tel" name="phonenumber" id="phonenumber" placeholder="Vul hier uw telefoonnummer in."/>
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${phonenumber_error}"/></label>
            </div>
            <div class="p">
                <input type="submit" name="button" value="Terug"/>
                <input type="reset" name="reset" value="Reset"/>
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
