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
import br.jpe.dallahits.util.db.ConnManager;
import br.jpe.dallahits.util.db.ContextUtils;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Classe CreationScript
 *
 * @author Joaov
 */
public class CreationScript {

    public static void main(String[] args) throws DAOException {
        try {
            System.out.println("");
            Properties pt = ContextUtils.
                    lePropriedadesConexao("C:\\Users\\Perin\\Documents\\NetBeansProjects\\DallaHits\\web");
            ConnManager.setProperties(pt);
            //        ConnManager.setProperties("jdbc:mysql://vc-pedweb-vubu", "jripedidoweb_perin", "root", "rechinfo");
        } catch (IOException e) {
            System.out.println(e);
        }
        new CreationScript().exec("jripedidoweb_perin");
    }

    private void exec(String dbName) throws DAOException {
        List<Table> tables = new ArrayList<>();
        System.out.println("oi");
        try (Conexao conn = ConnFactory.criaConexao()) {
            tables = getTables(conn, dbName);
        }

        for (Table t : tables) {
            System.out.println(t.toString());
        }
        File f
                = new File("C:\\Users\\Perin\\Documents\\NetBeansProjects\\DallaHits\\src\\java\\br\\jpe\\dallahits\\gen\\TsBean.java");
//        File f = new File("D:\\1-Projetos\\_Feevale\\DallaHits\\src\\java\\br\\jpe\\dallahits\\gen\\TestBean.java");
        new Generator(tables).execute(f);
        // CHAMAR O FREEMARKER A PARTIR DAQUI.
    }

    private List<Table> getTables(Conexao conn, String dbName) throws DAOException {
        List<Table> list = new ArrayList<>();
        try {
            ResultSet rs = conn.execSQLQuery("SHOW TABLES FROM " + dbName);
            while (rs.next()) {
                Table tb = getTabelaFromRs(rs);
                tb.setTableFields(getFields(conn, tb.getTableName()));
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
            ResultSet rs = conn.execSQLQuery("SHOW FIELDS FROM " + nome);
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
        tabela.setNome(getNome(rs.getString(1)));
        tabela.setTableName(rs.getString(1));
        return tabela;
    }

    private String getNome(String tableName){
        return tableName.replaceAll("_", "");
    }

    private Field getFieldFromRs(ResultSet rs) throws SQLException {
        Field tabela = new Field();
        tabela.setField(rs.getString(1));
        tabela.setType(rs.getString(2));
        return tabela;
    }

}
