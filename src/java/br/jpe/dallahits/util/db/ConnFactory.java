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

    /** Nome do Driver do MySQL */
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    /** Propriedades da conexão com o banco */
    private static final Properties DB_PROPERTIES = new Properties();

    /** Nome da conexão com o BD */
    private static final String DB_DEF_CONN = "jdbc:mysql://localhost/dallahits";
    /** Nome do usuário no BD */
    private static final String DB_DEF_USER = "admin";
    /** Senha do usuário no BD */
    private static final String DB_DEF_PASS = "senhaAdmin12";
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
        // Define as propriedades da conexão
        Properties pt = new Properties();
        pt.setProperty("user", getUsername());
        pt.setProperty("password", getPassword());
        pt.setProperty("autoReconnect", "true");
        return DriverManager.getConnection(getUrl(), pt);
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

    /**
     * Define as propriedades da conexão com o banco de dados
     *
     * @param pt Properties
     */
    public static void setProperties(Properties pt) {
        setProperties(
                pt.getProperty("url"),
                pt.getProperty("user"),
                pt.getProperty("password"));
    }

    /**
     * Define as propriedades da conexão com o banco de dados
     *
     * @param url
     * @param user
     * @param pass
     */
    public static void setProperties(String url, String user, String pass) {
        DB_PROPERTIES.clear();
        setUrl(url);
        setUser(user);
        setPassword(pass);
    }

    /**
     * Define a URL da conexão
     */
    private static void setUrl(String url) {
        if (url != null) {
            DB_PROPERTIES.setProperty("url", url);
        }
    }

    /**
     * Define o usuário da conexão
     */
    private static void setUser(String user) {
        if (user != null) {
            DB_PROPERTIES.setProperty("user", user);
        }
    }

    /**
     * Define a senha da conexão
     */
    private static void setPassword(String password) {
        if (password != null) {
            DB_PROPERTIES.setProperty("password", password);
        }
    }

    /**
     * Retorna a URL da conexão
     */
    private static String getUrl() {
        return DB_PROPERTIES.getProperty("url", DB_DEF_CONN);
    }

    /**
     * Retorna o usuário conexão
     */
    private static String getUsername() {
        return DB_PROPERTIES.getProperty("user", DB_DEF_USER);
    }

    /**
     * Retorna a senha da conexão
     */
    private static String getPassword() {
        return DB_PROPERTIES.getProperty("password", DB_DEF_PASS);
    }

}
