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
    private static final String SQL_SELECT = "SELECT idComanda, item, produto, quantidade, valorTotalItem FROM Itemcomanda";
    /** SQL para INSERT */
    private static final String SQL_INSERT = "INSERT INTO Itemcomanda (idComanda, item, produto, quantidade, valorTotalItem) VALUES ( ?,  ?,  ?,  ?,  ? )";

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
           PreparedStatement pstmt = conn.prepareStatement(getSqlInsert());
           pstmt.setLong(1, bean.getIdComanda());
           pstmt.setLong(2, bean.getItem());
           pstmt.setLong(3, bean.getProduto());
           pstmt.setInt(4, bean.getQuantidade());
           pstmt.setDouble(5, bean.getValorTotalItem());
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
            String busca = SQL_SELECT.concat(
            " WHERE idComanda, item =  ?,  ?"
            );
            PreparedStatement pstmt = conn.prepareStatement(busca);
            pstmt.setLong(1, pk.getIdComanda());
            pstmt.setLong(2, pk.getItem());
            return buscaPrimeiro(pstmt);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void update(ItemComandaBean bean) throws DAOException {
        throw new UnsupportedOperationException("ItemComandaDAO.update() nao suportado.");
    }

    @Override
    public void delete(ItemComandaBean bean) throws DAOException {
        throw new UnsupportedOperationException("ItemComandaDAO.delete() nao suportado.");
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

}
