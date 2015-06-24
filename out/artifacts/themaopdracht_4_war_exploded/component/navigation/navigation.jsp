<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="containernavigation">

    <%-- Logo --%>
    <div class="navigationtitle">
        <h1>
            <div><span class="black">A.&#09;</span>uto</div>
            <div><span class="black">T.&#09;</span>otaal</div>
            <div><span class="black">D.&#09;</span>ienst</div>
        </h1>
    </div>

    <%-- Uitloggen --%>
    <c:if test="${not empty sessionScope.current_user}">
        <div class="right navigationitem">
            <form action="<c:url value="/logout"/>" id="navigation" method="post">
                <input class="button" type="submit" name="button" value="Uitloggen"/>
            </form>
        </div>
    </c:if>

    <%-- Contact --%>
    <div class="right navigationitem">
        <a href="#" id="current">
            <input class="button" type="button" name="button" value="Contact"/>
        </a>
    </div>

        <%-- owner nav items --%>
        <c:if test="${sessionScope.current_user.getUserType() == 'OWNER'}">
            <div class="right navigationitem">
                <form action="<c:url value="/viewparking"/>" method="post">
                    <input type="submit" class="button" name="button" value="Parkeren"/>
                </form>
            </div>
            <div class="right navigationitem">
                <form action="<c:url value="/viewproducts"/>" method="post">
                    <input type="submit" class="button" name="button" value="Producten"/>
                </form>
            </div>
            <div class="right navigationitem">
                <form action="<c:url value="/viewusers"/>" method="post">
                    <input type="submit" class="button" name="button" value="Gebruikers"/>
                </form>
            </div>
        </c:if>

        <%-- customer nav item --%>
        <c:if test="${sessionScope.current_user.getUserType() == 'CUSTOMER'}">
            <div class="right navigationitem">
                <form action="<c:url value="/viewparking"/>" method="post">
                    <input type="submit" class="button" name="button" value="Parkeren"/>
                </form>
            </div>
            <div class="right navigationitem">
                <form action="<c:url value="/secure/user/detailsuser.jsp"/>" method="post">
                    <input type="submit" class="button" name="button" value="Gegevens Aanpassen"/>
                        <%--current_user param's--%>
                    <input type="hidden" name="usertype" value="${sessionScope.current_user.getUserType()}"/>
                    <input type="hidden" name="email" value="${sessionScope.current_user.getEmail()}"/>
                    <input type="hidden" name="name" value="${sessionScope.current_user.getRealName()}"/>
                    <input type="hidden" name="address" value="${sessionScope.current_user.getAddress()}"/>
                    <input type="hidden" name="postal" value="${sessionScope.current_user.getPostal()}"/>
                    <input type="hidden" name="dateofbirth" value="${sessionScope.current_user.getDateOfBirth()}"/>
                    <input type="hidden" name="phonenumber" value="${sessionScope.current_user.getPhoneNumber()}"/>
                </form>
            </div>
            <div class="right navigationitem">
                <form action="<c:url value="/viewcars"/>" method="post">
                    <input type="submit" class="button" name="button" value="Auto's Aanpassen"/>
                </form>
            </div>
        </c:if>
</div>

<%-- Huidig ingelogde gebruiker --%>
<c:if test="${not empty sessionScope.current_user}" >
    <div id="currentuserinfo">
        Huidig ingelogde gebruiker: <span id="username">${sessionScope.current_user.getRealName()}</span>.
    </div>
</c:if>

