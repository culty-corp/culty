package com.github.saulocalixto.culty.cultyserver.servico;

import com.github.saulocalixto.culty.cultyserver.model.Obra;
import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;
import com.github.saulocalixto.culty.cultyserver.repositorio.IUsuarioRepository;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoObra;
import com.github.saulocalixto.culty.cultyserver.servico.contrato.IServicoUsuario;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ServicoUsuario extends ServicoPadrao<Usuario, IUsuarioRepository> implements IServicoUsuario {

    @Autowired
    IUsuarioRepository repositorioUsuario;

    @Autowired
    IServicoObra servicoObra;

    @Override
    protected IUsuarioRepository Repositorio() {
        return repositorioUsuario;
    }

    @Override
    public Usuario seguir(String idSeguidor, String idSeguido) {
        Usuario seguidor = this.consultarPorId(new ObjectId(idSeguidor));
        Usuario seguido = this.consultarPorId(new ObjectId(idSeguido));
        seguidor.getListaSeguindo().add(seguido);
        return repositorioUsuario.save(seguidor);
    }

    @Override
    public Usuario deixarDeSeguir(String idSeguidor, String idSeguido) {
        Usuario seguidor = this.consultarPorId(new ObjectId(idSeguidor));
        consultarPorId(new ObjectId(idSeguido));        //apenas checa se o usuario existe ou não
        Iterator iterator = seguidor.getListaSeguindo().iterator();
        ObjectId objectIdSeguindo = new ObjectId(idSeguido);
        while (iterator.hasNext()) {
            Usuario usuario = (Usuario) iterator.next();
            if (usuario.get_id().equals(objectIdSeguindo)) {
                iterator.remove();
            }
        }
        return repositorioUsuario.save(seguidor);
    }

    @Override
    public Usuario gostarObra(String idUsuario, String idObra) {
        Usuario usuario = this.consultarPorId(new ObjectId(idUsuario));
        Obra obra = servicoObra.consultarPorId(new ObjectId(idObra));
        usuario.getListaObrasGostadas().add(obra);
        return repositorioUsuario.save(usuario);
    }

    @Override
    public Usuario deixarDeGostarObra(String idUsuario, String idObra) {
        Usuario usuario = this.consultarPorId(new ObjectId(idUsuario));
        servicoObra.consultarPorId(new ObjectId(idObra));   //apenas checa se a obra existe ou não
        Iterator iterator = usuario.getListaObrasGostadas().iterator();
        ObjectId objectIdObra = new ObjectId(idObra);
        while (iterator.hasNext()) {
            Obra obraNaLista = (Obra) iterator.next();
            if (obraNaLista.get_id().equals(objectIdObra)) {
                iterator.remove();
            }
        }
        return repositorioUsuario.save(usuario);
    }
}
