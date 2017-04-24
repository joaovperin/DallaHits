<%-- Descrição --%>
<%@tag description="Tag default para campos" pageEncoding="UTF-8"%>
<%@attribute name="id" description="ID do campo" required="false" %>
<%@attribute name="name" description="Name do campo" required="true" %>
<%@attribute name="label" description="Rótulo do campo" required="true" %>
<%@attribute name="type" description="Tipo do campo" required="true" %>
<%@attribute name="placeholder" description="Placeholder do campo" required="false" %>
<%@attribute name="required" description="Se o campo é obrigatório" required="false" %>
<%@attribute name="autofocus" description="Se o campo é autofocus" required="false" %>
<%@attribute name="disabled" description="Se o campo é desabilitado" required="false" %>
<%@attribute name="readonly" description="Se o campo é somente leitura" required="false" %>
<%@attribute name="cssclazz" description="Classe Css" required="false" %>
<%-- Importações --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Se não informou ID, assume o Name --%>
<c:if test="${empty id}">
    <c:set var="id" value="${name}"/>
</c:if>
<%-- Se não informou Label--%>
<c:if test="${not empty label}">
    ${label}: 
</c:if>
<%-- Início da Tag: --%>
<input type="${type}" name="${name}" id="${id}" class="form-control input ${cssclazz}" placeholder="${placeholder}" ${required} ${autofocus} ${disabled} ${readonly}>