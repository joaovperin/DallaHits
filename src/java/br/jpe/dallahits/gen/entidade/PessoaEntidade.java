/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.entidade;

import br.jpe.dallahits.generics.AbstractEntidade;
import br.jpe.dallahits.gen.bean.PessoaBean;
import br.jpe.dallahits.gen.pk.PessoaPk;
import org.json.simple.JSONArray;

/**
 * Classe PessoaEntidade
 *
 * @author Joaov
 */
public class PessoaEntidade extends AbstractEntidade<PessoaBean, PessoaPk> {

    /** 
     * Construtor da classe PessoaEntidade
     */
    public PessoaEntidade() {}
    
    @Override
    public JSONArray getTitulos() {
       JSONArray titulos = new JSONArray();       
        titulos.add("Nome");
        titulos.add("E-mail");
        titulos.add("Idade");
       return titulos;
    }
     
    @Override
    public JSONArray getColunas() {
       JSONArray colunas = new JSONArray();
        colunas.add("nome");
        colunas.add("email");
        colunas.add("idade");
       return colunas;
    }

}
