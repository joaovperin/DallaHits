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
    function criaDataTable(colunas) {
        // Cria o Datatable e associa à variável local 'table'
        table = $(param.grid).DataTable({
            "ajax": "/DallaHits/" + param.url + "/dados",
            "dataSrc": "demo",
            "info": false,
            "responsive": true,
            "order": [[0, "asc"]],
            "columns": getColunas(colunas)
        });
    }

    // Retorna as colunas do datatable no formato correto
    function getColunas(lista) {
        var cols = [];
        lista.forEach(function (e) {
            cols.push({"data": e});
        });
        return cols;
    }

    // Busca o Header do DataTable
    function buscaHeader() {
        $.ajax({
            type: "POST",
            url: "/DallaHits/" + param.url + "/titulo",
            success: function (ret) {
                var header = JSON.parse(ret);
                criaDataTable(header.colunas);
                appendHeader(header.titulos);
            }
        });
    }

    // Função auxiliar para criar o header do DataTable
    function appendHeader(dados) {
        // Busca Grid e cria um Header
        var g = $(param.grid);
        var header = criaHeader(dados);
        // Se já não tiver header, appenda um novo
        if (param.criaHeader) {
            g.find('thead').append(header);
        }
        // Se já não tiver footer, appenda um novo
        if (param.criaFooter) {
            g.find('tfoot').append(header);
        }
    }

    // Função auxiliar para criar o header à partir de um array
    function criaHeader(arr) {
        var head = '';
        arr.forEach(function (e) {
            head += '<th>' + e + '</th>';
        });
        return head;
    }

    // Busca o header do DataTable
    buscaHeader();

    return {
        table: table
    };

};