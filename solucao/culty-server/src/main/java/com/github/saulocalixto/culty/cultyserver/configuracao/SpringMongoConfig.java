package com.github.saulocalixto.culty.cultyserver.configuracao;

import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.MongoClient;

/**
 * Spring MongoDB configuration file
 *
 */
@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }

    @Override
    protected String getDatabaseName() {
        return "culty";
    }

    @Override
    @Bean
    public MongoClient mongoClient() {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://culty:culty123@culty-jo40j.mongodb.net/test?retryWrites=true");
        return new MongoClient(uri);
    }
}