package com.github.saulocalixto.culty.cultyserver.dto;

import com.github.saulocalixto.culty.cultyserver.model.abstratos.ObjetoPadrao;

import java.io.Serializable;

public abstract class DTOPadrao<T extends ObjetoPadrao> implements Serializable {

    private String id;

    public DTOPadrao(T objeto) {
        if (objeto != null && objeto.get_id() != null)
            this.id = objeto.get_id().toString();
        ConverteObjetoParaDto(objeto);
    }

    public DTOPadrao(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    protected abstract void ConverteObjetoParaDto(T objeto);
}
