package com.github.saulocalixto.culty.cultyserver.repositorio;

import com.github.saulocalixto.culty.cultyserver.model.Culty;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUsuarioRepository extends MongoRepository<Culty, String> {
    Culty findBy_id(ObjectId _id);
}
