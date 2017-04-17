/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.generics;

import br.jpe.dallahits.exception.DallaHitsException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Classe AbstractGrid
 *
 * @author Joaov
 */
public abstract class AbstractGrid {

    /**
     * Retorna os títulos de um grid
     *
     * @return JSONArray
     */
    protected abstract JSONArray getTitulos();

    /**
     * Retorna as colunas s de um grid
     *
     * @return JSONArray
     */
    protected abstract JSONArray getColunas();

    /**
     * Retorna os valores das colunas customizadas
     *
     * @return JSONArray
     */
    protected JSONArray getCustomColumnValues() {
        return new JSONArray();
    }

    /**
     * Retorna a lista de Dados do Grid
     *
     * @return List
     * @throws DallaHitsException
     */
    public abstract List<? extends AbstractBean> getDados() throws DallaHitsException;

    /**
     * Retorna o objeto Json do grid no formato esperado pelo DataTables.js
     *
     * @return JSONObject
     */
    public final JSONObject createGrid() {
        JSONObject root = new JSONObject();
        root.put("colunas", getColunas());
        root.put("columnDefs", getCustomColumnValues());
        root.put("titulos", getTitulos());
        return root;
    }

    // ----------------------------------------------------
    // FUNÇÕES AUXILIARES ESTÁTISCAS À PARTIR DAQUI
    // ---------------------------------------------------- //
    protected static JSONObject criaObj(String content) {
        JSONObject obj = new JSONObject();
        obj.put("content", content);
        return obj;
    }

}