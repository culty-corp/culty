package com.github.saulocalixto.culty.cultyserver.controller;

import com.github.saulocalixto.culty.cultyserver.servico.UsuarioServico;
import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServico servico;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> consultarTodos() {

        List<Usuario> lista = servico.consultarTodos();
        return ResponseEntity.ok().body(lista);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> consultarPorId(@PathVariable("id") String id) {
        Usuario usuario = servico.consutarPorId(id);
        return ResponseEntity.ok().body(usuario);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> criar(@RequestBody Usuario usuario) {
        usuario = servico.criar(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.get_id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
        servico.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@PathVariable("id") String id, @RequestBody Usuario usuario) {
        usuario.set_id(new ObjectId(id));
        usuario = servico.atualizar(usuario);
        return ResponseEntity.noContent().build();
    }
}
