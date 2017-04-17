/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import br.jpe.dallahits.gen.bean.MensagemBean;
import br.jpe.dallahits.gen.dao.MensagemDAO;
import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.exception.DallaHitsException;
import br.jpe.dallahits.grid.MensagemGrid;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import br.jpe.dallahits.util.db.DBUtils;
import br.jpe.dallahits.util.GsonUtils;
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
    private final GsonUtils gson = new GsonUtils();

    /**
     * Url para a página inicial (index)
     *
     * @param req
     * @return String
     * @throws DallaHitsException
     */
    @RequestMapping("/mensagens")
    public String mensagens(HttpServletRequest req) throws DallaHitsException {
        return "mensagens";
    }

    /**
     * Retorna todos os produtos do banco
     *
     * @return String Lista de produtos no formato JSON
     * @throws DallaHitsException
     */
    @RequestMapping("/mensagens/dados")
    @ResponseBody
    public String getMensagens() throws DallaHitsException {
        return gson.toDataTable(new MensagemGrid().getDados());
    }

    /**
     * Retorna os Títulos do Grid de Produtos
     *
     * @return String
     */
    @RequestMapping("/mensagens/titulo")
    @ResponseBody
    public String getMensagensTitulo() {
        return new MensagemGrid().createGrid().toJSONString();
    }

    /**
     * Adiciona uma mensagem na lista
     *
     * @param bean
     * @param req
     * @return String
     * @throws DallaHitsException
     */
    @RequestMapping("/addMensagem")
    @ResponseBody
    public String addMensagem(MensagemBean bean, HttpServletRequest req) throws DallaHitsException {
        List<MensagemBean> msgs = (List<MensagemBean>) req.getSession().getAttribute("mensagens");
        Conexao conn = null;
        try {
            conn = ConnFactory.criaConexaoTransacao();
            MensagemDAO dao = new MensagemDAO(conn);
            dao.insert(bean);
            msgs = dao.busca();
            DBUtils.commit(conn);
        } catch (DAOException e) {
            DBUtils.rollback(conn);
            throw new DallaHitsException(e);
        } finally {
            DBUtils.close(conn);
        }
        return gson.toJson(msgs);
    }

}
