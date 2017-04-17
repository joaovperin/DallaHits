/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.exception.DallaHitsException;
import br.jpe.dallahits.gen.dao.ComandaDAO;
import br.jpe.dallahits.gen.entidade.ComandaEntidade;
import br.jpe.dallahits.generics.AbstractBean;
import br.jpe.dallahits.generics.AbstractGrid;
import br.jpe.dallahits.grid.ProdutoGrid;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import br.jpe.dallahits.util.GsonUtils;
import java.util.List;
import org.json.simple.JSONArray;
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
        comandasGrid = new AbstractGrid() {
            @Override
            protected JSONArray getTitulos() {
                return new ComandaEntidade().getTitulos();
            }

            @Override
            protected JSONArray getColunas() {
                return new ComandaEntidade().getColunas();
            }

            @Override
            public List<? extends AbstractBean> getDados() throws DallaHitsException {
                try (Conexao conn = ConnFactory.criaConexao()) {
                    return new ComandaDAO(conn).busca();
                } catch (DAOException e) {
                    throw new DallaHitsException(e);
                }
            }
        };
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

    /**
     * Retorna todos os produtos do banco
     *
     * @return String Lista de produtos no formato JSON
     * @throws DallaHitsException
     */
    @RequestMapping("/produtos/dados")
    @ResponseBody
    public String getProdutos() throws DallaHitsException {
        return gson.toDataTable(new ProdutoGrid().getDados());
    }

    /**
     * Retorna os Títulos do Grid de Produtos
     *
     * @return String
     */
    @RequestMapping("/produtos/titulo")
    @ResponseBody
    public String getProdutosTitulo() {
        return new ProdutoGrid().createGrid().toJSONString();
    }

}
