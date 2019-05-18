package com.github.saulocalixto.culty.cultyserver.servico;

import com.github.saulocalixto.culty.cultyserver.model.Usuario;
import com.github.saulocalixto.culty.cultyserver.repositorio.IUsuarioRepository;
import com.github.saulocalixto.culty.cultyserver.servico.exceptions.ObjetoNaoEncontradoException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServico {

    @Autowired
    private IUsuarioRepository repo;

    public List<Usuario> consultarTodos() {
        return repo.findAll();
    }

    public Usuario consutarPorId (String id) {
        Optional<Usuario> usuario = repo.findById(id.toString());
        return usuario.orElseThrow(() -> new ObjetoNaoEncontradoException("Usuario não encontrado"));
    }
}
