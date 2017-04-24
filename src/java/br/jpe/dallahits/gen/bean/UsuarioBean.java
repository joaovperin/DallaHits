/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * ESTE FONTE É GERADO E NÃO DEVE SER ALTERADO.
 */
package br.jpe.dallahits.gen.bean;

import br.jpe.dallahits.generics.AbstractBean;
import java.util.Objects;
import org.json.simple.JSONArray;

/**
 * Classe UsuarioBean
 *
 * @author Joaov
 */
public class UsuarioBean extends AbstractBean<UsuarioBean> {

    /** Código */
    private int idUsuario;
    /** Login */
    private String login;
    /** Email */
    private String email;
    /** Senha */
    private String senha;
    /** Nome */
    private String nome;
    /** Tipo */
    private String tipo;

    /** 
     * Construtor da classe UsuarioBean
     */
    public UsuarioBean() {}

    /** 
     * Retorna o valor do campo Código
     * 
     * @return int
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /** 
     * Define o valor do campo Código
     * 
     * @param idUsuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /** 
     * Retorna o valor do campo Login
     * 
     * @return String
     */
    public String getLogin() {
        return login;
    }

    /** 
     * Define o valor do campo Login
     * 
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /** 
     * Retorna o valor do campo Email
     * 
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /** 
     * Define o valor do campo Email
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** 
     * Retorna o valor do campo Senha
     * 
     * @return String
     */
    public String getSenha() {
        return senha;
    }

    /** 
     * Define o valor do campo Senha
     * 
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /** 
     * Retorna o valor do campo Nome
     * 
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /** 
     * Define o valor do campo Nome
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** 
     * Retorna o valor do campo Tipo
     * 
     * @return String
     */
    public String getTipo() {
        return tipo;
    }

    /** 
     * Define o valor do campo Tipo
     * 
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna o valor das propriedades do bean em um JSONArray
     * 
     * @return JSONArray
     */
    @Override
    public JSONArray toArray() {
        JSONArray obj = new JSONArray();
        obj.add(getIdUsuario());
        obj.add(getLogin());
        obj.add(getEmail());
        obj.add(getSenha());
        obj.add(getNome());
        obj.add(getTipo());
        return obj;
    }

    /**
     * Gera e retorna um código hash para essa instância de Usuario
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idUsuario);
        hash = 53 * hash + Objects.hashCode(this.login);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.senha);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    /**
     * Retorna verdadeiro se os dois objetos forem iguais
     *
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioBean other = (UsuarioBean) obj;
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return true;
    }

    /**
     * Retorna a representação do campo em String
     *
     * @return String
     */
    @Override
    public String toString() {
        return "UsuarioBean{" +
                    "idUsuario=" + idUsuario + ", " +
                    "login=" + login + ", " +
                    "email=" + email + ", " +
                    "senha=" + senha + ", " +
                    "nome=" + nome + ", " +
                    "tipo=" + tipo + "}";
    }

}
