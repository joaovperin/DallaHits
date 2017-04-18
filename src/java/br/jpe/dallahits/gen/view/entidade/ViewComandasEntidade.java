/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.view.entidade;

import br.jpe.dallahits.generics.AbstractViewEntidade;
import br.jpe.dallahits.gen.view.bean.ViewComandasBean;
import org.json.simple.JSONArray;

/**
 * Classe ViewComandasEntidade
 *
 * @author Joaov
 */
public class ViewComandasEntidade extends AbstractViewEntidade<ViewComandasBean> {

    /** 
     * Construtor da classe ViewComandasEntidade
     */
    public ViewComandasEntidade() {}
    
    @Override
    public JSONArray getTitulos() {
       JSONArray titulos = new JSONArray();       
        titulos.add("Código");
        titulos.add("Código do cliente");
        titulos.add("Nome");
        titulos.add("Nome");
        titulos.add("Data");
        titulos.add("Valor Total");
       return titulos;
    }
     
    @Override
    public JSONArray getColunas() {
       JSONArray colunas = new JSONArray();
        colunas.add("idComanda");
        colunas.add("idCliente");
        colunas.add("cliente");
        colunas.add("usuario");
        colunas.add("data");
        colunas.add("valorTotal");
       return colunas;
    }

}
