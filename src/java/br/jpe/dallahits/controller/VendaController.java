/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import br.jpe.dallahits.exception.DallaHitsException;
import br.jpe.dallahits.generics.AbstractGrid;
import br.jpe.dallahits.grid.ComandaGrid;
import br.jpe.dallahits.grid.ProdutoGrid;
import br.jpe.dallahits.util.GsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Classe VendaController
 *
 * @author Joaov
 */
@Controller
public class VendaController {

    /** Api para gerar Jsons */
    private final GsonUtils gson = new GsonUtils();

    private final AbstractGrid comandasGrid;

    public VendaController() {
        comandasGrid = new ComandaGrid();
    }

    /**
     * URL para consultar a página de vendas
     *
     * @return String
     * @throws DallaHitsException
     */
    @RequestMapping(value = "/venda", method = RequestMethod.GET)
    public String venda() throws DallaHitsException {
        return "venda";
    }

    @RequestMapping("/comandas/dados")
    @ResponseBody
    public String getComandas() throws DallaHitsException {
        return gson.toDataTable(comandasGrid.getDados());
    }

    @RequestMapping("/comandas/titulo")
    @ResponseBody
    public String getComandasTitulo() {
        return comandasGrid.createGrid().toJSONString();
    }

}
