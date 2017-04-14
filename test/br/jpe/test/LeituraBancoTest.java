/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.test;

import br.jpe.dallahits.gen.bean.UsuarioBean;
import br.jpe.dallahits.gen.dao.UsuarioDAO;
import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.gen.pk.UsuarioPk;
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
            
            UsuarioDAO dao = new UsuarioDAO(conn);
            for (UsuarioBean bean : dao.busca()) {
                System.out.println(bean.toString());
            }
            System.out.println("PK:\n");
            System.out.println(dao.buscaPk(new UsuarioPk("joaovperin")));
            
        } catch (DAOException e) {
            e.printStackTrace(System.out);
            System.out.println("falhou :/");
        }

        System.out.println("Fim.");
    }

}
