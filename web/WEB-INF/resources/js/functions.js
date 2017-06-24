//
// IIFEs - Referency:
// https://imasters.com.br/front-end/javascript/sobre-funcoes-imediatas-javascript-iife/?trace=1519021197&source=single
//

// Objeto auxiliar para trabalhar com Forms!
var Form = function () {
    var f = {};
    // Prepara
    f.prepare = function (formElm) {
        formElm.submit(function () {
            f.limpaCampos(formElm);
        });
    };
    // Limpa campos antes do submit
    f.limpaCampos = function (formElm) {
        formElm.find('input').each(function () {
            var e = $(this);
            if (e.hasClass('input inp_number') && !e.val())
                e.val(0);
            if (e.hasClass('input inp_text') && !e.val())
                e.val('');
        });
    };
    // Retorna o objeto
    return f;
}();

// Objeto auxiliar para trabalhar com Forms!
var Ajax = function () {
    // Objeto em sí
    var a = {};

    // Defaults
    var defs = {
    };

    // Prepara
    a.send = function (param) {
        $.ajax({
            type: param.type,
            url: "/DallaHits/" + param.url,
            data: param.data,
            success: function (ret) {
                if (param.success)
                    param.success(ret);
                if (param.finnaly)
                    param.finnaly(ret);
            }, error: function (err) {
                if (param.err)
                    param.success(err);
                if (param.finnaly)
                    param.finnaly(err);
            }
        });
    };

    // Retorna o objeto
    return a;
}();


function formToObj(idForm) {
    var obj = {};



    return obj;
}


/**
 * Retorna verdadeiro se o array possuir um par com a soma
 *
 * @param arr Array de dados
 * @param sum Soma de valores
 * @return boolean
 */
function hasPairWithSum(arr, sum) {
    var comps = [];
    for (var i in arr) {
        var v = arr[i];
        if (comps.indexOf(v) != -1) {
            return true;
        }
        comps.push(sum - v);
    }
    return false;
}

/**
 * Atalho para Document.getElementById();
 * 
 * @param {string} idElm
 * @returns {Element}
 */
var gebi = function (idElm) {
    return document.getElementById(idElm);
};
