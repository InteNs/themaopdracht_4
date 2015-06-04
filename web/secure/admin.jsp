<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AutoTotaalDienst</title>
    <link rel="stylesheet" href="<c:url value="/global.css"/>"/>
</head>
<body>
hoi admin
<jsp:include page="/component/navigation/navigation.jsp"/>
<c:if test="${empty current_page}">
    <jsp:include page="/component/welcome/welcomePanel.jsp"/>
</c:if>
</body>
</html>
