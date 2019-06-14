package com.github.saulocalixto.culty.cultyserver.model;

import com.github.saulocalixto.culty.cultyserver.model.abstratos.ObjetoPadraoCodigoDescricao;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "filtro")
public class Filtro extends ObjetoPadraoCodigoDescricao {
}
