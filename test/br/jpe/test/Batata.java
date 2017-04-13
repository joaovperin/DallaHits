/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe Batata
 *
 * @author Joaov
 */
public class Batata {
    
    public static void main(String[] args){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(new Date());
        
        System.out.println(data);
        
    }

}
