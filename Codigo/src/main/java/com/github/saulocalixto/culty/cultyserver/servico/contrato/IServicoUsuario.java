package com.github.saulocalixto.culty.cultyserver.servico.contrato;

import com.github.saulocalixto.culty.cultyserver.dto.DTOUsuario;
import com.github.saulocalixto.culty.cultyserver.model.usuario.Usuario;

import java.util.List;

public interface IServicoUsuario extends IServicoPadrao<Usuario, DTOUsuario> {
    Usuario seguir(String idSeguidor, String idSeguido);
    Usuario deixarDeSeguir (String idSeguidor, String idSeguido);
    Usuario gostarObra(String idUsuario, String idObra);
    Usuario deixarDeGostarObra(String idUsuario, String idObra);
    List<DTOUsuario> consultarPorNomeUsuario (String text);
}
