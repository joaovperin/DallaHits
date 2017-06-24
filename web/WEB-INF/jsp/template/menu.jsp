<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="/META-INF/tlds/spring.tld" %>
<!-- Navegação -->
<nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
    <div class="container topnav">
        <!-- Header responsivo para Mobile -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Menu</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <spring:url value="/index" var="homeUrl" htmlEscape="true" />
            <a class="navbar-brand topnav" href="${homeUrl}">Início</a>
        </div>
        <!-- Navbar à direita -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <spring:url value="/mensagens" var="mensagensUrl" htmlEscape="true" />
                    <a href="${mensagensUrl}">Mensagens</a>
                </li>
                <%-- Se possuir usuário logado --%>
                <c:if test="${not empty usuarioLogado}">
                    <li>
                        <a href="logout">Sair do sistema</a>
                    </li>
                </c:if>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>