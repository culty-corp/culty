package com.github.saulocalixto.culty.cultyserver.controller;

import com.github.saulocalixto.culty.cultyserver.model.Obra;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoObra;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoPadrao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/obras")
@RestController
public class ObraController extends ControllerPadrao<Obra> {

    @Autowired
    private IServicoObra servico;

    @Override
    protected IServicoPadrao<Obra> Servico() {
        return servico;
    }
}
