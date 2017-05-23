<%-- Descrição --%>
<%@tag description="Tag default para campos" pageEncoding="UTF-8"%>
<%@attribute name="id" description="ID do campo" required="false" %>
<%@attribute name="name" description="Name do campo" required="true" %>
<%@attribute name="required" description="Se o campo é obrigatório" required="false" %>
<%@attribute name="cssclazz" description="Classe Css" required="false" %>
<%-- Importações --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Se não informou ID, assume o Name --%>
<c:if test="${empty id}">
    <c:set var="id" value="${name}"/>
</c:if>
<%-- Início da Tag: --%>
<select id="${id}}" name="${name}" class="form form-control select ${cssclazz}" ${disabled} ${readonly} ${required} style="margin-bottom:10px;">
    <jsp:doBody />
</select>