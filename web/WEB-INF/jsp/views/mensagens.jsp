<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <%-- Título --%>
        <div class="content" style="padding-bottom:50px;">
            <h2 class="text-center">Oi, ${usuarioLogado.nome}.</h2>
        </div>
        <%-- Formulário -> Add mensagem --%>
        <div class="content" style="width:400px; padding-bottom: 30px">
            <jpe:fieldText name="newMsg" placeholder="Mensagem"/>
            <button id="addMsg" class="form-control" >Add</button>
        </div>
        <%-- Grid de mensagens --%>
        <jpe:grid id="msg" url="mensagens" addAcaoUpdate="true" order='[[0, "desc"]]' />
        <script>
            $(function () {
                // Ao clicar no botão addMsg, cria uma nova
                $('#addMsg').click(function () {
                    var msgField = $('#newMsg');
                    includeMsgPost(createMsgObject(msgField.val()));
                    msgField.val('');
                });
            });

            // Cria um objeto de mensagem
            function createMsgObject(msg) {
                var msgObj = {};
                msgObj.usuario = '${usuarioLogado.login}';
                msgObj.msg = msg;
                return msgObj;
            }

            // Envia um HttpPost para incluir a mensagem
            function includeMsgPost(dataObj) {
                $.ajax({
                    type: "POST",
                    url: "/DallaHits/addMensagem",
                    data: dataObj,
                    success: function () {
                        $('#msg').DataTable().ajax.reload();
                    }
                });
            }
        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>