/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.dao;

import br.jpe.dallahits.gen.bean.ClienteBean;
import br.jpe.dallahits.gen.pk.ClientePk;
import br.jpe.dallahits.util.db.AbstractDAO;
import br.jpe.dallahits.util.db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.jpe.dallahits.exception.DAOException;
import java.sql.SQLException;

/**
 * Classe ClienteDAO
 *
 * @author Joaov
 */
public class ClienteDAO extends AbstractDAO<ClienteBean, ClientePk> {

    /** SQL para SELECT */
    private static final String SQL_SELECT = "SELECT idCliente, nome, sexo, idade FROM Cliente";
    /** SQL para INSERT */
    private static final String SQL_INSERT = "INSERT INTO Cliente (nome, sexo, idade) VALUES ( ?,  ?,  ? )";

    /** 
     * Construtor da classe ClientePk
     *
     * @param conn
     */
    public ClienteDAO(Conexao conn) {
       super(conn);
    }

    /**
     * Realiza o comando Insert na entidade à partir de um bean
     * 
     * @param bean
     * @throws DAOException
     */
    @Override
    public void insert(ClienteBean bean) throws DAOException {
        try {
           PreparedStatement pstmt = conn.prepareStatement(getSqlInsert());
           pstmt.setString(1, bean.getNome());
           pstmt.setString(2, bean.getSexo());
           pstmt.setInt(3, bean.getIdade());
           pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Realiza uma busca no banco à partir da chave primária do elemento
     * 
     * @param pk
     * @return ClienteBean
     * @throws DAOException
     */
    public ClienteBean buscaPk(ClientePk pk) throws DAOException {
        try {
            String busca = SQL_SELECT.concat(
            " WHERE idCliente =  ?"
            );
            PreparedStatement pstmt = conn.prepareStatement(busca);
            pstmt.setLong(1, pk.getIdCliente());
            return buscaPrimeiro(pstmt);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void update(ClienteBean bean) throws DAOException {
        throw new UnsupportedOperationException("ClienteDAO.update() nao suportado.");
    }

    @Override
    public void delete(ClienteBean bean) throws DAOException {
        throw new UnsupportedOperationException("ClienteDAO.delete() nao suportado.");
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
     * @return ClienteBean
     * @throws java.sql.SQLException
     */
    @Override
    protected ClienteBean getBeanFromResultSet(ResultSet rs) throws SQLException {
        ClienteBean bean = new ClienteBean();
        bean.setIdCliente(rs.getLong(1));
        bean.setNome(rs.getString(2));
        bean.setSexo(rs.getString(3));
        bean.setIdade(rs.getInt(4));
        return bean;
    }

}
