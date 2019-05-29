package com.github.saulocalixto.culty.cultyserver.servico;

import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;
import com.github.saulocalixto.culty.cultyserver.repositorio.IUsuarioRepository;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoPadrao;
import com.github.saulocalixto.culty.cultyserver.servico.exceptions.ObjetoNaoEncontradoException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServico implements IServicoPadrao<Usuario>{

    @Autowired
    private IUsuarioRepository repo;

    public List<Usuario> consultarTodos() {
        return repo.findAll();
    }

    public Usuario consultarPorId(ObjectId id) {
        Optional<Usuario> usuario = repo.findById(id.toString());
        return usuario.orElseThrow(() -> new ObjetoNaoEncontradoException("Usuario não encontrado"));
    }

    public Usuario criar(Usuario usuario) {
        return repo.insert(usuario);
    }

    public void deletar (ObjectId id) {
        consultarPorId(id);
        repo.deleteById(id.toString());
    }

    public Usuario atualizar (Usuario usuarioParam) {
        Usuario usuarioBanco = consultarPorId(usuarioParam.get_id());
        atualizarDados(usuarioBanco, usuarioParam);
        return repo.save(usuarioBanco);
    }

    private void atualizarDados (Usuario usuarioBanco, Usuario usuarioParam) {
        usuarioBanco.setNomeCulty(usuarioParam.getNomeCulty());
        usuarioBanco.setDescricao(usuarioParam.getDescricao());
        usuarioBanco.setEmail(usuarioParam.getEmail());
        usuarioBanco.setDataDeNascimento(usuarioParam.getDataDeNascimento());
        usuarioBanco.setRedesSociais(usuarioParam.getRedesSociais());
        usuarioBanco.setLocalizacao(usuarioParam.getLocalizacao());

    }
}
