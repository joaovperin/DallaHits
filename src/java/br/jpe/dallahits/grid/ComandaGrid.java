/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.grid;

import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.exception.DallaHitsException;
import br.jpe.dallahits.gen.bean.ClienteBean;
import br.jpe.dallahits.gen.bean.ComandaBean;
import br.jpe.dallahits.gen.bean.UsuarioBean;
import br.jpe.dallahits.gen.dao.ClienteDAO;
import br.jpe.dallahits.gen.dao.ComandaDAO;
import br.jpe.dallahits.gen.dao.UsuarioDAO;
import br.jpe.dallahits.gen.entidade.ComandaEntidade;
import br.jpe.dallahits.generics.AbstractBean;
import br.jpe.dallahits.generics.AbstractGrid;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;

/**
 * Classe ProdutoGrid
 *
 * @author Joaov
 */
public class ComandaGrid extends AbstractGrid {

    /**
     * Retorna os títulos do Grid
     *
     * @return JSONArray
     */
    @Override
    protected JSONArray getTitulos() {
        JSONArray titulos = new ComandaEntidade().getTitulos();
        titulos.add("Cliente");
        titulos.add("Usuario");
        return titulos;
    }

    /**
     * Retorna as colunas do Grid
     *
     * @return JSONArray
     */
    @Override
    protected JSONArray getColunas() {
        JSONArray colunas = new ComandaEntidade().getColunas();
        colunas.add("cliente");
        colunas.add("usuario");
        return colunas;
    }

    /**
     * Retorna busca no banco e retorna os dados do grid
     *
     * @return List Lista com os beans populados
     * @throws DallaHitsException
     */
    @Override
    public List<? extends AbstractBean> getDados() throws DallaHitsException {
        List dados = new ArrayList<>();
        try (Conexao conn = ConnFactory.criaConexao()) {
            List<ComandaBean> cmds = new ComandaDAO(conn).busca();
            List<ClienteBean> cls = new ClienteDAO(conn).busca();
            List<UsuarioBean> usus = new UsuarioDAO(conn).busca();
            // Monta lista
            cmds.forEach((cmd) -> {
                ViewComandaBean bean = new ViewComandaBean();
                bean.setIdComanda(cmd.getIdComanda());
                bean.setIdCliente(cmd.getIdCliente());
                bean.setIdUsuario(cmd.getIdUsuario());
                bean.setData(cmd.getData());
                bean.setValorTotal(cmd.getValorTotal());
                // Busca clientes
                cls.stream().filter((cli) -> {
                    return cli.getIdCliente() == cmd.getIdCliente();
                }).forEach((c) -> {
                    bean.setCliente(c.getNome());
                });
                // Busca Usuários
                usus.stream().filter((usu) -> {
                    return usu.getIdUsuario() == cmd.getIdUsuario();
                }).forEach((u) -> {
                    bean.setUsuario(u.getNome());
                });
                // Adiciona na lista
                dados.add(bean);
            });
        } catch (DAOException e) {
            throw new DallaHitsException(e);
        }
        return dados;
    }

    /**
     * Subclasse para criar um novo bean de comanda
     */
    private class ViewComandaBean extends ComandaBean {

        /** Descrição do cliente */
        private String cliente;
        /** Descrição do usuário */
        private String usuario;

        public String getCliente() {
            return cliente;
        }

        public void setCliente(String cliente) {
            this.cliente = cliente;
        }

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        @Override
        public JSONArray toArray() {
            JSONArray campos = super.toArray();
            campos.add("cliente");
            campos.add("usuario");
            return campos;
        }
    }

}
