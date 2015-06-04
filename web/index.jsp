<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <jsp:include page="component/navigation/navigation.jsp"/>
<c:if test="${not empty register}">
  <jsp:include page="component/customer/customerForm.jsp"/>
  </c:if>
  </body>
</html>
