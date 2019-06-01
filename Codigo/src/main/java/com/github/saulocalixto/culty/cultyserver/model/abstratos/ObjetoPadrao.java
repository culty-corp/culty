package com.github.saulocalixto.culty.cultyserver.model.abstratos;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public abstract class ObjetoPadrao implements Serializable {
    @Id
    public ObjectId _id;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }
}
