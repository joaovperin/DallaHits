/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.util.db;

import org.json.simple.JSONArray;

/**
 * Bean genérico
 *
 * @param <B>
 */
public abstract class AbstractBean<B extends AbstractBean> {

    /** Api para trabalhar com Jsons */
    private static final JpeGson GS = new JpeGson();

    /**
     * Retorna a representação do objeto em Json
     *
     * @return String
     */
    public String toJson() {
        return GS.toJson(this);
    }

    /**
     * Retorna o valor das propriedades do objeto em um JSONArray
     *
     * @return JSONArray
     */
    public abstract JSONArray toArray();

}
