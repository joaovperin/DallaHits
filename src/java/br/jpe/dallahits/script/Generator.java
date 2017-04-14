/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.script;

import br.jpe.dallahits.script.util.GeneratorException;
import br.jpe.dallahits.script.util.TemplateEntidade;
import br.jpe.dallahits.util.Texto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

/**
 * Classe Generator
 *
 * @author Joaov
 */
public class Generator {

    /** Caminho base para este gerador */
    private final String basePath;

    /**
     * Construtor padrão
     *
     * @param basePath
     */
    public Generator(String basePath) {
        this.basePath = basePath;
    }

    /**
     * Cria template para um Pk
     *
     * @param pack
     * @param entidade
     * @throws GeneratorException Problemas ao gerar templates
     */
    public void criaTplPk(String pack, TemplateEntidade entidade) {
        try {
            //Load template from source folder
            Template template = getConfig().getTemplate("web/META-INF/templates/tpPk.ftl");
            execute(pack, entidade, template, "Pk");
        } catch (Exception e) {
            throw new GeneratorException(e);
        }
    }
    
    /**
     * Cria template para um Bean
     *
     * @param pack
     * @param entidade
     * @throws GeneratorException Problemas ao gerar templates
     */
    public void criaTplBean(String pack, TemplateEntidade entidade) {
        try {
            //Load template from source folder
            Template template = getConfig().getTemplate("web/META-INF/templates/tpBean.ftl");
            execute(pack, entidade, template, "Bean");
        } catch (Exception e) {
            throw new GeneratorException(e);
        }
    }
    
    /**
     * Cria template para um DAO
     *
     * @param pack
     * @param entidade
     * @throws GeneratorException Problemas ao gerar templates
     */
    public void criaTplDAO(String pack, TemplateEntidade entidade) throws GeneratorException {
        try {
            //Load template from source folder
            Template template = getConfig().getTemplate("web/META-INF/templates/tpDAO.ftl");
            execute(pack, entidade, template, "DAO");
        } catch (Exception e) {
            throw new GeneratorException(e);
        }
    }

    private void execute(String pack, TemplateEntidade entidade, Template template, String sufixo) {
        try {
            // Build the data-model
            Map<String, Object> data = new HashMap<>();
            data.put("package", pack);
            data.put("entidade", entidade);

            // Saída no Console
            Writer out = new OutputStreamWriter(System.out);
            template.process(data, out);
            out.flush();

            // Saída em arquivo
            try (Writer file = new FileWriter(getOutputFile(pack, entidade.getNome(), sufixo))) {
                template.process(data, file);
                file.flush();
            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace(System.out);
        }
    }

    private File getOutputFile(String pack, String table, String suffix) {
        StringBuilder sb = new StringBuilder(basePath);
        sb.append("/src/java/");
        sb.append(pack.replaceAll("\\.", "/").concat("/"));
        sb.append(suffix.toLowerCase().concat("/"));
        sb.append(montaNome(table, suffix).concat(".java"));
        System.out.println("Using pkg = " + sb.toString());
        return new File(sb.toString().concat("/"));
    }
    
    private Configuration getConfig(){
        return new Configuration(new Version("2.3"));
    }

    private String montaNome(String table, String suffix) {
        return Texto.capitalize(table).concat(Texto.capitalize(suffix));
    }
}
