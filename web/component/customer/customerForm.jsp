<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/customer/customerform.css"/>"/>
<div class="container">
  <form action="customerForm" id="customerform" method="post">
    <fieldset>
      <div class="p">
        <input type="button" name="button" value="Nieuw"/>
        <input type="button" name="button" value="Aanpassen"/>
        <input type="button" name="button" value="Verwijderen"/>
      </div>

      <div class="p">
        <label class="formlabel" for="name">Naam:</label><input class="text" type="text" name="name" id="name" placeholder="Vul hier uw naam in."/>
      </div>
      <%--TODO geboortedatum--%>
      <div class="p">
        <label class="formlabel" for="address">Adres:</label><input class="text" type="text" name="address" id="address" placeholder="Vul hier uw adres."/>
      </div>
      <div class="p">
        <label class="formlabel" for="postalcode">Postcode:</label><input class="text" type="text" name="postalcode" id="postalcode" placeholder="Vul hier uw postcode."/>
      </div>
      <div class="p">
        <label class="formlabel" for="city">Plaats:</label><input class="text" type="text" name="city" id="city" placeholder="Vul hier uw woonplaats."/>
      </div>
      <div class="p">
        <label class="formlabel" for="phonenumber">Telefoon:</label><input class="text" type="text" name="phonenumber" id="phonenumber" placeholder="Vul hier uw telefoonnummer in."/>
      </div>
      <div class="p">
        <label class="formlabel" for="email">Email:</label><input class="text" type="text" name="email" id="email" placeholder="Vul hier uw email."/>
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

<%--<div class="p"><label class="formlabel" for="" for="date">Geboortedatum:</label>--%>
<%--<input type="date" name="date" id="date" value=""  />--%>
<%--<link rel="stylesheet" href="jquery.ui.datepicker.mobile.css" />--%>
<%--<script src="jQuery.ui.datepicker.js"></script>--%>
<%--<script src="jquery.ui.datepicker.mobile.js"></script>--%>
<%--<script>--%>
<%--//reset type=date inputs to text--%>
<%--$( document ).bind( "mobileinit", function(){--%>
<%--$.mobile.page.prototype.options.degradeInputs.date = true;--%>
<%--});--%>
<%--</script></div>--%>