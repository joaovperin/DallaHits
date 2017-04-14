/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package ${package}.dao;

import ${package}.bean.${entidade.nome}Bean;
import ${package}.pk.${entidade.nome}Pk;
import br.jpe.dallahits.util.db.AbstractDAO;
import br.jpe.dallahits.util.db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.jpe.dallahits.exception.DAOException;
import java.sql.SQLException;

/**
 * Classe ${entidade.nome}DAO
 *
 * @author Joaov
 */
public class ${entidade.nome}DAO extends AbstractDAO<${entidade.nome}Bean, ${entidade.nome}Pk> {

    /** SQL para SELECT */
    private static final String SQL_SELECT = "SELECT <#list entidade.attrs as a>${a.nome}<#if a_index < entidade.attrs?size - 1>, </#if></#list> FROM ${entidade.nome?capitalize}";
    /** SQL para INSERT */
    private static final String SQL_INSERT = "INSERT INTO ${entidade.nome?capitalize} (<#list entidade.attrs as a><#if !a.autoIncrement>${a.nome}<#if a_index < entidade.attrs?size - 1>, </#if></#if></#list>) VALUES (<#list entidade.attrs as a><#if !a.autoIncrement> ?<#if a_index < entidade.attrs?size - 1>, </#if></#if></#list> )";

    /** 
     * Construtor da classe ${entidade.nome?cap_first}Pk
     *
     * @param conn
     */
    public ${entidade.nome}DAO(Conexao conn) {
       super(conn);
    }

    /**
     * Realiza o comando Insert na entidade à partir de um bean
     * 
     * @param bean
     * @throws DAOException
     */
    @Override
    public void insert(${entidade.nome}Bean bean) throws DAOException {
        try {
           PreparedStatement pstmt = conn.prepareStatement(getSqlInsert());
<#assign idx = 1>
<#list entidade.attrs as a>
<#if !a.autoIncrement>
    <#if a.tipo = 'Date'>
           pstmt.set${a.tipo?cap_first}(${idx}, new java.sql.Date(bean.get${a.nome?cap_first}().getTime()));
    <#else>
           pstmt.set${a.tipo?cap_first}(${idx}, bean.get${a.nome?cap_first}());
    </#if>
<#assign idx++>
</#if>
</#list>
           pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Realiza uma busca no banco à partir da chave primária do elemento
     * 
     * @param pk
     * @return ${entidade.nome?cap_first}Bean
     * @throws DAOException
     */
    public ${entidade.nome?cap_first}Bean buscaPk(${entidade.nome?cap_first}Pk pk) throws DAOException {
        try {
            String busca = SQL_SELECT.concat(
            " WHERE <#list entidade.attrs as a><#if a.isPk>${a.nome}<#if a_index < entidade.lastKeyAtt>, </#if></#if></#list> = <#list entidade.attrs as a><#if a.isPk> ?<#if a_index < entidade.lastKeyAtt>, </#if></#if></#list>"
            );
            PreparedStatement pstmt = conn.prepareStatement(busca);
<#list entidade.attrs as a>
<#if a.isPk>
            pstmt.set${a.tipo?cap_first}(${a_index + 1}, pk.get${a.nome?cap_first}());
</#if>
</#list>
            return buscaPrimeiro(pstmt);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void update(${entidade.nome}Bean bean) throws DAOException {
        throw new UnsupportedOperationException("${entidade.nome}DAO.update() nao suportado.");
    }

    @Override
    public void delete(${entidade.nome}Bean bean) throws DAOException {
        throw new UnsupportedOperationException("${entidade.nome}DAO.delete() nao suportado.");
    }

    /** 
     * Retorna o comando SQL para executar uma SELECT
     *
     * @return String
     */
    @Override
    protected String getSqlSelect() {
        return SQL_SELECT;
    }

    /** 
     * Retorna o comando SQL para executar uma Insert
     *
     * @return String
     */
    @Override
    protected String getSqlInsert() {
        return SQL_INSERT;
    }
    
    /** 
     * Retorna um Bean à partir de um ResultSet
     *
     * @return ${entidade.nome?cap_first}Bean
     * @throws java.sql.SQLException
     */
    @Override
    protected ${entidade.nome}Bean getBeanFromResultSet(ResultSet rs) throws SQLException {
        ${entidade.nome}Bean bean = new ${entidade.nome}Bean();
<#list entidade.attrs as a>
        bean.set${a.nome?cap_first}(rs.get${a.tipo?cap_first}(${a_index + 1}));
</#list>
        return bean;
    }

}
