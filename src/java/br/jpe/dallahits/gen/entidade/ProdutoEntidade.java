/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.entidade;

import br.jpe.dallahits.generics.AbstractViewEntidade;
import br.jpe.dallahits.gen.bean.ProdutoBean;
import org.json.simple.JSONArray;

/**
 * Classe ProdutoEntidade
 *
 * @author Joaov
 */
public class ProdutoEntidade extends AbstractViewEntidade<ProdutoBean> {

    /** 
     * Construtor da classe ProdutoEntidade
     */
    public ProdutoEntidade() {}
    
    @Override
    public JSONArray getTitulos() {
       JSONArray titulos = new JSONArray();       
        titulos.add("Código");
        titulos.add("Descrição");
        titulos.add("Valor unitário");
       return titulos;
    }
     
    @Override
    public JSONArray getColunas() {
       JSONArray colunas = new JSONArray();
        colunas.add("idProduto");
        colunas.add("descricao");
        colunas.add("valorUnitario");
       return colunas;
    }

}
