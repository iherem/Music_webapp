<%-- 
    Document   : test
    Created on : Oct 26, 2016, 2:29:37 PM
    Author     : INT303
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script   src="https://code.jquery.com/jquery-2.2.0.js"   integrity="sha256-oYqpLeqZe9cetUDV+TFiBZHp3uJ+X4F5eLs4W6uSTSE="   crossorigin="anonymous"></script>
    </head>
    <body>
        <button>ABC</button>
        <p id="data"></p>
    </body>
    <script>
        
$( "button" ).click(function() {
  $.ajax({url: "Testz",data : { id : 'UXf4Sj7j754wqmW4PL8rSw=='}, success: function(result){
        $("#data").html(result);
    }});
});
    </script>
</html>
