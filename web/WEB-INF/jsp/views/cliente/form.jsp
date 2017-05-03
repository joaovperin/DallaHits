<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%@ taglib prefix="spring" uri="/META-INF/tlds/spring.tld" %>
<%-- Modal para manutenção de clientes --%>
<jpe:modal id="modCliente" title="Cliente - ${action}">
    <jpe:form titulo="Clientes" action="cliente/gravar" submit="Gravar" id="clientes">
        <c:if test="${action == 'alterar'}">
            <jpe:fieldHidden name="idCliente" value="${cliente.idCliente}" />
        </c:if>
        <jpe:fieldText name="nome" placeholder="Nome Cliente" value="${cliente.nome}" />
        <jpe:fieldText name="sexo" placeholder="Sexo" value="${cliente.sexo}" />
        <jpe:fieldNumber name="cpf" placeholder="CPF" value="${cliente.cpf}" />
        <jpe:fieldNumber name="idade" placeholder="Idade" value="${cliente.idade}" />
        <jpe:fieldHidden name="action" value="${action}" />
    </jpe:form>
    <%-- Validações do formulário --%>
    <script>
        $(function () {
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