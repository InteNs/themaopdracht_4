<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
        <fieldset name="adduser">
            <legend>Gebruiker Toevoegen</legend>
            <div class="buttonBoxLeft">
            <form action="<c:url value="/viewusers"/>" method="post">
                <input type="submit" class="button" name="button" value="Terug naar Gebruikersoverzicht"/>
            </form>
        </div>
            <form action="<c:url value="/adduser"/>"  method="post">
            <div class="p">
                <label class="notice"><c:out value="${requestScope.email_error}"/></label>
                <label class="formlabel" for="email">Email
                    <span class="requiredColor"> *</span>
                </label>
                <input class="text" type="email" name="email" id="email" placeholder="Vul email in" required/>
            </div>
            <div class="p">
                <label class="notice"><c:out value="${requestScope.email_repeat_error}"/></label>
                <label class="formlabel" for="emailrepeat">Herhaal
                    <span class="requiredColor"> *</span>
                </label>
                <input class="text" type="email" name="email_repeat" id="emailrepeat" placeholder="Herhaal email" required/>
            </div>
            <div class="p">
                <label class="notice"><c:out value="${requestScope.password_error}"/></label>
                <label class="formlabel" for="password">Wachtwoord
                    <span class="requiredColor"> *</span>
                </label>
                <input class="text" type="password" name="password" id="password" placeholder="Vul wachtwoord in" required/>
            </div>
            <div class="p">
                <label class="notice"><c:out value="${requestScope.password_repeat_error}"/></label>
                <label class="formlabel" for="passwordrepeat">Herhaal
                    <span class="requiredColor"> *</span>
                </label>
                <input class="text" type="password" name="password_repeat" id="passwordrepeat" placeholder="Herhaal wachtwoord" required/>
            </div>
            <div class="p">
                <label class="notice"><c:out value="${requestScope.realname_error}"/></label>
                <label class="formlabel" for="realname">Naam
                    <span class="requiredColor"> *</span>
                </label>
                <input class="text" type="text" name="realname" id="realname" placeholder="Vul voor- en achternaam in" required/>
            </div>
            <div class="p">
                <label class="notice"><c:out value="${requestScope.dateofbirth_error}"/></label>
                <label class="formlabel" for="date">Geboortedatum
                    <span class="requiredColor"> *</span>
                </label>
                <input class="text" type="date" name="date" id="date" value="" required/>
            </div>
            <div class="p">
                <label class="notice"><c:out value="${requestScope.address_error}"/></label>
                <label class="formlabel" for="address">Adres
                    <span class="requiredColor"> *</span>
                </label>
                <input class="text" type="text" name="address" id="address" placeholder="Vul adres in" required/>
            </div>
            <div class="p">
                <label class="formlabel" for="postalcode">Postcode
                    <span class="requiredColor"> *</span>
                </label>
                <input class="text" type="text" name="postal" id="postalcode" placeholder="Vul postcode in" required/>
                <label class="formlabel">&nbsp;</label>
                <label class="notice"><c:out value="${requestScope.postal_error}"/></label>
            </div>
            <div class="p">
                <label class="notice"><c:out value="${requestScope.phonenumber_error}"/></label>
                <label class="formlabel" for="phonenumber">Telefoonnummer
                    <span class="requiredColor"> *</span>
                </label>
                <input class="text" type="tel" name="phonenumber" id="phonenumber" placeholder="Vul telefoonnummer in." required/>
            </div>
            <div class="p">
                <label class="notice"><c:out value="${requestScope.usertype_error}"/></label>
                <label class="formlabel" for="usertype">Type
                    <span class="requiredColor"> *</span>
                </label>
                <select class="text" id="usertype" name="usertype">
                    <option value="CUSTOMER">Klant</option>
                    <option value="OWNER">Eigenaar</option>
                    <option value="MECHANIC">Monteur</option>
                </select>
            </div>
            <div class="buttonBox">
                <input type="reset" class="button" name="reset" value="Reset"/>
                <input type="submit" class="button" name="button" value="Toevoegen"/>
            </div>
        </fieldset>
    </form>
</div>
