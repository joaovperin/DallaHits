/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.util;

/**
 * Classe auxiliar para trabalhar com Textos/Strings
 *
 * @author Joaov
 */
public class Texto {

    /**
     * Capitaliza uma String
     *
     * @param str
     * @return String
     */
    public static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase().concat(str.substring(1));
    }

    /**
     * Descapitaliza uma String
     *
     * @param str
     * @return String
     */
    public static String uncaptalize(String str) {
        return str.substring(0, 1).toLowerCase().concat(str.substring(1));
    }

}
