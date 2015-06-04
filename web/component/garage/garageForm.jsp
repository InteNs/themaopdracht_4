<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/garage/garageform.css"/>"/>
<div class="container">
	<form action="garageForm" id="garageform" method="post">
		<fieldset>
			<div class="p">
		 <button type="submit" >Nieuw</button>
		 <button type="submit" >Aanpassen</button>
		 <button type="submit" >Verwijderen</button>
				</div>
			<%--TODO geboortedatum--%>
			<div class="p"><label class="formlabel" for="garageMonteur">Monteur:</label>
					<select name="filter">
						<option value="Geen" selected="selected">Geen</option>
						<option value="jaap">Jaap a €15,00</option>
						<option value="hans">Hans a €12,50</option>
						<option value="sjaak">Sjaak a €10,00</option>
						<option value="piet">Piet a €15,00</option>
					</select>
			</div>

			<div class="p"><label class="formlabel" for="aantalOnderdelen">Aantal onderdelen:</label><input type="text" name="aantalOnderdelen" id = "aantalOnderdelen" size="30"/></div>
			<div class="p"><label class="formlabel" for="kenteken">Kenteken:</label><input type="text" name="kenteken" id = "kenteken" size="30"/></div>
			<div class="p"><button type="submit" >Opslaan</button><button type="submit" >Annuleren</button><br></div>
</fieldset>
</form>
</div>
				


<%--
	<div><label for="date">Datum van:</label>
		<input type="date" name="date" id="date" value=""  />
		<link rel="stylesheet" href="jquery.ui.datepicker.mobile.css" />
		<script src="jQuery.ui.datepicker.js"></script>
		<script src="jquery.ui.datepicker.mobile.js"></script>
		<script>
			//reset type=date inputs to text
			$( document ).bind( "mobileinit", function(){
				$.mobile.page.prototype.options.degradeInputs.date = true;
			});
		</script></div>


<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap-3.3.4-dist/js/bootstrap.min.js"></script> --%>
