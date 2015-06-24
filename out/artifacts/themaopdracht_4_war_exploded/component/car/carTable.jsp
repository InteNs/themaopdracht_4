<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="right">
        <a href="<c:url value="/component/navigation/links.jsp"/>"><input type="button" class="button" value="Terug" /></a>
    </div>
    <div class="right">
        <a href="<c:url value="/secure/car/addcar.jsp"/>"><input type="button" class="button" value="Auto Toevoegen" /></a>
    </div>
    <table>
        <tr>
            <th>Autotype</th>
            <th>Kenteken</th>
            <th><span class="smalltext">Verwijder</span></th>
        </tr>
        <c:forEach items="${sessionScope.current_user.cars}" var="car">
        <tr>
            <td>${car.getType()}</td>
            <td>${car.getNumberPlate()}</td>
            <td>
                <form action="<c:url value="/removecar"/>" id="removecar" method="post">
                    <input type="submit" class="buttonsmall" value="&#10005;"/>
                    <input type="hidden" name="selectedcar" value="${car}"/>
                </form>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>