package com.github.saulocalixto.culty.cultyserver.model;

import com.github.saulocalixto.culty.cultyserver.model.abstratos.ObjetoPadrao;
import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Sessao extends ObjetoPadrao {

    private ObjectId token;

    @DBRef(lazy = false)
    private Usuario usuario;

    public ObjectId getToken() {
        return token;
    }

    public void setToken(ObjectId token) {
        this.token = token;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
