/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.entidade;

import br.jpe.dallahits.generics.AbstractViewEntidade;
import br.jpe.dallahits.gen.bean.ItemComandaBean;
import org.json.simple.JSONArray;

/**
 * Classe ItemComandaEntidade
 *
 * @author Joaov
 */
public class ItemComandaEntidade extends AbstractViewEntidade<ItemComandaBean> {

    /** 
     * Construtor da classe ItemComandaEntidade
     */
    public ItemComandaEntidade() {}
    
    @Override
    public JSONArray getTitulos() {
       JSONArray titulos = new JSONArray();       
        titulos.add("Código");
        titulos.add("Item");
        titulos.add("Código do produto");
        titulos.add("Quantidade");
        titulos.add("Total do Item");
       return titulos;
    }
     
    @Override
    public JSONArray getColunas() {
       JSONArray colunas = new JSONArray();
        colunas.add("idComanda");
        colunas.add("item");
        colunas.add("produto");
        colunas.add("quantidade");
        colunas.add("valorTotalItem");
       return colunas;
    }

}
