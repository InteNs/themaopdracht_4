<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: InteNs
  Date: 18.jun.2015
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="/editcar" id="/editcar" method="post">
  <>
    <td><c:out value="${car.getType()}"></c:out></td>
    <td><c:out value="${car.getNumberPlate()}"></c:out></td>
  </tr>

  <tr>
    <td>
      <input type="text" name="cartype" id="cartype" placeholder="Vul autotype in"/>
    </td>
    <td>
      <input type="text" name="numberplate" id="numberplate" placeholder="Vul kenteken in"/>
    </td>
    <td>
      &nbsp;
    </td>
    <td>
      <input type="submit" name="button" value="Aanpassen" /></td>
  </tr>
</form>

</body>
</html>
