package com.mesalvo.patientdemo.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

//@Configuration
//@EnableReactiveMongoRepositories(basePackages = "com.mesalvo.patientdemo.dao")
public class MongoConfig extends AbstractReactiveMongoConfiguration {
    @Value("${mongodb.port}")
    private String port;

    @Value("${mongodb.dbname}")
    private String dbName;

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return dbName;
    }
}
