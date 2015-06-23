<%--
  Created by IntelliJ IDEA.
  User: HogeschoolUtrecht
  Date: 18/06/15
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/form.css"/>"/>
<form action="<c:url value="/viewcars"/>" method="post">
            <span class="navigationitem">
              <input type="submit" name="button" value="Auto's"/>
            </span>
</form>
<div class="container">
  <form action="<c:url value="/addcar"/>" id="addCar" method="post">
    <fieldset name="Auto toevoegen">
      <legend>Auto toevoegen</legend>
      <div class="p">
        <label class="formlabel" for="carBrand">Merk:</label>
        <input class="text" type="text" name="carbrand" id="carBrand" placeholder="Vul het merk in"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.brand_error}"/></label>
      </div>
      <div class="p">
        <label class="formlabel" for="carType">Type:</label>
        <input class="text" type="text" name="cartype" id="carType" placeholder="Vul het type in"/>
        <label class="formlabel">&nbsp;</label>
      </div>
      <div class="p">
        <label class="formlabel" for="numberPlate">Kenteken:</label>
        <input class="text" type="text" name="numberplate" id="numberPlate" placeholder="Vul het kenteken in"/>
        <label class="formlabel">&nbsp;</label>
        <label class="text"><c:out value="${requestScope.numberplate_error}"/></label>
      </div>
      <div class="p">
        <input type="reset" name="reset" class="button" value="Reset"/>
        <input type="submit" name="button" class="button" value="Toevoegen"/>
      </div>

    </fieldset>
  </form>
</div>
