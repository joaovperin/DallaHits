/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.dao;

import br.jpe.dallahits.gen.bean.PessoaBean;
import br.jpe.dallahits.gen.pk.PessoaPk;
import br.jpe.dallahits.generics.AbstractDAO;
import br.jpe.dallahits.util.db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.jpe.dallahits.exception.DAOException;
import java.sql.SQLException;

/**
 * Classe PessoaDAO
 *
 * @author Joaov
 */
public class PessoaDAO extends AbstractDAO<PessoaBean, PessoaPk> {

    /** SQL para SELECT */
    private static final String SQL_SELECT = "SELECT nome, email, idade FROM pessoa";
    /** SQL para INSERT */
    private static final String SQL_INSERT = "INSERT INTO pessoa (nome, email, idade) VALUES ( ?,  ?,  ? )";
    /** SQL para UPDATE */
    private static final String SQL_UPDATE = "UPDATE pessoa SET email =  ?, idade =  ?";
    /** SQL para DELETE */
    private static final String SQL_DELETE = "DELETE FROM pessoa";

    /** 
     * Construtor da classe PessoaPk
     *
     * @param conn
     */
    public PessoaDAO(Conexao conn) {
       super(conn);
    }

    /**
     * Realiza o comando Insert na entidade à partir de um bean
     * 
     * @param bean
     * @throws DAOException
     */
    @Override
    public void insert(PessoaBean bean) throws DAOException {
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
     * @return PessoaBean
     * @throws DAOException
     */
    public PessoaBean buscaPk(PessoaPk pk) throws DAOException {
        try {
            String sql = SQL_SELECT.concat(
            " WHERE nome =  ?"
            );
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pk.getNome());
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
    public void update(PessoaBean bean) throws DAOException {
        try {
            String where = " WHERE nome =  ?";
            PreparedStatement pstmt = getPstmt(conn.prepareStatement(getSqlUpdate(where)), bean);
            pstmt.setString(3, bean.getNome());
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
    public void delete(PessoaBean bean) throws DAOException {
        try {
            String where = " WHERE nome =  ?";
            PreparedStatement pstmt = getPstmt(conn.prepareStatement(getSqlDelete(where)), bean);
            pstmt.setString(1, bean.getNome());
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
     * @return PessoaBean
     * @throws java.sql.SQLException
     */
    @Override
    protected PessoaBean getBeanFromResultSet(ResultSet rs) throws SQLException {
        PessoaBean bean = new PessoaBean();
        bean.setNome(rs.getString(1));
        bean.setEmail(rs.getString(2));
        bean.setIdade(rs.getInt(3));
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
    protected PreparedStatement getPstmt(PreparedStatement pstmt, PessoaBean bean) throws SQLException {
        pstmt.setString(1, bean.getEmail());
        pstmt.setInt(2, bean.getIdade());
        return pstmt;
    }

}
