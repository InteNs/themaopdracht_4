<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href="<c:url value="/component/navigation/links.jsp"/>"><input type="button" class="button" value="Terug" /></a>
<a href="<c:url value="/secure/car/addCar.jsp"/>"><input type="button" class="button" value="Auto Toevoegen" /></a>
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
    </table>
</div>