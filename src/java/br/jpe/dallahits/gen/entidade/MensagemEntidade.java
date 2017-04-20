/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.entidade;

import br.jpe.dallahits.generics.AbstractViewEntidade;
import br.jpe.dallahits.gen.bean.MensagemBean;
import org.json.simple.JSONArray;

/**
 * Classe MensagemEntidade
 *
 * @author Joaov
 */
public class MensagemEntidade extends AbstractViewEntidade<MensagemBean> {

    /** 
     * Construtor da classe MensagemEntidade
     */
    public MensagemEntidade() {}
    
    @Override
    public JSONArray getTitulos() {
       JSONArray titulos = new JSONArray();       
        titulos.add("Código da mensagem");
        titulos.add("Usuário que escreveu");
        titulos.add("Mensagem");
       return titulos;
    }
     
    @Override
    public JSONArray getColunas() {
       JSONArray colunas = new JSONArray();
        colunas.add("idMsg");
        colunas.add("usuario");
        colunas.add("msg");
       return colunas;
    }

}
