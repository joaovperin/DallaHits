/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.pk;

import br.jpe.dallahits.generics.AbstractPk;
import java.util.Date;

/**
 * Classe ComandaPk
 *
 * @author Joaov
 */
public class ComandaPk extends AbstractPk<ComandaPk> {

    /** Código */
    private long idComanda;

    /** 
     * Construtor da classe ComandaPk
     */
    public ComandaPk() {}

    /** 
     * Construtor da classe ComandaPk
     * 
     * @param  idComanda
     */
    public ComandaPk(long idComanda) {
       this.idComanda = idComanda;
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

}
