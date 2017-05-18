<%-- Descrição --%>
<%@tag description="Tag padrão para Grids" pageEncoding="UTF-8"%>
<%@attribute name="id" description="Id do botão" required="true" %>
<%@attribute name="title" description="Título" required="true" %>
<%@attribute name="tipo" description="Tipo do botão" required="false" %>
<%-- Importações --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Início da Tag: --%>
<c:if test="${empty tipo}">
    <c:set var="tipo" value="submit"/>
</c:if>
<button type="${tipo}" id="btn_${id}" class="btn btn-lg btn-primary btn-block btn-signin">${title}</button>