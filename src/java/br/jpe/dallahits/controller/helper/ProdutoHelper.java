/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller.helper;

import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.exception.DallaHitsException;
import br.jpe.dallahits.gen.bean.ProdutoBean;
import br.jpe.dallahits.gen.dao.ProdutoDAO;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import br.jpe.dallahits.util.db.DBUtils;

/**
 * Classe ProdutoHelper
 *
 * @author Joaov
 */
public class ProdutoHelper {

    /**
     * Executa a gravação de um produto no banco
     *
     * @param produto
     * @return String Mensagem de validação
     * @throws DallaHitsException
     */
    public String executaGravacao(ProdutoBean produto) throws DallaHitsException {
        String msg = "Produto " + produto.getDescricao() + " incluído com sucesso!";
        Conexao conn = null;
        try {
            conn = ConnFactory.criaConexaoTransacao();
            new ProdutoDAO(conn).insert(produto);
            DBUtils.commit(conn);
        } catch (DAOException e) {
            msg = "Falha ao gravar produto " + produto.getDescricao() + " :/";
            DBUtils.rollback(conn);
            throw new DallaHitsException(e);
        } finally {
            DBUtils.close(conn);
        }
        return msg;
    }

}
