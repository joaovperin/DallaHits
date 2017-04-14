/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe auxiliar para trabalhar com Textos/Strings
 *
 * @author Joaov
 */
public class Texto {

    /** Pattern para converter Strings Underscored para CamelCased */
    private static final Pattern PT_UNDERSCORE_TO_CAMELCASE = Pattern.compile("_(.)");

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

    /**
     * Converte um texto separado por underlines para CamelCase
     *
     * @param str Texto
     * @param capFirst Se deve capitalizar o primeiro caracter
     * @return String
     */
    public static String toCamelCase(String str, boolean capFirst) {
        Matcher m = PT_UNDERSCORE_TO_CAMELCASE.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, m.group(1).toUpperCase());
        }
        m.appendTail(sb);
        // Se deve capitalizar o primeiro
        if (capFirst) {
            return capitalize(sb.toString());
        }
        return sb.toString();
    }

}
