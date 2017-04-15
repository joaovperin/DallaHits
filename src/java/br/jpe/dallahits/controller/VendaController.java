/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.exception.DallaHitsException;
import br.jpe.dallahits.gen.bean.PessoaBean;
import br.jpe.dallahits.gen.dao.PessoaDAO;
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

    /**
     * Retorna todas as pessoas do banco
     *
     * @return String Lista de pessoas no formato JSON
     * @throws DallaHitsException
     */
    @RequestMapping(value = "/pessoasDt/dados")
    @ResponseBody
    public String getPessoas() throws DallaHitsException {
        try (Conexao conn = ConnFactory.criaConexao()) {
            return gson.toDataTable(new PessoaDAO(conn).busca());
        } catch (DAOException e) {
            throw new DallaHitsException(e);
        }
    }

    /**
     * Retorna os Títulos do Grid de pessoas
     *
     * @return String
     */
    @RequestMapping(value = "/pessoasDt/titulo")
    @ResponseBody
    public String getPessoasTitulo() {
        return PessoaBean.getFields().toJSONString();
    }

}
