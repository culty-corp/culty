package com.github.saulocalixto.culty.cultyserver;

import com.github.saulocalixto.culty.cultyserver.configuracao.SpringMongoConfig;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.gridfs.GridFsOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class CultyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CultyServerApplication.class, args);
	}
}
