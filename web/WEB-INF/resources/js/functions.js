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

/**
 * Retorna verdadeiro se o array possuir um par com a soma
 * 
 * @param arr Array de dados
 * @param sum Soma de valores
 * @return boolean
 */
function hasPairWithSum(arr, sum){
	var comps = [];
	for (var i in arr){
		var v = arr[i];
		if (comps.indexOf(v) != -1){
			return true;
		}
		comps.push(sum - v);
	}
	return false;
}