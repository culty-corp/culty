package com.github.saulocalixto.culty.cultyserver.servico;

import com.github.saulocalixto.culty.cultyserver.repositorio.IUsuarioRepository;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoPadrao;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public abstract class ServicoPadrao<T, T_REPO extends MongoRepository<T, String>> implements IServicoPadrao {

    @Autowired
    private T_REPO repositorio;

    @Override
    public Object consultarPorId(ObjectId id) {
        return null;
    }

    @Override
    public List consultarTodos() {
        return repositorio.findAll();
    }

    @Override
    public Object criar(Object objeto) {
        return null;
    }

    @Override
    public T atualizar(Object objeto) {
        return null;
    }

    @Override
    public void deletar(ObjectId id) {

    }

    public T_REPO Repositorio() {
        return repositorio;
    }
}
