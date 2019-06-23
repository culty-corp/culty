package com.github.saulocalixto.culty.cultyserver.controller;

import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoPadrao;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/usuarios")
@RestController
public class UsuarioController extends ControllerPadrao<Usuario> {

    @Autowired
    private IServicoUsuario servico;

    @Override
    protected IServicoPadrao<Usuario> Servico() {
        return servico;
    }

    @RequestMapping(value = "/seguir/{idseguidor}/{idseguido}", method = RequestMethod.PUT)
    public ResponseEntity<Void> seguirUsuario(@PathVariable String idseguidor, @PathVariable String idseguido) {
        servico.seguir(idseguidor, idseguido);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/deixarDeSeguir/{idseguidor}/{idseguido}", method = RequestMethod.PUT)
    public ResponseEntity<Void> deixarDeSeguir(@PathVariable String idseguidor, @PathVariable String idseguido) {
        servico.deixarDeSeguir(idseguidor, idseguido);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/gostar/{idUsuario}/{idObra}", method = RequestMethod.PUT)
    public ResponseEntity<Void> gostarObra(@PathVariable String idUsuario, @PathVariable String idObra) {
        servico.gostarObra(idUsuario, idObra);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/deixarDeGostar/{idUsuario}/{idObra}", method = RequestMethod.PUT)
    public ResponseEntity<Void> deixarDeGostarObra(@PathVariable String idUsuario, @PathVariable String idObra) {
        servico.deixarDeGostarObra(idUsuario, idObra);
        return ResponseEntity.noContent().build();
    }
}
