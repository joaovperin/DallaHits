/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.view.dao;

import br.jpe.dallahits.gen.view.bean.ViewComandasBean;
import br.jpe.dallahits.generics.AbstractViewDAO;
import br.jpe.dallahits.generics.AbstractPk;
import br.jpe.dallahits.util.db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe ViewComandasDAO
 *
 * @author Joaov
 */
public class ViewComandasDAO extends AbstractViewDAO<ViewComandasBean, AbstractPk> {

    /** SQL para SELECT */
    private static final String SQL_SELECT = "SELECT idComanda, idCliente, cliente, usuario, data, valorTotal FROM view_comandas";

    /** 
     * Construtor da classe ViewComandasPk
     *
     * @param conn
     */
    public ViewComandasDAO(Conexao conn) {
       super(conn);
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
     * Retorna um Bean à partir de um ResultSet
     *
     * @return ViewComandasBean
     * @throws java.sql.SQLException
     */
    @Override
    protected ViewComandasBean getBeanFromResultSet(ResultSet rs) throws SQLException {
        ViewComandasBean bean = new ViewComandasBean();
        bean.setIdComanda(rs.getLong(1));
        bean.setIdCliente(rs.getLong(2));
        bean.setCliente(rs.getString(3));
        bean.setUsuario(rs.getString(4));
        bean.setData(rs.getDate(5));
        bean.setValorTotal(rs.getDouble(6));
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
    protected PreparedStatement getPstmt(PreparedStatement pstmt, ViewComandasBean bean) throws SQLException {
        pstmt.setLong(1, bean.getIdComanda());
        pstmt.setLong(2, bean.getIdCliente());
        pstmt.setString(3, bean.getCliente());
        pstmt.setString(4, bean.getUsuario());
        pstmt.setDate(5, new java.sql.Date(bean.getData().getTime()));
        pstmt.setDouble(6, bean.getValorTotal());
        return pstmt;
    }

}
