<%-- Descrição --%>
<%@tag description="Mensagem Default" pageEncoding="UTF-8"%>
<%@attribute name="title" description="Título da mensagem" required="false" %>
<%@attribute name="msg" description="Mensagem" required="false" %>
<%@attribute name="titleClazz" description="Classe CSS a adicionar no título" required="false" %>
<%@attribute name="clazz" description="Classe CSS a adicionar" required="false" %>
<%@attribute name="center" description="Se deve centralizar" required="false" %>
<%-- Importações --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty center}">
    <c:set var="clazz" value="${clazz} text-center" />
</c:if>
<%-- Início da Tag: --%>
<c:if test="${not empty msg}">
    <h2 class="${titleClazz}">${title}</h2>
    <p class="${clazz}">${msg}</p>
</c:if>
<jsp:doBody/>