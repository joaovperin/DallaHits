/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.dao;

import br.jpe.dallahits.gen.bean.ComandaBean;
import br.jpe.dallahits.gen.pk.ComandaPk;
import br.jpe.dallahits.util.db.AbstractDAO;
import br.jpe.dallahits.util.db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.jpe.dallahits.exception.DAOException;
import java.sql.SQLException;

/**
 * Classe ComandaDAO
 *
 * @author Joaov
 */
public class ComandaDAO extends AbstractDAO<ComandaBean, ComandaPk> {

    /** SQL para SELECT */
    private static final String SQL_SELECT = "SELECT idComanda, idCliente, data, valorTotal FROM Comanda";
    /** SQL para INSERT */
    private static final String SQL_INSERT = "INSERT INTO Comanda (idCliente, data, valorTotal) VALUES ( ?,  ?,  ? )";

    /** 
     * Construtor da classe ComandaPk
     *
     * @param conn
     */
    public ComandaDAO(Conexao conn) {
       super(conn);
    }

    /**
     * Realiza o comando Insert na entidade à partir de um bean
     * 
     * @param bean
     * @throws DAOException
     */
    @Override
    public void insert(ComandaBean bean) throws DAOException {
        try {
           PreparedStatement pstmt = conn.prepareStatement(getSqlInsert());
           pstmt.setLong(1, bean.getIdCliente());
           pstmt.setDate(2, new java.sql.Date(bean.getData().getTime()));
           pstmt.setDouble(3, bean.getValorTotal());
           pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Realiza uma busca no banco à partir da chave primária do elemento
     * 
     * @param pk
     * @return ComandaBean
     * @throws DAOException
     */
    public ComandaBean buscaPk(ComandaPk pk) throws DAOException {
        try {
            String busca = SQL_SELECT.concat(
            " WHERE idComanda =  ?"
            );
            PreparedStatement pstmt = conn.prepareStatement(busca);
            pstmt.setLong(1, pk.getIdComanda());
            return buscaPrimeiro(pstmt);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void update(ComandaBean bean) throws DAOException {
        throw new UnsupportedOperationException("ComandaDAO.update() nao suportado.");
    }

    @Override
    public void delete(ComandaBean bean) throws DAOException {
        throw new UnsupportedOperationException("ComandaDAO.delete() nao suportado.");
    }

    /** 
     * Retorna o comando SQL para executar uma SELECT
     *
     * @return String
     */
    @Override
    protected String getSqlSelect() {
        return SQL_SELECT;
    }

    /** 
     * Retorna o comando SQL para executar uma Insert
     *
     * @return String
     */
    @Override
    protected String getSqlInsert() {
        return SQL_INSERT;
    }
    
    /** 
     * Retorna um Bean à partir de um ResultSet
     *
     * @return ComandaBean
     * @throws java.sql.SQLException
     */
    @Override
    protected ComandaBean getBeanFromResultSet(ResultSet rs) throws SQLException {
        ComandaBean bean = new ComandaBean();
        bean.setIdComanda(rs.getLong(1));
        bean.setIdCliente(rs.getLong(2));
        bean.setData(rs.getDate(3));
        bean.setValorTotal(rs.getDouble(4));
        return bean;
    }

}
