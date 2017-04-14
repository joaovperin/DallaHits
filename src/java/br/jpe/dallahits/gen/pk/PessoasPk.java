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
 * Classe PessoasPk
 *
 * @author Joaov
 */
public class PessoasPk extends AbstractPk<PessoasPk> {

    /** Nome */
    private String nome;

    /** 
     * Construtor da classe PessoasPk
     */
    public PessoasPk() {}

    /** 
     * Construtor da classe PessoasPk
     * 
     * @param  nome
     */
    public PessoasPk(String nome) {
       this.nome = nome;
    }

    /** 
     * Retorna o valor do campo Nome
     * 
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /** 
     * Define o valor do campo Nome
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

}
