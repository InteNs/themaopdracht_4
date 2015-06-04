<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/stock/stockform.css"/>"/>
<div class="container">
	<form action="stockForm" id="stockform" method="post">
		<fieldset>
			<div class="p">
				<input type="button" name="button" value="Nieuw"/>
				<input type="button" name="button" value="Aanpassen"/>
				<input type="button" name="button" value="Verwijderen"/>
			</div>
			<div class="p"><label class="formlabel" for="Naam">Naam:</label><input type="text" name="naam" id = "naam" size="30"/></div>
			<div class="p"><label class="formlabel" for="aantal">Aantal:</label><input type="text" name="aantal" id = "aantal" size="30"/></div>
			<div class="p"><label class="formlabel" for="minAantal">Min. Aantal:</label><input type="text" name="minAantal" id = "minAantal" size="30" /></div>
			<div class="p"><label class="formlabel" for="prijs">Prijs:</label><input type="text" name="prijs" id = "prijs" size="30" /></div>
			<div class="p"><label class="formlabel" for="inkoopprijs">Inkoopprijs:</label><input type="text" name="inkoopprijs" id = "inkoopprijs" size="30" /></div>
			<div class="p"><label class="formlabel" for="leverancier">Leverancier:</label>
				<select name="filter">
						<option value="Geen" selected="selected">Geen</option>
						<option value="CheapoBV">Cheapo BV</option>
						<option value="BandenBV">Banden BV</option>
						<option value="Peugot">Peugot</option>
						<option value="Mercedes">Mercedes</option>
						<option value="Shell">Shell</option>
					</select>
			</div>
			<div class="p"><label class="formlabel" for="adres">Adres:</label><input type="text" name="adres" id = "adres" size="20"/></div>
			<div class="p"><label class="formlabel" for="postcode">Postcode:</label><input type="text" name="postcode" id = "postcode" size="10"/></div>
			<div class="p"><label class="formlabel" for="plaats">Plaats:</label><input type="text" name="plaats" id = "plaats" size="10"/></div>
			<div class="p">
				<button type="submit" >Opslaan</button>
			    <button type="submit" >Annuleren</button><br>
				</div>
			</fieldset>
		</form>
	</div>
<%--
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap-3.3.4-dist/js/bootstrap.min.js"></script> --%>
	