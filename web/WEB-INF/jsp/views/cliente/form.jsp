<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%@ taglib prefix="spring" uri="/META-INF/tlds/spring.tld" %>
<%-- Modal para manutenção de clientes --%>
<jpe:modal id="modCliente" title="Cliente - ${action}">
    <jpe:form titulo="Clientes" action="cliente/gravar" id="clientes">
        <c:if test="${action == 'alterar'}">
            <jpe:fieldHidden name="idCliente" value="${cliente.idCliente}" />
        </c:if>
        <jpe:fieldText name="nome" placeholder="Nome Cliente" value="${cliente.nome}" />
        <jpe:fieldText name="sexo" placeholder="Sexo" value="${cliente.sexo}" />
        <jpe:fieldNumber name="cpf" placeholder="CPF" value="${cliente.cpf}" />
        <jpe:fieldNumber name="idade" placeholder="Idade" value="${cliente.idade}" />
        <jpe:fieldHidden name="action" value="${action}" />
        <jpe:buttonSubmit id="grvCli" title="Gravar" tipo="button" />
    </jpe:form>
    <%-- Validações do formulário --%>
    <script>
        $(function () {

            $('#btn_grvCli').click(function () {
                console.log("oi");
                // Se não for válido cai fora
                if(!$('form#form_clientes').valid()){
                    console.log('naaao');
                    return;
                }
                // Envia requisição para gravar dados
                Ajax.send({
                    type: "POST",
                    url: "cliente/gravar",
                    data: cnvFormToObj('form_clientes'),
                    success: function (ret) {
                        console.log('Dados:\n');
                        console.log(ret);
                    }, error: function(ret){
                        console.log("error");
                    }
                });
            });

            var cnvFormToObj = function (idForm) {
                var data = {};
                var arrSerialized = $('form#' + idForm).serializeArray();
                for (var i = 0; i < arrSerialized.length; i++) {
                    data[arrSerialized[i]['name']] = arrSerialized[i]['value'];
                }
                return data;
            };

            var gebi = function (idElm) {
                return document.getElementById(idElm);
            };


            // Inicializa a validação do Form
            $("form#form_clientes").validate({
                // Regras de validação dos campos
                rules: {
                    nome: {
                        required: true,
                        minlength: 2
                    },
                    sexo: {
                        required: true,
                        maxlength: 1
                    },
                    cpf: {
                        required: true,
                        number: true,
                        min: 191,
                        max: 99999999999
                    },
                    idade: {
                        required: true,
                        number: true,
                        max: 99
                    }
                },
                // Mensagens de validação
                messages: {
                    nome: {
                        required: "Este campo é obrigatório",
                        minlength: "O tamanho mínimo deste campo é {0}."
                    },
                    sexo: "Este campo é obrigatório",
                    cpf: "Formato de CPF inválido!",
                    idade: "Idade inválida!"
                },
                // Força a submissão (ui)
                submitHandler: function (form) {
                    if ($(form).valid()) {
                        form.submit();
                    }
                }
            });
        });
    </script>
</jpe:modal>