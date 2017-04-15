/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.entidade;

import br.jpe.dallahits.generics.AbstractEntidade;
import br.jpe.dallahits.gen.bean.ComandaBean;
import br.jpe.dallahits.gen.pk.ComandaPk;
import org.json.simple.JSONArray;

/**
 * Classe ComandaEntidade
 *
 * @author Joaov
 */
public class ComandaEntidade extends AbstractEntidade<ComandaBean, ComandaPk> {

    /** 
     * Construtor da classe ComandaEntidade
     */
    public ComandaEntidade() {}
    
    @Override
    public JSONArray getTitulos() {
       JSONArray titulos = new JSONArray();       
        titulos.add("Código");
        titulos.add("Cliente vinculado");
        titulos.add("Usuario");
        titulos.add("Data");
        titulos.add("Valor Total");
       return titulos;
    }
     
    @Override
    public JSONArray getColunas() {
       JSONArray colunas = new JSONArray();
        colunas.add("idComanda");
        colunas.add("idCliente");
        colunas.add("idUsuario");
        colunas.add("data");
        colunas.add("valorTotal");
       return colunas;
    }

}
