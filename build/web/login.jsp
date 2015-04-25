<%-- 
    Document   : login
    Created on : Apr 25, 2015, 4:37:18 AM
    Author     : Emannuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ENTRAR | BANCO NEVER ENDS</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="LoginServlet">
            <p>Nome do cliente</p>
            <p>Senha:</p>
            <p><input type="text" name="senha" value="" placeholder="Senha"></p>
            <p class="submit"><input type="submit" name="commit" value="Entrar"></p>
        </form>
    </body>
</html>
