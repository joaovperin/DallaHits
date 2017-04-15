/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe HtmlTagBuilder
 *
 * @author Joaov
 */
public class HtmlTagBuilder {

    private final String tag;
    private final String inlineValue;
    private final List<String> atributos;

    public HtmlTagBuilder(String tag) {
        this(tag, "");
    }

    public HtmlTagBuilder(String tag, String inlineValue) {
        this.tag = tag;
        this.inlineValue = inlineValue;
        atributos = new ArrayList<>();
    }

    public HtmlTagBuilder add(String attr, String valor) {
        StringBuilder sb = new StringBuilder();
        sb.append(attr).append("=").append(putInAspas(valor));
        atributos.add(sb.toString());
        return this;
    }

    public HtmlTagBuilder addId(String valor) {
        return add("id", valor);
    }
    
    public HtmlTagBuilder addClass(String valor) {
        return add("class", valor);
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(tag);
        for (String attr : atributos) {
            sb.append(" ").append(attr);
        }
        sb.append(">");
        sb.append(inlineValue);
        sb.append("</").append(tag).append(">");
        return sb.toString();
    }

    private static String putInAspas(String valor) {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(valor).append("'");
        return sb.toString();
    }

}
