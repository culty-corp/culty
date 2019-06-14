package com.github.saulocalixto.culty.cultyserver.controller;

import com.github.saulocalixto.culty.cultyserver.model.Filtro;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoFiltro;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoPadrao;
import org.springframework.beans.factory.annotation.Autowired;

public class FiltroController extends ControllerPadrao<Filtro> {

    @Autowired
    private IServicoFiltro servico;

    @Override
    protected IServicoPadrao<Filtro> Servico() {
        return servico;
    }
}
