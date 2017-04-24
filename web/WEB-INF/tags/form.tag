<%-- Descrição --%>
<%@tag description="Tag padrão para Formulários" pageEncoding="UTF-8"%>
<%@attribute name="id" description="Id do elemento de form" required="true" %>
<%@attribute name="titulo" description="Título" required="false" %>
<%@attribute name="action" description="URL para submit do form" required="true" %>
<%@attribute name="submit" description="Texto para botão Submit" required="false" %>
<%@attribute name="backUrl" description="URL para botão Voltar" required="false" %>
<%-- Importações --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%-- Início da Tag: --%>
<c:if test="${not empty titulo}">
    <h2 class="text-center">${titulo}</h2>
</c:if>
<%-- Container principal do formulário --%>
<div class="content">
    <%-- Se houver mensagem, exibe --%>
    <jpe:message msg="${msg}" center="true" />
    <div class="card card-container">
        <form id="form_${id}" class="form-signin" action="${action}" method="POST">
            <jsp:doBody />
            <%-- Se deve incluir botão subtmir --%>
            <c:if test="${not empty submit}">
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">${submit}</button>
            </c:if>
        </form><!-- /form -->
    </div>
    <%-- Se definiu URL para volta, exibe botão Back --%>
    <c:if test="${not empty backUrl}">
        <jpe:button title="Voltar" href="${backUrl}" />
    </c:if>
    <script>
        $(function () {
            Form.prepare($('#form_${id}'));
        });
    </script>
</div>