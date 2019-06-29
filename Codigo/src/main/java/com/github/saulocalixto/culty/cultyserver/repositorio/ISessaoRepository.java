package com.github.saulocalixto.culty.cultyserver.repositorio;

import com.github.saulocalixto.culty.cultyserver.model.Sessao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISessaoRepository extends MongoRepository<Sessao, String> {
}
