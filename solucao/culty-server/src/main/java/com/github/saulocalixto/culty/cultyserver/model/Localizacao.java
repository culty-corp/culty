/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.saulocalixto.culty.cultyserver.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Armazena as informações básica de localização
 * @author Lucas Sampaio Dias
 */
public class Localizacao {
    @Id
    public ObjectId _id;
    
    private String cidade;
    private String estado;
    private String pais;

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
