/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.dao;

import br.jpe.dallahits.gen.bean.ProdutoBean;
import br.jpe.dallahits.gen.pk.ProdutoPk;
import br.jpe.dallahits.util.db.AbstractDAO;
import br.jpe.dallahits.util.db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.jpe.dallahits.exception.DAOException;
import java.sql.SQLException;

/**
 * Classe ProdutoDAO
 *
 * @author Joaov
 */
public class ProdutoDAO extends AbstractDAO<ProdutoBean, ProdutoPk> {

    /** SQL para SELECT */
    private static final String SQL_SELECT = "SELECT idProduto, descricao, valorUnitario FROM produto";
    /** SQL para INSERT */
    private static final String SQL_INSERT = "INSERT INTO produto (descricao, valorUnitario) VALUES ( ?,  ? )";
    /** SQL para UPDATE */
    private static final String SQL_UPDATE = "UPDATE produto SET descricao =  ?, valorUnitario =  ?";
    /** SQL para DELETE */
    private static final String SQL_DELETE = "DELETE FROM produto";

    /** 
     * Construtor da classe ProdutoPk
     *
     * @param conn
     */
    public ProdutoDAO(Conexao conn) {
       super(conn);
    }

    /**
     * Realiza o comando Insert na entidade à partir de um bean
     * 
     * @param bean
     * @throws DAOException
     */
    @Override
    public void insert(ProdutoBean bean) throws DAOException {
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
     * @return ProdutoBean
     * @throws DAOException
     */
    public ProdutoBean buscaPk(ProdutoPk pk) throws DAOException {
        try {
            String sql = SQL_SELECT.concat(
            " WHERE idProduto =  ?"
            );
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, pk.getIdProduto());
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
    public void update(ProdutoBean bean) throws DAOException {
        try {
            String where = " WHERE idProduto =  ?";
            PreparedStatement pstmt = getPstmt(conn.prepareStatement(getSqlUpdate(where)), bean);
            pstmt.setLong(3, bean.getIdProduto());
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
    public void delete(ProdutoBean bean) throws DAOException {
        try {
            String where = " WHERE idProduto =  ?";
            PreparedStatement pstmt = getPstmt(conn.prepareStatement(getSqlDelete(where)), bean);
            pstmt.setLong(1, bean.getIdProduto());
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
     * @return ProdutoBean
     * @throws java.sql.SQLException
     */
    @Override
    protected ProdutoBean getBeanFromResultSet(ResultSet rs) throws SQLException {
        ProdutoBean bean = new ProdutoBean();
        bean.setIdProduto(rs.getLong(1));
        bean.setDescricao(rs.getString(2));
        bean.setValorUnitario(rs.getDouble(3));
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
    protected PreparedStatement getPstmt(PreparedStatement pstmt, ProdutoBean bean) throws SQLException {
        pstmt.setString(1, bean.getDescricao());
        pstmt.setDouble(2, bean.getValorUnitario());
        return pstmt;
    }

}
