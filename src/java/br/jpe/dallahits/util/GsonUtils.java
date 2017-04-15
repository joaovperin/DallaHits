/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.util;

import br.jpe.dallahits.generics.AbstractBean;
import com.google.gson.Gson;
import java.util.List;
import org.json.simple.JSONObject;

/**
 * Objeto auxiliar para trabalhar com a API Gson
 */
public class GsonUtils {

    /** Objeto da api Gson - NÃO UTILIZAR DIRETAMENTE */
    private static Gson gson;

    /**
     * Getter privado para o objeto da API
     *
     * @return Gson
     */
    private Gson getGson() {
        if (gson == null) {
            instantiate();
        }
        return gson;
    }

    /**
     * Instancia o Gson
     */
    private static synchronized void instantiate() {
        if (gson == null) {
            gson = new Gson();
        }
    }

    /**
     * Converte um objeto para Json
     *
     * @param obj
     * @return String
     */
    public String toJson(Object obj) {
        return getGson().toJson(obj);
    }

    /**
     * Retorna uma lista de beans no formato padrão para datatables
     *
     * @param list
     * @return String
     */
    public String toDataTable(List<? extends AbstractBean> list) {
        JSONObject obj = new JSONObject();
        obj.put("data", list);
        return toJson(obj);
    }

}
