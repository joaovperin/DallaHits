/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.test;

//import java.util.Date;
//import java.sql.Date;
import java.util.Date;

/**
 * Classe Perin
 *
 * @author Joaov
 */
public class Perin {

    public static void main(String[] args) {
        System.out.println("Hello!");
//        Date now = new Date();
//        System.out.println(now);
        
//        Date now = new Date(new java.util.Date());
//        System.out.println(now);
        
        Date dataUtil = new Date();
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
        
        System.out.println(dataUtil);
        System.out.println(dataSql);
        
        
        
        System.out.println("Fim.");
    }

}
