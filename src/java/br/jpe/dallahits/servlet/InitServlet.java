/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.servlet;

import br.jpe.dallahits.util.db.ConnFactory;
import br.jpe.dallahits.util.db.ContextUtils;
import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Servlet responsável pela inicialização da aplicação
 */
public class InitServlet extends HttpServlet {

    /**
     * Realiza a inicialização da aplicação
     *
     * @param config Configurações do Servlet
     * @throws javax.servlet.ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ContextUtils.setServletContext(config.getServletContext());
        definePropriedadesConexao();
        System.out.println("Aplicação inicializada com sucesso!");
    }

    /**
     * Define as propriedades da conexão
     *
     * @throws ServletException Exceção genérica pois ocorreu no Servlet
     */
    private void definePropriedadesConexao() throws ServletException {
        try {
            Properties pt = new Properties();
            pt.load(ContextUtils.getResourcesAsReader("/META-INF/conexao.properties"));
            ConnFactory.setProperties(pt);
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

}
