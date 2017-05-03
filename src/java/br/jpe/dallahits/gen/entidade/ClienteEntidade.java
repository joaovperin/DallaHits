/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.entidade;

import br.jpe.dallahits.generics.AbstractViewEntidade;
import br.jpe.dallahits.gen.bean.ClienteBean;
import org.json.simple.JSONArray;

/**
 * Classe ClienteEntidade
 *
 * @author Joaov
 */
public class ClienteEntidade extends AbstractViewEntidade<ClienteBean> {

    /** 
     * Construtor da classe ClienteEntidade
     */
    public ClienteEntidade() {}
    
    @Override
    public JSONArray getTitulos() {
       JSONArray titulos = new JSONArray();       
        titulos.add("Código");
        titulos.add("Nome");
        titulos.add("Sexo");
        titulos.add("Idade");
        titulos.add("Cpf");
       return titulos;
    }
     
    @Override
    public JSONArray getColunas() {
       JSONArray colunas = new JSONArray();
        colunas.add("idCliente");
        colunas.add("nome");
        colunas.add("sexo");
        colunas.add("idade");
        colunas.add("cpf");
       return colunas;
    }

}
