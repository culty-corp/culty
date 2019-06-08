package com.github.saulocalixto.culty.cultyserver.servico;

import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;
import com.github.saulocalixto.culty.cultyserver.repositorio.IUsuarioRepository;
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

    @Override
    protected IUsuarioRepository Repositorio() {
        return repositorioUsuario;
    }

    public Usuario seguir(String idSeguidor, String idSeguido) {
        Usuario seguidor = this.consultarPorId(new ObjectId(idSeguidor));
        Usuario seguido = this.consultarPorId(new ObjectId(idSeguido));
        seguidor.getListaSeguindo().add(seguido);
        return repositorioUsuario.save(seguidor);
    }

    public Usuario deixarDeSeguir(String idSeguidor, String idSeguido) {
        Usuario seguidor = this.consultarPorId(new ObjectId(idSeguidor));
        //apenas checa se o usuario existe ou não
        consultarPorId(new ObjectId(idSeguido));
        Iterator iterator = seguidor.getListaSeguindo().iterator();
        while (iterator.hasNext()) {
            Usuario usuario = (Usuario) iterator.next();
            if (usuario.get_id().equals(new ObjectId(idSeguido))) {
                iterator.remove();
            }
        }
        return repositorioUsuario.save(seguidor);
    }
}
