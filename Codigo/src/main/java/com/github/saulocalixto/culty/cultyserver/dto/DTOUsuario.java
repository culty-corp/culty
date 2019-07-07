package com.github.saulocalixto.culty.cultyserver.dto;

import com.github.saulocalixto.culty.cultyserver.utilidade.FormatarData;
import com.github.saulocalixto.culty.cultyserver.model.Localizacao;
import com.github.saulocalixto.culty.cultyserver.model.Obra;
import com.github.saulocalixto.culty.cultyserver.model.usuario.RedesSociais;
import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DTOUsuario extends DTOPadrao<Usuario> {

    private String nome;
    private String descricao;
    private String email;
    private String dataDeNascimento;
    private Localizacao localizacao;
    private RedesSociais redesSociais;
    private int quantSeguidores;
    private String senha;

    private List<String> listaSeguindo;

    private List<String> listaObrasGostadas;

    public DTOUsuario(Usuario usuario) {
        super(usuario);

    }

    public DTOUsuario(){
        super();
    }

    @Override
    protected void ConverteObjetoParaDto(Usuario usuario) {

        if (usuario.getNomeUsuario() != null)
            this.setNome(usuario.getNomeUsuario());
        if (usuario.getDescricao() != null)
            this.setDescricao(usuario.getDescricao());
        if (usuario.getEmail() != null)
            this.setEmail(usuario.getEmail());
        if (usuario.getDataDeNascimento() != null)
            this.setDataDeNascimento(FormatarData.formatarData(usuario.getDataDeNascimento()));
        this.setSenha(usuario.getSenha());
        if (usuario.getLocalizacao() != null)
            this.setLocalizacao(usuario.getLocalizacao());
        if (usuario.getRedesSociais() != null)
            this.setRedesSociais(usuario.getRedesSociais());
        this.setQuantSeguidores(usuario.getQuantSeguidores());
        if (usuario.getListaSeguindo() != null)
            for (Usuario usuarioDaLista : usuario.getListaSeguindo())
                if (usuarioDaLista != null && usuarioDaLista.get_id() != null)
                    this.getListaSeguindo().add(usuarioDaLista.get_id().toString());
        List obrasGostadas = this.getListaObrasGostadas();
        if (usuario.getListaObrasGostadas() != null) {
            for (Obra obraDaLista : usuario.getListaObrasGostadas()) {
                if (obraDaLista != null && obraDaLista.get_id() != null) {
                    obrasGostadas.add(obraDaLista.get_id().toString());
                }
            }
            this.setListaObrasGostadas(obrasGostadas);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return listaSeguindo == null ? new ArrayList<>() : listaSeguindo;
    }

    public void setListaSeguindo(List<String> listaSeguindo) {
        this.listaSeguindo = listaSeguindo;
    }

    public List<String> getListaObrasGostadas() {
        return listaObrasGostadas == null ? new ArrayList<>() : listaObrasGostadas;
    }

    public void setListaObrasGostadas(List<String> listaObrasGostadas) {
        this.listaObrasGostadas = listaObrasGostadas;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
