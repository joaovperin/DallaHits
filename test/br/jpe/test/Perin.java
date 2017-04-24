/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.test;

import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.gen.dao.ProdutoDAO;
import br.jpe.dallahits.util.GsonUtils;
import br.jpe.dallahits.util.HtmlTagBuilder;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.catalina.util.Base64;

/**
 * Classe Perin
 *
 * @author Joaov
 */
public class Perin {
    
    int code;

    public static void main(String[] args) throws DAOException {
        System.out.println("Hello!");

        GsonUtils g = new GsonUtils();
        
        try (Conexao conn = ConnFactory.criaConexao()){
            System.out.println(g.toDataTable(new ProdutoDAO(conn).busca()));
        }

        System.out.println("Fim.");
    }

    private class Bean {
        
        private List data;

        public List getData() {
            
            Collections.sort(data, (Perin a, Perin b) -> a.code - b.code);
            
            data.sort((Object a, Object b) -> 1);
            
            return data;
        }

        public void setData(List data) {
            this.data = data;
        }

    }

}
