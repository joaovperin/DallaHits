/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import br.jpe.dallahits.bean.Person;
import br.jpe.dallahits.bean.UsuarioBean;
import br.jpe.dallahits.dao.UsuarioDAO;
import br.jpe.dallahits.exception.DAOException;
import br.jpe.dallahits.util.db.Conexao;
import br.jpe.dallahits.util.db.ConnFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 * Classe SpringTilesController
 *
 * @author Joaov
 */
@Controller
public class SpringTilesController {

    @RequestMapping("/viewPerson")
    public ModelAndView viewPersons(Model model) {
        System.out.println("oieeee");
        Map<String, List<Person>> persons = new HashMap<>();
        persons.put("persons", Person.createPersons());
        return new ModelAndView("personList", persons);
    }
    
    @RequestMapping("/pessoas")
    public String pessoas(Model model, HttpServletRequest req) {
        System.out.println("oi pessoas");
        Map<String, List<Person>> persons = new HashMap<>();
        List<Person> createPersons = Person.createPersons();
        persons.put("persons", createPersons);
        req.setAttribute("persons", createPersons);
        return "personList";
    }

}
