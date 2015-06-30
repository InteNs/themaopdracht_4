<%--
Standard Page Imports
1.  JSTL Custom Tag Library
2.  Java Language for HTML Library
--%>
<%@ taglib
        prefix="c"
        uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
        contentType="text/html;charset=UTF-8"
        language="java"%>

<html>

<head>

    <title>
        AutoTotaalDienst
    </title>

    <link
            rel="stylesheet"
            href="<c:url value="/css/global.css"/>"/>

</head>

<body>
<%--
Import & Placing Components
1.  Navigationbar
2.  Registrationform
--%>
    <jsp:include
            page="/component/navigation/navigation.jsp"/>
    <jsp:include
            page="/component/session/register.jsp"/>

</body>

</html>
