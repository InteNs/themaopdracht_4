<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<div class="container">
        <fieldset name="addParking">
            <legend>Reservering Toevoegen</legend>
            <div class="buttonBoxLeft">
                <form action="<c:url value="/viewparking"/>" method="post">
                    <span class="navigationitem">
                        <input type="submit" class="button" name="button" value="Terug naar Reserveringen Overzicht"/>
                    </span>
                </form>
            </div>
            <form action="<c:url value="/addparking"/>"  method="post">
            <div class="p">
                <label class="notify"><c:out value="${requestScope.date_error}"/></label>
                <label class="formlabel" for="date">Kies een datum</label>
                <input class="text" type="date" name="date" id="date" value="" required/>
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
            <div class="buttonBox">
                <input type="submit" class="button" name="button" value="Reservering Toevoegen"/>
            </div>
            </form>
        </fieldset>
</div>