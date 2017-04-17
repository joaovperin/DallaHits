/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.bean;

import br.jpe.dallahits.generics.AbstractBean;
import br.jpe.dallahits.gen.pk.ItemComandaPk;
import java.util.Objects;
import org.json.simple.JSONArray;

/**
 * Classe ItemComandaBean
 *
 * @author Joaov
 */
public class ItemComandaBean extends AbstractBean<ItemComandaBean> {

    /** Código */
    private long idComanda;
    /** Item */
    private long item;
    /** Produto */
    private long produto;
    /** Quantidade */
    private int quantidade;
    /** Total do Item */
    private double valorTotalItem;

    /** 
     * Construtor da classe ItemComandaBean
     */
    public ItemComandaBean() {}
 
    /** 
     * Retorna a chave primária da entidade ItemComanda
     * 
     * @return ItemComandaPk
     */
    public ItemComandaPk getPk() {
        return new ItemComandaPk(getIdComanda(), getItem());
    }    

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
     * Retorna o valor do campo Item
     * 
     * @return long
     */
    public long getItem() {
        return item;
    }

    /** 
     * Define o valor do campo Item
     * 
     * @param item
     */
    public void setItem(long item) {
        this.item = item;
    }

    /** 
     * Retorna o valor do campo Produto
     * 
     * @return long
     */
    public long getProduto() {
        return produto;
    }

    /** 
     * Define o valor do campo Produto
     * 
     * @param produto
     */
    public void setProduto(long produto) {
        this.produto = produto;
    }

    /** 
     * Retorna o valor do campo Quantidade
     * 
     * @return int
     */
    public int getQuantidade() {
        return quantidade;
    }

    /** 
     * Define o valor do campo Quantidade
     * 
     * @param quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /** 
     * Retorna o valor do campo Total do Item
     * 
     * @return double
     */
    public double getValorTotalItem() {
        return valorTotalItem;
    }

    /** 
     * Define o valor do campo Total do Item
     * 
     * @param valorTotalItem
     */
    public void setValorTotalItem(double valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
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
        obj.add(getItem());
        obj.add(getProduto());
        obj.add(getQuantidade());
        obj.add(getValorTotalItem());
        return obj;
    }

    /**
     * Gera e retorna um código hash para essa instância de ItemComanda
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idComanda);
        hash = 53 * hash + Objects.hashCode(this.item);
        hash = 53 * hash + Objects.hashCode(this.produto);
        hash = 53 * hash + Objects.hashCode(this.quantidade);
        hash = 53 * hash + Objects.hashCode(this.valorTotalItem);
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
        final ItemComandaBean other = (ItemComandaBean) obj;
        if (!Objects.equals(this.idComanda, other.idComanda)) {
            return false;
        }
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.valorTotalItem, other.valorTotalItem)) {
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
        return "ItemComandaBean{" +
                    "idComanda=" + idComanda + ", " +
                    "item=" + item + ", " +
                    "produto=" + produto + ", " +
                    "quantidade=" + quantidade + ", " +
                    "valorTotalItem=" + valorTotalItem + "}";
    }

}
