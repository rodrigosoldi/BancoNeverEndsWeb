<%-- 
    Document   : entrar
    Created on : Apr 25, 2015, 4:35:24 AM
    Author     : Emannuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BANCO NEVER ENDS</title>
    </head>
    <body>
        <h1>Entrar</h1>
        <form method="post" action="EntrarServlet">
            <p>Agência:</p>
            <p><input type="text" name="agencia" value="" placeholder="Agência"></p>
            <p>Conta:</p>
            <p><input type="text" name="conta" value="" placeholder="Conta"></p>
            <p class="submit"><input type="submit" name="commit" value="Entrar"></p>
        </form>
    </body>
</html>
