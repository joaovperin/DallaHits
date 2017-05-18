/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.bean;

import br.jpe.dallahits.generics.AbstractBean;
import java.util.Objects;
import org.json.simple.JSONArray;
import java.util.Date;

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
    /** Data de nascimento */
    private Date dataNascimento;

    /** 
     * Construtor da classe ClienteBean
     */
    public ClienteBean() {}

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
     * Retorna o valor do campo Data de nascimento
     * 
     * @return Date
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /** 
     * Define o valor do campo Data de nascimento
     * 
     * @param dataNascimento
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
        obj.add(getDataNascimento());
        return obj;
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
        hash = 53 * hash + Objects.hashCode(this.dataNascimento);
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
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
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
                    "dataNascimento=" + dataNascimento + "}";
    }

}
