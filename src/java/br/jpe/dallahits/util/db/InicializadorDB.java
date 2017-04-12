/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.util.db;

import br.jpe.dallahits.exception.DAOException;
import static br.jpe.dallahits.util.db.ConnFactory.getDatabaseName;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.ibatis.jdbc.ScriptRunner;

/**
 * Classe InicializadorDB
 *
 * @author Joaov
 */
public class InicializadorDB {

    /** Diretório base */
    private static final String DIR_BASE = "D:\\1-Projetos\\_Feevale\\DallaHits\\web\\";
    /** Diretório relativo do script de criação das tabelas */
    private static final String SC_TABLES = "/META-INF/modelo/BD_Tables.sql";
    /** Diretório relativo do script de inicialização de dados */
    private static final String SC_INIT = "/META-INF/modelo/BD_Init.sql";

    /**
     * Executa criação das tabelas do banco
     *
     * @throws IOException Falha ao ler Script SQL de geração das tabelas
     * @throws DAOException Falha ao executar a criação das tabelas
     */
    public void executaCriacaoBanco() throws IOException, DAOException {
        Conexao conn = null;
        try {
            // Define as propriedades da conexão
            ConnFactory.setProperties(ContextUtils.lePropriedadesConexao());
            // Cria conexão e prepara o ScriptRunner
            conn = ConnFactory.criaConexaoTransacao();
            criaBaseDados();
            ScriptRunner sr = new ScriptRunner(conn.get());
            // Roda os scripts
            criaTabelas(sr);
            inicializaDados(sr);
        } catch (IOException e) {
            throw e;
        } finally {
            // Encerra conexão
            DBUtils.close(conn);
        }
    }

    /**
     * Roda o script de criação das tabelas
     *
     * @param sr ScriptRunner
     * @throws FileNotFoundException
     */
    private void criaTabelas(ScriptRunner sr) throws FileNotFoundException {
        sr.runScript(getReaderFor(SC_TABLES));
    }

    /**
     * Roda o script de inicialização dos dados
     *
     * @param sr ScriptRunner
     * @throws FileNotFoundException
     */
    private void inicializaDados(ScriptRunner sr) throws FileNotFoundException {
        sr.runScript(getReaderFor(SC_INIT));
    }

    /**
     * Cria um Reader(leitor) para determinado arquivo
     *
     * @param fileName Nome do arquivo
     * @return BufferedReader Leitor bufferizado
     * @throws FileNotFoundException
     */
    private BufferedReader getReaderFor(String fileName) throws FileNotFoundException {
        try {
            return ContextUtils.getResourcesAsReader(fileName);
        } catch (Exception e) {
            return new BufferedReader(new FileReader(DIR_BASE + fileName));
        }
    }

    /**
     * Retorna o SQL de DROP database
     *
     * @return String
     */
    private String getSqlDropDB() {
        return "DROP SCHEMA IF EXISTS " + getDatabaseName();
    }

    /**
     * Retorna o SQL de CREATE database
     *
     * @return String
     */
    private String getSqlCreateDB() {
        return "CREATE SCHEMA IF NOT EXISTS " + getDatabaseName() +
                " DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci";
    }

    /**
     * Retorna o SQL de USE database
     *
     * @return String
     */
    private String getSqlUseDB() {
        return "USE " + getDatabaseName();
    }

    /**
     * Executa criação do Database (Schema)
     *
     * @throws DAOException
     */
    private void criaBaseDados() throws DAOException {
        try (Conexao conn = ConnFactory.criaConexaoTransacao()) {
            conn.execSQL(getSqlDropDB());
            conn.execSQL(getSqlCreateDB());
            conn.execSQL(getSqlUseDB());
        }
    }

}
