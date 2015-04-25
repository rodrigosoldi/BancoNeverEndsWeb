<%-- 
    Document   : tentarNovamente
    Created on : Apr 25, 2015, 5:31:01 AM
    Author     : Emannuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Agência ou conta errada. Tente novamente.</h1>
        <form method="post" action="EntrarServlet">
            <p>Agência:</p>
            <p><input type="text" name="agencia" value="" placeholder="Agência"></p>
            <p>Conta:</p>
            <p><input type="text" name="conta" value="" placeholder="Conta"></p>
            <p class="submit"><input type="submit" name="commit" value="Entrar"></p>
        </form>
    </body>
</html>
