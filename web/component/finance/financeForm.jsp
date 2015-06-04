<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/component/finance/financeform.css"/>"/>
<div class="container">
    <form action="financeForm" id="financeform" method="post">
        <fieldset>

            <div class="p">
                <label class="formlabel" for="omzet">Omzet:</label><input class="text" type="text" name="omzet" id="omzet" placeholder="Vul hier uw omzet in."/>
            </div>
            <div class="p">
                <label class="formlabel" for="BTW">BTW:</label><input class="text" type="text" name="BTW" id="BTW" placeholder="Vul hier uw BTW in."/>
            </div>
            <div class="p">
                <label class="formlabel" for="Aantal Facturen">Aantal Facturen:</label><input class="text" type="text" name="Aantal Facturen" id="Aantal Facturen" placeholder="Vul hier uw Aantal facturen in."/>
            </div>
            <div class="p">
                <label class="formlabel" for="Facturen op totaalprijs">Facturen op totaalprijs:</label><input class="text" type="text" name="Facturen op totaalprijs" id="Facturen op totaalprijs" placeholder="Vul hier uw facturen op totaalprijs in."/>
            </div>

            <div class="p">
                <label class="formlabel" for="date">Kies van datum:</label>
                <input  class="text" type="date" name="date" id="date" value=""  />
                <link rel="stylesheet" href="jquery.ui.datepicker.mobile.css" />
                <script src="jQuery.ui.datepicker.js"></script>
                <script src="jquery.ui.datepicker.mobile.js"></script>
                <script>
                    //reset type=date inputs to text
                    $( document ).bind( "mobileinit", function(){
                        $.mobile.page.prototype.options.degradeInputs.date = true;
                    });
                </script>
            </div>

            <div class="p">
                <label class="formlabel" for="date">Kies tot datum:</label>
                <input  class="text" type="date" name="date" id="date" value=""  />
                <link rel="stylesheet" href="jquery.ui.datepicker.mobile.css" />
                <script src="jQuery.ui.datepicker.js"></script>
                <script src="jquery.ui.datepicker.mobile.js"></script>
                <script>
                    //reset type=date inputs to text
                    $( document ).bind( "mobileinit", function(){
                        $.mobile.page.prototype.options.degradeInputs.date = true;
                    });
                </script>
            </div>

        </fieldset>
    </form>
</div>


