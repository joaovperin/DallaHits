/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.exception;

/**
 * Exception padrão para problemas gerais
 *
 * @author Joaov
 */
public class DallaHitsException extends Exception {

    /**
     * Construtor padrão da exceção
     */
    public DallaHitsException() {
        super();
    }

    /**
     * Construtor da exceção que recebe uma mensagem
     *
     * @param message
     */
    public DallaHitsException(String message) {
        super(message);
    }

    /**
     * Construtor da exceção que recebe a causa e uma mensagem
     *
     * @param message
     * @param cause
     */
    public DallaHitsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construtor da exceção que recebe a causa
     *
     * @param cause
     */
    public DallaHitsException(Throwable cause) {
        super(cause);
    }

}
