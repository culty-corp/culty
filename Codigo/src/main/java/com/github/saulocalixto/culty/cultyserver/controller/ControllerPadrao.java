package com.github.saulocalixto.culty.cultyserver.controller;

import com.github.saulocalixto.culty.cultyserver.dto.DTOPadrao;
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
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public abstract class ControllerPadrao<T extends ObjetoPadrao, T_DTO extends DTOPadrao<T>> {

    @Autowired
    protected abstract IServicoPadrao<T, T_DTO> Servico();

    @RequestMapping(value = {"","/"}, method = RequestMethod.GET)
    public ResponseEntity<List<T_DTO>> consultarTodos() {
        List<T_DTO> lista = Servico().consultarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<T_DTO> consultarPorId(@PathVariable("id") String id) {
        T_DTO objeto = Servico().consultarDTOPorId(id);
        return ResponseEntity.ok().body(objeto);
    }

    @RequestMapping(value = {"","/"}, method = RequestMethod.POST)
    public ResponseEntity<Void> criar(@RequestBody T_DTO objeto) {
        objeto = Servico().criar(objeto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objeto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
        Servico().deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@PathVariable("id") String id, @RequestBody T_DTO objeto) {
        objeto.setId(id);
        Servico().atualizar(objeto);
        return ResponseEntity.noContent().build();
    }
}
