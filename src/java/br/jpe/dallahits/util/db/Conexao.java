/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.util.db;

import br.jpe.dallahits.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe Wrapper para uma Conexao com banco de dados
 *
 * @author Joaov
 */
public class Conexao implements AutoCloseable {

    /** Conexão com o BD */
    private final Connection conn;
    /** Se é uma conexão para transação */
    private final boolean isTransaction;

    /**
     * Construtor padrão
     *
     * @param conn Conexão com o banco
     */
    public Conexao(Connection conn) {
        this(conn, false);
    }

    /**
     * Construtor padrão
     *
     * @param conn Conexão com o banco
     * @param isTransaction Se é uma conexão para transação
     */
    public Conexao(Connection conn, boolean isTransaction) {
        this.conn = conn;
        this.isTransaction = isTransaction;
    }

    /**
     * Retorna a conexão do MySQL (não utilizar)
     *
     * @return Connection
     */
    @Deprecated
    public Connection get() {
        return conn;
    }

    /**
     * Retorna um PreparedStatement à partir de um SQL
     *
     * @param sql Comando SQL a rodar
     * @return PreparedStatement
     * @throws DAOException
     */
    public PreparedStatement prepareStatement(String sql) throws DAOException {
        try {
            return conn.prepareStatement(sql);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Executa um comando SQL diretamente no banco
     *
     * @param sql Comando SQL a rodar
     * @throws DAOException Falha ao executar comando
     */
    public void execSQL(String sql) throws DAOException {
        try {
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Retorna verdadeiro se for uma conexão para transação
     *
     * @return boolean
     */
    public boolean isTransaction() {
        return isTransaction;
    }

    /**
     * Realiza o commit da conexão de transação
     *
     * @throws DAOException
     */
    public void commit() throws DAOException {
        try {
            if (isTransaction) {
                conn.commit();
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Realiza o rollback da conexão de transação
     *
     * @throws DAOException
     */
    public void rollback() throws DAOException {
        try {
            if (isTransaction) {
                conn.rollback();
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Fecha uma conexão
     *
     * @throws DAOException
     */
    @Override
    public void close() throws DAOException {
        // Se já foi fechada, encerra
        if (conn == null) {
            return;
        }
        // Tenta fechar a conexão
        try {
            conn.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

}
