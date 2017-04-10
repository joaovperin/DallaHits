<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <h1>Página principal</h1>
        <br><br><br>
        <h2>Bem vindo, ${usuarioLogado.nome}.</h2>
        <p>Um texto qualquer...</p>
        <a href="logout">Sair do sistema</a>
    </tiles:putAttribute>
</tiles:insertDefinition>

