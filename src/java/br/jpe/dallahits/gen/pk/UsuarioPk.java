/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.pk;

import br.jpe.dallahits.util.db.AbstractPk;

/**
 * Classe UsuarioPk
 *
 * @author Joaov
 */
public class UsuarioPk extends AbstractPk<UsuarioPk> {

    /** Login */
    private String login;

    /** 
     * Construtor da classe UsuarioPk
     */
    public UsuarioPk() {}

    /** 
     * Construtor da classe UsuarioPk
     * 
     * @param  login
     */
    public UsuarioPk(String login) {
       this.login = login;
    }

    /** 
     * Retorna o valor do campo Login
     * 
     * @return String
     */
    public String getLogin() {
        return login;
    }

    /** 
     * Define o valor do campo Login
     * 
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

}
