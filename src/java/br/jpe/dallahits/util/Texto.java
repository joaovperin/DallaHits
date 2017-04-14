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
    /** Pattern para converter Strings CamelCased para Underscored */
    private static final Pattern PT_CAMELCASE_TO_UNDERSCORE = Pattern.compile("([^_A-Z])([A-Z])");
    /** Pattern para detectar palavras entre parênteses */
    private static final Pattern PT_PARENTESES = Pattern.compile("\\(.+\\)");

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

    /**
     * Converte um texto separado por CamelCase para UnderScored
     *
     * @param str Texto
     * @return String
     */
    public static String toUnderScore(String str) {
        return PT_CAMELCASE_TO_UNDERSCORE.matcher(str).replaceAll("$1_$2");
    }

    /**
     * Remove a primeira ocorrência da expressão num texto
     *
     * @param regex
     * @param text
     * @return String
     */
    public static String removeFirst(String regex, String text) {
        return text.replaceFirst(regex, "");
    }

    /**
     * Remove a última ocorrência da expressão num texto
     *
     * @param regex
     * @param text
     * @return String
     */
    public static String removeLast(String regex, String text) {
        String pattern = "(?s)" + regex + "(?!.*?" + regex + ")";
        return text.replaceFirst(pattern, "");
    }

    /**
     * Remove o caracter na posição indicada
     *
     * @param text
     * @param index
     * @return String
     */
    public static String removeCharAt(String text, int index) {
        if (index < 0 || index > text.length()) {
            return text;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text.substring(0, index));
        sb.append(text.substring(index + 1, text.length()));
        return sb.toString();
    }

    /**
     * Remove os parênteses externos do texto (não recursivamente)
     *
     * @param text
     * @return String
     */
    public static String removeOuterParenteses(String text) {
        if (PT_PARENTESES.matcher(text).find()) {
            String temp = removeCharAt(text, text.length() - 1);
            return removeCharAt(temp, 0);
        }
        return text;
    }

}
