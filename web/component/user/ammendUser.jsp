<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/form.css"/>"/>
<form action="<c:url value="/viewusers"/>" method="post">
            <span class="navigationitem">
              <input type="submit" class="button" name="button" value="Gebruikers"/>
            </span>
</form>
<%--TODO XML userdetails--%>
<form action="<c:url value="/userdetails"/>" method="post">
            <span class="navigationitem">
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
        <input class="text" type="text" name="email" id="email" placeholder="Vul email in" value="${requestScope.user.getEmail()}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.email_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="emailrepeat">Herhaal:</label>
        <input class="text" type="text" name="email_repeat" id="emailrepeat" placeholder="Herhaal email"/>
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
        <input class="text" type="text" name="realname" id="realname" placeholder="Vul voor- en achternaam in"  value="${requestScope.user.getRealName()}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.realname_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="date">Geboortedatum:</label>
        <input class="text" type="date" name="date" id="date" value="${requestScope.user.getDateOfBirth()}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.dateofbirth_error}"/></label>

      </div>
      <div class="p">
        <label class="formlabel" for="address">Adres:</label>
        <input class="text" type="text" name="address" id="address" placeholder="Vul adres in" value="${requestScope.user.getAddress()}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.address_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="postalcode">Postcode:</label>
        <input class="text" type="text" name="postal" id="postalcode" placeholder="Vul postcode in" value="${requestScope.user.getPostal()}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.postal_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="phonenumber">Telefoonnummer:</label>
        <input class="text" type="tel" name="phonenumber" id="phonenumber" placeholder="Vul telefoonnummer in." value="${requestScope.user.getPhoneNumber()}"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.phonenumber_error}"/></label>
      </div>
      <%--TODO usertype kunnen ontvangen in backend--%>
      <%--TODO dropdown for usertype--%>
      <div class="p">
        <label class="formlabel" for="usertype">Type:</label>
        <input class="text" type="tel" name="usertype" id="usertype" placeholder="Vul type gebruiker in."/>
        <label class="formlabel">&nbsp;</label>
        <%--TODO usertype_error--%>
        <label class="text"><c:out value="${requestScope.usertype_error}"/></label>
      </div>
      <div class="p">
        <input type="reset" class="button" name="reset" value="Reset"/>
        <input type="submit" class="button" name="button" value="Aanpassen"/>
      </div>
    </fieldset>
  </form>
</div>
