/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import br.jpe.dallahits.controller.helper.ProdutoHelper;
import br.jpe.dallahits.exception.DallaHitsException;
import br.jpe.dallahits.gen.bean.ProdutoBean;
import br.jpe.dallahits.grid.ProdutoGrid;
import br.jpe.dallahits.util.GsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Classe ProdutoController
 *
 * @author Joaov
 */
@Controller
public class ProdutoController {

    /** Api para gerar Jsons */
    private final GsonUtils gson = new GsonUtils();
    /** Helper do controller */
    private final ProdutoHelper helper;

    /**
     * Construtor padrão
     */
    public ProdutoController() {
        helper = new ProdutoHelper();
    }

    /**
     * URL para consultar a listagem de produtos
     *
     * @return String
     * @throws DallaHitsException
     */
    @RequestMapping(value = {"/produto", "/produto/listagem"}, method = RequestMethod.GET)
    public String listagem() throws DallaHitsException {
        return "produto/grid";
    }

    /**
     * URL para o formulário de produtos
     *
     * @return String
     * @throws DallaHitsException
     */
    @RequestMapping(value = "/produto/form", method = RequestMethod.GET)
    public String form() throws DallaHitsException {
        return "produto/form";
    }

    /**
     * URL para realizar a gravação de um produto
     *
     * @param produto
     * @param flashAttr
     * @return String
     * @throws DallaHitsException
     */
    @RequestMapping(value = "/produto/incluir", method = RequestMethod.POST)
    public String produtoIncluir(ProdutoBean produto, RedirectAttributes flashAttr)
            throws DallaHitsException {
        String msg;
        // Executa validação e tenta gravar
        if (produto.getDescricao() != null && produto.getValorUnitario() > 0) {
            msg = helper.executaGravacao(produto);
        } else {
            msg = "Dados inválidos! O produto não foi gravado.";
        }
        // Repassa o resultado adiante e redireciona
        flashAttr.addFlashAttribute("msg", msg);
        return "redirect:form";
    }

    /**
     * Retorna todos os produtos do banco
     *
     * @return String Lista de produtos no formato JSON
     * @throws DallaHitsException
     */
    @RequestMapping("/produto/listagem/dados")
    @ResponseBody
    public String getProdutos() throws DallaHitsException {
        return gson.toDataTable(new ProdutoGrid().getDados());
    }

    /**
     * Retorna os Títulos do Grid de Produtos
     *
     * @return String
     */
    @RequestMapping("/produto/listagem/titulo")
    @ResponseBody
    public String getProdutosTitulo() {
        return new ProdutoGrid().createGrid().toJSONString();
    }

}
