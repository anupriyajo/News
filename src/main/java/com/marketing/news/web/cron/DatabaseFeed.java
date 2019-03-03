package com.marketing.news.web.cron;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class DatabaseFeed {
    public MongoClient getMongoClient() {
        return mongoClient;
    }

    private MongoClient mongoClient;

    public DatabaseFeed() {
        this.mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27018"));
    }

    public DBCollection getCollection(String name){
        return mongoClient.getDB("feedDb").getCollection(name);
    }
}
