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
 * Classe ItemComandaPk
 *
 * @author Joaov
 */
public class ItemComandaPk extends AbstractPk<ItemComandaPk> {

    /** Código */
    private long idComanda;
    /** Item */
    private long item;

    /** 
     * Construtor da classe ItemComandaPk
     */
    public ItemComandaPk() {}

    /** 
     * Construtor da classe ItemComandaPk
     * 
     * @param  idComanda
     * @param  item
     */
    public ItemComandaPk(long idComanda, long item) {
       this.idComanda = idComanda;
       this.item = item;
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

}
