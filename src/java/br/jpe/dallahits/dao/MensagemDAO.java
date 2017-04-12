/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.dao;

import br.jpe.dallahits.bean.MensagemBean;
import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.util.db.AbstractDAO;
import br.jpe.dallahits.util.db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe MensagemDAO
 *
 * @author Joaov
 */
public class MensagemDAO extends AbstractDAO<MensagemBean> {

    /** SQL para SELECT */
    private static final String SELECT
            = "SELECT idMsg, Usuario, Msg FROM MENSAGEM";

    public MensagemDAO(Conexao conn) {
        super(conn);
    }

    @Override
    public void insert(MensagemBean bean) throws DAOException {
        try {
            PreparedStatement pstmt = conn.prepareStatement(getSqlInsert());
            pstmt.setString(1, bean.getUsuario());
            pstmt.setString(2, bean.getMsg());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void update(MensagemBean bean) throws DAOException {
        throw new UnsupportedOperationException("MensagemDAO.update() nao suportado.");
    }

    @Override
    public void delete(MensagemBean bean) throws DAOException {
        throw new UnsupportedOperationException("MensagemDAO.delete() nao suportado.");
    }

    @Override
    protected MensagemBean getBeanFromResultSet(ResultSet rs) throws SQLException {
        MensagemBean bean = new MensagemBean();
        bean.setIdMsg(rs.getLong(1));
        bean.setUsuario(rs.getString(2));
        bean.setMsg(rs.getString(3));
        return bean;
    }

    @Override
    protected String getSqlSelect() {
        return SELECT;
    }
    
    protected String getSqlInsert(){
        return "INSERT INTO `Mensagem` (Usuario, Msg) "
                + "VALUES (?, ?)";
    }

}
