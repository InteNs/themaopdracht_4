<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AutoTotaalDienst</title>
    <link rel="stylesheet" href="<c:url value="/global.css"/>"/>
</head>
<body>

<jsp:include page="/component/navigation/navigation.jsp"/>

<c:if test="${empty sessionScope.current_user}">
    <jsp:include page="/component/login/loginForm.jsp"/>
    <c:if test="${!empty requestScope.register}">
        <jsp:include page="/component/register/register.jsp"/>
    </c:if>
</c:if>
<c:out value="${requestScope.login_error}"/>
</body>
</html>
