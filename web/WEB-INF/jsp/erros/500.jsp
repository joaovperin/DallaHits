<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <h1>AH, não!!!</h1>
        <br><br><br>
        <h2>Infelizmente, ocorreu um erro ao processar sua página. Tente novamente mais tarde!</h2>
        <br>
        <p>Código do erro: HTTP 500 - Falha interna no servidor</p>
    </tiles:putAttribute>
</tiles:insertDefinition>