package com.github.saulocalixto.culty.cultyserver.controller;

import com.github.saulocalixto.culty.cultyserver.model.Localizacao;
import com.github.saulocalixto.culty.cultyserver.model.usuario.RedesSociais;
import com.github.saulocalixto.culty.cultyserver.servico.ServicoUsuario;
import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoPadrao;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoUsuario;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RequestMapping("/usuarios")
@RestController
public class UsuarioController extends ControllerPadrao<Usuario> {

    @Autowired
    private IServicoUsuario servico;

    @Override
    protected IServicoPadrao<Usuario> Servico() {
        return servico;
    }

    @RequestMapping(value = "/se", method = RequestMethod.PUT)
    public ResponseEntity<Void> seguirUsuario(@PathVariable("id") String id, @RequestBody Usuario objeto) {
        objeto = new Usuario()
                        .setDescricao("Usuarío novo")
                        .setEmail("sauloacalixto@gmail.com")
                        .setLocalizacao(new Localizacao())
                        .setNomeUsuario("saulocalixto")
                        .setRedesSociais(new RedesSociais());
        return ResponseEntity.noContent().build();
    }
}
