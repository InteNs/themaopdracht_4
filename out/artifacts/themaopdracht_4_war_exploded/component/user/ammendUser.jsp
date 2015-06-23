<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="<c:url value="/viewusers"/>" method="post">
            <span class="navigationitem">
              <input type="submit" class="button" name="button" value="Gebruikers"/>
            </span>
</form>
<form action="<c:url value="/secure/user/detailsuser.jsp"/>" method="post">
            <span class="navigationitem">
  <input type="hidden" name="email" value="${param.email}"/>
  <input type="hidden" name="name" value="${param.name}"/>
  <input type="hidden" name="dateofbirth" value="${param.dateofbirth}"/>
  <input type="hidden" name="address" value="${param.address}"/>
  <input type="hidden" name="postal" value="${param.postal}"/>
  <input type="hidden" name="phonenumber" value="${param.phonenumber}"/>
              <input type="hidden" name="usertype" value="${param.usertype}"/>
              <input type="submit" class="button" name="button" value="Details"/>
            </span>
</form>
<div class="container">
    <form action="<c:url value="/ammenduser"/>"  method="post">
    <fieldset name="adduser">
      <legend>Gebruiker aanpssen</legend>
      <div class="p">
        <label class="formlabel" for="email">Email:</label>
        <input class="text" type="email" name="email" id="email" placeholder="Vul email in" value="${param.email}"/>
          <input type="hidden" name="originalemail" value="${param.email}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.email_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="emailrepeat">Herhaal:</label>
        <input class="text" type="email" name="email_repeat" id="emailrepeat" placeholder="Herhaal email"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.email_repeat_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="password">Wachtwoord:</label>
        <input class="text" type="password" name="password" id="password" placeholder="Vul wachtwoord in"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.password_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="passwordrepeat">Herhaal:</label>
        <input class="text" type="password" name="password_repeat" id="passwordrepeat" placeholder="Herhaal wachtwoord"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.password_repeat_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="realname">Naam:</label>
        <input class="text" type="text" name="realname" id="realname" placeholder="Vul voor- en achternaam in"  value="${param.name}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.realname_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="date">Geboortedatum:</label>
        <input class="text" type="date" name="date" id="date" value="${param.dateofbirth}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.dateofbirth_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="address">Adres:</label>
        <input class="text" type="text" name="address" id="address" placeholder="Vul adres in" value="${param.address}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.address_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="postalcode">Postcode:</label>
        <input class="text" type="text" name="postal" id="postalcode" placeholder="Vul postcode in" value="${param.postal}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.postal_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="phonenumber">Telefoonnummer:</label>
        <input class="text" type="tel" name="phonenumber" id="phonenumber" placeholder="Vul telefoonnummer in." value="${param.phonenumber}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.phonenumber_error}"/></label>
      </div>
      <div class="p">
          <label class="formlabel" for="usertype">Type:</label>
          <select id="usertype" name="usertype">
              <option value="CUSTOMER">Klant</option>
              <option value="OWNER">Eigenaar</option>
              <option value="MECHANIC">Monteur</option>
          </select>
          <label class="formlabel">&nbsp;</label>
      </div>
      <div class="p">
        <input type="reset" class="button" name="reset" value="Reset"/>
        <input type="submit" class="button" name="button" value="Aanpassen"/>
      </div>
    </fieldset>
  </form>
</div>

