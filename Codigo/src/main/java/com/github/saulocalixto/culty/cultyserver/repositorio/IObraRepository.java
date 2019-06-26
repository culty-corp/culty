package com.github.saulocalixto.culty.cultyserver.repositorio;

import com.github.saulocalixto.culty.cultyserver.model.Obra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraRepository extends MongoRepository<Obra, String> {
    List<Obra> findByFiltrosContainingIgnoreCase(String[] text);
}
