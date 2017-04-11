/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.util.db;

import br.jpe.dallahits.exception.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Classe Abstrata para todos os DAOs
 *
 * @author Joaov
 * @param <B> Bean
 */
public abstract class AbstractDAO<B> {

    /** Conexão com o banco de dados */
    protected final Conexao conn;

    /**
     * Construtor padrão que recebe uma conexão por inversão de controle
     *
     * @param conn Conexão com o banco de dados
     */
    public AbstractDAO(Conexao conn) {
        this.conn = conn;
    }

    public abstract List<B> busca() throws DAOException;

    public abstract void insert(B bean) throws DAOException;

    public abstract void update(B bean) throws DAOException;

    public abstract void delete(B bean) throws DAOException;

    /**
     * Busca o primeiro registro através do PreparedStatement
     *
     * @param pstmt PreparedStatement com os filtro estabelecidos
     * @return B Bean populado
     * @throws DAOException
     */
    protected B buscaPrimeiro(PreparedStatement pstmt) throws DAOException {
        try {
            // Realiza busca
            ResultSet rs = pstmt.executeQuery();
            // Se encontrar
            if (rs.next()) {
                return getBeanFromResultSet(rs);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return null;
    }

    /**
     * Cria um novo Bean e popula a partir do ResultSet
     *
     * @param rs ResultSet com dados lidos do banco
     * @return B Bean populado
     * @throws SQLException Problema ao ler parâmetro do result set
     */
    protected abstract B getBeanFromResultSet(ResultSet rs) throws SQLException;

}
