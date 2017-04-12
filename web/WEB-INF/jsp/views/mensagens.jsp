<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <!-- Header -->
        <a name="about"></a>
        <div class="intro-header">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="intro-message">
                            <h2>Oi, ${usuarioLogado.nome}.</h2>
                            <hr class="intro-divider">
                            <jpe:fieldText name="newMsg" placeholder="Mensagem"/>
                            <button id="addMsg" class="form-control" >Add</button>
                            <hr class="intro-divider">
                            Prod:
                            <c:forEach items="${produtos}" var="p">
                            <li>Cod: ${p.idProduto}: ${p.descricao}</li><br>
                            </c:forEach>                                
                            
                            <h3>Mensagens:</h3>
                            <ul id="msgHolder" class="list-inline intro-social-buttons">
                                <c:forEach items="${mensagens}" var="m">
                                    <li>Msg from ${m.usuario}:               ${m.msg}</li><br>
                                    </c:forEach>                                
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container -->
        </div>

        <script>

            $(function () {
                $('#addMsg').click(function () {
                    var msg = $('#newMsg').val();
                    addMensagem(msg);
                });
            });

            function addMensagem(msg) {
                var msgObj = {};
                msgObj.usuario = '${usuarioLogado.login}';
                msgObj.msg = msg;
                sendPost(msgObj);
            }

            var dadosRecebidos;

            function sendPost(dataObj) {
                $.ajax({
                    type: "POST",
                    url: "/DallaHits/addMensagem",
                    data: dataObj,
                    success: function (ret) {
                        dadosRecebidos = ret;
                        render([].concat(eval(ret)));
                    }
                });
            }

            function render(list) {
                $('#msgHolder').find('li').remove();

                list.forEach(function(e){
                        $('#msgHolder').append(criaMsg(e));
                });

            }

            function criaMsg(msg) {
                console.log(msg);
                var elm = '<li>Msg From ';
                elm += msg.usuario;
                elm += ': ';
                elm += msg.msg;
                elm += '</li><br>';
                return elm;
            }

        </script>

        <!-- /.intro-header -->
    </tiles:putAttribute>
</tiles:insertDefinition>