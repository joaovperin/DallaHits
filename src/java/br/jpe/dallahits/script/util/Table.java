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
    List<Field> fields;

    public Table() {
        fields = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public void addField(Field field) {
        fields.add(field);
    }

    @Override
    public String toString() {
        return "Table{" + "nome=" + nome + ", fields=" + fields + '}';
    }

}
