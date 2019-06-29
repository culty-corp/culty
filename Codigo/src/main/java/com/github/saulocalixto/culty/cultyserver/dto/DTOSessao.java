package com.github.saulocalixto.culty.cultyserver.dto;

import com.github.saulocalixto.culty.cultyserver.model.Sessao;
import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;
import org.bson.types.ObjectId;

public class DTOSessao extends DTOPadrao<Sessao> {

    private String token;
    private Usuario usuario;

    public DTOSessao(Sessao objeto) {
        super(objeto);
    }

    @Override
    protected void ConverteObjetoParaDto(Sessao objeto) {
        this.token = objeto.getToken().toString();
        this.usuario = objeto.getUsuario();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
