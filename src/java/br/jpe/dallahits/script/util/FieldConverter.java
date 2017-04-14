/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.script.util;

/**
 * Classe FieldConverter
 *
 * @author Joaov
 */
public class FieldConverter {
    
    public static String get(String field){
        if (field.startsWith("varchar(") || field.startsWith("string")){
            return "String";
        }
        if (field.startsWith("bigint(")){
            return "long";
        }
        if (field.startsWith("int(")){
            return "int";
        }
        if (field.startsWith("tinyint(1)")){
            return "boolean";
        }
        if (field.startsWith("decimal(")){
            return "double";
        }
        if (field.startsWith("datetime") || field.startsWith("date ")){
            return "Date";
        }
        return "NULL";
    }

}
