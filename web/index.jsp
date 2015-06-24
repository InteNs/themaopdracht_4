<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>AutoTotaalDienst</title>
    <link rel="stylesheet" href="<c:url value="/css/global.css"/>"/>
</head>
<body>
<jsp:include page="/component/navigation/navigation.jsp"/>
<c:choose>
    <c:when test="${empty sessionScope.current_user}">
        <jsp:include page="/component/session/loginForm.jsp"/>
    </c:when>
    <c:otherwise>
        <div class="textBox">
            <h2 class="center-align">U bent al ingelogd!</h2>
            <p class="center-align">Klik
                <a href="<c:url value="/secure/user/homepage.jsp"/>">hier</a>
                om door te gaan naar de welkomspagina.
            </p>
            <p class="center-align">Wilt u inloggen met een andere account? Klik dan eerst
                <a href="<c:url value="/logout"/>">hier</a>
                om uit te loggen.
            </p>
        </div>
    </c:otherwise>
</c:choose>
<c:out value="${requestScope.login_error}"/>
</body>
</html>
