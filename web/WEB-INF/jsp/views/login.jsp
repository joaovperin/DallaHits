<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/WEB-INF/tlds/jpe" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Início</title>
    </head>
    <body>
        <h1>Bem vindo ao site!</h1>
        <form action="login" method="POST">
            Login: <input type="text" name="login" /><br><br>
            Senha: <input type="password" name="senha" /><br><br>
            <input type="submit" title="Login" />
        </form>        
        <%-- Se houver mensagem, exibe --%>
        <jpe:message title="Atenção!" msg="${msg}" />
    </body>
</html>
