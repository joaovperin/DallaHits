/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.grid;

import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.exception.DallaHitsException;
import br.jpe.dallahits.gen.dao.ProdutoDAO;
import br.jpe.dallahits.gen.entidade.ProdutoEntidade;
import br.jpe.dallahits.generics.AbstractBean;
import br.jpe.dallahits.generics.AbstractGrid;
import br.jpe.dallahits.util.HtmlTagBuilder;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import java.util.List;
import org.json.simple.JSONArray;

/**
 * Classe ProdutoGrid
 *
 * @author Joaov
 */
public class ProdutoGrid extends AbstractGrid {

    @Override
    protected JSONArray getTitulos() {
        JSONArray titulos = new ProdutoEntidade().getTitulos();
        titulos.add("Alterar");
        titulos.add("Excluir");
        return titulos;
    }

    @Override
    protected JSONArray getColunas() {
        JSONArray colunas = new ProdutoEntidade().getColunas();
        colunas.add("alt");
        colunas.add("exc");
        return colunas;
    }

    @Override
    protected JSONArray getCustomColumnValues() {
        JSONArray arr = new JSONArray();
        arr.add(criaObj(new HtmlTagBuilder("div", new HtmlTagBuilder("button", "A").addId("alt").addClass("dt-button").build())
                .addClass("center").build()));
        arr.add(criaObj(new HtmlTagBuilder("div", new HtmlTagBuilder("button", "E").addId("exc").addClass("dt-button").build())
                .addClass("center").build()));
        return arr;
    }

    /**
     * Retorna busca no banco e retorna os dados do grid
     *
     * @return List Lista com os beans populados
     * @throws DallaHitsException
     */
    @Override
    public List<? extends AbstractBean> getDados() throws DallaHitsException {
        try (Conexao conn = ConnFactory.criaConexao()) {
            return new ProdutoDAO(conn).busca();
        } catch (DAOException e) {
            throw new DallaHitsException(e);
        }
    }

}
