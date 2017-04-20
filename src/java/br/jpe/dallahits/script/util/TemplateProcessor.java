/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.script.util;

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
 * Classe TemplateProcessor
 *
 * @author Joaov
 */
public class TemplateProcessor {

    /** Caminho base para este gerador */
    private final String basePath;

    /**
     * Construtor padrão
     *
     * @param basePath
     */
    public TemplateProcessor(String basePath) {
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
            Template template = getConfig().getTemplate("web/META-INF/templates/tpDAO.ftl");
            execute(pack, entidade, template, "DAO");
        } catch (Exception e) {
            throw new GeneratorException(e);
        }
    }

    /**
     * Cria template para uma Entidade
     *
     * @param pack
     * @param entidade
     * @throws GeneratorException Problemas ao gerar templates
     */
    public void criaTplEntidade(String pack, TemplateEntidade entidade) throws GeneratorException {
        try {
            Template template = getConfig().getTemplate("web/META-INF/templates/tpEntidade.ftl");
            execute(pack, entidade, template, "Entidade");
        } catch (Exception e) {
            throw new GeneratorException(e);
        }
    }

    /**
     * Cria template para um ViewDAO
     *
     * @param pack
     * @param entidade
     * @throws GeneratorException Problemas ao gerar templates
     */
    public void criaTplViewDAO(String pack, TemplateEntidade entidade) throws GeneratorException {
        try {
            //Load template from source folder
            Template template = getConfig().getTemplate("web/META-INF/templates/tpViewDAO.ftl");
            execute(pack, entidade, template, "DAO");
        } catch (Exception e) {
            throw new GeneratorException(e);
        }
    }

    /**
     * Processa um template e gera o arquivo de saída
     *
     * @param pack
     * @param entidade
     * @param template
     * @param sufixo
     */
    /**
     * Processa um template e gera o arquivo de saída
     *
     * @param pack
     * @param entidade
     * @param template
     * @param sufixo
     */
    private void execute(String pack, TemplateEntidade entidade, Template template, String sufixo) {
        execute(pack, entidade, template, "", sufixo);
    }

    /**
     * Processa um template e gera o arquivo de saída
     *
     * @param pack
     * @param entidade
     * @param template
     * @param prefixo
     * @param sufixo
     */
    private void execute(String pack, TemplateEntidade entidade, Template template, String prefix, String sufixo) {
        try {
            // Monta o data-model esperado pelo FreeMarker
            Map<String, Object> data = new HashMap<>();
            data.put("package", pack);
            data.put("entidade", entidade);

            // Saída no Console
            Writer out = new OutputStreamWriter(System.out);
            template.process(data, out);
            out.flush();

            // Saída em arquivo
            try (Writer file = new FileWriter(getOutputFile(pack, entidade.getNome(), prefix, sufixo))) {
                template.process(data, file);
                file.flush();
            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * Monta o arquivo de saída
     *
     * @param pack
     * @param table
     * @param prefix
     * @param suffix
     * @return File
     */
    private File getOutputFile(String pack, String table, String prefix, String suffix) {
        StringBuilder sb = new StringBuilder(basePath);
        sb.append("/src/java/");
        sb.append(pack.replaceAll("\\.", "/").concat("/"));
        sb.append(suffix.toLowerCase().concat("/"));
        sb.append(montaNome(table, prefix, suffix).concat(".java"));
        return new File(sb.toString().concat("/"));
    }

    /**
     * Retorna a configuração do Template Engine
     *
     * @return Configuration
     */
    private Configuration getConfig() {
        return new Configuration(new Version("2.3"));
    }

    /**
     * Monta o nome do arquivo .Java a gerar
     *
     * @param table
     * @param prefix
     * @param suffix
     * @return String
     */
    private String montaNome(String table, String prefix, String suffix) {
        return prefix.concat(Texto.capitalize(table).concat(Texto.capitalize(suffix)));
    }
}
