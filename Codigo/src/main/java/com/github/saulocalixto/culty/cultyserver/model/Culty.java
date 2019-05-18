package com.github.saulocalixto.culty.cultyserver.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class Culty {

    @Id
    public ObjectId _id;

    private String nomeCulty;
    private String descricao;
    private String email;
    private Date dataDeNascimento;

    private List<String> redesSociais;

//    private Localizacao localizacao;


    public Culty() {
    }

    public Culty(String nomeCulty, String descricao, String email) {
        this.nomeCulty = nomeCulty;
        this.descricao = descricao;
        this.email = email;
//        this.dataDeNascimento = dataDeNascimento;
        this.redesSociais = redesSociais;
    }

    public String getNomeCulty() {
        return nomeCulty;
    }

    public void setNomeCulty(String nomeCulty) {
        this.nomeCulty = nomeCulty;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public List<String> getRedesSociais() {
        return redesSociais;
    }

    public void setRedesSociais(List<String> redesSociais) {
        this.redesSociais = redesSociais;
    }



//    public Localizacao getLocalizacao() {
//        return localizacao;
//    }
//
//    public void setLocalizacao(Localizacao localizacao) {
//        this.localizacao = localizacao;
//    }
}
