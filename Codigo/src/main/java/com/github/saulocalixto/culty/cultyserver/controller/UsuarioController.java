package com.github.saulocalixto.culty.cultyserver.controller;

import com.github.saulocalixto.culty.cultyserver.model.Usuario;
import com.github.saulocalixto.culty.cultyserver.servico.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServico servico;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> consulteTodos() {

        List<Usuario> lista = servico.consultarTodos();
        return ResponseEntity.ok().body(lista);
    }

//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public Culty consulte(@PathVariable("id") ObjectId id) {
//        return repositorio.findBy_id(id);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public void atualize(@PathVariable("id") ObjectId id, @Valid @RequestBody Culty usuario) {
//        usuario.set_id(id);
//        repositorio.save(usuario);
//    }
//
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public Culty crie(@Valid @RequestBody Culty usuario) {
//        usuario.set_id(ObjectId.get());
//        repositorio.save(usuario);
//
//        return usuario;
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void apague(@PathVariable("id") ObjectId id) {
//        repositorio.delete(repositorio.findBy_id(id));
//    }
}
