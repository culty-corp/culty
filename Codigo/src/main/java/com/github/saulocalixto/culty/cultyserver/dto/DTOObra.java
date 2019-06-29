package com.github.saulocalixto.culty.cultyserver.dto;

import com.github.saulocalixto.culty.cultyserver.model.Obra;
import com.github.saulocalixto.culty.cultyserver.model.enums.TipoConteudo;

import java.util.List;

public class DTOObra extends DTOPadrao<Obra> {

    private String titulo;
    private String tipoMidia;
    private String resumo;
    private byte[] conteudo;
    private String conteudoTexto;
    private int quantGostei;
    private int quantVisualizacoes;

    private DTOUsuario usuario;

    private List<String> filtros;

    public DTOObra(Obra obra) {
        super(obra);

    }

    public DTOObra(){
        super();
    }

    @Override
    protected void ConverteObjetoParaDto(Obra obra) {

        this.setTitulo(obra.getNome());
        this.setTipoMidia(obra.getTipoConteudo().name());
        this.setResumo(obra.getDescricao());
        this.setConteudo(obra.getConteudo());
        this.setQuantGostei(obra.getQuantGostei());
        this.setQuantVisualizacoes(obra.getQuantVisualizacoes());
        this.setConteudoTexto(obra.getConteudoTexto());

        convertaUsuario(obra);

        this.setFiltros(obra.getFiltros());
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipoMidia() {
        return tipoMidia;
    }

    public void setTipoMidia(String tipoMidia) {
        this.tipoMidia = tipoMidia;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
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

    public DTOUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(DTOUsuario usuario) {
        this.usuario = usuario;
    }

    public List<String> getFiltros() {
        return filtros;
    }

    public void setFiltros(List<String> filtros) {
        this.filtros = filtros;
    }

    private void convertaUsuario(Obra obra) {
        if (obra.getUsuario() != null && obra.getUsuario().get_id() != null) {
            this.usuario = new DTOUsuario();
            this.usuario.setId(obra.getUsuario().get_id().toString());
            this.usuario.setNome(obra.getUsuario().getNomeUsuario());
        }
    }

    public String getConteudoTexto() {
        return conteudoTexto;
    }

    public void setConteudoTexto(String conteudoTexto) {
        this.conteudoTexto = conteudoTexto;
    }
}
