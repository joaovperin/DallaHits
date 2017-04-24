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
 * Classe UsuarioPk
 *
 * @author Joaov
 */
public class UsuarioPk extends AbstractPk<UsuarioPk> {

    /** Código */
    private int idUsuario;

    /** 
     * Construtor da classe UsuarioPk
     */
    public UsuarioPk() {}

    /** 
     * Construtor da classe UsuarioPk
     * 
     * @param  idUsuario
     */
    public UsuarioPk(int idUsuario) {
       this.idUsuario = idUsuario;
    }

    /** 
     * Retorna o valor do campo Código
     * 
     * @return int
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /** 
     * Define o valor do campo Código
     * 
     * @param idUsuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
