<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%-- Insere o template default --%>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <%-- Datatables --%>
        <jpe:grid id="gridProdutos" url="produtos" title="Produtos" clClick="pClick"/>
        <%-- Se houver mensagem, exibe --%>
        <jpe:message msg="${msg}" />
        <jpe:button href="javascript:alert('oi')" title="Batata" />
        <script>
            $(function(){
                $('#gridProdutos').on('pClick', function(evt, target, data){
                    console.log('matheus feioso' + 'click no produto ' + data.idProduto);
                });
            });
        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>