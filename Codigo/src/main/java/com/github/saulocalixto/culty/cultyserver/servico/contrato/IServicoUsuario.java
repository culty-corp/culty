package com.github.saulocalixto.culty.cultyserver.servico.contrato;

import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;

public interface IServicoUsuario extends IServicoPadrao<Usuario> {
    Usuario seguir(String idSeguidor, String idSeguido);
    Usuario deixarDeSeguir (String idSeguidor, String idSeguido);
    Usuario gostarObra(String idUsuario, String idObra);
    Usuario deixarDeGostarObra(String idUsuario, String idObra);
}
