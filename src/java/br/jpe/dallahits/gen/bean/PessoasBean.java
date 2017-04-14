/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.bean;

import br.jpe.dallahits.util.db.AbstractBean;
import br.jpe.dallahits.gen.pk.PessoasPk;
import java.util.Objects;

/**
 * Classe PessoasBean
 *
 * @author Joaov
 */
public class PessoasBean extends AbstractBean<PessoasBean> {

    /** Nome */
    private String nome;
    /** E-mail */
    private String email;
    /** Idade */
    private int idade;

    /** 
     * Construtor da classe PessoasBean
     */
    public PessoasBean() {}
 
    /** 
     * Retorna a chave primária da entidade Pessoas
     * 
     * @return PessoasPk
     */
    public PessoasPk getPk() {
        return new PessoasPk(getNome());
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

    /** 
     * Retorna o valor do campo E-mail
     * 
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /** 
     * Define o valor do campo E-mail
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** 
     * Retorna o valor do campo Idade
     * 
     * @return int
     */
    public int getIdade() {
        return idade;
    }

    /** 
     * Define o valor do campo Idade
     * 
     * @param idade
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Gera e retorna um código hash para essa instância de Pessoas
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.idade);
        return hash;
    }

    /**
     * Retorna verdadeiro se os dois objetos forem iguais
     *
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoasBean other = (PessoasBean) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.idade, other.idade)) {
            return false;
        }
        return true;
    }

    /**
     * Retorna a representação do campo em String
     *
     * @return String
     */
    @Override
    public String toString() {
        return "PessoasBean{" +
                    "nome=" + nome + ", " +
                    "email=" + email + ", " +
                    "idade=" + idade + "}";
    }

}
