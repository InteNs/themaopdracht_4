<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/customer/customerform.css"/>"/>
<div class="containerform">
  <form action="register" id="register" method="post">
    <fieldset>
      <div class="p">
        <input type="button" name="button" value="Nieuw"/>
        <input type="button" name="button" value="Aanpassen"/>
        <input type="button" name="button" value="Verwijderen"/>
      </div>

      <div class="p">
        <label class="formlabel" for="email">email:</label><input class="text" type="text" name="email" id="email" placeholder="Vul hier uw email."/>
      </div>

        <div class="p">
            <label class="formlabel" for="email_repeat">email nogmaals:</label><input class="text" type="text" name="email_repeat" id="email_repeat" placeholder="Vul hier uw email nogmaals."/>
        </div>

      <div class="p">
        <label class="formlabel" for="password">wachtwoord:</label><input class="text" type="text" name="password" id="password" placeholder="Vul hier uw wachtwoord."/>
      </div>
      <div class="p">
        <label class="formlabel" for="password_repeat">wachtwoord nogmaals:</label><input class="text" type="text" name="password_repeat" id="password_repeat" placeholder="Vul hier uw wachtwoord nogmaals."/>
      </div>
      <div class="p">
        <label class="formlabel" for="realname">naam:</label><input class="text" type="text" name="realname" id="realname" placeholder="Vul hier uw naam."/>
      </div>

        <div class="p">
            <label class="formlabel" for="date">Geboortedatum:</label>
            <input  class="text" type="date" name="date" id="date" value=""  />
            <link rel="stylesheet" href="jquery.ui.datepicker.mobile.css" />
            <script src="jQuery.ui.datepicker.js"></script>
            <script src="jquery.ui.datepicker.mobile.js"></script>
            <script>
                //reset type=date inputs to text
                $( document ).bind( "mobileinit", function(){
                    $.mobile.page.prototype.options.degradeInputs.date = true;
                });
            </script>
        </div>

        <div class="p">
            <label class="formlabel" for="address">adres:</label><input class="text" type="text" name="address" id="address" placeholder="Vul hier uw adres in."/>
        </div>

        <div class="p">
            <label class="formlabel" for="postal">postcode:</label><input class="text" type="text" name="postal" id="postal" placeholder="Vul hier uw postcode in."/>
        </div>

        <div class="p">
        <label class="formlabel" for="phonenumber">Telefoon:</label><input class="text" type="text" name="phonenumber" id="phonenumber" placeholder="Vul hier uw telefoonnummer in."/>
      </div>

      <c:if test="${userrole == 'manager'}">
        <div class="p">
          <label class="formlabel" for="blacklist">Blacklist:</label><input type="checkbox" name="blacklist" id="blacklist"/>
        </div>
      </c:if>

      <div class="p">
        <input type="reset" name="reset" value="Reset"/>
        <input type="button" name="button" value="Opslaan"/>
      </div>
    </fieldset>
  </form>
</div>
