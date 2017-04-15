/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.pk;

import br.jpe.dallahits.generics.AbstractPk;

/**
 * Classe ProdutoPk
 *
 * @author Joaov
 */
public class ProdutoPk extends AbstractPk<ProdutoPk> {

    /** Código */
    private long idProduto;

    /** 
     * Construtor da classe ProdutoPk
     */
    public ProdutoPk() {}

    /** 
     * Construtor da classe ProdutoPk
     * 
     * @param  idProduto
     */
    public ProdutoPk(long idProduto) {
       this.idProduto = idProduto;
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

}
