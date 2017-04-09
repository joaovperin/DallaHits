<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/WEB-INF/tlds/jpe" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem vindo</title>
    </head>
    <body>
        <h1>Página principal</h1>
        <br><br><br>
        <h2>Bem vindo, ${usuarioLogado.nome}.</h2>
        <p>Um texto qualquer...</p>
        <a href="logout">Sair do sistema</a>
    </body>
</html>
