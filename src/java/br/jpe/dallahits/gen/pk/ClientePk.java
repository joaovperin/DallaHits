/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.pk;

import br.jpe.dallahits.util.db.AbstractPk;

/**
 * Classe ClientePk
 *
 * @author Joaov
 */
public class ClientePk extends AbstractPk<ClientePk> {

    /** Código */
    private long idCliente;

    /** 
     * Construtor da classe ClientePk
     */
    public ClientePk() {}

    /** 
     * Construtor da classe ClientePk
     * 
     * @param  idCliente
     */
    public ClientePk(long idCliente) {
       this.idCliente = idCliente;
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

}
