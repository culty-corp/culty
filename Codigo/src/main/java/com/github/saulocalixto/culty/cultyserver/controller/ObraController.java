package com.github.saulocalixto.culty.cultyserver.controller;

import com.github.saulocalixto.culty.cultyserver.controller.utilidade.URL;
import com.github.saulocalixto.culty.cultyserver.model.Obra;
import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoObra;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoPadrao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/obras")
@RestController
public class ObraController extends ControllerPadrao<Obra> {

    @Autowired
    private IServicoObra servico;

    @Override
    protected IServicoPadrao<Obra> Servico() {
        return servico;
    }

    @RequestMapping(value = "/consultarPorFiltro", method = RequestMethod.GET)
    public ResponseEntity<List<Obra>> consultarPorFiltro(@RequestParam(value = "text", defaultValue = "")
                                                                         String text) {
        text = URL.decodeParam(text);
        text = text.toLowerCase();
        List<Obra> list = servico.consultarPorFiltro(text);
        return ResponseEntity.ok().body(list);
    }
}
