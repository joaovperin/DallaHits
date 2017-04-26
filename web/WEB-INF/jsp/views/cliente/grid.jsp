<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%@ taglib prefix="spring" uri="/META-INF/tlds/spring.tld" %>
<%-- Insere o template default --%>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <div id="modCt">

        </div>
        <jpe:grid id="gridClientes" url="cliente/listagem" title="Clientes" addAcaoUpdate="true"
                  callbackAdd="addCliente" callbackAlt="altCliente" />
        <%-- Se houver mensagem, exibe --%>
        <jpe:message msg="${msg}" />
        <script>

            function addCliente() {
                console.log('Inclusão!');
                openModal({url: '/cliente/incluir'}).load();
            }

            function altCliente(clientes) {
                console.log('Alteração!');
                var c = clientes[0];
                openModal({url: '/cliente/alterar', data: c}).load();
                console.log(c);
            }

        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>


