package com.github.saulocalixto.culty.cultyserver.controller;

import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;
import com.github.saulocalixto.culty.cultyserver.repositorio.IUsuarioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioRepository repositorio;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Usuario> consulteTodos() {
        return repositorio.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Usuario consulte(@PathVariable("id") ObjectId id) {
        return repositorio.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void atualize(@PathVariable("id") ObjectId id, @Valid @RequestBody Usuario usuario) {
        usuario.set_id(id);
        repositorio.save(usuario);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Usuario crie(@Valid @RequestBody Usuario usuario) {
        usuario.set_id(ObjectId.get());
        repositorio.save(usuario);

        return usuario;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void apague(@PathVariable("id") ObjectId id) {
        repositorio.delete(repositorio.findBy_id(id));
    }
}
