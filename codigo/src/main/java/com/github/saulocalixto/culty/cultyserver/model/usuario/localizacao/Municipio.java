/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.saulocalixto.culty.cultyserver.model.usuario.localizacao;

import com.github.saulocalixto.culty.cultyserver.model.abstratos.ObjetoPadraoCodigoDescricao;

/**
 * Armazena as informações básica de localização
 * @author Lucas Sampaio Dias
 */
public class Municipio extends ObjetoPadraoCodigoDescricao {

    private Estado estado;
    private Pais pais;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
