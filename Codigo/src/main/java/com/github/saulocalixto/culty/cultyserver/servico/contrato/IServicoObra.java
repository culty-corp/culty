package com.github.saulocalixto.culty.cultyserver.servico.contrato;

import com.github.saulocalixto.culty.cultyserver.model.Obra;

public interface IServicoObra extends IServicoPadrao<Obra> {
    void addVisualizacao(Obra obra);
}
