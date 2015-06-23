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
    <p>U bent al ingelogd. Ga door naar de welkomspagina.</p>
    <a href="<c:url value="/secure/user/homepage.jsp"/>"><input type="button" class="button" value="Welkomspagina" /></a>
</c:otherwise>
</c:choose>
<c:out value="${requestScope.login_error}"/>
</body>
</html>
