<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%-- Insere o template default --%>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <div class="container">
            <%-- Datatables --%>
            <jpe:grid id="example" url="pessoasDt" title="Grid de Pessoas" />
            <%-- Se houver mensagem, exibe --%>
            <jpe:message msg="${msg}" />
        </div><!-- /container -->
    </tiles:putAttribute>
</tiles:insertDefinition>