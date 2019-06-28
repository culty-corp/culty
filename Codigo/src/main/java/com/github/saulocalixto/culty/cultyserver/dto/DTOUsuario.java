package com.github.saulocalixto.culty.cultyserver.dto;

import com.github.saulocalixto.culty.cultyserver.model.Localizacao;
import com.github.saulocalixto.culty.cultyserver.model.Obra;
import com.github.saulocalixto.culty.cultyserver.model.usuario.RedesSociais;
import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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

    public DTOUsuario(Usuario usuario) {
        super(usuario);
        this.setNomeUsuario(usuario.getNomeUsuario());
        this.setDescricao(usuario.getDescricao());
        this.setEmail(usuario.getEmail());
        this.setDataDeNascimento(formatarData(usuario.getDataDeNascimento()));
        this.setLocalizacao(usuario.getLocalizacao());
        this.setRedesSociais(usuario.getRedesSociais());
        this.setQuantSeguidores(usuario.getQuantSeguidores());
        for (Usuario usuarioDaLista : usuario.getListaSeguindo())
            this.getListaSeguindo().add(usuarioDaLista.get_id().toString());
        for (Obra obraDaLista : usuario.getListaObrasGostadas())
            this.getListaObrasGostadas().add(obraDaLista.get_id().toString());
    }

    public static List<DTOUsuario> conveterLista(List<Usuario> lista) {
        List<DTOUsuario> listaDTO = new ArrayList<>();
        for (Usuario usuario : lista) {
            listaDTO.add(new DTOUsuario(usuario));
        }
        return listaDTO;
    }

    private String formatarData(Date dataDeNascimento) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-3"));
        return sdf.format(dataDeNascimento);
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
