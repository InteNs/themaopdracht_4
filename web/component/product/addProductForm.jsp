<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <fieldset name="Product toevoegen">
      <legend>Product Toevoegen</legend>
      <div class="buttonBoxLeft">
        <form action="<c:url value="/viewproducts"/>" method="post">
          <input type="submit" class="button" name="button" value="Terug naar Productenoverzicht"/>
        </form>
      </div>
      <form action="<c:url value="/addproduct"/>" id="addProduct" method="post">
        <div class="p">
          <label class="notice"><c:out value="${requestScope.name_error}"/></label>
          <label class="formlabel" for="productname">Productnaam
            <span class="requiredColor"> *</span>
          </label>
        <input class="text" type="text" name="productname" id="productname" placeholder="Vul de Productnaam in" required/>
      </div>
      <div class="p">
        <label class="notice"><c:out value="${requestScope.amount_error}"/></label>
        <label class="formlabel" for="amount">Aantal
          <span class="requiredColor"> *</span>
        </label>
        <input class="text" type="number" step="1" name="amount" id="amount" placeholder="Vul het aantal in"required/>
      </div>
      <div class="p">
        <label class="notice"><c:out value="${requestScope.price_error}"/></label>
        <label class="formlabel" for="price">Prijs
          <span class="requiredColor"> *</span>
        </label>
        <input class="text" type="number" name="price" id="price" step="0.01" placeholder="Vul de prijs in"required/>
      </div>
      <div class="buttonBox">
        <input type="reset" name="reset" class="button" value="Reset"/>
        <input type="submit" name="button" class="button" value="Toevoegen"/>
      </div>
      </form>
    </fieldset>
</div>
