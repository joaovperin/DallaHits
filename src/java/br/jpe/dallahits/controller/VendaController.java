/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.exception.DallaHitsException;
import br.jpe.dallahits.gen.bean.ComandaBean;
import br.jpe.dallahits.gen.bean.ProdutoBean;
import br.jpe.dallahits.gen.dao.ComandaDAO;
import br.jpe.dallahits.gen.dao.ProdutoDAO;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import br.jpe.dallahits.util.db.JpeGson;
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
    private final JpeGson gson = new JpeGson();

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
        try (Conexao conn = ConnFactory.criaConexao()) {
            return gson.toDataTable(new ComandaDAO(conn).busca());
        } catch (DAOException e) {
            throw new DallaHitsException(e);
        }
    }

    @RequestMapping("/comandas/titulo")
    @ResponseBody
    public String getComandasTitulo() {
        return ComandaBean.getFields().toJSONString();
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
        try (Conexao conn = ConnFactory.criaConexao()) {
            return gson.toDataTable(new ProdutoDAO(conn).busca());
        } catch (DAOException e) {
            throw new DallaHitsException(e);
        }
    }

    /**
     * Retorna os Títulos do Grid de Produtos
     *
     * @return String
     */
    @RequestMapping("/produtos/titulo")
    @ResponseBody
    public String getProdutosTitulo() {
        return ProdutoBean.getFields().toJSONString();
    }

}
