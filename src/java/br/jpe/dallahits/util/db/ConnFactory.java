/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.util.db;

import br.jpe.dallahits.exception.DAOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Factory responsavel por criar conexões com o banco
 *
 * @author Joaov
 */
public class ConnFactory {

    /** Nome do Driver do MySQL */
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    /** Nome da conexão com o BD */
    private static final String DB_CONN = "jdbc:mysql://localhost/dallahits";
    /** Nome do usuário no BD */
    private static final String DB_USER = "admin";
    /** Senha do usuário no BD */
    private static final String DB_PASS = "senhaAdmin12";
    /** Controle - indica se já registrou o driver do MySQL */
    private static boolean registrouDriver = false;

    /**
     * Cria uma conexão para consulta
     *
     * @return Conexao Conexão com o banco
     * @throws DAOException Problema ao criar conexão
     */
    public static Conexao criaConexao() throws DAOException {
        // Cria a conexão
        try {
            Connection conn = getMySQLConn();
            conn.setAutoCommit(false);
            return new Conexao(conn);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Cria uma conexão para transação
     *
     * @return Conexao Conexão com o banco
     * @throws DAOException Problema ao criar conexão
     */
    public static Conexao criaConexaoTransacao() throws DAOException {
        // Cria a conexão
        try {
            Connection conn = getMySQLConn();
            conn.setAutoCommit(false);
            return new Conexao(conn, true);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Cria uma conexão pelo Driver
     *
     * @return Connection
     * @throws SQLException
     */
    private static Connection getMySQLConn() throws SQLException {
        // Registra o Driver se precisar
        if (registrouDriver == false) {
            registraDriver();
        }
        return DriverManager.getConnection(DB_CONN, DB_USER, DB_PASS);
    }

    /**
     * Registra o Driver do MySQL no ClassLoader da JVM
     */
    private static void registraDriver() {
        registrouDriver = false;
        try {
            Class.forName(DRIVER_NAME);
            registrouDriver = true;
        } catch (ClassNotFoundException e) {
            registrouDriver = false;
            throw new RuntimeException("Falha ao registrar o Driver do MySQL JDBC!", e);
        }
    }

}
