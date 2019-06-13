package com.github.saulocalixto.culty.cultyserver.repositorio;

import com.github.saulocalixto.culty.cultyserver.model.Obra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IObraRepository extends MongoRepository<Obra, String> {
}
