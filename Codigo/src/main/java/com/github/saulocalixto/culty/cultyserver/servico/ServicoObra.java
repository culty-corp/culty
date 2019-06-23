package com.github.saulocalixto.culty.cultyserver.servico;

import com.github.saulocalixto.culty.cultyserver.model.Obra;
import com.github.saulocalixto.culty.cultyserver.repositorio.IObraRepository;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoObra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoObra extends ServicoPadrao<Obra, IObraRepository> implements IServicoObra {

    @Autowired
    IObraRepository repositorio;

    @Override
    protected IObraRepository Repositorio() {
        return repositorio;
    }

    @Override
    public void addVisualizacao(Obra obra) {
        repositorio.save(obra);
    }
}
