/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.test;

import br.jpe.dallahits.util.HtmlTagBuilder;

/**
 * Classe Perin
 *
 * @author Joaov
 */
public class Perin {

    public static void main(String[] args) {
        System.out.println("Hello!");

        HtmlTagBuilder tb = new HtmlTagBuilder("a", "Alterar");
        tb.add("id", "alterar");
        tb.add("class", "batata");
        System.out.println(tb.build());

        System.out.println("Fim.");
    }

}
