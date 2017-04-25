/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import br.jpe.dallahits.exception.DallaHitsException;
import br.jpe.dallahits.generics.AbstractGrid;
import br.jpe.dallahits.grid.ClienteGrid;
import br.jpe.dallahits.util.GsonUtils;
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
    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public String cliente() throws DallaHitsException {
        return "cliente/grid";
    }

    /**
     * URL para acesso do formulário de clientes (modal)
     *
     * @return String
     * @throws DallaHitsException
     */
    @RequestMapping(value = "/cliente/form", method = RequestMethod.GET)
    public String form(RedirectAttributes flashAttr) throws DallaHitsException {
        
        return "cliente/form";
    }

    @RequestMapping(value = "/cliente/alterar", method = RequestMethod.GET)
    public String alterar(RedirectAttributes flashAttr) throws DallaHitsException {

        flashAttr.addFlashAttribute("msg", "alterar");
        return "redirect:cliente/form";
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
