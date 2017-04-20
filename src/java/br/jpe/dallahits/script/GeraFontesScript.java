/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.script;

import br.jpe.dallahits.script.core.FontGenerator;
import br.jpe.dallahits.util.db.ContextUtils;

/**
 * Classe GeraFontesScript
 *
 * @author Joaov
 */
public class GeraFontesScript {

    /**
     * Método principal responsável pela execução do Script
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando geração dos códigos fonte...");
        String dirBase = ContextUtils.getDirBas();
        long start = 0, end = 0;
        start = System.currentTimeMillis();
        new FontGenerator(dirBase).exec();
        end = System.currentTimeMillis();
        // Mensagem de tempo decorrido
        System.out.println("Fim. Tempo decorrido: " + (end - start) + " ms.");
    }

}
