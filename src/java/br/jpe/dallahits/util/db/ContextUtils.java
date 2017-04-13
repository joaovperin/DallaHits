/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.util.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import javax.servlet.ServletContext;

/**
 * Classe utilitária para trabalhar com contextos de servlet
 */
public class ContextUtils {

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
        return getServletContext().getResourceAsStream(res);
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
        Properties pt = new Properties();
        pt.load(getResourcesAsReader("/META-INF/conexao.properties"));
        return pt;
    }

}