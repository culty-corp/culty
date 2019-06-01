package com.github.saulocalixto.culty.cultyserver.controller;

import com.github.saulocalixto.culty.cultyserver.servico.ServicoUsuario;
import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoPadrao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/usuarios")
@RestController
public class UsuarioController extends ControllerPadrao<Usuario> {

    @Autowired
    private ServicoUsuario servico;

    @Override
    @Autowired
    protected IServicoPadrao<Usuario> Servico() {
        return servico;
    }
}
