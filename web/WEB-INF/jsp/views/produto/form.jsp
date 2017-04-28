<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%-- Insere o template default --%>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <%-- Formulário de produtos! --%>
        <jpe:form action="incluir" id="listagem" backUrl="listagem" submit="Gravar" titulo="Inclusão de produtos!" >
            <jpe:fieldText name="descricao" placeholder="Descrição do produto" required="required" autofocus="autofocus" />
            <jpe:fieldNumber name="valorUnitario" placeholder="Valor" required="required" />
        </jpe:form>
        <script>
            $(function () {
                // Inicializa a validação do Form
                $("form#form_listagem").validate({
                    // Regras de validação dos campos
                    rules: {
                        descricao: {
                            required: true,
                            minlength: 5
                        },
                        valorUnitario: {
                            required: true,
                            number: true,
                            max: 999999
                        }
                    },
                    // Mensagens de validação
                    messages: {
                        descricao: {
                            required: "Este campo é obrigatório",
                            minlength: "O tamanho mínimo deste campo é {0}."
                        },
                        valorUnitario: {
                            required: "Precisa de valor essa droga",
                            max: "Valor máximo {0}"
                        }
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
    </tiles:putAttribute>
</tiles:insertDefinition>