package com.github.saulocalixto.culty.cultyserver.model;

import com.github.saulocalixto.culty.cultyserver.model.abstratos.ObjetoPadrao;
import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Sessao extends ObjetoPadrao {

    private ObjectId token;

    @DBRef(lazy = true)
    private Usuario usuario;

    public ObjectId getToken() {
        return token;
    }

    public Sessao setToken(ObjectId token) {
        this.token = token;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Sessao setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }
}
