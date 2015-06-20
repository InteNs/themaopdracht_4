<%--
  Created by IntelliJ IDEA.
  User: Jorrit Meulenbeld
  Date: 18/06/15
  Time: 12:08
  TODO: Ammend Product Page
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/form.css"/>"/>
<html>
<head>
    <title>Product Aanpassen</title>
</head>
<body>
<%--TODO: FIX THIS SHIT YO--%>
<div class="container">
  <form action="<c:url value="/ammendproduct"/>" id="ammendProduct" method="post">
    <fieldset name="Product Aanpassen">
      <legend>Product aanpassen</legend>
      <div class="p">
        <label class="formlabel" for="productname">Productnaam:</label>
        <input class="text" type="text" name="productname" id="productname" value=""/>
        <label class="formlabel">&nbsp;</label>
        <%--<label class="text"><c:out value="${requestScope.name_error}"/></label>--%>
      </div>
      <div class="p">
        <%--<label class="formlabel" for="amount">Aantal:</label>--%>
        <%--<input class="text" type="text" name="amount" id="amount" value="${param.amount}"/>--%>
        <label class="formlabel">&nbsp;</label>
        <%--<label class="text"><c:out value="${requestScope.amount_error}"/></label>--%>
      </div>
      <div class="p">
        <label class="formlabel" for="price">Prijs:</label>
        <input class="text" type="text" name="price" id="price" value="${param.price}"/>
        <label class="formlabel">&nbsp;</label>
        <%--<label class="text"><c:out value="${requestScope.price_error}"/></label>--%>
      </div>
      <div class="p">
        <label class="formlabel" for="check">*Bevestig aanpassingen:</label>
        <input class="text" type="checkbox" name="check" id="check" required/>
      </div>

      <div class="p">
        <input type="button" name="button" value="Terug"/>
        <input type="reset" name="reset" value="Reset"/>
        <input type="submit" name="button" value="Aanpassen"/>
      </div>

    </fieldset>
  </form>
</div>

</body>
</html>
