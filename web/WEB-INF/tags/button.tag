<%-- Descrição --%>
<%@tag description="Tag padrão para Grids" pageEncoding="UTF-8"%>
<%@attribute name="id" description="Id do botão" required="false" %>
<%@attribute name="title" description="Título" required="true" %>
<%@attribute name="href" description="Href do button" required="true" %>
<%-- Importações --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Início da Tag: --%>
<a href="${href}" class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i> <span class="network-name">${title}</span></a>