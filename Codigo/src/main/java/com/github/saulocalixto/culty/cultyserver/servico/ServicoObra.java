package com.github.saulocalixto.culty.cultyserver.servico;

import com.github.saulocalixto.culty.cultyserver.dto.DTOObra;
import com.github.saulocalixto.culty.cultyserver.model.Obra;
import com.github.saulocalixto.culty.cultyserver.model.enums.TipoConteudo;
import com.github.saulocalixto.culty.cultyserver.repositorio.IObraRepository;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoObra;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoUsuario;
import com.github.saulocalixto.culty.cultyserver.servico.exceptions.TipoConteudoInvalido;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoObra extends ServicoPadrao<Obra, IObraRepository, DTOObra> implements IServicoObra {

    @Autowired
    IObraRepository repositorio;

    @Autowired
    IServicoUsuario servicoUsuario;

    @Override
    protected IObraRepository Repositorio() {
        return repositorio;
    }

    @Override
    protected DTOObra transformarEmDto(Obra obra) {
        return new DTOObra(obra);
    }

    @Override
    protected Obra transformarEmObjeto(DTOObra dto) {
        Obra obra = new Obra();
        if (dto.getId() != null)
            obra.set_id(new ObjectId(dto.getId()));
        if (dto.getNome() != null)
            obra.setNome(dto.getNome());
        if (dto.getTipoConteudo() != null)
            try {
            obra.setTipoConteudo(TipoConteudo.valueOf(dto.getTipoConteudo()));
            } catch (Exception e) {
            throw new TipoConteudoInvalido("O tipo de conteudo informado na obra é invalido");
            }
        if (dto.getUsuario() != null)
            obra.setUsuario(servicoUsuario.consultarPorId(dto.getUsuario()));
        if (dto.getDescricao() != null)
            obra.setDescricao(dto.getDescricao());
        if (dto.getConteudo() != null)
            obra.setConteudo(dto.getConteudo());
        if (dto.getQuantGostei() > 0)
        obra.setQuantGostei(dto.getQuantGostei());
        else obra.setQuantGostei(0);
        if (dto.getQuantVisualizacoes() > 0)
        obra.setQuantVisualizacoes(dto.getQuantVisualizacoes());
        else obra.setQuantVisualizacoes(0);
        if (dto.getFiltros() != null)
        obra.setFiltros(dto.getFiltros());
        return obra;
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

    public List<DTOObra> consultarPorFiltro (String[] filtro) {
        List<DTOObra> lista = new ArrayList<>();
        for (Obra obra : repositorio.findByFiltrosContainingIgnoreCase(filtro))
            lista.add(transformarEmDto(obra));
        return lista;
    }


}
