<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%-- Insere o template default --%>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <jpe:grid id="gridComandas" url="comandas" title="Comandas" addAcaoUpdate="true"
                  callbackAdd="addComanda" />
        <%-- Se houver mensagem, exibe --%>
        <jpe:message msg="${msg}" />
        <script>

            function addComanda() {
                console.log('Inclusão!');
//                $("#modComanda").modal();
                openModal({url: '/comanda/form'}).load();
            }

            function altComanda(comandas) {
                console.log('Alteração!');
                var cmd = comandas[0];
                console.log('Comanda ' + cmd.idComanda + ' -> Cliente ' + cmd.cliente);
            }

            function excComanda(cmds) {
                console.log('Exclusão!');
                for (var i in cmds) {
                    var cmd = cmds[i];
                    console.log('Comanda ' + cmd.idComanda + ' -> Cliente ' + cmd.cliente);
                }
            }

        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>