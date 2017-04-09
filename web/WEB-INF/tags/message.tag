<%-- Descrição --%>
<%@tag description="Mensagem Default" pageEncoding="UTF-8"%>
<%@attribute name="title" description="Título da mensagem" %>
<%@attribute name="msg" description="Mensagem" %>
<%-- Importações --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Início da Tag: --%>
<c:if test="${not empty msg}">
    <h2>${title}</h2>
    ${msg}
</c:if>
<jsp:doBody/>