/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import br.jpe.dallahits.exception.DallaHitsException;
import br.jpe.dallahits.gen.bean.ClienteBean;
import br.jpe.dallahits.generics.AbstractGrid;
import br.jpe.dallahits.grid.ClienteGrid;
import br.jpe.dallahits.util.GsonUtils;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
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
    public String alterar(@Valid ClienteBean c, RedirectAttributes flashAttr) throws DallaHitsException {
        flashAttr.addFlashAttribute("action", "alterar");
        System.out.println(c);
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

    @RequestMapping(value = "/cliente/gravar", method = RequestMethod.POST)
    public String gravar(@Valid ClienteBean c, String action, RedirectAttributes flashAttr, BindingResult result) throws DallaHitsException {
        System.out.println(c);
        System.out.println(action);

        if (result.hasErrors()){
            System.out.println("Erros!");
        }



        String msg = "Sucesso - " + flashAttr.asMap().get("action");
        flashAttr.addFlashAttribute("msg", msg);
        return "cliente/grid";
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
