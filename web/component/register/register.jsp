<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/form.css"/>"/>


<div class="containerform">
    <form action="register" id="register" method="post">
        <fieldset>
            <div class="p">
                <label class="formlabel" for="email">Email:</label>
                <input class="text" type="text" name="email" id="email" placeholder="Vul email in"/>
            </div>
            <div class="p">
                <label class="formlabel" for="emailrepeat">Herhaal:</label>
                <input class="text" type="text" name="emailrepeat" id="emailrepeat" placeholder="Herhaal email"/>
            </div>
            <div class="p">
                <label class="formlabel" for="password">Wachtwoord:</label>
                <input class="text" type="password" name="password" id="password" placeholder="Vul wachtwoord in"/>
            </div>
            <div class="p">
                <label class="formlabel" for="passwordrepeat">Herhaal:</label>
                <input class="text" type="password" name="passwordrepeat" id="passwordrepeat" placeholder="Herhaal wachtwoord"/>
            </div>
            <div class="p">
                <label class="formlabel" for="realname">Voor- en achternaam:</label>
                <input class="text" type="text" name="realname" id="realname" placeholder="Vul voor- en achternaam in"/>
            </div>
            <div class="p">
                <label class="formlabel" for="date">Geboortedatum:</label>
                <input class="text" type="date" name="date" id="date" value=""/>
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
            </div>
            <div class="p">
                <label class="formlabel" for="postalcode">Postcode:</label>
                <input class="text" type="text" name="postalcode" id="postalcode" placeholder="Vul postcode in"/>
            </div>
            <div class="p">
                <label class="formlabel" for="phonenumber">Telefoonnummer:</label>
                <input class="text" type="tel" name="phonenumber" id="phonenumber" placeholder="Vul hier uw telefoonnummer in."/>
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
