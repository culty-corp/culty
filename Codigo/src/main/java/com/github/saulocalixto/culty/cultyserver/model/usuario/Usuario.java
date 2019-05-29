package com.github.saulocalixto.culty.cultyserver.model.usuario;

import com.github.saulocalixto.culty.cultyserver.model.Localizacao;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document(collection = "usuario")
public class Usuario implements Serializable {

    @Id
    private ObjectId _id;

    private String nomeCulty;
    private String descricao;
    private String email;
    private Date dataDeNascimento;
    private Localizacao localizacao;
    private RedesSociais redeSocial;


    public Usuario() {
    }

    public Usuario(String nomeCulty, String descricao, String email, Date dataDeNascimento, List<String> redesSociais,
                   Localizacao localizacao) {
        this.nomeCulty = nomeCulty;
        this.descricao = descricao;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
        this.localizacao = localizacao;
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

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Localizacao getLocalizacao() {
        return localizacao;

    }
}
