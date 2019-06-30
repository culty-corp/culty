package com.github.saulocalixto.culty.cultyserver.servico.contrato;

import com.github.saulocalixto.culty.cultyserver.dto.DTOSessao;
import com.github.saulocalixto.culty.cultyserver.model.Sessao;

public interface IServicoSessao extends IServicoPadrao<Sessao, DTOSessao> {
    DTOSessao efetueLogin(DTOSessao sessao);
}
