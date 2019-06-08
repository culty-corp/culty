package com.github.saulocalixto.culty.cultyserver.model.usuario;

public class RedesSociais {

    private String facebook;
    private String instagram;
    private String youtube;


    public String getFacebook() {
        return facebook;
    }

    public RedesSociais setFacebook(String facebook) {
        this.facebook = facebook;
        return this;
    }

    public String getInstagram() {
        return instagram;
    }

    public RedesSociais setInstagram(String instagram) {
        this.instagram = instagram;
        return this;
    }

    public String getYoutube() {
        return youtube;
    }

    public RedesSociais setYoutube(String youtube) {
        this.youtube = youtube;
        return this;
    }
}
