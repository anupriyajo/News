package com.marketing.news.web;

import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

import java.util.Arrays;

public class GetTopFeeds {

    // make cron
    // put top 5 id in table
    public static void main(String args []) {
        DatabaseFeed databaseFeed = new DatabaseFeed();
        //check if exists db
        MongoCollection<Document> dbCollection = databaseFeed.getMongoClient().getDatabase("feedDb").getCollection("feedRating");


        Block<Document> printBlock = document -> System.out.println(document.entrySet().toArray()[0]);

        AggregateIterable<Document> agg  = dbCollection.aggregate(
                Arrays.asList(
                        Aggregates.group("$feedId", Accumulators.sum("totRating", "$rating")),
                        Aggregates.sort(Sorts.descending("totRating")),
                        Aggregates.limit(3)
                )
        );
                agg.forEach(printBlock);

        System.out.println("done");
    }
}
