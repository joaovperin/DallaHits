/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.generics;

import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.util.db.Conexao;

/**
 * Classe Abstrata para todos os DAOs
 *
 * @author Joaov
 * @param <B> Bean
 * @param <P> Pk
 */
public abstract class AbstractViewDAO<B extends AbstractBean, P extends AbstractPk> extends AbstractDAO<B, P> {

    /**
     * Construtor padrão que recebe uma conexão por inversão de controle
     *
     * @param conn Conexão com o banco de dados
     */
    public AbstractViewDAO(Conexao conn) {
        super(conn);
    }

    /** Insere um registro no banco */
    @Override
    public final void insert(B bean) throws DAOException {
        throw new UnsupportedOperationException("Impossível realizar Insert numa View!");
    }

    /** Atualiza um registro no banco
     *
     * @throws br.jpe.dallahits.exception.DAOException */
    @Override
    public final void update(B bean) throws DAOException {
        throw new UnsupportedOperationException("Impossível realizar Update numa View!");
    }

    /** Deleta um registro do banco */
    @Override
    public final void delete(B bean) throws DAOException {
        throw new UnsupportedOperationException("Impossível realizar Delete numa View!");
    }

    /** Retorna o comando SQL para inserção do registro */
    @Override
    protected final String getSqlInsert() {
        throw new UnsupportedOperationException("Impossível realizar Insert numa View!");
    }

    /** Retorna o comando SQL para atualizar um registro */
    @Override
    protected final String getSqlUpdate(String where) {
        throw new UnsupportedOperationException("Impossível realizar Update numa View!");
    }

    /** Retorna o comando SQL para deletar um registro */
    @Override
    protected final String getSqlDelete(String where) {
        throw new UnsupportedOperationException("Impossível realizar Delete numa View!");
    }

}
