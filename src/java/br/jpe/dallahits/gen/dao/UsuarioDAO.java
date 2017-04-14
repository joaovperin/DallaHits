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
           PreparedStatement pstmt = conn.prepareStatement(getSqlInsert());
           pstmt.setString(1, bean.getLogin());
           pstmt.setString(2, bean.getEmail());
           pstmt.setString(3, bean.getSenha());
           pstmt.setString(4, bean.getNome());
           pstmt.setString(5, bean.getTipo());
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
            String busca = SQL_SELECT.concat(
            " WHERE login =  ?"
            );
            PreparedStatement pstmt = conn.prepareStatement(busca);
            pstmt.setString(1, pk.getLogin());
            return buscaPrimeiro(pstmt);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void update(UsuarioBean bean) throws DAOException {
        throw new UnsupportedOperationException("UsuarioDAO.update() nao suportado.");
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

}
