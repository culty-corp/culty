package com.github.saulocalixto.culty.cultyserver.dto;

import com.github.saulocalixto.culty.cultyserver.utilidade.FormatarData;
import com.github.saulocalixto.culty.cultyserver.model.Localizacao;
import com.github.saulocalixto.culty.cultyserver.model.Obra;
import com.github.saulocalixto.culty.cultyserver.model.usuario.RedesSociais;
import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DTOUsuario extends DTOPadrao<Usuario> {

    private String nomeUsuario;
    private String descricao;
    private String email;
    private String dataDeNascimento;
    private Localizacao localizacao;
    private RedesSociais redesSociais;
    private int quantSeguidores;

    private List<String> listaSeguindo = new ArrayList<>();

    private List<String> listaObrasGostadas = new ArrayList<>();

    public DTOUsuario() {
    }

    public DTOUsuario(Usuario usuario) {
        super(usuario);
        if (usuario.getNomeUsuario() != null)
            this.setNomeUsuario(usuario.getNomeUsuario());
        if (usuario.getDescricao() != null)
            this.setDescricao(usuario.getDescricao());
        if (usuario.getEmail() != null)
            this.setEmail(usuario.getEmail());
        if (usuario.getDataDeNascimento() != null)
            this.setDataDeNascimento(FormatarData.formatarData(usuario.getDataDeNascimento()));
        if (usuario.getLocalizacao() != null)
            this.setLocalizacao(usuario.getLocalizacao());
        if (usuario.getRedesSociais() != null)
            this.setRedesSociais(usuario.getRedesSociais());
        this.setQuantSeguidores(usuario.getQuantSeguidores());
        if (usuario.getListaSeguindo() != null)
        for (Usuario usuarioDaLista : usuario.getListaSeguindo())
            if (usuarioDaLista != null && usuarioDaLista.get_id() != null)
                this.getListaSeguindo().add(usuarioDaLista.get_id().toString());
        if (usuario.getListaObrasGostadas() != null)
        for (Obra obraDaLista : usuario.getListaObrasGostadas())
            if (obraDaLista != null && obraDaLista.get_id() != null)
                this.getListaObrasGostadas().add(obraDaLista.get_id().toString());
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
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

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public RedesSociais getRedesSociais() {
        return redesSociais;
    }

    public void setRedesSociais(RedesSociais redesSociais) {
        this.redesSociais = redesSociais;
    }

    public int getQuantSeguidores() {
        return quantSeguidores;
    }

    public void setQuantSeguidores(int quantSeguidores) {
        this.quantSeguidores = quantSeguidores;
    }

    public List<String> getListaSeguindo() {
        return listaSeguindo;
    }

    public void setListaSeguindo(List<String> listaSeguindo) {
        this.listaSeguindo = listaSeguindo;
    }

    public List<String> getListaObrasGostadas() {
        return listaObrasGostadas;
    }

    public void setListaObrasGostadas(List<String> listaObrasGostadas) {
        this.listaObrasGostadas = listaObrasGostadas;
    }
}
