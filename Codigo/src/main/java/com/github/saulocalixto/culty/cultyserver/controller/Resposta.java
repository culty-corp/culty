package com.github.saulocalixto.culty.cultyserver.controller;

public class Resposta<T> {
    private T valor;
    private String mensagem;
    private boolean sucesso;

    public Resposta ObtenhaResposta(T valor, String mensagem, boolean sucesso){
        this.valor = valor;
        this.mensagem = mensagem;
        this.sucesso = sucesso;
        return this;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }
}
