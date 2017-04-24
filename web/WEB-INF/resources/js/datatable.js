/*
 * Objeto para trabalhar com datatables
 *
 * Formato esperado:
 * {
 *   grid: '#gridId',
 *   url:  '/produtos/',
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
        criaHeader: true,
        addAcaoColunas: true,
        addAcaoPrint: true,
        addAcaoUpdate: true,
        callbackAdd: false,
        callbackAlt: false,
        callbackExc: false
    };
    // Mescla os parâmetro externos com os internos
    $.extend(param, externalParams);
    // Realiza a criação do DataTable
    function criaDataTable(header) {
        // Cria o Datatable e associa à variável local 'table'
        table = $(param.grid).DataTable({
            "ajax": "/DallaHits/" + param.url + "/dados",
            "dataSrc": "demo",
            "columnDefs": getColumnDefs(header.columnDefs),
            "sPaginationType": "simple_numbers",
            "dom": 'Bfrtip',
            "buttons": createButtons(header),
            "initComplete": function () {
                appendTitulos(header.titulos);
                if (param.callback) {
                    param.callback(table);
                }
            },
            "info": false,
            "processing": true,
            "responsive": true,
            "order": [[0, "asc"]],
            "columns": getColumns(header.colunas),
            "select": true,
            // Para adicionar novas Strings
            // http://legacy.datatables.net/usage/i18n
            "language": {
                "lengthMenu": "Exibindo  _MENU_  registros.",
                "search": "Buscar",
                "paginate": {
                    "first": "Primeiro",
                    "last": "Último",
                    "previous": "Anterior",
                    "next": "Próximo"
                },
                "processing": "Carregando...",
                "info": "Mostrando página _PAGE_ de _PAGES_.",
                "zeroRecords": "Nenhum registro encontrado.",
                "infoEmpty": "Nenhum registro disponível."
            }
        });
    }

    // Cria os botões no cabeçalho do Grid
    function createButtons(header) {
        var arr = [];
        // Se deve incluir ação de configurar colunas
        if (param.addAcaoColunas) {
            arr.push({
                extend: 'colvis',
                text: 'Colunas',
                columns: header.titulos
            });
        }
        // Se deve incluir ação de impressão
        if (param.addAcaoPrint) {
            arr.push({
                extend: 'print',
                text: 'Imprimir'
            });
        }
        // Se deve incluir ação de atualizar grid
        if (param.addAcaoUpdate) {
            arr.push({
                text: 'Atualizar',
                action: function (e, dt, node, config) {
                    dt.ajax.reload();
                }
            });
        }
        // Se deve incluir ação de inclusão
        if (param.callbackAdd) {
            arr.push({
                name: 'add',
                text: 'Add',
                action: function (e, dt, node, config) {
                    var arr = createDataArray(dt.rows({selected: true}).data());
                    doCallback(param.callbackAdd, arr);
                }
            });
        }
        // Se deve incluir ação de alteração
        if (param.callbackAlt) {
            arr.push({
                extend: 'selected',
                text: 'Alterar',
                name: 'edit',
                action: function (e, dt, node, config) {
                    var arr = createDataArray(dt.rows({selected: true}).data());
                    doCallback(param.callbackAlt, arr);
                }
            });
        }
        // Se deve incluir ação de exclusão
        if (param.callbackExc) {
            arr.push({
                extend: 'selected',
                text: 'Excluir',
                name: 'delete',
                action: function (e, dt, node, config) {
                    var arr = createDataArray(dt.rows({selected: true}).data());
                    doCallback(param.callbackExc, arr);
                }
            });
        }
        return arr;
    }

    // Chama um callback passando os argumentos
    function doCallback(callName) {
        // Se não definiu o callback, retorna
        if (!callName || typeof window[callName] !== 'function') {
            return console.log('É necessário definir um callback.');
        }
        var args = [].slice.call(arguments).splice(1);
        return window[callName].apply(null, args);
    }

    // Cria um array baseado em um conjunto de dados
    function createDataArray(data) {
        var arr = [];
        for (var i = 0; i < data.length; i++) {
            arr.push(data[i]);
        }
        return arr;
    }

    // Retorna as colunas default do datatable
    function getColumnDefs(lista) {
        var arr = [];
        for (var i in lista) {
            arr.push({
                "targets": (-1 - i),
                "data": null,
                "defaultContent": lista[i].content
            });
        }
        return arr;
    }

    // Retorna as colunas do datatable no formato correto
    function getColumns(lista) {
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
                criaDataTable(header);
            }
        });
    }

    // Função auxiliar para criar o header do DataTable
    function appendTitulos(dados) {
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