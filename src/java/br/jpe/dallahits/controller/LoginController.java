/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import br.jpe.dallahits.gen.bean.UsuarioBean;
import br.jpe.dallahits.gen.dao.UsuarioDAO;
import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.exception.DallaHitsException;
import br.jpe.dallahits.gen.pk.UsuarioPk;
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
     * @throws DallaHitsException
     */
    @RequestMapping("/login")
    public String execute(UsuarioBean usuario, HttpSession session, HttpServletRequest req)
            throws DallaHitsException {
        // Busca usuário no banco de dados
        UsuarioBean usuarioBean = null;
        if (usuario.getLogin() != null) {
            // Se recebeu um login de usuário, tenta buscá-lo no banco
            try (Conexao conn = ConnFactory.criaConexao()) {
                usuarioBean = new UsuarioDAO(conn).buscaPk(new UsuarioPk(usuario.getLogin()));
            } catch (DAOException e) {
                throw new DallaHitsException(e);
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
