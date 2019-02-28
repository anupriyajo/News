package com.marketing.news.web;

import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

import java.util.Arrays;

public class GetTopFeeds {

    public static void main(String args []) {
        DatabaseFeed databaseFeed = new DatabaseFeed();
        //check if exists db
        MongoCollection<Document> dbCollection = databaseFeed.getMongoClient().getDatabase("feedDb").getCollection("feedRating");


        Block<Document> printBlock = document -> System.out.println(document.toJson());

        dbCollection.aggregate(
                Arrays.asList(
                        Aggregates.group("$feedId", Accumulators.sum("totRating", "$rating")),
                        Aggregates.sort(Sorts.descending("totRating")),
                        Aggregates.limit(3)
                )
        ).forEach(printBlock);

        System.out.println("done");

    }
}
