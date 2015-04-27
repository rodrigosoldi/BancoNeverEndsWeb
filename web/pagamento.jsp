<%-- 
    Document   : pagamento
    Created on : Apr 25, 2015, 4:38:30 AM
    Author     : Emannuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAGAMENTO | BANCO NEVER ENDS</title>
    </head>
    <body>
        <h1>Pagamento</h1>
        <form method="post" action="PagamentoServlet">
            <p>Código:</p>
            <p><input type="text" name="codigo" value="" placeholder="Código"></p>
            <p>Valor:</p>
            <p><input type="text" name="valor" value="" placeholder="Valor (em R$)"></p>
            <p>Data:</p>
            <p><input type="date" name="Data"></p>
            <p class="submit"><input type="submit" name="commit" value="Entrar"></p>
        </form>
    </body>
</html>
