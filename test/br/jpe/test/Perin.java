/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.test;

//import java.util.Date;
//import java.sql.Date;
import java.util.Date;
import org.json.simple.JSONObject;

/**
 * Classe Perin
 *
 * @author Joaov
 */
public class Perin {

    public static void main(String[] args) {
        System.out.println("Hello!");

        String input = "Àgua";
        
        System.out.println(input);
        JSONObject temp = new JSONObject();
        temp.put("values", input);
        System.out.println(temp.toString());

        System.out.println("Fim.");
    }

}
