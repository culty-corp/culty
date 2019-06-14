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
    private byte[] conteudo;
    private int quantGostei;
    private int quantVisualizacoes;

    @DBRef
    private List<Filtro> filtros;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public List<Filtro> getFiltros() {
        return filtros;
    }

    public void setFiltros(List<Filtro> filtros) {
        this.filtros = filtros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoConteudo getTipoConteudo() {
        return tipoConteudo;
    }

    public void setTipoConteudo(TipoConteudo tipoConteudo) {
        this.tipoConteudo = tipoConteudo;
    }

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }

    public int getQuantidadeGostei() {
        return quantGostei;
    }

    public void setQuantidadeGostei(int quantGostei) {
        this.quantGostei = quantGostei;
    }

    public int getQuantidadeVisualizacoes() {
        return quantVisualizacoes;
    }

    public void setQuantidadeVisualizacoes(int quantiVisualizacoes) {
        this.quantVisualizacoes = quantiVisualizacoes;
    }
}
