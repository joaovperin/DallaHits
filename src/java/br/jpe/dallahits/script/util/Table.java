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

    private String nome;
    private String tableName;
    private List<Field> tableFields;

    public Table() {
        tableFields = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Field> getTableFields() {
        return tableFields;
    }

    public void setTableFields(List<Field> tableFields) {
        this.tableFields = tableFields;
    }

    public void addField(Field field) {
        tableFields.add(field);
    }

    @Override
    public String toString() {
        return "Table{" + "nome=" + tableName + ", fields=" + tableFields + '}';
    }

}
