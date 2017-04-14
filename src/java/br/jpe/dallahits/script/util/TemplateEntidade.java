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

    private String tableName;
    private String nome;
    private int lastKeyAtt;
    private List<TemplateAtributo> attrs;

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
        nome = Texto.toCamelCase(t.getName(), true);
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<TemplateAtributo> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<TemplateAtributo> attrs) {
        this.attrs = attrs;
    }

    public void addAttr(TemplateAtributo attr) {
        attrs.add(attr);
    }

    public int getLastKeyAtt() {
        return lastKeyAtt;
    }

    public void setLastKeyAtt(int lastKeyAtt) {
        this.lastKeyAtt = lastKeyAtt;
    }

}
