package com.github.saulocalixto.culty.cultyserver.controller;

import com.github.saulocalixto.culty.cultyserver.dto.DTOSessao;
import com.github.saulocalixto.culty.cultyserver.model.Sessao;
import com.github.saulocalixto.culty.cultyserver.servico.ServicoSessao;
import com.github.saulocalixto.culty.cultyserver.servico.ServicoUsuario;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoPadrao;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoSessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;

@CrossOrigin
@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    private ServicoSessao servico;

    @Autowired
    private ServicoUsuario servicoUsuario;

    @Autowired
    protected IServicoSessao Servico() {
        return servico;
    }

    @RequestMapping(value = {"","/"}, method = RequestMethod.POST)
    public ResponseEntity<DTOSessao> login(@RequestBody DTOSessao login) {
        DTOSessao sessao = Servico().efetueLogin(login);
        return ResponseEntity.ok().body(sessao);
    }
}
