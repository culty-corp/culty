package com.github.saulocalixto.culty.cultyserver.servico;

import com.github.saulocalixto.culty.cultyserver.dto.DTOPadrao;
import com.github.saulocalixto.culty.cultyserver.model.abstratos.ObjetoPadrao;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoPadrao;
import com.github.saulocalixto.culty.cultyserver.servico.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class ServicoPadrao<T extends ObjetoPadrao, T_REPO extends MongoRepository<T, String>,
        T_DTO extends DTOPadrao<T>> implements IServicoPadrao<T, T_DTO> {

    @Override
    public T consultarPorId(String id) {
        Optional<T> obj = Repositorio().findById(id);
        return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado"));
    }

    @Override
    public T_DTO consultarDTOPorId(String id) {
        return transformarEmDto(consultarPorId(id));
    }

    @Override
    public List<T_DTO> consultarTodos() {
        List<T_DTO> listaDTO= new ArrayList<>();
        for (T t : Repositorio().findAll())
            listaDTO.add(transformarEmDto(t));
        return listaDTO;
    }

    @Override
    public T_DTO criar(T_DTO dto) {
        return transformarEmDto(Repositorio().insert(transformarEmObjeto(dto)));
    }

    @Override
    public T_DTO atualizar(T_DTO dto) {
        return transformarEmDto(Repositorio().save(transformarEmObjeto(dto)));
    }

    @Override
    public void deletar(String id) {
        consultarPorId(id);
        Repositorio().deleteById(id);
    }

    protected abstract T_DTO transformarEmDto(T obj);

    protected abstract T transformarEmObjeto(T_DTO dto);

    @Autowired
    protected abstract T_REPO Repositorio();

}
