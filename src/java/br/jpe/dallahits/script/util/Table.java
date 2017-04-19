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
    
        
    /** 
     * COMENTAR ISSO AQUI
     */

    private String name;
    private String type;
    private List<Field> tableFields;

    public Table() {
        tableFields = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "Table{" + "name=" + name + ", type=" + type + ", tableFields=" + tableFields + '}';
    }

}
