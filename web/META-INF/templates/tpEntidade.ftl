/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package ${package}.entidade;

import br.jpe.dallahits.util.db.AbstractEntidade;
import ${package}.bean.${entidade.nome}Bean;
import ${package}.pk.${entidade.nome}Pk;
import org.json.simple.JSONArray;

/**
 * Classe ${entidade.nome}Entidade
 *
 * @author Joaov
 */
public class ${entidade.nome}Entidade extends AbstractEntidade<${entidade.nome}Bean, ${entidade.nome}Pk> {

    /** 
     * Construtor da classe ${entidade.nome?cap_first}Entidade
     */
    public ${entidade.nome}Entidade() {}
    
    @Override
    public JSONArray getTitulos() {
       JSONArray titulos = new JSONArray();       
<#list entidade.attrs as a>
        titulos.add("${a.descricao?cap_first}");
</#list>
       return titulos;
    }
     
    @Override
    public JSONArray getColunas() {
       JSONArray colunas = new JSONArray();
<#list entidade.attrs as a>
        colunas.add("${a.nome}");
</#list>
       return colunas;
    }

}
