/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.exception.DallaHitsException;
import br.jpe.dallahits.gen.dao.PessoasDAO;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Classe SpringTilesController
 *
 * @author Joaov
 */
@Controller
public class SpringTilesController {

    /**
     * Teste do ApacheTiles com Spring MVC
     *
     * @param model DataModel
     * @param req Request
     * @return String
     * @throws br.jpe.dallahits.exception.DallaHitsException
     */
    @RequestMapping("/pessoas")
    public String pessoas(Model model, HttpServletRequest req) throws DallaHitsException {
        try (Conexao conn = ConnFactory.criaConexao()) {
            req.setAttribute("persons", new PessoasDAO(conn).busca());
        } catch (DAOException e) {
            throw new DallaHitsException(e);
        }
        return "personList";
    }

}
