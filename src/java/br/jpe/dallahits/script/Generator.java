/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.script;

import br.jpe.dallahits.script.util.Table;
import java.util.List;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Classe Generator
 *
 * @author Joaov
 */
public class Generator {

    private final List<Table> tables;

    public Generator(List<Table> tables) {
        this.tables = tables;
    }

    public void execute() {
        //Freemarker configuration object
        Configuration cfg = new Configuration();
        try {
            //Load template from source folder
            Template template = cfg.getTemplate("web/META-INF/templates/bean.ftl");

            // Build the data-model
            Map<String, Object> data = new HashMap<>();
            data.put("message", "Hello World!");

            //List parsing 
            List<String> countries = new ArrayList<>();
            countries.add("India");
            countries.add("United States");
            countries.add("Germany");
            countries.add("France");

            data.put("countries", countries);
            
            data.put("name", "TestBean");

            // Console output
            Writer out = new OutputStreamWriter(System.out);
            template.process(data, out);
            out.flush();

            // File output
            
            Writer file = new FileWriter(new File("D:\\1-Projetos\\_Feevale\\DallaHits\\src\\java\\br\\jpe\\dallahits\\gen\\TestBean.java"));
            template.process(data, file);
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

}
