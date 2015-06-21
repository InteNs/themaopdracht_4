<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/form.css"/>"/>
<form action="<c:url value="/viewusers"/>" method="post">
            <span class="navigationitem">
              <input type="submit" class="button" name="button" value="Gebruikers"/>
            </span>
</form>
<div class="container">
  <form action="<c:url value="/ammenduser"/>"  method="post">
    <fieldset name="userdetails">
      <legend>Details Gebruiker</legend>
      <div class="p">
        <label class="formlabel" for="email">Email:</label>
        <label class="text" name="email" id="email">${requestScope.user.getEmail()}</label>
      </div>
      <div class="p">
        <label class="formlabel" for="realname">Naam:</label>
        <label class="text" name="realname" id="realname">${requestScope.user.getRealName()}</label>
      </div>
      <div class="p">
        <label class="formlabel" for="dateofbirth">Geboortedatum:</label>
        <label class="text" name="dateofbirth" id="dateofbirth">${requestScope.user.getDateOfBirth()}</label>
      </div>
      <div class="p">
        <label class="formlabel" for="address">Adres:</label>
        <label class="text" name="address" id="address">${requestScope.user.getAddress()}</label>
      </div>
      <div class="p">
        <label class="formlabel" for="postal">Postcode:</label>
        <label class="text" name="postal" id="postal">${requestScope.user.getPostal()}</label>
      </div>
      <div class="p">
        <label class="formlabel" for="phonenumber">Telefoonnummer:</label>
        <label class="text" name="phonenumber" id="phonenumber">${requestScope.user.getPhoneNumber()}</label>
      </div>
      <div class="p">
        <label class="formlabel" for="usertype">Type:</label>
        <label class="text" name="usertype" id="usertype">${requestScope.user.getUserType()}</label>
      </div>
      <div class="p">
        <input type="submit" class="button" name="button" value="Aanpassen"/>
      </div>
    </fieldset>
  </form>
</div>
