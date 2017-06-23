/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.exception.DallaHitsException;
import br.jpe.dallahits.gen.bean.ClienteBean;
import br.jpe.dallahits.gen.dao.ClienteDAO;
import br.jpe.dallahits.gen.pk.ClientePk;
import br.jpe.dallahits.generics.AbstractGrid;
import br.jpe.dallahits.grid.ClienteGrid;
import br.jpe.dallahits.util.GsonUtils;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import br.jpe.dallahits.util.db.DBUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Classe ClienteController
 *
 * @author Joaov
 */
@Controller
public class ClienteController {

    /** Api para gerar Jsons */
    private final GsonUtils gson = new GsonUtils();
    /** Grid de comandas */
    private final AbstractGrid comandasGrid;

    /**
     * Construtor padrão
     */
    public ClienteController() {
        comandasGrid = new ClienteGrid();
    }

    /**
     * URL para consultar a página de vendas
     *
     * @return String
     * @throws DallaHitsException
     */
    @RequestMapping(value = {"/cliente", "/cliente/listagem"}, method = RequestMethod.GET)
    public String cliente() throws DallaHitsException {
        return "cliente/grid";
    }

    /**
     * URL para acesso do formulário de clientes (modal)
     *
     * @param flashAttr
     * @return String
     * @throws DallaHitsException
     */
    @RequestMapping(value = "/cliente/form", method = RequestMethod.GET)
    public String form(RedirectAttributes flashAttr) throws DallaHitsException {
        return "cliente/form";
    }

    /**
     * Acessa o formulário no modo alteração
     *
     * @param c
     * @param flashAttr
     * @return String
     * @throws DallaHitsException
     */
    @RequestMapping(value = "/cliente/alterar", method = RequestMethod.GET)
    public String alterar(ClienteBean c, RedirectAttributes flashAttr) throws DallaHitsException {
        ClienteBean cli = null;
        try(Conexao conn = ConnFactory.criaConexao()){
            cli = new ClienteDAO(conn).buscaPk(new ClientePk(c.getIdCliente()));
        } catch (DAOException e) {
            throw new DallaHitsException(e);
        }


        flashAttr.addFlashAttribute("action", "alterar");
        flashAttr.addFlashAttribute("cliente", cli);
        return "redirect:form";
    }

    /**
     * Acessa o formulário no modo inclusão
     *
     * @param flashAttr
     * @return String
     * @throws DallaHitsException
     */
    @RequestMapping(value = "/cliente/incluir", method = RequestMethod.GET)
    public String incluir(RedirectAttributes flashAttr) throws DallaHitsException {
        flashAttr.addFlashAttribute("action", "incluir");
        return "redirect:form";
    }

    /**
     * URL para executar a gravação de clientes!
     *
     * @param c
     * @param action
     * @param flashAttr
     * @return
     * @throws DallaHitsException
     */
    @RequestMapping(value = "/cliente/gravar", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String gravar(ClienteBean c, String action, RedirectAttributes flashAttr)
            throws DallaHitsException {
        String msg = "Sucesso - " + action;
        Conexao conn = null;
        try {
            conn = ConnFactory.criaConexaoTransacao();
            ClienteDAO dao = new ClienteDAO(conn);
            // Se deve gravar um novo ou dar update
            if ("incluir".equals(action)) {
                dao.insertAi(c);
            } else if ("alterar".equals(action)) {
                dao.update(c);
            }
            DBUtils.commit(conn);
        } catch (DAOException e) {
            System.out.println("Erro! " + e);
            msg = e.getMessage();
            DBUtils.rollback(conn);
        } finally {
            DBUtils.close(conn);
        }

        flashAttr.addFlashAttribute("msg", msg);
        System.out.println(msg);
        return msg;
    }

    /**
     * Acessa o formulário no modo consulta
     *
     * @param flashAttr
     * @return String
     * @throws DallaHitsException
     */
    @RequestMapping(value = "/cliente/consultar", method = RequestMethod.GET)
    public String consultar(RedirectAttributes flashAttr) throws DallaHitsException {
        flashAttr.addFlashAttribute("action", "consultar");
        return "redirect:form";
    }

    /**
     * URL para retornar os dados do grid de comandas em formato JSON
     *
     * @return String
     * @throws DallaHitsException
     */
    @RequestMapping(value = "/cliente/listagem/dados", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String getClientes() throws DallaHitsException {
        return gson.toDataTable(comandasGrid.getDados());
    }

    /**
     * URL para retornar os headers do grid de comandas em formato JSON
     *
     * @return String
     */
    @RequestMapping("/cliente/listagem/titulo")
    @ResponseBody
    public String getClientesTitulo() {
        return comandasGrid.createGrid().toJSONString();
    }

}
