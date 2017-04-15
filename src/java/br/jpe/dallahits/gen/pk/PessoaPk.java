/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.pk;

import br.jpe.dallahits.generics.AbstractPk;

/**
 * Classe PessoaPk
 *
 * @author Joaov
 */
public class PessoaPk extends AbstractPk<PessoaPk> {

    /** Nome */
    private String nome;

    /** 
     * Construtor da classe PessoaPk
     */
    public PessoaPk() {}

    /** 
     * Construtor da classe PessoaPk
     * 
     * @param  nome
     */
    public PessoaPk(String nome) {
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
