/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.view.bean;

import br.jpe.dallahits.generics.AbstractBean;
import java.util.Objects;
import org.json.simple.JSONArray;
import java.util.Date;

/**
 * Classe ViewComandasBean
 *
 * @author Joaov
 */
public class ViewComandasBean extends AbstractBean<ViewComandasBean> {

    /** Código */
    private long idComanda;
    /** Código do cliente */
    private long idCliente;
    /** Nome */
    private String cliente;
    /** Nome */
    private String usuario;
    /** Data */
    private Date data;
    /** Valor Total */
    private double valorTotal;

    /** 
     * Construtor da classe ViewComandasBean
     */
    public ViewComandasBean() {}

    /** 
     * Retorna o valor do campo Código
     * 
     * @return long
     */
    public long getIdComanda() {
        return idComanda;
    }

    /** 
     * Define o valor do campo Código
     * 
     * @param idComanda
     */
    public void setIdComanda(long idComanda) {
        this.idComanda = idComanda;
    }

    /** 
     * Retorna o valor do campo Código do cliente
     * 
     * @return long
     */
    public long getIdCliente() {
        return idCliente;
    }

    /** 
     * Define o valor do campo Código do cliente
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
    public String getCliente() {
        return cliente;
    }

    /** 
     * Define o valor do campo Nome
     * 
     * @param cliente
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /** 
     * Retorna o valor do campo Nome
     * 
     * @return String
     */
    public String getUsuario() {
        return usuario;
    }

    /** 
     * Define o valor do campo Nome
     * 
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /** 
     * Retorna o valor do campo Data
     * 
     * @return Date
     */
    public Date getData() {
        return data;
    }

    /** 
     * Define o valor do campo Data
     * 
     * @param data
     */
    public void setData(Date data) {
        this.data = data;
    }

    /** 
     * Retorna o valor do campo Valor Total
     * 
     * @return double
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /** 
     * Define o valor do campo Valor Total
     * 
     * @param valorTotal
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * Retorna o valor das propriedades do bean em um JSONArray
     * 
     * @return JSONArray
     */
    @Override
    public JSONArray toArray() {
        JSONArray obj = new JSONArray();
        obj.add(getIdComanda());
        obj.add(getIdCliente());
        obj.add(getCliente());
        obj.add(getUsuario());
        obj.add(getData());
        obj.add(getValorTotal());
        return obj;
    }

    /**
     * Gera e retorna um código hash para essa instância de ViewComandas
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idComanda);
        hash = 53 * hash + Objects.hashCode(this.idCliente);
        hash = 53 * hash + Objects.hashCode(this.cliente);
        hash = 53 * hash + Objects.hashCode(this.usuario);
        hash = 53 * hash + Objects.hashCode(this.data);
        hash = 53 * hash + Objects.hashCode(this.valorTotal);
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
        final ViewComandasBean other = (ViewComandasBean) obj;
        if (!Objects.equals(this.idComanda, other.idComanda)) {
            return false;
        }
        if (!Objects.equals(this.idCliente, other.idCliente)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.valorTotal, other.valorTotal)) {
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
        return "ViewComandasBean{" +
                    "idComanda=" + idComanda + ", " +
                    "idCliente=" + idCliente + ", " +
                    "cliente=" + cliente + ", " +
                    "usuario=" + usuario + ", " +
                    "data=" + data + ", " +
                    "valorTotal=" + valorTotal + "}";
    }

}
