<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%-- Insere o template default --%>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <jpe:grid id="gridProdutos" url="produto/listagem" title="Produtos" addAcaoUpdate="true">
            <div style="padding-bottom: 5px;">
                <jpe:button href="produto/form" title="Formulário" />
            </div>
        </jpe:grid>
        <%-- Se houver mensagem, exibe --%>
        <jpe:message msg="${msg}" />
    </tiles:putAttribute>
</tiles:insertDefinition>