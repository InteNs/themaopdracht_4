<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="<c:url value="/viewparking"/>" method="post">
            <span class="navigationitem">
              <input type="submit" class="button" name="button" value="Parkeren overzicht"/>
            </span>
</form>
<div class="container">
    <fieldset name="userdetails">
        <legend>Details Gebruiker</legend>
        <div class="p">
            <label class="formlabel" for="date">Datum:</label>
            <label class="text" id="date">${param.date}</label>
        </div>
        <div class="p">
            <label class="formlabel" for="parkingplace">Naam:</label>
            <label class="text" id="parkingplace">${param.parkid}</label>
        </div>
        <div class="p">
            <label class="formlabel" for="customer">Klant:</label>
            <label class="text" id="customer">${param.customer}</label>
        </div>
        <div class="p">
            <label class="formlabel" for="car">Auto:</label>
            <label class="text" id="car">${param.car}</label>
        </div>
        <div class="p">
            <form action="<c:url value="/deleteparking"/>" method="post">
                <input type="hidden" name="reservationid" value="${param.reservationid}"/>
                <input type="submit" class="button" name="button" value="Reservering verwijderen"/>
                <label class="text"><c:out value="${requestScope.date_error}"/></label>
            </form>
        </div>
    </fieldset>
</div>