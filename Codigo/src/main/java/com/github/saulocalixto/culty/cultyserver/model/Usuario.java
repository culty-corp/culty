package com.github.saulocalixto.culty.cultyserver.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Usuario {

    @Id
    public ObjectId _id;

    private String nomeUsuario;
    private String email;
    private String senha;
    private RedesSociais redesSociais;
    private Localizacao localizacao;

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public RedesSociais getRedesSociais() {
        return redesSociais;
    }

    public void setRedesSociais(RedesSociais redesSociais) {
        this.redesSociais = redesSociais;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }
}
