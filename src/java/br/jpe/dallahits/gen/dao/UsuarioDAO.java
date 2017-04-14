/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.dao;

import br.jpe.dallahits.gen.bean.UsuarioBean;
import br.jpe.dallahits.gen.pk.UsuarioPk;
import br.jpe.dallahits.util.db.AbstractDAO;
import br.jpe.dallahits.util.db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.jpe.dallahits.exception.DAOException;
import java.sql.SQLException;

/**
 * Classe UsuarioDAO
 *
 * @author Joaov
 */
public class UsuarioDAO extends AbstractDAO<UsuarioBean, UsuarioPk> {

    /** SQL para SELECT */
    private static final String SQL_SELECT = "SELECT login, email, senha, nome, tipo FROM Usuario";
    /** SQL para INSERT */
    private static final String SQL_INSERT = "INSERT INTO Usuario (login, email, senha, nome, tipo) VALUES ( ?,  ?,  ?,  ?,  ? )";
    /** SQL para UPDATE */
    private static final String SQL_UPDATE = "UPDATE Usuario SET email =  ?, senha =  ?, nome =  ?, tipo =  ?";

    /** 
     * Construtor da classe UsuarioPk
     *
     * @param conn
     */
    public UsuarioDAO(Conexao conn) {
       super(conn);
    }

    /**
     * Realiza o comando Insert na entidade à partir de um bean
     * 
     * @param bean
     * @throws DAOException
     */
    @Override
    public void insert(UsuarioBean bean) throws DAOException {
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
     * @return UsuarioBean
     * @throws DAOException
     */
    public UsuarioBean buscaPk(UsuarioPk pk) throws DAOException {
        try {
            String sql = SQL_SELECT.concat(
            " WHERE login =  ?"
            );
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pk.getLogin());
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
    public void update(UsuarioBean bean) throws DAOException {
        try {
            String where = " WHERE login =  ?";
            PreparedStatement pstmt = getPstmt(conn.prepareStatement(getSqlUpdate(where)), bean);
            pstmt.setString(5, bean.getLogin());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void delete(UsuarioBean bean) throws DAOException {
        throw new UnsupportedOperationException("UsuarioDAO.delete() nao suportado.");
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
     * Retorna um Bean à partir de um ResultSet
     *
     * @return UsuarioBean
     * @throws java.sql.SQLException
     */
    @Override
    protected UsuarioBean getBeanFromResultSet(ResultSet rs) throws SQLException {
        UsuarioBean bean = new UsuarioBean();
        bean.setLogin(rs.getString(1));
        bean.setEmail(rs.getString(2));
        bean.setSenha(rs.getString(3));
        bean.setNome(rs.getString(4));
        bean.setTipo(rs.getString(5));
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
    protected PreparedStatement getPstmt(PreparedStatement pstmt, UsuarioBean bean) throws SQLException {
        pstmt.setString(1, bean.getEmail());
        pstmt.setString(2, bean.getSenha());
        pstmt.setString(3, bean.getNome());
        pstmt.setString(4, bean.getTipo());
        return pstmt;
    }

}
