/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.entidade;

import br.jpe.dallahits.generics.AbstractEntidade;
import br.jpe.dallahits.gen.bean.ItemComandaBean;
import br.jpe.dallahits.gen.pk.ItemComandaPk;
import org.json.simple.JSONArray;

/**
 * Classe ItemComandaEntidade
 *
 * @author Joaov
 */
public class ItemComandaEntidade extends AbstractEntidade<ItemComandaBean, ItemComandaPk> {

    /** 
     * Construtor da classe ItemComandaEntidade
     */
    public ItemComandaEntidade() {}
    
    @Override
    public JSONArray getTitulos() {
       JSONArray titulos = new JSONArray();       
        titulos.add("Código");
        titulos.add("Item");
        titulos.add("Produto");
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
