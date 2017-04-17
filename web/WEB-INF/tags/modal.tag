<%-- Descrição --%>
<%@tag description="Tag padrão para Grids" pageEncoding="UTF-8"%>
<%@attribute name="id" description="Id do elemento principal" required="true" %>
<%@attribute name="title" description="Título do grid" required="true" %>
<%@attribute name="url" description="URL para buscar dados do grid" required="false" %>
<%-- Importações --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Início da Tag: --%>
<%-- Container principal da modal --%>
<div class="modal fade" id="${id}" role="dialog">
    <div class="modal-dialog">

        <%-- Modal content --%>
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">${title}</h4>
            </div>
            <div class="modal-body">
                <jsp:doBody/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>