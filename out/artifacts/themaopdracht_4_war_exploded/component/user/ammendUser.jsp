<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <fieldset name="adduser">
        <legend>Gebruiker Bewerken</legend>
        <div class="buttonBoxLeftAmmend">
            <form action="<c:url value="/secure/user/detailsuser.jsp"/>" method="post">
                      <span class="navigationitem">
                          <input type="hidden" name="email" value="${param.email}"/>
                          <input type="hidden" name="name" value="${param.name}"/>
                          <input type="hidden" name="dateofbirth" value="${param.dateofbirth}"/>
                          <input type="hidden" name="address" value="${param.address}"/>
                          <input type="hidden" name="postal" value="${param.postal}"/>
                          <input type="hidden" name="phonenumber" value="${param.phonenumber}"/>
                          <input type="hidden" name="usertype" value="${param.usertype}"/>
                          <input type="submit" class="button" name="button" value="Terug naar Gebruikersdetails"/>
                      </span>
            </form>
        </div>
        <div class="buttonBoxLeftAmmend">
                <form action="<c:url value="/viewusers"/>" method="post">
                    <span class="navigationitem">
                        <input type="submit" class="button" name="button" value="Terug naar Gebruikersoverzicht"/>
                    </span>
                </form>
            </div>
        <form action="<c:url value="/ammenduser"/>"  method="post">
            <div class="p">
                <input type="hidden" name="originalemail" value="${param.email}"/>
                <label class="notice"><c:out value="${requestScope.email_error}"/></label>
                <label class="formlabel" for="email">Email</label>
                <input class="text" type="email" name="email" id="email" placeholder="Vul email in" value="${param.email}"/>
            </div>
            <div class="p">
                <label class="notice"><c:out value="${requestScope.email_repeat_error}"/></label>
                <label class="formlabel" for="emailrepeat">Herhaal</label>
                <input class="text" type="email" name="email_repeat" id="emailrepeat" placeholder="Herhaal email"/>
            </div>
            <div class="p">
                <label class="notice"><c:out value="${requestScope.password_error}"/></label>
                <label class="formlabel" for="password">Wachtwoord</label>
                <input class="text" type="password" name="password" id="password" placeholder="Vul wachtwoord in"/>
            </div>
            <div class="p">
                <label class="notice"><c:out value="${requestScope.password_repeat_error}"/></label>
                <label class="formlabel" for="passwordrepeat">Herhaal</label>
                <input class="text" type="password" name="password_repeat" id="passwordrepeat" placeholder="Herhaal wachtwoord"/>
            </div>
            <div class="p">
                <label class="notice"><c:out value="${requestScope.realname_error}"/></label>
                <label class="formlabel" for="realname">Naam</label>
                <input class="text" type="text" name="realname" id="realname" placeholder="Vul voor- en achternaam in"  value="${param.name}"/>
            </div>
            <div class="p">
                <label class="notice"><c:out value="${requestScope.dateofbirth_error}"/></label>
                <label class="formlabel" for="date">Geboortedatum</label>
                <input class="text" type="date" name="date" id="date" value="${param.dateofbirth}"/>
            </div>
            <div class="p">
                <label class="notice"><c:out value="${requestScope.address_error}"/></label>
                <label class="formlabel" for="address">Adres</label>
                <input class="text" type="text" name="address" id="address" placeholder="Vul adres in" value="${param.address}"/>
            </div>
            <div class="p">
                <label class="notice"><c:out value="${requestScope.postal_error}"/></label>
                <label class="formlabel" for="postalcode">Postcode</label>
                <input class="text" type="text" name="postal" id="postalcode" placeholder="Vul postcode in" value="${param.postal}"/>
            </div>
            <div class="p">
                <label class="notice"><c:out value="${requestScope.phonenumber_error}"/></label>
                <label class="formlabel" for="phonenumber">Telefoonnummer</label>
                <input class="text" type="tel" name="phonenumber" id="phonenumber" placeholder="Vul telefoonnummer in." value="${param.phonenumber}"/>
            </div>
            <div class="p">
                <label class="notice"><c:out value="${requestScope.usertype_error}"/></label>
                <label class="formlabel" for="usertype">Type</label>
                <select class="text" id="usertype" name="usertype">
                    <option value="CUSTOMER">Klant</option>
                    <option value="OWNER">Eigenaar</option>
                    <option value="MECHANIC">Monteur</option>
                </select>
            </div>
            <div class="buttonBox">
                <input type="reset" class="button" name="reset" value="Reset"/>
                <input type="submit" class="button" name="button" value="Aanpassen"/>
            </div>
        </form>
    </fieldset>
</div>

