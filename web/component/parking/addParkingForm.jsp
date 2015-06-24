<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<form action="<c:url value="/viewparking"/>" method="post">
    <span class="navigationitem">
        <input type="submit" class="button" name="button" value="Parkeren overzicht"/>
    </span>
</form>
<div class="container">
    <form action="<c:url value="/addparking"/>"  method="post">
        <fieldset name="addParking">
            <legend>Reservering toevoegen</legend>

            <div class="p">
                <label class="formlabel" for="date">Kies datum:</label>
                <input class="text" type="date" name="date" id="date" value="" required/>
                <label class="formlabel">&nbsp;</label>
                <label class="text"><c:out value="${requestScope.date_error}"/></label>
            </div>

            <div class="p">
                <c:when test="${not empty sessionScope.current_user.getCars()}">
                <label class="formlabel" for="licenseplate">Auto:</label>
                <select id="licenseplate" name="licenseplate" required>
                    <c:forEach items="${sessionScope.current_user.getCars()}" var="car">
                    <option value="${car.getLicensePlate()}">${car.getLicensePlate()}</option>
                    </c:forEach>
                </select>
                </c:when>
                <c:otherwise>
                    <label class="formlabel">&nbsp;</label>
                    <label class="text">U moet eerst een auto aanmaken voordat u een parkeerplek kan reserveren.</label>
                </c:otherwise>
            </div>

            <div class="p">
                <input type="submit" class="button" name="button" value="Reservering toevoegen"/>
            </div>

        </fieldset>
    </form>
</div>