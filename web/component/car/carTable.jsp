<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/global.css"/>"/>
<link rel="stylesheet" href="<c:url value="/component/customerTable.css"/>"/>
<div class="container">
  <table>
    <tr>
      <th>Autotype</th>
      <th>Kenteken</th>
      <th>Verwijderen</th>
      <th>Aanpassen</th>
    </tr>
    <c:out value="${sessionScope.current_user.cars}"/>
    <c:forEach items="${sessionScope.current_user.cars}" var="car">
      <tr>
        <td>${car.getType()}</td>
        <td>${car.getNumberPlate()}</td>
        <form action="/removecar" id="removecar" method="post">
          <td><input type="submit" name="button" value="Verwijderen"/></td>
          <input type="hidden" name="car" value="${car}"/>
        </form>
        <%--<form action="/editcar" id="/editcar" method="post">--%>
          <%--<td><input type="submit" name="button"  value="Aanpassen"/></td>--%>
          <%--<input type="hidden" name="car" value="${car}"/>--%>
        <%--</form>--%>
      </tr>
    </c:forEach>
    <form action="/addcar" id="addcar" method="post">
      <tr>
        <td>
          <input type="text" name="cartype" id="cartype" placeholder="Vul autotype in"/>
        </td>
        <td>
          <input type="text" name="numberplate" id="numberplate" placeholder="Vul kenteken in"/>
        </td>
        <td>
          &nbsp;
        </td>
        <td>
          <input type="submit" name="button" value="Toevoegen" /></td>
      </tr>
    </form>
    <label class="text"><c:out value="${car_error}"/></label>


</div>