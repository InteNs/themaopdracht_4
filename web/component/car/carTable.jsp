<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/global.css"/>"/>
<link rel="stylesheet" href="<c:url value="/component/table.css"/>"/>
<div class="container">
    <table>
        <tr>
            <th>Autotype</th>
            <th>Kenteken</th>
            <th>Verwijderen</th>
        </tr>
        <c:forEach items="${sessionScope.current_user.cars}" var="car">
        <tr>
            <td>${car.getType()}</td>
            <td>${car.getNumberPlate()}</td>
            <td>
                <form action="<c:url value="/removecar"/>" id="removecar" method="post">
                    <input type="submit" name="button" value="Verwijderen"/>
                    <input type="hidden" name="selectedcar" value="${car}"/>
                </form>
            </td>
        </tr>
        </c:forEach>
        <form action="<c:url value="/addcar"/>" id="addcar" method="post">
            <tr>
                <td><input type="text" name="cartype" id="cartype" placeholder="Vul autotype in"/></td>
                <td><input type="text" name="numberplate" id="numberplate" placeholder="Vul kenteken in"/></td>
                <td>&nbsp;</td>
                <td><input type="submit" name="button" value="Toevoegen" /></td>
            </tr>
        </form>
        <label class="text"><c:out value="${requestScope.car_error}"/></label>


</div>