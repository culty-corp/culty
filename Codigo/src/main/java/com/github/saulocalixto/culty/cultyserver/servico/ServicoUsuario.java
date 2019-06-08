package com.github.saulocalixto.culty.cultyserver.servico;

import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;
import com.github.saulocalixto.culty.cultyserver.repositorio.IUsuarioRepository;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoPadrao;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoUsuario;
import com.github.saulocalixto.culty.cultyserver.servico.exceptions.ObjetoNaoEncontradoException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoUsuario extends ServicoPadrao<Usuario, IUsuarioRepository> implements IServicoUsuario {

    @Autowired
    IUsuarioRepository repositorioUsuario;

    @Override
    protected IUsuarioRepository Repositorio() {
        return repositorioUsuario;
    }

    public Usuario seguirUsuario(String idSeguidor, String idSeguido) {
        Usuario seguidor = this.consultarPorId(new ObjectId(idSeguidor));
        Usuario seguido = this.consultarPorId(new ObjectId(idSeguido));
        seguidor.getListaSeguindo().add(seguido);
        return repositorioUsuario.save(seguidor);
    }
}
