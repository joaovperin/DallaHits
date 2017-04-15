/*
 * Objeto para trabalhar com datatables
 *   
 * Formato esperado:
 * {
 *   grid: '#gridId',
 *   url:  '/pessoas/',
 *   criaHeader: false,
 *   criaFooter: false
 * }
 * 
 */
var Grid = function (externalParams) {

// Variável para guardar a referência do datatable
    var table;
    // Objeto com os parâmetros
    var param = {
        criaHeader: true
    };
    // Mescla os parâmetro externos com os internos
    $.extend(param, externalParams);
    // Realiza a criação do DataTable
    function criaDataTable(header) {
        // Cria o Datatable e associa à variável local 'table'
        table = $(param.grid).DataTable({
            "ajax": "/DallaHits/" + param.url + "/dados",
            "dataSrc": "demo",
            "columnDefs": [
                {
                    "targets": -1,
                    "data": null,
                    "defaultContent": "<button>Click!</button>"
                }
            ],
            "initComplete": function () {
                appendHeader(header.titulos);
                if (param.callback){
                    param.callback(table);
                }
            },
            "info": false,
            "responsive": true,
            "order": [[0, "asc"]],
            "columns": getColunas(header.colunas),
            "select": true,
            // Para adicionar novas Strings
            // http://legacy.datatables.net/usage/i18n
            "language": {
                "lengthMenu": "Exibindo  _MENU_  registros.",
                "search": "Buscar",
                "paginate": {
                    "previous": "Anterior",
                    "next": "Próximo"
                },
                "info": "Mostrando página _PAGE_ de _PAGES_.",
                "zeroRecords": "Nenhum registro encontrado.",
                "infoEmpty": "Nenhum registro disponível."
            }
        });
    }

    // Retorna as colunas do datatable no formato correto
    function getColunas(lista) {
        var cols = [];
        lista.forEach(function (e) {
            cols.push({"data": e});
        });
        cols.push({"data": "acoes"});
        return cols;
    }

    // Busca o Header do DataTable
    function buscaHeader() {
        $.ajax({
            type: "POST",
            url: "/DallaHits/" + param.url + "/titulo",
            success: function (ret) {
                var header = JSON.parse(ret);
                criaDataTable(header);
            }
        });
    }

    // Função auxiliar para criar o header do DataTable
    function appendHeader(dados) {
        // Busca Grid e cria um Header
        var g = $(param.grid);
        // Se já não tiver header, appenda um novo
        if (param.criaHeader) {
            g.find('thead th').each(function (e) {
                $(this).append(criaHeader(dados[e]));
            });
        }
        // Se já não tiver footer, appenda um novo
        if (param.criaFooter) {
            g.find('tfoot th').each(function (e) {
                $(this).append(criaHeader(dados[e]));
            });
        }
    }

    // Função auxiliar para criar o header à partir de um array
    function criaHeader(head) {
        return  '<th>' + head + '</th>';
    }

    // Busca o header do DataTable
    buscaHeader();
    return {
        table: table
    };
};