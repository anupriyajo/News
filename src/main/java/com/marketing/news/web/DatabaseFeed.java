package com.marketing.news.web;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class DatabaseFeed {
    private MongoClient mongoClient;

    public DatabaseFeed() {
        this.mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
    }

    public DBCollection getCollection(String name){
        return mongoClient.getDB("feedDb").getCollection(name);
    }
}
