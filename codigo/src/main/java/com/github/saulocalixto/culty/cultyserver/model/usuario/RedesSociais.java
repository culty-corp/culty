/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.saulocalixto.culty.cultyserver.model.usuario;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Armazena os links das redes sociais de um Usuário
 * @author Lucas Sampaio Dias
 */
public class RedesSociais {
    @Id
    public ObjectId _id;
    
    private String facebook;
    private String instagram;
    private String youtube;

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }
}
