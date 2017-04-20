/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.script.core;

import br.jpe.dallahits.script.util.TemplateProcessor;
import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.script.util.Field;
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
 * Classe FontGenerator
 *
 * @author Joaov
 */
public class FontGenerator {

    /** Gerador de códigos fonte */
    private final TemplateProcessor g;
    /** Diretório base */
    private final String dirBase;

    /**
     * Construtor padrão do Script
     *
     * @param dirBase
     */
    public FontGenerator(String dirBase) {
        this.g = new TemplateProcessor(dirBase);
        this.dirBase = dirBase;
    }

    /**
     * Realiza a execução do script em um banco
     *
     * @throws DAOException
     * @throws java.io.IOException
     */
    public void exec() throws DAOException, IOException {
        ConnManager.setProperties(ContextUtils.lePropriedadesConexao(dirBase + "/web"));
        try (Conexao conn = ConnFactory.criaConexao()) {
            // Gera os fontes das Views
            for (Table t : getTables(conn, ConnManager.getDatabaseName())) {
                g.criaTplPk("br.jpe.dallahits.gen", new TemplateEntidade(t));
                g.criaTplBean("br.jpe.dallahits.gen", new TemplateEntidade(t));
                g.criaTplDAO("br.jpe.dallahits.gen", new TemplateEntidade(t));
                g.criaTplEntidade("br.jpe.dallahits.gen", new TemplateEntidade(t));
            }
            // Gera os fontes das Views
            for (Table t : getViews(conn, ConnManager.getDatabaseName())) {
                g.criaTplBean("br.jpe.dallahits.gen.view", new TemplateEntidade(t));
                g.criaTplViewDAO("br.jpe.dallahits.gen.view", new TemplateEntidade(t));
                g.criaTplEntidade("br.jpe.dallahits.gen.view", new TemplateEntidade(t));
            }
        }
    }

    /**
     * Busca as Tabelas de um Schema
     *
     * @param conn
     * @param dbName
     * @return List
     * @throws DAOException
     */
    private List<Table> getTables(Conexao conn, String dbName) throws DAOException {
        return getEntities(conn, dbName, "BASE_TABLE");
    }

    /**
     * Busca as Views de um Schema
     *
     * @param conn
     * @param dbName
     * @return List
     * @throws DAOException
     */
    private List<Table> getViews(Conexao conn, String dbName) throws DAOException {
        return getEntities(conn, dbName, "VIEW");
    }

    /**
     * Executa a bsuca de Tabelas/Views de um banco
     *
     * @param conn
     * @param dbName
     * @return List
     * @throws DAOException
     */
    private List<Table> getEntities(Conexao conn, String dbName, String tType) throws DAOException {
        List<Table> list = new ArrayList<>();
        try {
            ResultSet rs = conn.execSQLQuery("SHOW FULL TABLES FROM " + dbName + " WHERE TABLE_TYPE LIKE '" + tType +
                    "'");
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

    /**
     * Busca os campos de uma Tabela/View
     *
     * @param conn
     * @param nome
     * @return List
     * @throws DAOException
     */
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

    /**
     * Cria uma tabela à partir de um ResultSet
     *
     * @param rs
     * @return Table
     */
    private Table getTabelaFromRs(ResultSet rs) throws SQLException {
        Table tabela = new Table();
        tabela.setName(rs.getString(1));
        tabela.setType(rs.getString(2));
        return tabela;
    }

    /**
     * Cria uma Field à partir de um ResultSet
     *
     * @param rs
     * @return Field
     */
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
