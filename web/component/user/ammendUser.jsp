<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/form.css"/>"/>
<form action="<c:url value="/viewusers"/>" method="post">
            <span class="navigationitem">
              <input type="submit" class="button" name="button" value="Gebruikers"/>
            </span>
</form>
<%--TODO XML userdetails--%>
<form action="<c:url value="/secure/detailsuser.jsp"/>" method="post">
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
<%--TODO XML ammenduser--%>
    <form action="<c:url value="/ammenduser"/>"  method="post">
    <fieldset name="adduser">
      <legend>Gebruiker toevoegen</legend>
      <div class="p">
        <label class="formlabel" for="email">Email:</label>
        <input class="text" type="text" name="email" id="email" placeholder="Vul email in" value="${param.email}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${pageScope.email_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="emailrepeat">Herhaal:</label>
        <input class="text" type="text" name="email_repeat" id="emailrepeat" placeholder="Herhaal email"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${pageScope.email_repeat_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="password">Wachtwoord:</label>
        <input class="text" type="password" name="password" id="password" placeholder="Vul wachtwoord in"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${pageScope.password_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="passwordrepeat">Herhaal:</label>
        <input class="text" type="password" name="password_repeat" id="passwordrepeat" placeholder="Herhaal wachtwoord"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${pageScope.password_repeat_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="realname">Naam:</label>
        <input class="text" type="text" name="realname" id="realname" placeholder="Vul voor- en achternaam in"  value="${param.name}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${pageScope.realname_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="date">Geboortedatum:</label>
        <input class="text" type="date" name="date" id="date" value="${param.dateofbirth}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${pageScope.dateofbirth_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="address">Adres:</label>
        <input class="text" type="text" name="address" id="address" placeholder="Vul adres in" value="${param.address}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${pageScope.address_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="postalcode">Postcode:</label>
        <input class="text" type="text" name="postal" id="postalcode" placeholder="Vul postcode in" value="${param.postal}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${pageScope.postal_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="phonenumber">Telefoonnummer:</label>
        <input class="text" type="tel" name="phonenumber" id="phonenumber" placeholder="Vul telefoonnummer in." value="${param.phonenumber}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${pageScope.phonenumber_error}"/></label>
      </div>
      <%--TODO usertype kunnen ontvangen in backend--%>
      <%--TODO dropdown for usertype--%>
      <div class="p">
        <label class="formlabel" for="usertype">Type:</label>
        <input class="text" type="tel" name="usertype" id="usertype" placeholder="Vul type gebruiker in." value="${param.usertype}"/>
        <label class="formlabel">&nbsp;</label>
        <%--TODO usertype_error--%>
        <label class="text"><c:out value="${pageScope.usertype_error}"/></label>
      </div>
      <div class="p">
        <input type="reset" class="button" name="reset" value="Reset"/>
        <input type="submit" class="button" name="button" value="Aanpassen"/>
      </div>
    </fieldset>
  </form>
</div>

