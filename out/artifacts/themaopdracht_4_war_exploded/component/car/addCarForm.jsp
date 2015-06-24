<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
  <fieldset name="Auto toevoegen">
    <legend>Auto Toevoegen</legend>
    <div class="buttonBoxLeft">
      <form action="<c:url value="/viewcars"/>" method="post">
    <span class="navigationitem">
      <input type="submit" name="button" value="Terug naar Auto Overzicht"/>
    </span>
      </form>
    </div>
    <form action="<c:url value="/addcar"/>" id="addCar" method="post">
      <div class="p">
        <label class="notice"><c:out value="${requestScope.brand_error}"/></label>
        <label class="formlabel" for="carBrand">Merk
          <span class="requiredColor"> *</span>
        </label>
        <input class="text" type="text" name="carbrand" id="carBrand" placeholder="Vul het merk in"/>
      </div>
      <div class="p">
        <label class="formlabel" for="carType">Type
          <span class="requiredColor"> *</span>
        </label>
        <input class="text" type="text" name="cartype" id="carType" placeholder="Vul het type in"/>
      </div>
      <div class="p">
        <label class="notice"><c:out value="${requestScope.numberplate_error}"/></label>
        <label class="formlabel" for="licensePlate">Kenteken
          <span class="requiredColor"> *</span>
        </label>
        <input class="text" type="text" name="numberplate" id="licensePlate" placeholder="Vul het kenteken in"/>
      </div>
      <div class="p">
        <div class="buttonBox">
          <input type="reset" name="reset" class="button" value="Reset"/>
          <input type="submit" name="button" class="button" value="Toevoegen"/>
        </div>
      </div>
    </form>

  </fieldset>
</div>
