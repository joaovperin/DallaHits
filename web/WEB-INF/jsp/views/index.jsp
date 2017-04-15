<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%@ taglib prefix="spring" uri="/META-INF/tlds/spring.tld" %>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <!-- Header -->
        <a name="about"></a>
        <div class="intro-header intro-header-introimg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="intro-message">
                            <h1>Bem vindo, ${usuarioLogado.nome}.</h1>
                            <h3 class="def" >O que deseja fazer?</h3>
                            <hr class="intro-divider">
                            <ul class="list-inline intro-social-buttons">
                                <li>
                                    <spring:url value="/venda" var="vendaUrl" htmlEscape="true" />
                                    <a href="${vendaUrl}" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Vendas</span></a>
                                </li>
                                <li>
                                    <a href="#Cadastros" class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i> <span class="network-name">Cadastros</span></a>
                                </li>
                                <li>
                                    <a href="#Listagens" class="btn btn-default btn-lg"><i class="fa fa-linkedin fa-fw"></i> <span class="network-name">Listagens</span></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.container -->
        </div>
        <!-- /.intro-header -->
    </tiles:putAttribute>
</tiles:insertDefinition>