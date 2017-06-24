<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%@ taglib prefix="spring" uri="/META-INF/tlds/spring.tld" %>
<%-- Modal para manutenção de comandas --%>
<jpe:modal id="modComanda" title="Inclusão - Comanda">
    <jpe:form titulo="Comandas" action="comanda/incluir" id="comandas">
        <c:if test="${action == 'alterar'}">
            <jpe:fieldHidden name="idCliente" value="${cliente.idCliente}" />
        </c:if>
        <jpe:fieldNumber name="idCliente" placeholder="Cód. Cliente" />
        <jpe:fieldNumber name="valorTotal" placeholder="Valor total" />
        <jpe:fieldHidden name="action" value="${action}" />
        <jpe:buttonSubmit id="grvCmd" title="Gravar" tipo="button" />
    </jpe:form>
    <!--<button type="button" class="btn btn-info btn-lg" id="myBtn">Botão</button>-->


    <%-- Validações do formulário --%>
    <script>
        $(function () {
            $('#btn_grvCmd').click(function () {
                // Envia requisição para gravar dados
                Ajax.send({
                    type: "POST",
                    url: "comanda/incluir",
                    data: cnvFormToObj('form_comandas'),
                    success: function (ret) {
                        console.log('Dados:\n');
                        console.log(ret);
                    }, error: function (ret) {
                        console.log("error");
                    },
                    finnaly: function (ret) {
                        console.log('oi');
                        $('#modComanda_close').click();
                        $('#gridComandas').DataTable().ajax.reload();
                        if (ret && ret.status === 200) {
                        }
                    }
                });
            });



        });
    </script>
</jpe:modal>