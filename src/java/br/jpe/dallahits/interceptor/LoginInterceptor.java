/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.interceptor;

import br.jpe.dallahits.gen.dao.ProdutoDAO;
import br.jpe.dallahits.util.GsonUtils;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Classe LoginInterceptor
 *
 * @author Joaov
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    /**
     * Handler antes de cada requisição
     *
     * @param req Request
     * @param res Response
     * @param controller Controller solicitado
     * @return boolean Verdadeiro se pode continuar requisição
     * @throws Exception Problemas ao obter parâmetros
     */
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
            Object controller) throws Exception {
        // Teste -> Codificação
        System.out.println("Request! " + req.getRequestURI());
        res.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        // Se for uma requisição à página de login ou a algum recurso, permite
        String uri = req.getRequestURI();
        if (uri.endsWith("login") || uri.contains("resources")) {
            return true;
        }
        // Se possuir usuário logado, permite
        if (req.getSession().getAttribute("usuarioLogado") != null) {
            return true;
        }
        // Redireciona à página de Login e informa
        res.sendRedirect("login");
        return false;
    }
}
