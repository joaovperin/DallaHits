/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.script.util;

import br.jpe.dallahits.util.Texto;

/**
 * Classe TemplateCampo
 *
 * @author Joaov
 */
public class TemplateAtributo {

    /** Tipo de acesso do campo */
    private String acesso;
    /** Nome do campo */
    private String nome;
    /** Descrição do campo */
    private String descricao;
    /** Descrição do campo */
    private String tipo;
    /** Se o campo é chave primária */
    private boolean isPk;
    /** Se o campo é auto incremento */
    private boolean autoIncrement;

    /**
     * Construtor padrão do atributo
     *
     * @param f
     */
    public TemplateAtributo(Field f) {
        acesso = "private";
        nome = Texto.uncaptalize(f.getField());
        descricao = f.getComment();
        tipo = FieldConverter.get(f.getType());
        isPk = f.isPk();
        autoIncrement = f.isAutoIncrement();
    }

    /**
     * Retorna o modificador de acesso do atributo
     *
     * @return String
     */
    public String getAcesso() {
        return acesso;
    }

    /**
     * Define o modificador de acesso do campo
     *
     * @param acesso
     */
    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    /**
     * Retorna o nome do campo
     *
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do campo
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a descrição do campo
     *
     * @return String
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do campo
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna o tipo do campo
     *
     * @return String
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo do campo
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna verdadeiro se o campo é Chave Primária
     *
     * @return boolean
     */
    public boolean isIsPk() {
        return isPk;
    }

    /**
     * Define se o campo é chave primária
     *
     * @param isPk
     */
    public void setIsPk(boolean isPk) {
        this.isPk = isPk;
    }

    /**
     * Retorna verdadeiro se o campo é auto incremento
     *
     * @return boolean
     */
    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    /**
     * Define se o campo é auto incremento
     *
     * @param autoIncrement
     */
    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

}
