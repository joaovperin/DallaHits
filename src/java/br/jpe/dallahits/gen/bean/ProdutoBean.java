/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.bean;

import br.jpe.dallahits.generics.AbstractBean;
import br.jpe.dallahits.gen.pk.ProdutoPk;
import java.util.Objects;
import org.json.simple.JSONArray;

/**
 * Classe ProdutoBean
 *
 * @author Joaov
 */
public class ProdutoBean extends AbstractBean<ProdutoBean> {

    /** Código */
    private long idProduto;
    /** Descrição */
    private String descricao;
    /** Valor unitário */
    private double valorUnitario;

    /** 
     * Construtor da classe ProdutoBean
     */
    public ProdutoBean() {}
 
    /** 
     * Retorna a chave primária da entidade Produto
     * 
     * @return ProdutoPk
     */
    public ProdutoPk getPk() {
        return new ProdutoPk(getIdProduto());
    }    

    /** 
     * Retorna o valor do campo Código
     * 
     * @return long
     */
    public long getIdProduto() {
        return idProduto;
    }

    /** 
     * Define o valor do campo Código
     * 
     * @param idProduto
     */
    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    /** 
     * Retorna o valor do campo Descrição
     * 
     * @return String
     */
    public String getDescricao() {
        return descricao;
    }

    /** 
     * Define o valor do campo Descrição
     * 
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /** 
     * Retorna o valor do campo Valor unitário
     * 
     * @return double
     */
    public double getValorUnitario() {
        return valorUnitario;
    }

    /** 
     * Define o valor do campo Valor unitário
     * 
     * @param valorUnitario
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * Retorna o valor das propriedades do bean em um JSONArray
     * 
     * @return JSONArray
     */
    @Override
    public JSONArray toArray() {
        JSONArray obj = new JSONArray();
        obj.add(getIdProduto());
        obj.add(getDescricao());
        obj.add(getValorUnitario());
        return obj;
    }

    /**
     * Gera e retorna um código hash para essa instância de Produto
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idProduto);
        hash = 53 * hash + Objects.hashCode(this.descricao);
        hash = 53 * hash + Objects.hashCode(this.valorUnitario);
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
        final ProdutoBean other = (ProdutoBean) obj;
        if (!Objects.equals(this.idProduto, other.idProduto)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.valorUnitario, other.valorUnitario)) {
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
        return "ProdutoBean{" +
                    "idProduto=" + idProduto + ", " +
                    "descricao=" + descricao + ", " +
                    "valorUnitario=" + valorUnitario + "}";
    }

}
