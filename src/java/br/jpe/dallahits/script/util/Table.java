/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.script.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Table
 *
 * @author Joaov
 */
public class Table {

    /** Nome da tabela no banco */
    private String name;
    /** Tipo da tabela no banco */
    private String type;
    /** Lista de campos da tabela */
    private List<Field> tableFields;

    /**
     * Construtor padrão da tabela
     */
    public Table() {
        tableFields = new ArrayList<>();
    }

    /**
     * Retorna o nome da tabela
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome da tabela
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o tipo da tabela
     *
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * Define o tipo da tabela
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Retorna a lista de campos da tabela
     *
     * @return List
     */
    public List<Field> getTableFields() {
        return tableFields;
    }

    /**
     * Define a lista de campos da tabela
     *
     * @param tableFields
     */
    public void setTableFields(List<Field> tableFields) {
        this.tableFields = tableFields;
    }

    /**
     * Adiciona um campo na tabela
     *
     * @param field
     */
    public void addField(Field field) {
        tableFields.add(field);
    }

    /**
     * Serializa a tabela
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Table{" + "name=" + name + ", type=" + type + ", tableFields=" + tableFields + '}';
    }

}
