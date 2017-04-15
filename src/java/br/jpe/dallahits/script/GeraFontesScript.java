/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.script;

import br.jpe.dallahits.script.core.Generator;
import br.jpe.dallahits.script.util.Field;
import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.script.util.Table;
import br.jpe.dallahits.script.util.TemplateEntidade;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import br.jpe.dallahits.util.db.ConnManager;
import br.jpe.dallahits.util.db.ContextUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe GeraFontesScript
 *
 * @author Joaov
 */
public class GeraFontesScript {

    /** Gerador de códigos fonte */
    private final Generator g;

    /**
     * Construtor padrão do Script
     *
     * @param basePath
     */
    public GeraFontesScript(String basePath) {
        this.g = new Generator(basePath);
    }

    /**
     * Método principal responsável pela execução do Script
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Determina os parâmetros da conexão
        String basePath = "D:/1-Projetos/_Feevale/DallaHits";
        ConnManager.setProperties(ContextUtils.lePropriedadesConexao(basePath + "/web"));
        long start = 0, end = 0;
        // Inicializa execução do Script e carrega os tempos
        System.out.println("Iniciando geração dos códigos fonte...");
        // Executa a geração dos códigos fonte
        start = System.currentTimeMillis();
        new GeraFontesScript(basePath).exec(ConnManager.getDatabaseName());
        end = System.currentTimeMillis();
        // Mensagem de tempo decorrido
        System.out.println("Fim. Tempo decorrido: " + (end - start) + " ms.");
    }

    /**
     * Realiza a execução do script em um banco
     *
     * @param dbName Nome do database
     * @throws DAOException
     */
    private void exec(String dbName) throws DAOException {
        try (Conexao conn = ConnFactory.criaConexao()) {
            for (Table t : getTables(conn, dbName)) {
                g.criaTplPk("br.jpe.dallahits.gen", new TemplateEntidade(t));
                g.criaTplBean("br.jpe.dallahits.gen", new TemplateEntidade(t));
                g.criaTplDAO("br.jpe.dallahits.gen", new TemplateEntidade(t));
                g.criaTplEntidade("br.jpe.dallahits.gen", new TemplateEntidade(t));
            }
        }
    }

    /**
     * Busca as tabelas de um Schema
     *
     * @param conn
     * @param dbName
     * @return List
     * @throws DAOException
     */
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

    /**
     * Busca os campos de uma tabela
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
