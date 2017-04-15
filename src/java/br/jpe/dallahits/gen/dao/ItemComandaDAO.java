/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.dao;

import br.jpe.dallahits.gen.bean.ItemComandaBean;
import br.jpe.dallahits.gen.pk.ItemComandaPk;
import br.jpe.dallahits.util.db.AbstractDAO;
import br.jpe.dallahits.util.db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.jpe.dallahits.exception.DAOException;
import java.sql.SQLException;

/**
 * Classe ItemComandaDAO
 *
 * @author Joaov
 */
public class ItemComandaDAO extends AbstractDAO<ItemComandaBean, ItemComandaPk> {

    /** SQL para SELECT */
    private static final String SQL_SELECT = "SELECT idComanda, item, produto, quantidade, valorTotalItem FROM item_comanda";
    /** SQL para INSERT */
    private static final String SQL_INSERT = "INSERT INTO item_comanda (idComanda, item, produto, quantidade, valorTotalItem) VALUES ( ?,  ?,  ?,  ?,  ? )";
    /** SQL para UPDATE */
    private static final String SQL_UPDATE = "UPDATE item_comanda SET produto =  ?, quantidade =  ?, valorTotalItem =  ?";
    /** SQL para DELETE */
    private static final String SQL_DELETE = "DELETE FROM item_comanda";

    /** 
     * Construtor da classe ItemComandaPk
     *
     * @param conn
     */
    public ItemComandaDAO(Conexao conn) {
       super(conn);
    }

    /**
     * Realiza o comando Insert na entidade à partir de um bean
     * 
     * @param bean
     * @throws DAOException
     */
    @Override
    public void insert(ItemComandaBean bean) throws DAOException {
        try {
           PreparedStatement pstmt = getPstmt(conn.prepareStatement(getSqlInsert()), bean);
           pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Realiza uma busca no banco à partir da chave primária do elemento
     * 
     * @param pk
     * @return ItemComandaBean
     * @throws DAOException
     */
    public ItemComandaBean buscaPk(ItemComandaPk pk) throws DAOException {
        try {
            String sql = SQL_SELECT.concat(
            " WHERE idComanda, item =  ?,  ?"
            );
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, pk.getIdComanda());
            pstmt.setLong(2, pk.getItem());
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
    public void update(ItemComandaBean bean) throws DAOException {
        try {
            String where = " WHERE idComanda, item =  ?,  ?";
            PreparedStatement pstmt = getPstmt(conn.prepareStatement(getSqlUpdate(where)), bean);
            pstmt.setLong(5, bean.getIdComanda());
            pstmt.setLong(6, bean.getItem());
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
    public void delete(ItemComandaBean bean) throws DAOException {
        try {
            String where = " WHERE idComanda, item =  ?,  ?";
            PreparedStatement pstmt = getPstmt(conn.prepareStatement(getSqlDelete(where)), bean);
            pstmt.setLong(1, bean.getIdComanda());
            pstmt.setLong(2, bean.getItem());
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
     * @return ItemComandaBean
     * @throws java.sql.SQLException
     */
    @Override
    protected ItemComandaBean getBeanFromResultSet(ResultSet rs) throws SQLException {
        ItemComandaBean bean = new ItemComandaBean();
        bean.setIdComanda(rs.getLong(1));
        bean.setItem(rs.getLong(2));
        bean.setProduto(rs.getLong(3));
        bean.setQuantidade(rs.getInt(4));
        bean.setValorTotalItem(rs.getDouble(5));
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
    protected PreparedStatement getPstmt(PreparedStatement pstmt, ItemComandaBean bean) throws SQLException {
        pstmt.setLong(1, bean.getProduto());
        pstmt.setInt(2, bean.getQuantidade());
        pstmt.setDouble(3, bean.getValorTotalItem());
        return pstmt;
    }

}
