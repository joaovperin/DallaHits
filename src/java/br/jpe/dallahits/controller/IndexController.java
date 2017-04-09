/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Classe LoginController
 *
 * @author Joaov
 */
@Controller
public class IndexController {

    /**
     * Url para a página inicial (index)
     *
     * @return String
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
