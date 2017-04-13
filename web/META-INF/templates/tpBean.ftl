/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.bean;

import br.jpe.dallahits.util.db.AbstractBean;
import java.util.Objects;
<#list attr as a>
<#if a.tipo = 'Date'>
import java.util.Date;
<#break>
</#if>
</#list>

/**
 * Classe ${name}
 *
 * @author Joaov
 */
public class ${name}Bean extends AbstractBean<${name}Bean>{

        /** ${a.descricao?cap_first} */
    ${a.acesso} ${a.tipo} ${a.nome};

    ${entidade}

    <#if a.tipo == "boolean">
    public ${a.tipo} is${a.nome?cap_first}() {
        return ${a.nome};
    }
<#else>
    public ${a.tipo} get${a.nome?cap_first}() {
        return ${a.nome};
    }
</#if>

    @Override
    public String toString() {
        return "${entidade}Bean{" +
<#list atributos as a>
<#if a_has_next>
                    "${a.nome}=" + ${a.nome} + ", " +
<#else>
                    "${a.nome}=" + ${a.nome} + "}";
</#if>
</#list>
    }

    public Pk getPk() {
        return new ${entidade}Pk(<#list atributos as a><#if a.isPk>get${a.nome?cap_first}()<#if a_index < last_att_key>, </#if></#if></#list>);
    }

    public ${entidade}Bean() {}

    public void set${a.nome?cap_first}(${a.tipo} ${a.nome}) {
        this.${a.nome} = ${a.nome};
    }

  <#list atributos as a>
    /** ${a.descricao?cap_first} */
    ${a.acesso} ${a.tipo} ${a.nome};
</#list>

    @Override
    public String toString() {
        return "ProdutoBean{" + "idProduto=" + idProduto + ", descricao=" + descricao + ", ValorUnitario=" + ValorUnitario + '}';
    }

}
