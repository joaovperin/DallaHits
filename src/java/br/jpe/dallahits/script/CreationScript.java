/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.script;

import br.jpe.dallahits.script.util.Field;
import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.script.util.Table;
import br.jpe.dallahits.script.util.TemplateEntidade;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import br.jpe.dallahits.util.db.ConnManager;
import br.jpe.dallahits.util.db.ContextUtils;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe CreationScript
 *
 * @author Joaov
 */
public class CreationScript {

    /** Gerador de códigos fonte */
    private final Generator g;

    /**
     * Construtor padrão do Script
     *
     * @param basePath
     */
    public CreationScript(String basePath) {
        this.g = new Generator(basePath);
    }

    public static void main(String[] args) throws Exception {
        // Lê as propriedades da conexão e seta
        try {
            // Executa a geração dos códigos fonte
            String basePath = "D:/1-Projetos/_Feevale/DallaHits";
            ConnManager.setProperties(ContextUtils.lePropriedadesConexao(basePath + "/web"));
            new CreationScript(basePath).exec(ConnManager.getDatabaseName());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void exec(String dbName) throws DAOException {
        try (Conexao conn = ConnFactory.criaConexao()) {
            for (Table t : getTables(conn, dbName)) {
                g.criaTplPk("br.jpe.dallahits.gen", new TemplateEntidade(t));
                g.criaTplBean("br.jpe.dallahits.gen", new TemplateEntidade(t));
                g.criaTplDAO("br.jpe.dallahits.gen", new TemplateEntidade(t));
            }
        }
    }

    private List<Table> getTables(Conexao conn, String dbName) throws DAOException {
        List<Table> list = new ArrayList<>();
        try {
            ResultSet rs = conn.execSQLQuery("SHOW TABLES FROM " + dbName);
            while (rs.next()) {
                Table tb = getTabelaFromRs(rs);
                tb.setTableFields(getFields(conn, tb.getName()));
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
            ResultSet rs = conn.execSQLQuery("SHOW FULL FIELDS FROM " + nome);
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
        tabela.setName(rs.getString(1));
        return tabela;
    }

    private Field getFieldFromRs(ResultSet rs) throws SQLException {
        Field field = new Field();
        field.setField(rs.getString(1));
        field.setType(rs.getString(2));
        field.setPk(rs.getString(5).equalsIgnoreCase("PRI"));
        field.setAutoIncrement(rs.getString(7).equalsIgnoreCase("auto_increment"));
        field.setComment(rs.getString(9));
        return field;
    }

}
