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

    /**
     * COMENTAR ISSO AQUI
     */
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

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isIsPk() {
        return isPk;
    }

    public void setIsPk(boolean isPk) {
        this.isPk = isPk;
    }

    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

}
