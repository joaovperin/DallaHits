<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%-- Insere o template default --%>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <%-- Modal para manutenção de comandas --%>
        <jpe:modal id="modComanda" title="tituloo">
            <jpe:form titulo="Comandas" action="comanda/incluir" submit="Gravar" >
                <jpe:fieldText name="idCliente" placeholder="Cód. Cliente" />
                <jpe:fieldText name="cliente" placeholder="Nome Cliente" />
            </jpe:form>
            <!--<button type="button" class="btn btn-info btn-lg" id="myBtn">Botão</button>-->
        </jpe:modal>
        <jpe:grid id="gridComandas" url="comandas" title="Comandas" addAcaoUpdate="true"
                  callbackAdd="addComanda" callbackAlt="altComanda" callbackExc="excComanda" />
        <%-- Se houver mensagem, exibe --%>
        <jpe:message msg="${msg}" />
        <script>

            function addComanda() {
                console.log('Inclusão!');
                $("#modComanda").modal();
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