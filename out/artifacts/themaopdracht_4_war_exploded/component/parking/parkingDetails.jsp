<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <fieldset name="userdetails">
        <legend>Details Reservering</legend>
        <div class="buttonBoxLeft">
            <form action="<c:url value="/viewparking"/>" method="post">
            <span class="navigationitem">
              <input type="submit" class="button" name="button" value="Terug naar Reserveringen Overzicht"/>
            </span>
            </form>
        </div>
        <div class="p">
            <label class="formlabel" for="date">Datum</label>
            <input class="text" id="date" value="${param.date}"/>
        </div>
        <div class="p">
            <label class="formlabel" for="parkingplace">Naam</label>
            <input class="text" id="parkingplace" value="${param.parkid}"/>
        </div>
        <div class="p">
            <label class="formlabel" for="customer">Klant</label>
            <input class="text" id="customer" value="${param.customer}"/>
        </div>
        <div class="p">
            <label class="formlabel" for="car">Auto</label>
            <input class="text" id="car" value="${param.car}"/>
        </div>
        <div class="buttonBox">
            <label class="notify"><c:out value="${requestScope.date_error}"/></label>
            <form action="<c:url value="/deleteparking"/>" method="post">
                <input type="hidden" name="reservationid" value="${param.reservationid}"/>
                <input type="submit" class="button" name="button" value="Reservering verwijderen"/>
            </form>
        </div>
    </fieldset>
</div>