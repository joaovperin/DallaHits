<%-- Descrição --%>
<%@tag description="Tag default para campos" pageEncoding="UTF-8"%>
<%@attribute name="id" description="ID do campo" required="false" %>
<%@attribute name="name" description="Name do campo" required="true" %>
<%@attribute name="placeholder" description="Placeholder do campo" required="true" %>
<%@attribute name="label" description="Rótulo do campo" required="false" %>
<%@attribute name="required" description="Se o campo é obrigatório" required="false" %>
<%@attribute name="autofocus" description="Se o campo é autofocus" required="false" %>
<%@attribute name="disabled" description="Se o campo é desabilitado" required="false" %>
<%@attribute name="readonly" description="Se o campo é somente leitura" required="false" %>
<%@attribute name="cssclazz" description="Classe Css" required="false" %>
<%-- Importações --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%-- Início da Tag: --%>
<jpe:field type="text" name="${name}" id="${id}" cssclazz="inp_number ${cssclazz}" placeholder="${placeholder}" label="${label}" required="${required}" autofocus="${autofocus}" disabled="${disabled}" readonly="${readonly}"/>