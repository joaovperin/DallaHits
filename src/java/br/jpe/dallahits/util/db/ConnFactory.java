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
import java.util.Properties;

/**
 * Factory responsavel por criar conexões com o banco
 *
 * @author Joaov
 */
public class ConnFactory {

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
            Connection conn = getJDBCConn();
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
            Connection conn = getJDBCConn();
            conn.setAutoCommit(false);
            return new Conexao(conn, true);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Cria uma conexão pelo Driver executando a configuração se necessário
     *
     * @return Connection
     * @throws SQLException
     */
    private static Connection getJDBCConn() throws SQLException {
        return getJDBCConn(true);
    }

    /**
     * Cria uma conexão pelo Driver
     *
     * @param exec Indica se deve executar configuração
     * @return Connection
     * @throws SQLException
     */
    private static Connection getJDBCConn(boolean exec) throws SQLException {
        // Registra o Driver se precisar
        if (exec && registrouDriver == false) {
            registraDriver();
        }
        // Define as propriedades da conexão
        Properties pt = new Properties();
        pt.setProperty("user", ConnManager.getUsername());
        pt.setProperty("password", ConnManager.getPassword());
        pt.setProperty("autoReconnect", "true");
        return DriverManager.getConnection(ConnManager.getUrl(), pt);
    }

    /**
     * Registra o Driver do MySQL no ClassLoader da JVM
     */
    private static void registraDriver() throws SQLException {
        registrouDriver = false;
        try {
            Class.forName(ConnManager.getDriverName());
            setUseDb();
            registrouDriver = true;
        } catch (ClassNotFoundException e) {
            registrouDriver = false;
            throw new RuntimeException("Falha ao registrar o Driver do MySQL JDBC!", e);
        }
    }

    /**
     * Executa o comando que indica a Database a utilizar
     *
     * @throws SQLException
     */
    public static void setUseDb() throws SQLException {
        getJDBCConn(false).createStatement().execute(getSqlUseDB());
    }

    /**
     * Retorna o SQL de USE database
     *
     * @return String
     */
    private static String getSqlUseDB() {
        return "USE " + ConnManager.getDatabaseName();
    }

}
