/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import br.jpe.dallahits.bean.Person;
import java.util.List;
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
     */
    @RequestMapping("/pessoas")
    public String pessoas(Model model, HttpServletRequest req) {
        List<Person> createPersons = Person.createPersons();
        req.setAttribute("persons", createPersons);
        return "personList";
    }

}
