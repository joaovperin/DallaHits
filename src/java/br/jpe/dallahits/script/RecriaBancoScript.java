/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.script;

import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.script.core.InicializadorDB;
import java.io.IOException;

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
    public static void main(String[] args) {
        System.out.println("Inicializando criação do banco de dados...");
        String dirBase = "D:\\1-Projetos\\_Feevale\\DallaHits\\web";
        long start = 0, end = 0;
        try {
            start = System.currentTimeMillis();
            new InicializadorDB(dirBase).exec();
            end = System.currentTimeMillis();
        } catch (IOException e) {
            System.out.println("Ocorreu um problema ao ler o script de geraçao do BD!");
        } catch (DAOException e) {
            System.out.println("Ocorreu um problema no acesso aos dados!");
        }
        // Mensagem de tempo decorrido
        System.out.println("Fim. Tempo decorrido: " + (end - start) + " ms.");
    }

}
