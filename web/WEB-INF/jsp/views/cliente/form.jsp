<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<%@ taglib prefix="spring" uri="/META-INF/tlds/spring.tld" %>
<%-- Modal para manutenção de clientes --%>
<jpe:modal id="modCliente" title="Inclusão - Cliente">

    action: ${action}.

    <jpe:form titulo="Clientes" action="cliente/gravar" submit="Gravar" id="clientes">
        <jpe:fieldText name="nome" placeholder="Nome Cliente" />
        <jpe:fieldText name="sexo" placeholder="Sexo" />
        <jpe:fieldNumber name="cpf" placeholder="CPF" />
        <jpe:fieldNumber name="idade" placeholder="Idade" />
    </jpe:form>
</jpe:modal>