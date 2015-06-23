<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="<c:url value="/viewusers"/>" method="post">
            <span class="navigationitem">
              <input type="submit" class="button" name="button" value="Gebruikers"/>
            </span>
</form>
<div class="container">
  <form action="<c:url value="/secure/user/ammenduser.jsp"/>"  method="post">
    <fieldset name="userdetails">
      <legend>Details Gebruiker</legend>
      <div class="p">
        <label class="formlabel" for="email">Email:</label>
        <label class="text" id="email">${param.email}</label>
        <input type="hidden" name="email" value="${param.email}"/>
      </div>
      <div class="p">
        <label class="formlabel" for="realname">Naam:</label>
        <label class="text" id="realname">${param.name}</label>
        <input type="hidden" name="name" value="${param.name}"/>
      </div>
      <div class="p">
        <label class="formlabel" for="dateofbirth">Geboortedatum:</label>
        <label class="text" id="dateofbirth">${param.dateofbirth}</label>
        <input type="hidden" name="dateofbirth" value="${param.dateofbirth}"/>
      </div>
      <div class="p">
        <label class="formlabel" for="address">Adres:</label>
        <label class="text" id="address">${param.address}</label>
        <input type="hidden" name="address" value="${param.address}"/>
      </div>
      <div class="p">
        <label class="formlabel" for="postal">Postcode:</label>
        <label class="text" id="postal">${param.postal}</label>
        <input type="hidden" name="postal" value="${param.postal}"/>
      </div>
      <div class="p">
        <label class="formlabel" for="phonenumber">Telefoonnummer:</label>
        <label class="text" id="phonenumber">${param.phonenumber}</label>
        <input type="hidden" name="phonenumber" value="${param.phonenumber}"/>
      </div>
      <div class="p">
        <label class="formlabel" for="usertype">Type:</label>
        <label class="text" id="usertype">${param.usertype}</label>
        <input type="hidden" name="usertype" value="${param.usertype}"/>
      </div>
      <div class="p">
        <input type="submit" class="button" name="button" value="Aanpassen"/>
      </div>
    </fieldset>
  </form>
</div>
