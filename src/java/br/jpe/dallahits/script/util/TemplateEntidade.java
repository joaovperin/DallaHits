/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.script.util;

import br.jpe.dallahits.util.Texto;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe TemplateTabela
 *
 * @author Joaov
 */
public class TemplateEntidade {

    /** Nome da tabela no banco */
    private String tableName;
    /** Tipo de tabela */
    private String tableType;
    /** Nome da tabela para exibição */
    private String nome;
    /** Índice do último atributo chave */
    private int lastKeyAtt;
    /** Lista de atributos da tabela */
    private List<TemplateAtributo> attrs;

    /**
     * Constrói uma entidade à partir de uma tabela MySQL
     *
     * @param t Tabela MySQL
     */
    public TemplateEntidade(Table t) {
        attrs = new ArrayList<>();
        lastKeyAtt = -1;
        for (Field f : t.getTableFields()) {
            attrs.add(new TemplateAtributo(f));
            if (f.isPk()) {
                lastKeyAtt++;
            }
        }
        tableName = t.getName();
        tableType = t.getType();
        nome = Texto.toCamelCase(t.getName(), true);
    }

    /**
     * Retorna o nome da tabela
     *
     * @return String
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Define o nome da tabela
     *
     * @param tableName
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * Retorna o tipo da tabela
     *
     * @return String
     */
    public String getTableType() {
        return tableType;
    }

    /**
     * Define o tipo da tabela
     *
     * @param tableType
     */
    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    /**
     * Retorna verdadeiro se for uma View
     *
     * @return boolean
     */
    public boolean isView() {
        return getTableType().equals("VIEW");
    }

    /**
     * Retorna verdadeiro se for uma Tabela
     *
     * @return boolean
     */
    public boolean isTable() {
        return getTableType().equals("BASE_TABLE");
    }

    /**
     * Retorna o nome da tabela no banco
     *
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da tabela no banco
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna os atributos da tabela
     *
     * @return List
     */
    public List<TemplateAtributo> getAttrs() {
        return attrs;
    }

    /**
     * Define os atributos da tabela
     *
     * @param attrs
     */
    public void setAttrs(List<TemplateAtributo> attrs) {
        this.attrs = attrs;
    }

    /**
     * Adiciona uma tributo na tabela
     *
     * @param attr
     */
    public void addAttr(TemplateAtributo attr) {
        attrs.add(attr);
    }

    /**
     * Retorna o índice do último atributo chave
     *
     * @return int
     */
    public int getLastKeyAtt() {
        return lastKeyAtt;
    }

    /**
     * Define o índice do último atributo chave
     *
     * @param lastKeyAtt
     */
    public void setLastKeyAtt(int lastKeyAtt) {
        this.lastKeyAtt = lastKeyAtt;
    }

}
