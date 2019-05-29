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
    public Object consulte(ObjectId id) {
        return null;
    }

    @Override
    public List consulteTodos() {
        return repositorio.findAll();
    }

    @Override
    public Object salve(Object objeto) {
        return null;
    }

    @Override
    public void atualize(Object objeto) {

    }

    @Override
    public void exclua(ObjectId id) {

    }

    public T_REPO Repositorio() {
        return repositorio;
    }
}
