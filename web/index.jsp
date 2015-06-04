<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AutoTotaalDienst</title>
    <link rel="stylesheet" href="<c:url value="/global.css"/>"/>
</head>
<body>
<jsp:include page="component/navigation/navigation.jsp"/>
<c:if test="${empty current_user and empty register}">
    <jsp:include page="component/login/loginForm.jsp"/>
</c:if>
<c:if test="${register == 'register'}">
    <jsp:include page="component/register/register.jsp"/>
</c:if>
</body>
</html>
