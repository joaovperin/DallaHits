<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%@ taglib prefix="spring" uri="/META-INF/tlds/spring.tld" %>
<%-- Insere o template default --%>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <jpe:grid id="gridClientes" url="cliente/listagem" title="Clientes" addAcaoUpdate="true" />
        <%-- Se houver mensagem, exibe --%>
        <jpe:message msg="${msg}" />
    </tiles:putAttribute>
</tiles:insertDefinition>