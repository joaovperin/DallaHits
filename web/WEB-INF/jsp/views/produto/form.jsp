<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%-- Insere o template default --%>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <%-- Formulário de produtos! --%>
        <jpe:form action="incluir" backUrl="listagem" submit="Gravar" titulo="Inclusão de produtos!" >
            <jpe:fieldText name="descricao" placeholder="Descrição do produto" required="required" autofocus="autofocus" />
            <jpe:fieldText name="valorUnitario" placeholder="Valor" required="required" />
        </jpe:form>
    </tiles:putAttribute>
</tiles:insertDefinition>