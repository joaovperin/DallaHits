/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.dao;

import br.jpe.dallahits.bean.MensagemBean;
import br.jpe.dallahits.bean.ProdutoBean;
import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.util.db.AbstractDAO;
import br.jpe.dallahits.util.db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe MensagemDAO
 *
 * @author Joaov
 */
public class ProdutoDAO extends AbstractDAO<ProdutoBean> {

    /** SQL para SELECT */
    private static final String SELECT
            = "SELECT idProduto, Descricao FROM PRODUTO";

    public ProdutoDAO(Conexao conn) {
        super(conn);
    }

    @Override
    public void insert(ProdutoBean bean) throws DAOException {
        throw new UnsupportedOperationException("ProdutoDAO.insert() nao suportado.");
    }

    @Override
    public void update(ProdutoBean bean) throws DAOException {
        throw new UnsupportedOperationException("ProdutoDAO.update() nao suportado.");
    }

    @Override
    public void delete(ProdutoBean bean) throws DAOException {
        throw new UnsupportedOperationException("ProdutoDAO.delete() nao suportado.");
    }

    @Override
    protected String getSqlSelect() {
        return SELECT;
    }

    @Override
    protected ProdutoBean getBeanFromResultSet(ResultSet rs) throws SQLException {
        ProdutoBean produto = new ProdutoBean();
        produto.setIdProduto(rs.getLong(1));
        produto.setDescricao(rs.getString(2));
        return produto;
    }

    

}
