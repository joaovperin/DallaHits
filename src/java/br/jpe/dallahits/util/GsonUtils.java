/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.util;

import br.jpe.dallahits.generics.AbstractBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.UnsupportedEncodingException;
import java.util.List;

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
            gson = new GsonBuilder()
                    .setDateFormat("dd/MM/yyyy")
                    .create();
        }
    }

    /**
     * Converte um objeto para Json
     *
     * @param obj
     * @return String
     */
    public String toJson(Object obj) {
        String encoded = getGson().toJson(obj);
        try {
            return new String(encoded.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return encoded;
        }
    }

    /**
     * Retorna uma lista de beans no formato padrão para datatables
     *
     * @param list
     * @return String
     */
    public String toDataTable(List<? extends AbstractBean> list) {
        return toJson(new DataTableBean(list));
    }

    /**
     * Bean para trabalhar com DataTables
     */
    private class DataTableBean {

        /**
         * Construtor default que recebe uma lista de dados
         */
        public DataTableBean(List data) {
            this.data = data;
        }

        /** Lista de dados */
        private List data;

        /** Define os dados */
        public List getData() {
            return data;
        }

        /** Retorna os dados */
        public void setData(List data) {
            this.data = data;
        }

    }

}
