/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.dao;

import br.jpe.dallahits.gen.bean.MensagemBean;
import br.jpe.dallahits.gen.pk.MensagemPk;
import br.jpe.dallahits.util.db.AbstractDAO;
import br.jpe.dallahits.util.db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.jpe.dallahits.exception.DAOException;
import java.sql.SQLException;

/**
 * Classe MensagemDAO
 *
 * @author Joaov
 */
public class MensagemDAO extends AbstractDAO<MensagemBean, MensagemPk> {

    /** SQL para SELECT */
    private static final String SQL_SELECT = "SELECT idMsg, usuario, msg FROM Mensagem";
    /** SQL para INSERT */
    private static final String SQL_INSERT = "INSERT INTO Mensagem (usuario, msg) VALUES ( ?,  ? )";
    /** SQL para UPDATE */
    private static final String SQL_UPDATE = "UPDATE Mensagem SET usuario =  ?, msg =  ?";

    /** 
     * Construtor da classe MensagemPk
     *
     * @param conn
     */
    public MensagemDAO(Conexao conn) {
       super(conn);
    }

    /**
     * Realiza o comando Insert na entidade à partir de um bean
     * 
     * @param bean
     * @throws DAOException
     */
    @Override
    public void insert(MensagemBean bean) throws DAOException {
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
     * @return MensagemBean
     * @throws DAOException
     */
    public MensagemBean buscaPk(MensagemPk pk) throws DAOException {
        try {
            String sql = SQL_SELECT.concat(
            " WHERE idMsg =  ?"
            );
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, pk.getIdMsg());
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
    public void update(MensagemBean bean) throws DAOException {
        try {
            String where = " WHERE idMsg =  ?";
            PreparedStatement pstmt = getPstmt(conn.prepareStatement(getSqlUpdate(where)), bean);
            pstmt.setLong(3, bean.getIdMsg());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void delete(MensagemBean bean) throws DAOException {
        throw new UnsupportedOperationException("MensagemDAO.delete() nao suportado.");
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
     * @return MensagemBean
     * @throws java.sql.SQLException
     */
    @Override
    protected MensagemBean getBeanFromResultSet(ResultSet rs) throws SQLException {
        MensagemBean bean = new MensagemBean();
        bean.setIdMsg(rs.getLong(1));
        bean.setUsuario(rs.getString(2));
        bean.setMsg(rs.getString(3));
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
    protected PreparedStatement getPstmt(PreparedStatement pstmt, MensagemBean bean) throws SQLException {
        pstmt.setString(1, bean.getUsuario());
        pstmt.setString(2, bean.getMsg());
        return pstmt;
    }

}
