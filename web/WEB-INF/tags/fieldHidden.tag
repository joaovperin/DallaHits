<%-- Descrição --%>
<%@tag description="Tag default para campos Hidden" pageEncoding="UTF-8"%>
<%@attribute name="name" description="Name do campo" required="true" %>
<%@attribute name="value" description="Valor do campo" required="false" %>
<%@attribute name="disabled" description="Se o campo é desabilitado" required="false" %>
<%-- Importações --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%-- Início da Tag: --%>
<jpe:field type="hidden" name="${name}" cssclazz="inp_hidden" required="false" disabled="${disabled}" value="${value}" />