/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.saulocalixto.culty.cultyserver.model;

import com.github.saulocalixto.culty.cultyserver.model.abstratos.ObjetoPadrao;
import com.github.saulocalixto.culty.cultyserver.model.enums.TipoConteudo;
import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author Lucas Sampaio Dias
 */
@Document(collection = "obra")
public class Obra extends ObjetoPadrao {
    
    private String nome;
    private TipoConteudo tipoConteudo;

    @DBRef
    private Usuario usuario;

    private String descricao;
    private int quantGostei;
    private int quantVisualizacoes;
    private byte[] conteudo;
    private String conteudoTexto;

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }

    private List<String> filtros;

    public String getDescricao() {
        return descricao;
    }

    public Obra setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public int getQuantGostei() {
        return quantGostei;
    }

    public Obra setQuantGostei(int quantGostei) {
        this.quantGostei = quantGostei < 0 ? 0 : quantGostei;
        return this;
    }

    public int getQuantVisualizacoes() {
        return quantVisualizacoes;
    }

    public Obra setQuantVisualizacoes(int quantVisualizacoes) {
        this.quantVisualizacoes = quantVisualizacoes < 0 ? 0 : quantVisualizacoes;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Obra setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Obra setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public TipoConteudo getTipoConteudo() {
        return tipoConteudo;
    }

    public Obra setTipoConteudo(TipoConteudo tipoConteudo) {
        this.tipoConteudo = tipoConteudo;
        return this;
    }

    public List<String> getFiltros() {
        return filtros;
    }

    public Obra setFiltros(List<String> filtros) {
        this.filtros = filtros;
        return this;
    }

    public String getConteudoTexto() {
        return conteudoTexto;
    }

    public void setConteudoTexto(String conteudoTexto) {
        this.conteudoTexto = conteudoTexto;
    }
}
