package com.github.saulocalixto.culty.cultyserver.servico;

import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;
import com.github.saulocalixto.culty.cultyserver.repositorio.IUsuarioRepository;
import com.github.saulocalixto.culty.cultyserver.servico.exceptions.ObjetoNaoEncontradoException;
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

    public Usuario consutarPorId(String id) {
        Optional<Usuario> usuario = repo.findById(id);
        return usuario.orElseThrow(() -> new ObjetoNaoEncontradoException("Usuario não encontrado"));
    }

    public Usuario criar(Usuario usuario) {
        return repo.insert(usuario);
    }

    public void deletar (String id) {
        consutarPorId(id);
        repo.deleteById(id);
    }

    public Usuario atualizar (Usuario usuarioParam) {
        Usuario usuarioBanco = consutarPorId(usuarioParam.get_id().toString());
        atualizarDados(usuarioBanco, usuarioParam);
        return repo.save(usuarioBanco);
    }

    private void atualizarDados (Usuario usuarioBanco, Usuario usuarioParam) {
        usuarioBanco.setNomeCulty(usuarioParam.getNomeCulty());
        usuarioBanco.setDescricao(usuarioParam.getDescricao());
        usuarioBanco.setEmail(usuarioParam.getEmail());
        usuarioBanco.setDataDeNascimento(usuarioParam.getDataDeNascimento());
        usuarioBanco.setRedesSociais(usuarioParam.getRedesSociais());
        //usuarioBanco.setLocalizacao(usuarioParam.getLocalizacao());

    }
}
