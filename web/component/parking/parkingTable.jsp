<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
  <c:if test="${sessionScope.current_user.getUserType() == 'CUSTOMER'}">
  <div class="right">
  <a href="<c:url value="/secure/parking/addparking.jsp"/>">
    <input type="button" class="button" value="Reservering Toevoegen" />
  </a>
  </div>
    </c:if>
  <div class="right">
    <a href="<c:url value="/secure/user/homepage.jsp"/>">
      <input type="button" class="button" value="Terug" />
    </a>
  </div>

  <table>
    <tr>
      <th>Reserveringsnummer</th>
      <th>Datum</th>
      <th>Parkeerplek</th>
      <th>Klant</th>
      <th>Kenteken</th>
      <th><span class="smalltext">Details</span></th>
    </tr>
    <c:forEach items="${requestScope.reservations}" var="reservation">
      <tr>
        <td>${reservation.getID()}</td>
        <td>${reservation.getDate()}</td>
        <td>${reservation.getParkingSpot()}</td>
        <td>${reservation.getCustomer()}</td>
        <td>${reservation.getCar()}</td>
        <td>
          <form class="buttonform" action="<c:url value="/secure/parking/detailsparking.jsp"/>" method="post">
            <input type="submit" name="button" class="buttonsmall" value="&#9636;"/>
            <input type="hidden" name="usertype" value="${reservation.getID()}"/>
            <input type="hidden" name="email" value="${reservation.getDate()}"/>
            <input type="hidden" name="name" value="${reservation.getParkingSpot()}"/>
            <input type="hidden" name="address" value="${reservation.getCustomer()}"/>
            <input type="hidden" name="postal" value="${reservation.getCar()}"/>
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>