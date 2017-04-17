/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.entidade;

import br.jpe.dallahits.generics.AbstractEntidade;
import br.jpe.dallahits.gen.bean.ClienteBean;
import br.jpe.dallahits.gen.pk.ClientePk;
import org.json.simple.JSONArray;

/**
 * Classe ClienteEntidade
 *
 * @author Joaov
 */
public class ClienteEntidade extends AbstractEntidade<ClienteBean, ClientePk> {

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
       return titulos;
    }
     
    @Override
    public JSONArray getColunas() {
       JSONArray colunas = new JSONArray();
        colunas.add("idCliente");
        colunas.add("nome");
        colunas.add("sexo");
        colunas.add("idade");
       return colunas;
    }

}