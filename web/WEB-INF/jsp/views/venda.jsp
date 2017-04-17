<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%-- Insere o template default --%>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <%-- Datatables --%>
        <jpe:grid id="gridProdutos" url="produtos" title="Produtos" addAcaoUpdate="true"
                  callbackAdd="addProduto" callbackAlt="altProduto" callbackExc="excProduto" />
        <%-- Se houver mensagem, exibe --%>
        <jpe:message msg="${msg}" />
        <jpe:button href="javascript:alert('oi')" title="Batata" />
        <script>
            
            function addProduto(){
                console.log('Inclusão!');
            }
            function altProduto(produtos){
                console.log('Alteração!');
                var pr = produtos[0];
                console.log('Produto ' + pr.idProduto + ': ' + pr.descricao);
            }
            function excProduto(pr){
                console.log('Exclusão!');
                for (var i in pr){
                    console.log('Produto ' + pr[i].idProduto + ': ' + pr[i].descricao);
                }
            }
            
            $(function(){
                $('#gridProdutos').on('pClick', function(evt, target, dado){
                    console.log('Click: ' + dado.idProduto + ' - ' + dado.descricao);
                });
            });
        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>