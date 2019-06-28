package com.github.saulocalixto.culty.cultyserver.dto;

import com.github.saulocalixto.culty.cultyserver.model.Obra;

import java.util.ArrayList;
import java.util.List;

public class DTOObra extends DTOPadrao<Obra> {

    private String nome;
    private String tipoConteudo;
    private String descricao;
    private byte[] conteudo;
    private int quantGostei;
    private int quantVisualizacoes;

    private String usuario;

    private List<String> filtros;

    public DTOObra() {
    }

    public DTOObra(Obra obra) {
        super(obra);
        if (obra.getNome() != null)
            this.setNome(obra.getNome());
        if (obra.getTipoConteudo() != null)
            this.setTipoConteudo(obra.getTipoConteudo().name());
        if (obra.getDescricao() != null)
            this.setDescricao(obra.getDescricao());
        if (obra.getConteudo() != null)
            this.setConteudo(obra.getConteudo());
        this.setQuantGostei(obra.getQuantGostei());
        this.setQuantVisualizacoes(obra.getQuantVisualizacoes());
        if (obra.getUsuario() != null && obra.getUsuario().get_id() != null)
            this.setUsuario(obra.getUsuario().get_id().toString());
        if (obra.getFiltros() != null)
        this.setFiltros(obra.getFiltros());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoConteudo() {
        return tipoConteudo;
    }

    public void setTipoConteudo(String tipoConteudo) {
        this.tipoConteudo = tipoConteudo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }

    public int getQuantGostei() {
        return quantGostei;
    }

    public void setQuantGostei(int quantGostei) {
        this.quantGostei = quantGostei;
    }

    public int getQuantVisualizacoes() {
        return quantVisualizacoes;
    }

    public void setQuantVisualizacoes(int quantVisualizacoes) {
        this.quantVisualizacoes = quantVisualizacoes;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<String> getFiltros() {
        return filtros;
    }

    public void setFiltros(List<String> filtros) {
        this.filtros = filtros;
    }
}
