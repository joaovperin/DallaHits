/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.generics;

import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.util.db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Abstrata para todos os DAOs
 *
 * @author Joaov
 * @param <B> Bean
 * @param <P> Pk
 */
public abstract class AbstractDAO<B extends AbstractBean, P extends AbstractPk> {

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

    /**
     * Realiza uma busca de todas as entidades no banco
     *
     * @return List Lista de beans
     * @throws DAOException
     */
    public List<B> busca() throws DAOException {
        List<B> list = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(getSqlSelect());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(getBeanFromResultSet(rs));
            }
            return list;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Realiza uma busca de todas as entidades no banco
     *
     * @param filtro String com um filtro a passar para o banco (Cláusula Where)
     * @return List Lista de beans
     * @throws DAOException
     */
    public List<B> busca(String filtro) throws DAOException {
        List<B> list = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(getSqlSelect().concat(filtro));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(getBeanFromResultSet(rs));
            }
            return list;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Busca o primeiro registro através do PreparedStatement
     *
     * @param pstmt PreparedStatement com os filtro estabelecidos
     * @return B Bean populado
     * @throws DAOException
     */
    protected B buscaPrimeiro(PreparedStatement pstmt) throws DAOException {
        try {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return getBeanFromResultSet(rs);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return null;
    }

    /**
     * Busca o primeiro registro através do filtro passado
     *
     * @param filtro String com um filtro a passar para o banco (Cláusula Where)
     * @return B Bean populado
     * @throws DAOException
     */
    public B buscaPrimeiro(String filtro) throws DAOException {
        return buscaPrimeiro(conn.prepareStatement(getSqlSelect().concat(filtro)));
    }

    /** Insere um registro no banco */
    public abstract void insert(B bean) throws DAOException;

    /** Atualiza um registro no banco */
    public abstract void update(B bean) throws DAOException;

    /** Deleta um registro do banco */
    public abstract void delete(B bean) throws DAOException;

    /** Retorna o comando SQL para leitura do registro */
    protected abstract String getSqlSelect();

    /** Retorna o comando SQL para inserção do registro */
    protected abstract String getSqlInsert();

    /** Retorna o comando SQL para atualizar um registro */
    protected abstract String getSqlUpdate(String where);

    /** Retorna o comando SQL para deletar um registro */
    protected abstract String getSqlDelete(String where);

    /**
     * Cria um novo Bean e popula a partir do ResultSet
     *
     * @param rs ResultSet com dados lidos do banco
     * @return B Bean populado
     * @throws SQLException Problema ao ler parâmetro do result set
     */
    protected abstract B getBeanFromResultSet(ResultSet rs) throws SQLException;

    /**
     * Preenche um PreparedStatement à partir de um Bean
     *
     * @param pstmt PreparedStatement recém criado (vazio)
     * @param bean Objeto com os dados a popular
     * @return PreparedStatement Dados populados
     * @throws SQLException
     */
    protected abstract PreparedStatement getPstmt(PreparedStatement pstmt, B bean) throws SQLException;

}
