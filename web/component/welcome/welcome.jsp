<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="<c:url value="/global.css"/>"
    <link rel="stylesheet" href="<c:url value="/component/form.css"/>"/>
</head>
<body>
<div class="container">
    <div>
        <h2>Welkom ${current_user.realName()}, </h2>
    </div>
    <div>
        <p>U bent nu ingelogd, als u klaar bent kunt u weer uitloggen.</p>
    </div>
    <div>
        <form action="logout" method="post">
            <input class="button" type="submit" value="Uitloggen"/>
        </form>
    </div>
</div>
</body>
