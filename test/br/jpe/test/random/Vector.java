/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.test.random;

/**
 * Classe Vector
 *
 * @author Joaov
 * @param <V>
 */
public interface Vector<V extends Vector> {
    
    public V add(V other);
    public V subtract(V other);

}
