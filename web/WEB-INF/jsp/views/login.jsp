<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <h1>Bem vindo ao site!</h1>
        <form action="login" method="POST">
            Login: <input type="text" name="login" /><br><br>
            Senha: <input type="password" name="senha" /><br><br>
            <input type="submit" title="Login" />
        </form>
        <%-- Se houver mensagem, exibe --%>
        <jpe:message title="Atenção!" msg="${msg}" />
    </tiles:putAttribute>
</tiles:insertDefinition>