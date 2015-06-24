<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <fieldset name="userdetails">
        <legend>Details Gebruiker</legend>
        <c:if test="${sessionScope.current_user.getUserType() == 'CUSTOMER'}">
            <div class="buttonBoxLeft">
                <form action="<c:url value="/secure/user/homepage.jsp"/>" method="post">
                    <input type="submit" class="button" name="button" value="Terug naar Hoofdpagina"/>
                </form>
            </div>
        </c:if>
        <c:if test="${sessionScope.current_user.getUserType() == 'OWNER'}">
            <div class="buttonBoxLeft">
                <form action="<c:url value="/viewusers"/>" method="post">
                    <input type="submit" class="button" name="button" value="Terug naar Gebruikersoverzicht"/>
                </form>
            </div>
        </c:if>

        <div class="p">
            <label class="formlabel" for="email">Email</label>
            <input class="text"  readonly id="email" value="${param.email}"/>
        </div>
        <div class="p">
            <label class="formlabel" for="realname">Naam</label>
            <input class="text"  readonly id="realname" value="${param.name}"/>
        </div>
        <div class="p">
            <label class="formlabel" for="dateofbirth">Geboortedatum</label>
            <input class="text"  readonly id="dateofbirth" value="${param.dateofbirth}"/>
        </div>
        <div class="p">
            <label class="formlabel" for="address">Adres</label>
            <input class="text"  readonly id="address" value="${param.address}"/>
        </div>
        <div class="p">
            <label class="formlabel" for="postal">Postcode</label>
            <input class="text"  readonly id="postal" value="${param.postal}"/>
        </div>
        <div class="p">
            <label class="formlabel" for="phonenumber">Telefoonnummer</label>
            <input class="text"  readonly id="phonenumber" value="${param.phonenumber}"/>
        </div>
        <div class="p">
            <label class="formlabel" for="usertype">Type</label>
            <input class="text"  readonly id="usertype" value="${param.usertype}"/>

        </div>
        <c:set value="${sessionScope.current_user}" var="user"/>
        <form action="<c:url value="/secure/user/ammenduser.jsp"/>"  method="post">
        <div class="buttonbox">
            <input type="hidden" value="${user.getEmail()}"/>
            <input type="hidden" value="${pageScope.name}"/>
            <input type="hidden" value="${pageScope.dateofbirth}"/>
            <input type="hidden" value="${pageScope.address}"/>
            <input type="hidden" value="${pageScope.postal}"/>
            <input type="hidden" value="${pageScope.phonenumber}"/>
            <input type="hidden" value="${pageScope.usertype}"/>
            <input type="submit" class="button" name="button" value="Aanpassen"/>
        </div>
        </form>
    </fieldset>
</div>
