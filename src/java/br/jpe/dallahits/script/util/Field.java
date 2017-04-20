/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.script.util;

/**
 * Classe Tabela
 *
 * @author Joaov
 */
public class Field {

    /** Nome do campo no banco */
    private String field;
    /** Tipo do campo no banco */
    private String type;
    /** Comentário do campo no banco */
    private String comment;
    /** Se o campo é chave primária */
    private boolean pk;
    /** Se o campo é auto incremento */
    private boolean autoIncrement;

    /**
     * Retorna o nome do campo no banco
     *
     * @return String
     */
    public String getField() {
        return field;
    }

    /**
     * Define o nome do campo no banco
     *
     * @param field
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * Retorna o tipo do campo no banco
     *
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * Define o tipo do campo no banco
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Retorna o comentário do campo no banco
     *
     * @return String
     */
    public String getComment() {
        return comment;
    }

    /**
     * Define o comentário do campo no banco
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Retorna verdadeiro se o campo for chave primária
     *
     * @return boolean
     */
    public boolean isPk() {
        return pk;
    }

    /**
     * Define se o campo é chave primária
     *
     * @param pk
     */
    public void setPk(boolean pk) {
        this.pk = pk;
    }

    /**
     * Retorna verdadeiro se o campo for auto incremento
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

    /**
     * Serializa o campo
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Field{" + "field=" + field + ", type=" + type + ", comment=" + comment + ", pk=" + pk +
                ", autoIncrement=" + autoIncrement + '}';
    }

}
