/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.test.random;

/**
 * Classe Testador
 *
 * @author Joaov
 */
public class Testador {

    public static void main(String[] args) {
        new Testador().run();
    }

    public void run() {
        Vector2D v = new Vector2D();
        Vector2D add = v.add(v);
        
        Vector x = testa(add);
    }

    public Vector testa(Vector v){
        return null;
    }
    
}
