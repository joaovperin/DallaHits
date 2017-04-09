/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.dao;

import br.jpe.dallahits.bean.UsuarioBean;
import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.util.db.AbstractDAO;
import br.jpe.dallahits.util.db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe UsuarioDAO
 *
 * @author Joaov
 */
public class UsuarioDAO extends AbstractDAO<UsuarioBean> {

    /** SQL para SELECT */
    private static final String SELECT
            = "SELECT Login, Senha, Nome, Tipo FROM USUARIO";

    /**
     * Construtor padrão que recebe uma conexão por inversão de controle
     *
     * @param conn Conexão com o banco de dados
     */
    public UsuarioDAO(Conexao conn) {
        super(conn);
    }

    /**
     * Busca um usuário à partir do seu Login
     *
     * @param login
     * @return UsuarioBean
     * @throws DAOException
     */
    public UsuarioBean busca(String login) throws DAOException {
        try {
            // Monta SQL de busca
            String busca = SELECT.concat(" WHERE Login = ?");
            PreparedStatement pstmt = conn.get().prepareStatement(busca);
            pstmt.setString(1, login);
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
     * Busca todos os usuários
     *
     * @return UsuarioBean
     * @throws DAOException
     */
    @Override
    public List<UsuarioBean> busca() throws DAOException {
        List<UsuarioBean> list = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.get().prepareStatement(SELECT);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(getBeanFromResultSet(rs));
            }
            return list;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void insert(UsuarioBean bean) throws DAOException {
        throw new UnsupportedOperationException("UsuarioDAO.insert() nao suportado.");
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
     * Cria um novo Bean e popula a partir do ResultSet
     *
     * @param rs ResultSet com dados lidos do banco
     * @return UsuarioBean Bean populado
     * @throws SQLException Problema ao ler parâmetro do result set
     */
    @Override
    protected UsuarioBean getBeanFromResultSet(ResultSet rs) throws SQLException {
        UsuarioBean bean = new UsuarioBean();
        bean.setLogin(rs.getString(1));
        bean.setSenha(rs.getString(2));
        bean.setNome(rs.getString(3));
        bean.setTipo(rs.getString(4));
        return bean;
    }

}
