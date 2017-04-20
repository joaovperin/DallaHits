/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.script;

import br.jpe.dallahits.script.core.InicializadorDB;
import br.jpe.dallahits.util.db.ContextUtils;

/**
 * Classe RecriaBancoScript
 *
 * @author Joaov
 */
public class RecriaBancoScript {

    /**
     * Executa o Script de recriação do banco de dados
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Inicializando criação do banco de dados...");
        String dirBase = ContextUtils.getDirBas().concat("\\web");
        long start = 0, end = 0;
        start = System.currentTimeMillis();
        new InicializadorDB(dirBase).exec();
        end = System.currentTimeMillis();
        // Mensagem de tempo decorrido
        System.out.println("Fim. Tempo decorrido: " + (end - start) + " ms.");
    }

}
