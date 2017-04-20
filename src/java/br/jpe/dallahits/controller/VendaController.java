/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.exception.DallaHitsException;
import br.jpe.dallahits.gen.bean.ClienteBean;
import br.jpe.dallahits.gen.bean.ComandaBean;
import br.jpe.dallahits.gen.dao.ClienteDAO;
import br.jpe.dallahits.gen.dao.ComandaDAO;
import br.jpe.dallahits.generics.AbstractGrid;
import br.jpe.dallahits.grid.ComandaGrid;
import br.jpe.dallahits.gen.view.bean.ViewComandasBean;
import br.jpe.dallahits.util.GsonUtils;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import br.jpe.dallahits.util.db.DBUtils;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Classe VendaController
 *
 * @author Joaov
 */
@Controller
public class VendaController {

    /** Api para gerar Jsons */
    private final GsonUtils gson = new GsonUtils();
    /** Grid de comandas */
    private final AbstractGrid comandasGrid;

    /**
     * Construtor padrão
     */
    public VendaController() {
        comandasGrid = new ComandaGrid();
    }

    /**
     * URL para consultar a página de vendas
     *
     * @return String
     * @throws DallaHitsException
     */
    @RequestMapping(value = "/venda", method = RequestMethod.GET)
    public String venda() throws DallaHitsException {
        return "venda";
    }

    /**
     * URL para a inclusão de comandas
     *
     * @param cmd Comanda
     * @param flashAttr
     * @return String
     * @throws DallaHitsException
     */
    @RequestMapping(value = "/comanda/incluir", method = RequestMethod.POST)
    public String comandaIncluir(ViewComandasBean cmd, RedirectAttributes flashAttr)
            throws DallaHitsException {
        
        System.out.println("Entrou!!");
        System.out.println(cmd);

        Conexao conn = null;
        try {
            // Cria conexão e instancia DAOs
            conn = ConnFactory.criaConexaoTransacao();
            ComandaDAO comandaDao = new ComandaDAO(conn);
            ComandaBean bean = new ComandaBean();

            // Se informou código do cliente
            if (cmd.getIdCliente() != 0){
                bean.setIdCliente(cmd.getIdCliente());
            } else {
                // Grava um nome cliente
                ClienteDAO cliDao = new ClienteDAO(conn);
                ClienteBean cliBean = new ClienteBean();
                cliBean.setNome(cmd.getCliente());
                cliBean.setIdade(21);
                cliBean.setSexo("M");
                bean.setIdCliente(cliDao.insertAi(cliBean).getIdCliente());
                DBUtils.commit(conn);
            }

            bean.setData(new Date());
            bean.setValorTotal(0);
            bean.setIdUsuario(1);
            comandaDao.insert(bean);
            DBUtils.commit(conn);
        } catch (DAOException e) {
            DBUtils.rollback(conn);
            flashAttr.addAttribute("msg", "Falha na gravação da comanda! Motivo:\n" + e.getMessage());
            throw new DallaHitsException(e);
        } finally {
            DBUtils.close(conn);
        }

        System.out.println("Inclusão: " + cmd.getIdCliente() + ": " + cmd.getCliente());
        flashAttr.addAttribute("msg", "Comanda incluída com sucesso!");
        return "venda";
    }

    /**
     * URL para retornar os dados do grid de comandas em formato JSON
     *
     * @return String
     * @throws DallaHitsException
     */
    @RequestMapping(value = "/comandas/dados",  produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String getComandas() throws DallaHitsException {
        return gson.toDataTable(comandasGrid.getDados());
    }

    /**
     * URL para retornar os headers do grid de comandas em formato JSON
     *
     * @return String
     */
    @RequestMapping("/comandas/titulo")
    @ResponseBody
    public String getComandasTitulo() {
        return comandasGrid.createGrid().toJSONString();
    }

}
