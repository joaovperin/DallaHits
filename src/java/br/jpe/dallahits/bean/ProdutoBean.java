/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.bean;

import br.jpe.dallahits.util.db.AbstractBean;
import java.util.Objects;

/**
 * Classe Mensagem
 *
 * @author Joaov
 */
public class ProdutoBean extends AbstractBean<ProdutoBean>{

    private long idProduto;
    private String descricao;
    private double ValorUnitario;

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorUnitario() {
        return ValorUnitario;
    }

    public void setValorUnitario(double ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (this.idProduto ^ (this.idProduto >>> 32));
        hash = 13 * hash + Objects.hashCode(this.descricao);
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.ValorUnitario) ^ (Double.doubleToLongBits(this.ValorUnitario) >>> 32));
        return hash;
    }

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
        if (this.idProduto != other.idProduto) {
            return false;
        }
        if (Double.doubleToLongBits(this.ValorUnitario) != Double.doubleToLongBits(other.ValorUnitario)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProdutoBean{" + "idProduto=" + idProduto + ", descricao=" + descricao + ", ValorUnitario=" + ValorUnitario + '}';
    }

}
