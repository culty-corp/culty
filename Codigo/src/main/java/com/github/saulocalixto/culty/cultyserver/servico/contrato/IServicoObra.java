package com.github.saulocalixto.culty.cultyserver.servico.contrato;

import com.github.saulocalixto.culty.cultyserver.model.Obra;

import java.util.List;

public interface IServicoObra extends IServicoPadrao<Obra> {
    void addVisualizacao(Obra obra);
    void addGostei (Obra obra);
    void removerGostei (Obra obra);
    List<Obra> consultarPorFiltro (String[] filtro);
}
