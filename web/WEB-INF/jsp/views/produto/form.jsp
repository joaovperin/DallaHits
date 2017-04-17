<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%-- Insere o template default --%>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <h2 class="text-center"> Formulário de produtos!</h2>
        <div class="content">
            <%-- Se houver mensagem, exibe --%>
            <jpe:message msg="${msg}" center="true" />
            <div class="card card-container">
                <form class="form-signin" action="incluir" method="POST">
                    <jpe:fieldText name="descricao" placeholder="Descrição do produto" required="required" autofocus="autofocus" />
                    <jpe:fieldText name="valorUnitario" placeholder="Valor" required="required" />
                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Gravar</button>
                </form><!-- /form -->
            </div>
            <jpe:button title="Voltar" href="listagem" />
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>