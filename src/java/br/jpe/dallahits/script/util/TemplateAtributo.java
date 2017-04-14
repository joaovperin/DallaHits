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

    private String acesso;
    private String nome;
    private String descricao;
    private String tipo;
    private boolean isPk;
    private boolean autoIncrement;

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
