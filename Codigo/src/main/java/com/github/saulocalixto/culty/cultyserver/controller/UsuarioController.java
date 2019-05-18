package com.github.saulocalixto.culty.cultyserver.controller;

import com.github.saulocalixto.culty.cultyserver.model.Usuario;
import com.github.saulocalixto.culty.cultyserver.servico.UsuarioServico;
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


//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public void atualize(@PathVariable("id") ObjectId id, @Valid @RequestBody Usuario usuario) {
//        usuario.set_id(id);
//        repositorio.save(usuario);
//    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void apague(@PathVariable("id") ObjectId id) {
//        repositorio.delete(repositorio.findBy_id(id));
//    }
}
