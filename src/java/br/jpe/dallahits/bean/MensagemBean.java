/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.dallahits.bean;

import br.jpe.dallahits.util.db.AbstractBean;
import java.util.Objects;

/**
 * Classe Mensagem
 *
 * @author Joaov
 */
public class MensagemBean extends AbstractBean<MensagemBean> {

    private long idMsg;
    private String usuario;
    private String msg;

    public long getIdMsg() {
        return idMsg;
    }

    public void setIdMsg(long idMsg) {
        this.idMsg = idMsg;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (int) (this.idMsg ^ (this.idMsg >>> 32));
        hash = 83 * hash + Objects.hashCode(this.usuario);
        hash = 83 * hash + Objects.hashCode(this.msg);
        return hash;
    }

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
        if (this.idMsg != other.idMsg) {
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

    @Override
    public String toString() {
        return "MensagemBean{" + "idMsg=" + idMsg + ", usuario=" + usuario + ", msg=" + msg + '}';
    }

}
