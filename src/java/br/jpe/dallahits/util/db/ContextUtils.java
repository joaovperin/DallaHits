/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.util.db;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import javax.servlet.ServletContext;

/**
 * Classe utilitária para trabalhar com contextos de servlet
 */
public class ContextUtils {

    /** Diretório base - R */
    private static final String DIRBASE_R = "C:\\Users\\Perin\\Documents\\NetBeansProjects\\DallaHits";
    /** Diretório base - J */
    private static final String DIRBASE_J = "D:\\1-Projetos\\_Feevale\\DallaHits";

    /** Contexto Servlet da aplicação */
    private static ServletContext context;

    /**
     * Define o contexto do servlet padrão da aplicação
     *
     * @param ctx Contexto Servlet
     */
    public static final void setServletContext(ServletContext ctx) {
        if (context != null) {
            throw new RuntimeException("Contexto Servlet já definido!");
        }
        context = ctx;
    }

    /**
     * Retorna o contexto do servlet padrão da aplicação
     *
     * @return ServletContext
     */
    private static ServletContext getServletContext() {
        if (context == null) {
            throw new RuntimeException("Contexto Servlet não definido!");
        }
        return context;
    }

    /**
     * Retorna um resource como Stream
     *
     * @param res
     * @return InputStream
     */
    public static InputStream getResourceAsStream(String res) {
        try {
            return getServletContext().getResourceAsStream(res);
        } catch (Exception e) {
            System.out.println("Contexto Servlet não encontrado! Tentando buscar do arquivo...");
            try {
                return new FileInputStream(res);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException("Arquivo não encontrado! Path:" + res, ex);
            }
        }
    }

    /**
     * Retorna um resource como BufferedReader
     *
     * @param res
     * @return BufferedReader
     */
    public static BufferedReader getResourcesAsReader(String res) {
        return new BufferedReader(new InputStreamReader(getResourceAsStream(res)));
    }

    /**
     * Le as propriedades da conexão
     *
     * @return String
     * @throws IOException
     */
    public static Properties lePropriedadesConexao() throws IOException {
        return lePropriedadesConexao("");
    }

    /**
     * Le as propriedades da conexão
     *
     * @param path
     * @return String
     * @throws IOException
     */
    public static Properties lePropriedadesConexao(String path) throws IOException {
        Properties pt = new Properties();
        pt.load(getResourcesAsReader(path + "/META-INF/conexao.properties"));
        return pt;
    }

    /**
     * Retorna o diretório base do projeto
     *
     * @return String
     */
    public static String getDirBas() {
        if ("Perin".equals(System.getenv("USERNAME"))) {
            return DIRBASE_R;
        }
        return DIRBASE_J;
    }

}
