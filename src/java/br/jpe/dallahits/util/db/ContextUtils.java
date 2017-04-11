/*
 * DallaHits
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.jpe.dallahits.util.db;

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
    public static final ServletContext getServletContext() {
        if (context != null) {
            throw new RuntimeException("Contexto Servlet não definido!");
        }
        return context;
    }

}
