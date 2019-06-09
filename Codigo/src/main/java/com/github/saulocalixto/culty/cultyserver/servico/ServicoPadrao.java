package com.github.saulocalixto.culty.cultyserver.servico;

import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoPadrao;
import com.github.saulocalixto.culty.cultyserver.servico.exceptions.ObjetoNaoEncontradoException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public abstract class ServicoPadrao<T, T_REPO extends MongoRepository<T, String>> implements IServicoPadrao<T> {

    @Override
    public T consultarPorId(ObjectId id) {
        Optional<T> obj = Repositorio().findById(id.toString());
        return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado"));
    }

    @Override
    public List consultarTodos() {
        return Repositorio().findAll();
    }

    @Override
    public T criar(T objeto) {
        return Repositorio().insert(objeto);
    }

    @Override
    public T atualizar(T objeto) {
        return Repositorio().save(objeto);
    }

    @Override
    public void deletar(ObjectId id) {
        consultarPorId(id);
        Repositorio().deleteById(id.toString());
    }

    @Autowired
    protected abstract T_REPO Repositorio();
}
