<%-- Descrição --%>
<%@tag description="Tag padrão para Grids" pageEncoding="UTF-8"%>
<%@attribute name="id" description="Id do elemento principal" required="true" %>
<%@attribute name="url" description="URL para buscar dados do grid" required="true" %>
<%@attribute name="title" description="Título do grid" required="false" %>
<%@attribute name="criaFooter" description="Se deve incluir um footer" required="false" %>
<%@attribute name="clClick" description="Evento no DOM para disparar callbacks" required="false" %>
<%@attribute name="addAcaoUpdate" description="Se deve adicionar ação Update" required="false" %>
<%@attribute name="callbackAdd" description="Ação Add - nome da função de callback" required="false" %>
<%@attribute name="callbackAlt" description="Ação Alteração - nome da função de callback" required="false" %>
<%@attribute name="callbackExc" description="Ação Exclusão - nome da função de callback" required="false" %>
<%-- Importações --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Início da Tag: --%>
<c:if test="${not empty title}">
    <div class="intro-header">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message bg-black">
                        <h1 class="text-center black">${title}</h1>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <jsp:doBody/>
    <br>
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
    var table;
    $(function () {
    table = new Grid({
    grid: '#${id}',
            url: '${url}',
            criaFooter: '${criaFooter}',
            callbackAdd: '${callbackAdd}',
            callbackAlt: '${callbackAlt}',
            callbackExc: '${callbackExc}',
            addAcaoUpdate: '${addAcaoUpdate}'
    <%-- Se definiu callback de clique --%>
    <c:if test="${not empty clClick}">
    , callback: function (tableObj) {
    $('#${id} tbody').on('click', 'a,button', function () {
    var data = tableObj.row($(this).parents('tr')).data();
    $('#${id}').trigger('${clClick}', [$(this), data]);
    });
    }
    </c:if>
    });
    });

</script>