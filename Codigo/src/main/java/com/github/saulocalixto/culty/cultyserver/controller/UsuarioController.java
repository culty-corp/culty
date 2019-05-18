package com.github.saulocalixto.culty.cultyserver.controller;

import com.github.saulocalixto.culty.cultyserver.model.Culty;
import com.github.saulocalixto.culty.cultyserver.repositorio.IUsuarioRepository;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioRepository repositorio;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Culty>> consulteTodos() {
        Culty maria = new Culty("maria", "cantora de opera", "maria@email.com");

        List<Culty> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(maria));
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
