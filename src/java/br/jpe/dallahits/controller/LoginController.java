/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import br.jpe.dallahits.bean.UsuarioBean;
import br.jpe.dallahits.dao.UsuarioDAO;
import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Classe LoginController
 *
 * @author Joaov
 */
@Controller
public class LoginController {

    /**
     * Página de login
     *
     * @param usuario Usuário
     * @param req
     * @param session
     * @return String
     * @throws DAOException Problema na camada de acesso aos dados
     */
    @RequestMapping("/login")
    public String execute(UsuarioBean usuario, HttpSession session, HttpServletRequest req)
            throws DAOException {
        // Busca usuário no banco de dados
        UsuarioBean usuarioBean = null;
        if (usuario.getLogin() != null) {
            try (Conexao conn = ConnFactory.criaConexao()) {
                usuarioBean = new UsuarioDAO(conn).buscaLogin(usuario.getLogin());
            }
        }
        // Se o usuario e senha forem válidos, redireciona para o login
        if (usuarioBean != null && usuarioBean.getSenha().equals(usuario.getSenha())) {
            session.setAttribute("usuarioLogado", usuarioBean);
            return "redirect:index";
        }
        // Retorna a página de login informando que não encontrou usuário
        if (usuario.getLogin() != null || usuario.getSenha() != null) {
            req.setAttribute("msg", "Usuário ou senha inválidos!");   
        }
        return "login";
    }

    /**
     * Url responsável por realizar o logout do usuário em sessão
     *
     * @param session
     * @return String
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }

}
