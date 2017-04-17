/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.util.db;

import br.jpe.dallahits.exception.DAOException;

/**
 * Classe auxiliar para operações com conexões
 *
 * @author Joaov
 */
public class DBUtils {

    /**
     * Realiza o commit de uma conexão
     *
     * @param conn Conexão com o banco
     * @throws DAOException
     */
    public static void commit(Conexao conn) throws DAOException {
        if (conn != null) {
            conn.commit();
        }
    }

    /**
     * Realiza o rollback de uma conexão
     *
     * @param conn Conexão com o banco
     * @throws DAOException
     */
    public static void rollback(Conexao conn) {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (DAOException e) { }
        }
    }

    /**
     * Realiza o fechamento de uma conexão
     *
     * @param conn Conexão com o banco
     * @throws DAOException
     */
    public static void close(Conexao conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (DAOException e) { }
        }
    }

    /**
     * Retorna a URL completa do database
     *
     * @param url
     * @param db
     * @return
     */
    public static String getURLCompleta(String url, String db) {
        // Se já estiver montado
        if (url.endsWith(db)){
            return url;
        }
        if (url.endsWith("/") && db.startsWith("/")) {
            return url + db.substring(1, db.length());
        } else if (!url.endsWith("/") && !db.startsWith("/")) {
            return url + "/" + db;
        } else {
            return url + db;
        }
    }

}
