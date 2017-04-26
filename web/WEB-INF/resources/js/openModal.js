/*
 * Objeto para trabalhar com modais
 *
 * Formato esperado:
 * {
 *  url: '/cliente/form',
 *  data: {}
 * }
 *
 */
var openModal = function (externalParams) {

    // Variável para guardar a referência da modal
    var ref;
    // Objeto com os parâmetros
    var param = {
        ajax: true,
        data: {}
    };
    // Mescla os parâmetro externos com os internos
    $.extend(param, externalParams);

    /**
     * Realiza a abertura da modal
     */
    function load() {
        if (param.ajax === true) {
            openByAjax();
        }
    }

    /**
     *  Abre a modal buscando seus dados via Ajax
     */
    function openByAjax() {
        $.ajax({
            method: "GET",
            url: "/DallaHits/" + param.url,
            data: param.data,
            success: function (data) {
                ref = $(data).modal();
            }
        });
    }

    // Retorna funções externas
    return {
        ref: ref,
        load: load
    };
};