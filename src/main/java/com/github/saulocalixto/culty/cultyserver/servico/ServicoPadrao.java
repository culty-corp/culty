package com.github.saulocalixto.culty.cultyserver.servico;

import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoPadrao;
import org.bson.types.ObjectId;

import java.util.List;

public abstract class ServicoPadrao<T> implements IServicoPadrao {
    @Override
    public Object consulte(ObjectId id) {
        return null;
    }

    @Override
    public List consulteTodos() {
        return null;
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
}
