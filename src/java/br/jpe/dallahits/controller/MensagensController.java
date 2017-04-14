/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import br.jpe.dallahits.gen.bean.MensagemBean;
import br.jpe.dallahits.gen.dao.MensagemDAO;
import br.jpe.dallahits.gen.dao.ProdutoDAO;
import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import br.jpe.dallahits.util.db.DBUtils;
import br.jpe.dallahits.util.db.JpeGson;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Classe LoginController
 *
 * @author Joaov
 */
@Controller
public class MensagensController {

    /** Api para gerar Jsons */
    private final JpeGson gson = new JpeGson();
    
    /**
     * Url para a página inicial (index)
     *
     * @param req
     * @return String
     * @throws br.jpe.dallahits.exception.DAOException
     */
    @RequestMapping("/mensagens")
    public String mensagens(HttpServletRequest req) throws DAOException {
        try (Conexao conn = ConnFactory.criaConexao()) {
            MensagemDAO dao = new MensagemDAO(conn);
            req.getSession().setAttribute("mensagens", dao.busca());
        }
        return "mensagens";
    }

    /**
     * Adiciona uma mensagem na lista
     */
    @RequestMapping("/addMensagem")
    @ResponseBody
    public String addMensagem(MensagemBean bean, HttpServletRequest req) throws DAOException {
        List<MensagemBean> msgs = (List<MensagemBean>) req.getSession().getAttribute("mensagens");
        Conexao conn = ConnFactory.criaConexaoTransacao();
        try {
            MensagemDAO dao = new MensagemDAO(conn);
            dao.insert(bean);
            msgs = dao.busca();
            DBUtils.commit(conn);
        } catch (DAOException e) {
            DBUtils.rollback(conn);
            throw e;
        } finally {
            DBUtils.close(conn);
        }
        return gson.toJson(msgs);
    }

    @RequestMapping("/produtos")
    public String produtos(HttpServletRequest req) throws DAOException {
        try (Conexao conn = ConnFactory.criaConexao()) {
            ProdutoDAO dao = new ProdutoDAO(conn);
            req.getSession().setAttribute("produtos", dao.busca());
        }
        return "mensagens";
    }

}
