package com.github.saulocalixto.culty.cultyserver.model.usuario;

import com.github.saulocalixto.culty.cultyserver.model.usuario.localizacao.Municipio;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Usuario {

    @Id
    public ObjectId _id;

    private String nomeUsuario;
    private String email;
    private String senha;
    private RedesSociais redesSociais;
    private Municipio municipio;

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

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
