package com.github.saulocalixto.culty.cultyserver.servico.contrato;

import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;

public interface IServicoUsuario extends IServicoPadrao<Usuario> {
    Usuario seguirUsuario(String idSeguidor, String idSeguido);
}
