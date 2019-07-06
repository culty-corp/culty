package com.github.saulocalixto.culty.cultyserver.dto;

import com.github.saulocalixto.culty.cultyserver.model.Sessao;
import com.github.saulocalixto.culty.cultyserver.utilidade.FormatarData;

public class DTOSessao extends DTOPadrao<Sessao> {

    private String token;
    private DTOUsuario usuario;
    private boolean sucesso;

    public DTOSessao(Sessao objeto) {
        super(objeto);
    }

    public DTOSessao(){}

    @Override
    protected void ConverteObjetoParaDto(Sessao objeto) {
        this.token = objeto.getToken().toString();
        convertaUsuario(objeto);
        this.sucesso = this.usuario != null && this.usuario.getId() != null;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DTOUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(DTOUsuario usuario) {
        this.usuario = usuario;
    }

    private void convertaUsuario(Sessao sessao) {
        if (sessao.getUsuario() != null && sessao.getUsuario().get_id() != null) {
            this.usuario = new DTOUsuario();
            this.usuario.setId(sessao.getUsuario().get_id().toString());
            this.usuario.setNome(sessao.getUsuario().getNomeUsuario());
            this.usuario.setRedesSociais(sessao.getUsuario().getRedesSociais());
            this.usuario.setSenha(sessao.getUsuario().getSenha());
            this.usuario.setDataDeNascimento(FormatarData.formatarData(sessao.getUsuario().getDataDeNascimento()));
            this.usuario.setSenha(sessao.getUsuario().getSenha());
        }
    }

    public boolean getSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }
}
