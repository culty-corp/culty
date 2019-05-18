/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.saulocalixto.culty.cultyserver.model;

import com.github.saulocalixto.culty.cultyserver.model.enums.TipoConteudo;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * @author Lucas Sampaio Dias
 */
public class Obra {
    @Id
    public ObjectId _id;
    
    private String nome;
    private TipoConteudo tipoConteudo;
    private Usuario usuario;
    private byte[] conteudo;
    private int quantGostei;
    private int quantVisualizacoes;
    private String[] macroCategorias;
    private String[] microCategorias;

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

    public String[] getMacroCategorias() {
        return macroCategorias;
    }

    public void setMacroCategorias(String[] macroCategorias) {
        this.macroCategorias = macroCategorias;
    }

    public String[] getMicroCategorias() {
        return microCategorias;
    }

    public void setMicroCategorias(String[] microCategorias) {
        this.microCategorias = microCategorias;
    }
}
