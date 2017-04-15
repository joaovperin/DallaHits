/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.bean;

import br.jpe.dallahits.util.db.AbstractBean;
import br.jpe.dallahits.gen.pk.ClientePk;
import java.util.Objects;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 * Classe ClienteBean
 *
 * @author Joaov
 */
public class ClienteBean extends AbstractBean<ClienteBean> {

    /** Código */
    private long idCliente;
    /** Nome */
    private String nome;
    /** Sexo */
    private String sexo;
    /** Idade */
    private int idade;

    /** 
     * Construtor da classe ClienteBean
     */
    public ClienteBean() {}
 
    /** 
     * Retorna a chave primária da entidade Cliente
     * 
     * @return ClientePk
     */
    public ClientePk getPk() {
        return new ClientePk(getIdCliente());
    }    

    /** 
     * Retorna o valor do campo Código
     * 
     * @return long
     */
    public long getIdCliente() {
        return idCliente;
    }

    /** 
     * Define o valor do campo Código
     * 
     * @param idCliente
     */
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    /** 
     * Retorna o valor do campo Nome
     * 
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /** 
     * Define o valor do campo Nome
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** 
     * Retorna o valor do campo Sexo
     * 
     * @return String
     */
    public String getSexo() {
        return sexo;
    }

    /** 
     * Define o valor do campo Sexo
     * 
     * @param sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /** 
     * Retorna o valor do campo Idade
     * 
     * @return int
     */
    public int getIdade() {
        return idade;
    }

    /** 
     * Define o valor do campo Idade
     * 
     * @param idade
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Retorna o valor das propriedades do bean em um JSONArray
     * 
     * @return JSONArray
     */
    @Override
    public JSONArray toArray() {
        JSONArray obj = new JSONArray();
        obj.add(getIdCliente());
        obj.add(getNome());
        obj.add(getSexo());
        obj.add(getIdade());
        return obj;
    }

    /**
     * Retorna um Objeto com Nome e Descrição dos campos formato JSONObject
     * 
     * @return JSONObject
     */
    public static JSONObject getFields() {
        JSONObject root = new JSONObject();
        JSONArray nodes = new JSONArray();
        nodes.add("idCliente");
        nodes.add("nome");
        nodes.add("sexo");
        nodes.add("idade");
        root.put("colunas", nodes);
        nodes = new JSONArray();
        nodes.add("Código");
        nodes.add("Nome");
        nodes.add("Sexo");
        nodes.add("Idade");
        root.put("titulos", nodes);
        return root;
    }

    /**
     * Gera e retorna um código hash para essa instância de Cliente
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idCliente);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.sexo);
        hash = 53 * hash + Objects.hashCode(this.idade);
        return hash;
    }

    /**
     * Retorna verdadeiro se os dois objetos forem iguais
     *
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteBean other = (ClienteBean) obj;
        if (!Objects.equals(this.idCliente, other.idCliente)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.idade, other.idade)) {
            return false;
        }
        return true;
    }

    /**
     * Retorna a representação do campo em String
     *
     * @return String
     */
    @Override
    public String toString() {
        return "ClienteBean{" +
                    "idCliente=" + idCliente + ", " +
                    "nome=" + nome + ", " +
                    "sexo=" + sexo + ", " +
                    "idade=" + idade + "}";
    }

}
