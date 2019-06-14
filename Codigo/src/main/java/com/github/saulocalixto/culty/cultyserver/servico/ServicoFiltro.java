package com.github.saulocalixto.culty.cultyserver.servico;

import com.github.saulocalixto.culty.cultyserver.model.Filtro;
import com.github.saulocalixto.culty.cultyserver.repositorio.IFiltroRepository;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoFiltro;
import org.springframework.beans.factory.annotation.Autowired;

public class ServicoFiltro extends ServicoPadrao<Filtro, IFiltroRepository> implements IServicoFiltro {

    @Autowired
    IFiltroRepository repositorio;

    @Override
    protected IFiltroRepository Repositorio() {
        return repositorio;
    }
}
