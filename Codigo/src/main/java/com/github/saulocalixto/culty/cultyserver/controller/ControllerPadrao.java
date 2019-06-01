package com.github.saulocalixto.culty.cultyserver.controller;

import com.github.saulocalixto.culty.cultyserver.model.abstratos.ObjetoPadrao;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoPadrao;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

public abstract class ControllerPadrao<T extends ObjetoPadrao> {

    @Autowired
    protected abstract IServicoPadrao<T> Servico();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<T>> consultarTodos() {
        List<T> lista = Servico().consultarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<T> consultarPorId(@PathVariable("id") String id) {
        ObjectId objectId = new ObjectId(id);
        T objeto = Servico().consultarPorId(objectId);
        return ResponseEntity.ok().body(objeto);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> criar(@RequestBody T objeto) {
        objeto = Servico().criar(objeto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objeto.get_id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
        ObjectId objectId = new ObjectId(id);
        Servico().deletar(objectId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@PathVariable("id") String id, @RequestBody T objeto) {
        objeto.set_id(new ObjectId(id));
        Servico().atualizar(objeto);
        return ResponseEntity.noContent().build();
    }
}
