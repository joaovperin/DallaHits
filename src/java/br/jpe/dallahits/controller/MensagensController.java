/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import br.jpe.dallahits.bean.MensagemBean;
import br.jpe.dallahits.dao.MensagemDAO;
import br.jpe.dallahits.dao.ProdutoDAO;
import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import br.jpe.dallahits.util.db.DBUtils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    /**
     * Url para a página inicial (index)
     *
     * @return String
     */
    @RequestMapping("/mensagens")
    public String mensagens(HttpServletRequest req) throws DAOException {
        try (Conexao conn = ConnFactory.criaConexao()) {
            MensagemDAO dao = new MensagemDAO(conn);
            req.getSession().setAttribute("mensagens", dao.busca());
        }
        return "mensagens";
    }

    public String addMsg(HttpServletRequest req) {
        HttpSession session = req.getSession();
        return "";
//        Object attribute = session.getAttribut"e("mensagens");
    }

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
        } catch (DAOException e){
            DBUtils.rollback(conn);
        } finally {
            DBUtils.close(conn);
        }
        return toJson(msgs);
    }

    public String toJson(List<MensagemBean> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int len = list.size();
        for (int i = 0; i < len; i++) {
            MensagemBean bean = list.get(i);
            sb.append("{");
            sb.append("idMsg: '").append(bean.getIdMsg()).append("', ");
            sb.append("usuario: '").append(bean.getUsuario()).append("', ");
            sb.append("msg: '").append(bean.getMsg()).append("'");
            sb.append("}");
            // 
            if (i < len - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
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
