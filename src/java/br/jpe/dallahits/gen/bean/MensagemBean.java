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
 * Classe MensagemBean
 *
 * @author Joaov
 */
public class MensagemBean extends AbstractBean<MensagemBean> {

    /** Código da mensagem */
    private long idMsg;
    /** Usuário que escreveu */
    private String usuario;
    /** Mensagem */
    private String msg;

    /** 
     * Construtor da classe MensagemBean
     */
    public MensagemBean() {}

    /** 
     * Retorna o valor do campo Código da mensagem
     * 
     * @return long
     */
    public long getIdMsg() {
        return idMsg;
    }

    /** 
     * Define o valor do campo Código da mensagem
     * 
     * @param idMsg
     */
    public void setIdMsg(long idMsg) {
        this.idMsg = idMsg;
    }

    /** 
     * Retorna o valor do campo Usuário que escreveu
     * 
     * @return String
     */
    public String getUsuario() {
        return usuario;
    }

    /** 
     * Define o valor do campo Usuário que escreveu
     * 
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /** 
     * Retorna o valor do campo Mensagem
     * 
     * @return String
     */
    public String getMsg() {
        return msg;
    }

    /** 
     * Define o valor do campo Mensagem
     * 
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * Retorna o valor das propriedades do bean em um JSONArray
     * 
     * @return JSONArray
     */
    @Override
    public JSONArray toArray() {
        JSONArray obj = new JSONArray();
        obj.add(getIdMsg());
        obj.add(getUsuario());
        obj.add(getMsg());
        return obj;
    }

    /**
     * Gera e retorna um código hash para essa instância de Mensagem
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idMsg);
        hash = 53 * hash + Objects.hashCode(this.usuario);
        hash = 53 * hash + Objects.hashCode(this.msg);
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
        final MensagemBean other = (MensagemBean) obj;
        if (!Objects.equals(this.idMsg, other.idMsg)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.msg, other.msg)) {
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
        return "MensagemBean{" +
                    "idMsg=" + idMsg + ", " +
                    "usuario=" + usuario + ", " +
                    "msg=" + msg + "}";
    }

}
