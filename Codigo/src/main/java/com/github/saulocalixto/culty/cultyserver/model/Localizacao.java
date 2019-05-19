/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.saulocalixto.culty.cultyserver.model;

/**
 * Armazena as informações básica de localização
 * No banco de dados Localização está aninhado a usuário
 *
 * @author Lucas Sampaio Dias
 */
public class Localizacao {

    private String cidade;
    private String estado;
    private String pais;

    public Localizacao() {
    }

    public Localizacao(String cidade, String estado, String pais) {
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
