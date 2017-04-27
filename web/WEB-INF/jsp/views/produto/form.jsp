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
            <jpe:fieldText name="valorUnitario" placeholder="Valor" required="required" />
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
                            required: true
                        }
                    },
                    // Mensagens de validação
                    messages: {
                        descricao: {
                            required: "Mete a porra da descrição, carai",
                            minlength: "Que bosta é essa? Min 5 caracteres rapá"
                        },
                        valorUnitario: {
                            required: "Precisa de valor essa droga"
                        }
                    },
                    // Força a submissão (ui)
                    submitHandler: function (form) {
                        console.log('odjaljdsklajdsa');
                        console.log(form);
                        console.log(form.valid());
                        if (form.valid()){
                            form.submit();
                        }
                    }
                });
            });
        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>