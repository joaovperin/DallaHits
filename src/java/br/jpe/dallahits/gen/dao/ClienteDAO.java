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
import br.jpe.dallahits.generics.AbstractDAO;
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
    private static final String SQL_SELECT = "SELECT idCliente, nome, sexo, idade, cPF FROM cliente";
    /** SQL para INSERT */
    private static final String SQL_INSERT = "INSERT INTO cliente (nome, sexo, idade, cPF) VALUES ( ?,  ?,  ?,  ? )";
    /** SQL para UPDATE */
    private static final String SQL_UPDATE = "UPDATE cliente SET nome =  ?, sexo =  ?, idade =  ?, cPF =  ?";
    /** SQL para DELETE */
    private static final String SQL_DELETE = "DELETE FROM cliente";

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
     * @return ClienteBean
     * @throws DAOException
     */
    public ClienteBean insertAi(ClienteBean bean) throws DAOException {
        try {
           PreparedStatement pstmt = getPstmt(conn.prepareStatementForAutoIncrement(getSqlInsert()), bean);
           pstmt.executeUpdate();
           ResultSet rs = pstmt.getGeneratedKeys();
           if (rs.next()){
              bean.setIdCliente(rs.getLong(1));
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
     * @return ClienteBean
     * @throws DAOException
     */
    public ClienteBean buscaPk(ClientePk pk) throws DAOException {
        try {
            String sql = SQL_SELECT.concat(
            " WHERE idCliente =  ?"
            );
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, pk.getIdCliente());
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
    public void update(ClienteBean bean) throws DAOException {
        try {
            String where = " WHERE idCliente =  ?";
            PreparedStatement pstmt = getPstmt(conn.prepareStatement(getSqlUpdate(where)), bean);
            pstmt.setLong(5, bean.getIdCliente());
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
    public void delete(ClienteBean bean) throws DAOException {
        try {
            String where = " WHERE idCliente =  ?";
            PreparedStatement pstmt = getPstmt(conn.prepareStatement(getSqlDelete(where)), bean);
            pstmt.setLong(1, bean.getIdCliente());
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
        bean.setCPF(rs.getLong(5));
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
    protected PreparedStatement getPstmt(PreparedStatement pstmt, ClienteBean bean) throws SQLException {
        pstmt.setString(1, bean.getNome());
        pstmt.setString(2, bean.getSexo());
        pstmt.setInt(3, bean.getIdade());
        pstmt.setLong(4, bean.getCPF());
        return pstmt;
    }

}
