<%-- Descrição --%>
<%@tag description="Tag padrão para Grids" pageEncoding="UTF-8"%>
<%@attribute name="id" description="Id do elemento principal" required="true" %>
<%@attribute name="url" description="URL para buscar dados do grid" required="true" %>
<%@attribute name="title" description="Título do grid" required="false" %>
<%@attribute name="criaFooter" description="Se deve incluir um footer" required="false" %>
<%-- Importações --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Início da Tag: --%>
<c:if test="${not empty title}">
    <h2 class="text-center">${title}</h2>
</c:if>
<%-- Datatable --%>
<table id="${id}" class="display" cellspacing="0" width="100%">
    <thead>

    </thead>
    <%-- Se deve incluir um footer --%>    
    <c:if test="${not empty criaFooter}">
        <tfoot>

        </tfoot>
    </c:if>
</table>
<script>

    $(function () {
        new Grid({
            grid: '#${id}',
            url: '${url}',
            criaFooter: '${criaFooter}'
        });
    });

</script>