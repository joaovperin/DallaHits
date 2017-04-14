/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.util.db;

import java.util.Properties;

/**
 * Classe ConnManager
 *
 * @author Joaov
 */
public class ConnManager {

    /** Nome do Driver do MySQL */
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    /** Propriedades da conexão com o banco */
    private static final Properties DB_PROPERTIES = new Properties();

    /** Nome da propriedade - Driver */
    private static final String PT_DRIVER = "driver";
    /** Nome da propriedade - Conexão */
    private static final String PT_CONNECTION = "url";
    /** Nome da propriedade - Usuário */
    private static final String PT_USERNAME = "user";
    /** Nome da propriedade - Senha */
    private static final String PT_PASSWORD = "password";
    /** Nome da propriedade - Database */
    private static final String PT_DATABASE = "database";

    /** Default - Nome da conexão com o BD */
    private static final String DB_DEF_CONN = "jdbc:mysql://localhost/dallahits";
    /** Default - Nome do usuário no BD */
    private static final String DB_DEF_USER = "admin";
    /** Default - Senha do usuário no BD */
    private static final String DB_DEF_PASS = "senhaAdmin12";
    /** Default - Database */
    private static final String DB_DEF_DATABASE = "dallahits";

    /**
     * Define as propriedades da conexão com o banco de dados
     *
     * @param pt Properties
     */
    public static void setProperties(Properties pt) {
        setProperties(
                pt.getProperty(PT_DRIVER),
                pt.getProperty(PT_CONNECTION),
                pt.getProperty(PT_DATABASE),
                pt.getProperty(PT_USERNAME),
                pt.getProperty(PT_PASSWORD));
    }

    /**
     * Define as propriedades da conexão com o banco de dados
     *
     * @param url
     * @param database
     * @param user
     * @param pass
     */
    public static void setProperties(String url, String database, String user, String pass) {
        setProperties(null, url, database, user, pass);
    }

    /**
     * Define as propriedades da conexão com o banco de dados
     *
     * @param driver
     * @param url
     * @param database
     * @param user
     * @param pass
     */
    public static void setProperties(String driver, String url, String database, String user, String pass) {
        System.out.println("Definindo as propriedades da conexão....");
        DB_PROPERTIES.clear();
        setDriver(driver);
        setUrl(url);
        setDatabase(database);
        setUser(user);
        setPassword(pass);
        // Printa as propriedades definidas
        DB_PROPERTIES.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }

    /**
     * Define o Driver
     *
     * @param driver
     */
    public static void setDriver(String driver) {
        if (driver != null) {
            DB_PROPERTIES.setProperty(PT_DATABASE, driver);
        }
    }

    /**
     * Define a Database
     *
     * @param database
     */
    public static void setDatabase(String database) {
        if (database != null) {
            DB_PROPERTIES.setProperty(PT_DATABASE, database);
        }
    }

    /**
     * Define a URL da conexão
     *
     * @param url
     */
    public static void setUrl(String url) {
        if (url != null) {
            DB_PROPERTIES.setProperty(PT_CONNECTION, url);
        }
    }

    /**
     * Define o usuário da conexão
     *
     * @param user
     */
    public static void setUser(String user) {
        if (user != null) {
            DB_PROPERTIES.setProperty(PT_USERNAME, user);
        }
    }

    /**
     * Define a senha da conexão
     *
     * @param password
     */
    public static void setPassword(String password) {
        if (password != null) {
            DB_PROPERTIES.setProperty(PT_PASSWORD, password);
        }
    }

    /**
     * Retorna a URL da conexão
     *
     * @return String
     */
    public static String getUrl() {
        return DB_PROPERTIES.getProperty(PT_CONNECTION, DB_DEF_CONN);
    }

    /**
     * Retorna o usuário conexão
     *
     * @return String
     */
    public static String getUsername() {
        return DB_PROPERTIES.getProperty(PT_USERNAME, DB_DEF_USER);
    }

    /**
     * Retorna a senha da conexão
     *
     * @return String
     */
    public static String getPassword() {
        return DB_PROPERTIES.getProperty(PT_PASSWORD, DB_DEF_PASS);
    }

    /**
     * Retorna o nome do Driver do banco de dados
     *
     * @return String
     */
    public static String getDriverName() {
        return DB_PROPERTIES.getProperty(PT_DRIVER, DRIVER_NAME);
    }

    /**
     * Retorna o nome do banco de dados
     *
     * @return String
     */
    public static String getDatabaseName() {
        return DB_PROPERTIES.getProperty(PT_DATABASE, DB_DEF_DATABASE);
    }

}
