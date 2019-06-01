package com.github.saulocalixto.culty.cultyserver.model.usuario;

import com.github.saulocalixto.culty.cultyserver.model.Localizacao;
import com.github.saulocalixto.culty.cultyserver.model.abstratos.ObjetoPadrao;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document(collection = "usuario")
public class Usuario extends ObjetoPadrao {

    private String nomeUsuario;
    private String descricao;
    private String email;
    private Date dataDeNascimento;
    private Localizacao localizacao;
    private RedesSociais redesSociais;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public Usuario setNomeUsuario(String nomeCulty) {
        this.nomeUsuario = nomeCulty;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Usuario setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public Usuario setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
        return this;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public Usuario setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
        return this;
    }

    public RedesSociais getRedesSociais() {
        return redesSociais;
    }

    public Usuario setRedesSociais(RedesSociais redesSociais) {
        this.redesSociais = redesSociais;
        return this;
    }

}
