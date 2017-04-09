/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.exception;

/**
 * Exception padrão para problemas na camada de acesso ao banco de dados
 *
 * @author Joaov
 */
public class DAOException extends Exception {

    /**
     * Construtor padrão da exceção
     */
    public DAOException() {
        super();
    }

    /**
     * Construtor da exceção que recebe uma mensagem
     *
     * @param message
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * Construtor da exceção que recebe a causa e uma mensagem
     *
     * @param message
     * @param cause
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construtor da exceção que recebe a causa
     *
     * @param cause
     */
    public DAOException(Throwable cause) {
        super(cause);
    }

}
