<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/parking/parkingform.css"/>"/>
<div class="container">
	<form action="parkingForm" id="parkingform" method="post">
		<fieldset>
			<div class="p">
		 <button href="submit">Nieuw</button>
		 <button type="submit" >Aanpassen</button>
		 <button type="submit" >Verwijderen</button>
				</div>
			<%--TODO datumVan--%>
			<%--TODO datumTot--%>
			<div class="p"><label class="formlabel" for="Kenteken">Kenteken:</label><input type="text" name="kenteken" id = "kenteken" size="30" /></div>
			<div class="p"><label class="formlabel" for="parking">Parkeerplaats:</label></div>
			<div class="p"><select name="filter">
						<option value="1" selected="selected">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
					</select></div>
				<div class="p">
				<button type="submit" >Opslaan</button>
			    <button type="submit" >Annuleren</button><br></div>
			</fieldset>
		</form>
	</div>





<%--

<!-- Datum werkt nu om te selecteren -->
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

<div><label for="date">Datum tot:</label>
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

