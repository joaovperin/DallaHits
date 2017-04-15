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
        new Grid({
            grid: '#${id}',
            url: '${url}',
            criaFooter: '${criaFooter}',
            callback: function (obj) {
                table = obj;
                $('#${id} tbody').on('click', 'button', function () {
                    var data = obj.row($(this).parents('tr')).data();
                    alert("Você clicou na comanda " + data.idComanda);
                });
            }
        });

    });

</script>