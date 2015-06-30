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
    <title>AutoTotaalDienst</title>
    <link rel="stylesheet" href="<c:url value="/css/global.css"/>"/>
</head>
<body>
<jsp:include page="/component/navigation/navigation.jsp"/>
<div class="textBox">
    <h2 class="center-align">Contact</h2>
    <p class="center-align">Als u liever telefonisch een afspraak wilt maken,vragen heeft of een parkeerplek wilt huren.</p>
    <p class="center-align">Voor u staan onze deuren staan 7 dagen per week open bij onze vestiging op de Nebraskadreef.</p>
    <p class="center-align">Natuurlijk kunt u ons ook e-mailen op <a class="atdlink" href="mailto:info@atd.nl">info@atd.nl</a>.</p>
    <h4 class="center-align">Auto Totaal Dienst</h4>
    <p class="center-align">
    <div class="center-align">Nebraskadreef 1</div>
    <div class="center-align">Utrecht</div>
    <div class="center-align">+3130-2613612</div>
    <p class="center-align">Dagelijks van 08.00 tot 20.00 geopend.</p>
    </p>
</div>
</body>
</html>
