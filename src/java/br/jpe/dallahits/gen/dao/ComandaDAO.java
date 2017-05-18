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
import br.jpe.dallahits.generics.AbstractDAO;
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
    private static final String SQL_SELECT = "SELECT idComanda, idCliente, idUsuario, data, valorTotal FROM comanda";
    /** SQL para INSERT */
    private static final String SQL_INSERT = "INSERT INTO comanda (idCliente, idUsuario, data, valorTotal) VALUES ( ?,  ?,  ?,  ? )";
    /** SQL para UPDATE */
    private static final String SQL_UPDATE = "UPDATE comanda SET idCliente =  ?, idUsuario =  ?, data =  ?, valorTotal =  ?";
    /** SQL para DELETE */
    private static final String SQL_DELETE = "DELETE FROM comanda";

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
           PreparedStatement pstmt = getPstmt(conn.prepareStatement(getSqlInsert()), bean);
           pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Realiza o comando Insert na entidade à partir de um bean
     * 
     * @param bean
     * @return ComandaBean
     * @throws DAOException
     */
    public ComandaBean insertAi(ComandaBean bean) throws DAOException {
        try {
           PreparedStatement pstmt = getPstmt(conn.prepareStatementForAutoIncrement(getSqlInsert()), bean);
           pstmt.executeUpdate();
           ResultSet rs = pstmt.getGeneratedKeys();
           if (rs.next()){
              bean.setIdComanda(rs.getLong(1));
           }
           return bean;
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
            String sql = SQL_SELECT.concat(
            " WHERE idComanda =  ?"
            );
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, pk.getIdComanda());
            return buscaPrimeiro(pstmt);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Realiza alteração de uma entidade no banco de dados
     * 
     * @param bean
     * @throws DAOException
     */
    @Override
    public void update(ComandaBean bean) throws DAOException {
        try {
            String where = " WHERE idComanda =  ?";
            PreparedStatement pstmt = getPstmt(conn.prepareStatement(getSqlUpdate(where)), bean);
            pstmt.setLong(5, bean.getIdComanda());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Realiza a deleção de um registro no banco de dados
     * 
     * @param bean
     * @throws DAOException
     */
    @Override
    public void delete(ComandaBean bean) throws DAOException {
        try {
            String where = " WHERE idComanda =  ?";
            PreparedStatement pstmt = getPstmt(conn.prepareStatement(getSqlDelete(where)), bean);
            pstmt.setLong(1, bean.getIdComanda());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
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
     * Retorna o comando SQL para executar um Insert
     *
     * @return String
     */
    @Override
    protected String getSqlInsert() {
        return SQL_INSERT;
    }

    /** 
     * Retorna o comando SQL para executar um Update
     *
     * @param where Cláusula WHERE para executar filtros
     * @return String
     */
    @Override
    protected String getSqlUpdate(String where) {
        return SQL_UPDATE.concat(where);
    }

    /** 
     * Retorna o comando SQL para executar um Delete
     *
     * @param where Cláusula WHERE para executar filtros
     * @return String
     */
    @Override
    protected String getSqlDelete(String where) {
        return SQL_DELETE.concat(where);
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
        bean.setIdUsuario(rs.getInt(3));
        bean.setData(rs.getDate(4));
        bean.setValorTotal(rs.getDouble(5));
        return bean;
    }

    /** 
     * Preenche um PreparedStatement à partir de um Bean
     *
     * @param pstmt PreparedStatement recém criado (vazio)
     * @param bean Objeto com os dados a popular
     * @return PreparedStatement Dados populados
     * @throws java.sql.SQLException
     */
    @Override
    protected PreparedStatement getPstmt(PreparedStatement pstmt, ComandaBean bean) throws SQLException {
        pstmt.setLong(1, bean.getIdCliente());
        pstmt.setInt(2, bean.getIdUsuario());
        if (bean.getData() == null){
           bean.setData(new java.util.Date());
        }
        pstmt.setDate(3, new java.sql.Date(bean.getData().getTime()));
        pstmt.setDouble(4, bean.getValorTotal());
        return pstmt;
    }

}
