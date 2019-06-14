package com.github.saulocalixto.culty.cultyserver.repositorio;

import com.github.saulocalixto.culty.cultyserver.model.Filtro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFiltroRepository extends MongoRepository<Filtro, String> {
}
