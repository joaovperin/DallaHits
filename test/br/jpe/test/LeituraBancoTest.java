/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.test;

import br.jpe.dallahits.bean.UsuarioBean;
import br.jpe.dallahits.dao.UsuarioDAO;
import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;

/**
 * Classe LeituraBancoTest
 *
 * @author Joaov
 */
public class LeituraBancoTest {

    public static void main(String[] args) {
        System.out.println("Hello!");

        try (Conexao conn = ConnFactory.criaConexao()){
            for (UsuarioBean bean : new UsuarioDAO(conn).busca()) {
                System.out.println(bean.toString());
            }
        } catch (DAOException e) {
            e.printStackTrace(System.out);
            System.out.println("falhou :/");
        }

        System.out.println("Fim.");
    }

}
