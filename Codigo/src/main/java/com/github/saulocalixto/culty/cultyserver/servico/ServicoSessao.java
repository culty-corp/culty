package com.github.saulocalixto.culty.cultyserver.servico;

import com.github.saulocalixto.culty.cultyserver.dto.DTOSessao;
import com.github.saulocalixto.culty.cultyserver.dto.DTOUsuario;
import com.github.saulocalixto.culty.cultyserver.model.Sessao;
import com.github.saulocalixto.culty.cultyserver.repositorio.ISessaoRepository;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoSessao;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoUsuario;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoSessao extends ServicoPadrao<Sessao, ISessaoRepository, DTOSessao> implements IServicoSessao {

    @Autowired
    IServicoUsuario servicoUsuario;

    @Override
    protected DTOSessao transformarEmDto(Sessao obj) {
        return new DTOSessao(obj);
    }

    @Override
    protected Sessao transformarEmObjeto(DTOSessao dtoSessao) {

        Sessao sessao = new Sessao();

        sessao.setToken(dtoSessao.getToken() != null ? new ObjectId(dtoSessao.getToken()) : new ObjectId())
                .setUsuario(servicoUsuario.consultarPorId(dtoSessao.getUsuario().getId()));

        return sessao;
    }

    @Override
    protected ISessaoRepository Repositorio() {
        return null;
    }

    @Override
    public DTOSessao efetueLogin(DTOSessao sessao) {
        DTOUsuario dtoUsuario = servicoUsuario.valideEmailESenha(sessao.getUsuario().getEmail(), sessao.getUsuario().getSenha());
        sessao.setUsuario(dtoUsuario);
        sessao.setSucesso(dtoUsuario != null && dtoUsuario.getId() != null);
        if(sessao.getSucesso()) {
            sessao.setToken(new ObjectId().toString());
        }
        return sessao;
    }
}
