<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%-- Insere o template default --%>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <div class="container">
            <h1 class="text-center">Bem vindo ao sistema!</h1>
            <div class="card card-container">
                <img id="profile-img" class="profile-img-card" src="resources/img/my-icon.jpg" />
                <p id="profile-name" class="profile-name-card"></p>
                <form class="form-signin" action="login" method="POST">
                    <jpe:fieldText name="login" placeholder="Login" required="required" autofocus="autofocus" />
                    <jpe:fieldSenha name="senha" placeholder="Senha" required="required" />
                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Login</button>
                </form><!-- /form -->
                <%-- Se houver mensagem, exibe --%>
                <jpe:message msg="${msg}" />
            </div><!-- /card-container -->
        </div><!-- /container -->
    </tiles:putAttribute>
</tiles:insertDefinition>