<%-- Descrição --%>
<%@tag description="Tag default para campos" pageEncoding="UTF-8"%>
<%@attribute name="id" description="ID do campo" required="false" %>
<%@attribute name="cssclazz" description="Classe Css" required="false" %>
<%@attribute name="value" description="Valor" required="true" %>
<%@attribute name="selected" description="Se ela deve estar selecionada" required="true" %>
<%-- Importações --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Início da Tag: --%>
<option value="${value}" <c:if test="${not empty selected && selected==value}">selected="selected"</c:if> ><jsp:doBody /></option>