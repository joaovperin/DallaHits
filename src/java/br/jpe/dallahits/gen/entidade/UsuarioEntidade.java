/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.entidade;

import br.jpe.dallahits.generics.AbstractViewEntidade;
import br.jpe.dallahits.gen.bean.UsuarioBean;
import org.json.simple.JSONArray;

/**
 * Classe UsuarioEntidade
 *
 * @author Joaov
 */
public class UsuarioEntidade extends AbstractViewEntidade<UsuarioBean> {

    /** 
     * Construtor da classe UsuarioEntidade
     */
    public UsuarioEntidade() {}
    
    @Override
    public JSONArray getTitulos() {
       JSONArray titulos = new JSONArray();       
        titulos.add("Login");
        titulos.add("Código");
        titulos.add("Email");
        titulos.add("Senha");
        titulos.add("Nome");
        titulos.add("Tipo");
       return titulos;
    }
     
    @Override
    public JSONArray getColunas() {
       JSONArray colunas = new JSONArray();
        colunas.add("login");
        colunas.add("idUsuario");
        colunas.add("email");
        colunas.add("senha");
        colunas.add("nome");
        colunas.add("tipo");
       return colunas;
    }

}
