<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AutoTotaalDienst</title>
    <link rel="stylesheet" href="<c:url value="/css/global.css"/>"/>
</head>
    <body>
        <jsp:include page="/component/navigation/navigation.jsp"/>
        <c:if test="${sessionScope.current_user.getUserType() == 'CUSTOMER'}">
        <jsp:include page="/component/user/ammendUserCustomer.jsp"/>
        </c:if>
        <c:if test="${sessionScope.current_user.getUserType() == 'OWNER'}">
        <jsp:include page="/component/user/ammendUser.jsp"/>
        </c:if>
    </body>
</html>