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
 * Classe MensagemPk
 *
 * @author Joaov
 */
public class MensagemPk extends AbstractPk<MensagemPk> {

    /** Código da mensagem */
    private long idMsg;

    /** 
     * Construtor da classe MensagemPk
     */
    public MensagemPk() {}

    /** 
     * Construtor da classe MensagemPk
     * 
     * @param  idMsg
     */
    public MensagemPk(long idMsg) {
       this.idMsg = idMsg;
    }

    /** 
     * Retorna o valor do campo Código da mensagem
     * 
     * @return long
     */
    public long getIdMsg() {
        return idMsg;
    }

    /** 
     * Define o valor do campo Código da mensagem
     * 
     * @param idMsg
     */
    public void setIdMsg(long idMsg) {
        this.idMsg = idMsg;
    }

}
