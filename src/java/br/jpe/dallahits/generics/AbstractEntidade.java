/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.generics;

import org.json.simple.JSONArray;

/**
 * Classe AbstractEntidade
 *
 * @author Joaov
 * @param <B>
 * @param <P>
 */
public abstract class AbstractEntidade <B extends AbstractBean, P extends AbstractPk> {

    public abstract JSONArray getTitulos();

    public abstract JSONArray getColunas();
    
}
