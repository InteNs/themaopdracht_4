<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <fieldset name="userdetails">
      <legend>Details Gebruiker</legend>
      <div class="buttonBoxLeft">
        <form action="<c:url value="/viewusers"/>" method="post">
          <input type="submit" class="button" name="button" value="Terug naar Gebruikersoverzicht"/>
        </form>
      </div>
  <form action="<c:url value="/secure/user/ammenduser.jsp"/>"  method="post">
      <div class="p">
        <label class="formlabel" for="email">Email</label>
        <input class="text"  readony id="email" value="${param.email}"/>
        <input type="hidden" name="email" value="${param.email}"/>
      </div>
      <div class="p">
        <label class="formlabel" for="realname">Naam</label>
        <input class="text"  readony id="realname" value="${param.name}"/>
        <input type="hidden" name="name" value="${param.name}"/>
      </div>
      <div class="p">
        <label class="formlabel" for="dateofbirth">Geboortedatum</label>
        <input class="text"  readony id="dateofbirth" value="${param.dateofbirth}"/>
        <input type="hidden" name="dateofbirth" value="${param.dateofbirth}"/>
      </div>
      <div class="p">
        <label class="formlabel" for="address">Adres</label>
        <input class="text"  readony id="address" value="${param.address}"/>
        <input type="hidden" name="address" value="${param.address}"/>
      </div>
      <div class="p">
        <label class="formlabel" for="postal">Postcode</label>
        <input class="text"  readony id="postal" value="${param.postal}"/>
        <input type="hidden" name="postal" value="${param.postal}"/>
      </div>
      <div class="p">
        <label class="formlabel" for="phonenumber">Telefoonnummer</label>
        <input class="text"  readony id="phonenumber" value="${param.phonenumber}"/>
        <input type="hidden" name="phonenumber" value="${param.phonenumber}"/>
      </div>
      <div class="p">
        <label class="formlabel" for="usertype">Type</label>
        <input class="text"  readony id="usertype" value="${param.usertype}"/>
        <input type="hidden" name="usertype" value="${param.usertype}"/>
      </div>
      <div class="buttonbox">
        <input type="submit" class="button" name="button" value="Aanpassen"/>
      </div>
  </form>
    </fieldset>
</div>
