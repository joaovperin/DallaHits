/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.script;

import br.jpe.dallahits.script.util.Field;
import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.script.util.Table;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe CreationScript
 *
 * @author Joaov
 */
public class CreationScript {

    public static void main(String[] args) throws DAOException {
        new CreationScript().exec("dallahits");
    }

    private void exec(String dbName) throws DAOException {
        List<Table> tables = new ArrayList<>();
        try (Conexao conn = ConnFactory.criaConexao()) {
            tables = getTables(conn, dbName);
        }
        new Generator(tables).execute();
        // CHAMAR O FREEMARKER A PARTIR DAQUI.
    }

    private List<Table> getTables(Conexao conn, String dbName) throws DAOException {
        List<Table> list = new ArrayList<>();
        try {
            ResultSet rs = conn.execSQLQuery("SHOW TABLES FROM " + dbName);
            while (rs.next()) {
                Table tb = getTabelaFromRs(rs);
                tb.setFields(getFields(conn, tb.getNome()));
                list.add(tb);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return list;
    }

    private List<Field> getFields(Conexao conn, String nome) throws DAOException {
        List<Field> list = new ArrayList<>();
        try {
            ResultSet rs = conn.execSQLQuery("DESC " + nome);
            while (rs.next()) {
                list.add(getFieldFromRs(rs));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return list;
    }

    private Table getTabelaFromRs(ResultSet rs) throws SQLException {
        Table tabela = new Table();
        tabela.setNome(rs.getString(1));
        return tabela;
    }

    private Field getFieldFromRs(ResultSet rs) throws SQLException {
        Field tabela = new Field();
        tabela.setField(rs.getString(1));
        tabela.setType(rs.getString(2));
        return tabela;
    }

}
