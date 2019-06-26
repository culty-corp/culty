package com.github.saulocalixto.culty.cultyserver.servico;

import com.github.saulocalixto.culty.cultyserver.model.Obra;
import com.github.saulocalixto.culty.cultyserver.repositorio.IObraRepository;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoObra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        obra.setQuantVisualizacoes(obra.getQuantVisualizacoes() + 1);
        repositorio.save(obra);
    }

    public void addGostei (Obra obra) {
        obra.setQuantGostei(obra.getQuantGostei() + 1);
        repositorio.save(obra);
    }

    public void removerGostei (Obra obra) {
        obra.setQuantGostei(obra.getQuantGostei() - 1);
        if (obra.getQuantGostei() < 0)
            obra.setQuantGostei(0);
        repositorio.save(obra);
    }

    public List<Obra> consultarPorFiltro (String filtro) {
        return repositorio.findByFiltrosContainingIgnoreCase(filtro);
    }


}
