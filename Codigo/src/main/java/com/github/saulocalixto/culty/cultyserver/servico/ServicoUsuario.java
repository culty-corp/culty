package com.github.saulocalixto.culty.cultyserver.servico;

import com.github.saulocalixto.culty.cultyserver.dto.DTOUsuario;
import com.github.saulocalixto.culty.cultyserver.model.Obra;
import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;
import com.github.saulocalixto.culty.cultyserver.repositorio.IUsuarioRepository;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoObra;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoUsuario;
import com.github.saulocalixto.culty.cultyserver.utilidade.FormatarData;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ServicoUsuario extends ServicoPadrao<Usuario, IUsuarioRepository, DTOUsuario> implements IServicoUsuario {

    @Autowired
    IUsuarioRepository repositorioUsuario;

    @Autowired
    IServicoObra servicoObra;

    @Override
    protected IUsuarioRepository Repositorio() {
        return repositorioUsuario;
    }

    @Override
    protected DTOUsuario transformarEmDto(Usuario usuario) {
        return new DTOUsuario(usuario);
    }

    @Override
    protected Usuario transformarEmObjeto(DTOUsuario dto) {
        Usuario usuario = new Usuario();
        if (dto.getId() != null)
            usuario.set_id(new ObjectId(dto.getId()));
        if (dto.getNomeUsuario() != null)
            usuario.setNomeUsuario(dto.getNomeUsuario());
        if (dto.getDescricao() != null)
                usuario.setDescricao(dto.getDescricao());
        if (dto.getEmail() != null)
                usuario.setEmail(dto.getEmail());
        if (dto.getDataDeNascimento() != null)
                usuario.setDataDeNascimento(FormatarData.parsearData(dto.getDataDeNascimento()));
        if (dto.getLocalizacao() != null)
                usuario.setLocalizacao(dto.getLocalizacao());
        if (dto.getRedesSociais() != null)
                usuario.setRedesSociais(dto.getRedesSociais());
        if (dto.getQuantSeguidores() > 0)
        usuario.setQuantSeguidores(dto.getQuantSeguidores());
        else usuario.setQuantSeguidores(0);

        List<Usuario> listaSeguindo = usuario.getListaSeguindo();
        if (dto.getListaSeguindo() != null)
        for (String idUsuario : dto.getListaSeguindo())
            listaSeguindo.add(consultarPorId(idUsuario));

        List<Obra> listaObras = usuario.getListaObrasGostadas();
        if (dto.getListaObrasGostadas() != null)
        for (String idObra : dto.getListaObrasGostadas())
            listaObras.add(servicoObra.consultarPorId(idObra));

        return usuario;
    }

    @Override
    public Usuario seguir(String idSeguidor, String idSeguido) {
        Usuario seguidor = this.consultarPorId(idSeguidor);
        Usuario seguido = this.consultarPorId(idSeguido);
        addSeguidor(seguido);
        seguidor.getListaSeguindo().add(seguido);
        return repositorioUsuario.save(seguidor);
    }

    @Override
    public Usuario deixarDeSeguir(String idSeguidor, String idSeguido) {
        Usuario seguidor = this.consultarPorId(idSeguidor);
        Usuario seguido = this.consultarPorId(idSeguido);        //checa se o usuario existe ou não
        Iterator iterator = seguidor.getListaSeguindo().iterator();
        ObjectId objectIdSeguindo = new ObjectId(idSeguido);
        while (iterator.hasNext()) {
            Usuario usuario = (Usuario) iterator.next();
            if (usuario.get_id().equals(objectIdSeguindo)) {
                iterator.remove();
                removerSeguidor(seguido);
            }
        }
        return repositorioUsuario.save(seguidor);
    }

    @Override
    public Usuario gostarObra(String idUsuario, String idObra) {
        Usuario usuario = this.consultarPorId(idUsuario);
        Obra obra = servicoObra.consultarPorId(idObra);
        usuario.getListaObrasGostadas().add(obra);
        servicoObra.addGostei(obra);
        return repositorioUsuario.save(usuario);
    }

    @Override
    public Usuario deixarDeGostarObra(String idUsuario, String idObra) {
        Usuario usuario = this.consultarPorId(idUsuario);
        Obra obra = servicoObra.consultarPorId(idObra);   //checa se a obra existe ou não
        Iterator iterator = usuario.getListaObrasGostadas().iterator();
        while (iterator.hasNext()) {
            Obra obraNaLista = (Obra) iterator.next();
            if (obraNaLista.get_id().equals(obra.get_id())) {
                iterator.remove();
                servicoObra.removerGostei(obra);
            }
        }
        return repositorioUsuario.save(usuario);
    }

    private void addSeguidor(Usuario usuario) {
        usuario.setQuantSeguidores(usuario.getQuantSeguidores() + 1);
        repositorioUsuario.save(usuario);
    }

    private void removerSeguidor(Usuario usuario) {
        usuario.setQuantSeguidores(usuario.getQuantSeguidores() - 1);
        if (usuario.getQuantSeguidores() < 0)
            usuario.setQuantSeguidores(0);
        repositorioUsuario.save(usuario);
    }

    public List<DTOUsuario> consultarPorNomeUsuario(String text) {
        List<DTOUsuario> lista = new ArrayList<>();
        for (Usuario usuario : repositorioUsuario.findByNomeUsuarioContainingIgnoreCase(text))
            lista.add(transformarEmDto(usuario));
        return lista;
    }
}
