package com.marketing.news.web.cron;

import com.marketing.news.web.models.NewsItemRatingCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class GetTopFeeds {

    @Autowired
    static MongoTemplate mongoTemplate;

    // make cron
    // put top 5 id in table
    public static void main(String args []) {
        //Query query = new TextQuery();
       //AggregationOperation match = Aggregation.match(Criteria.where("_id").lt(10)),
        // AggregationOperation group = Aggregation.group("fieldname");
//        AggregationOperation limit = Aggregation.limit(3);
//        AggregationOperation sort = Aggregation.sort(Sort.Direction.DESC, "rating");
//        Aggregation aggregation = Aggregation.newAggregation(sort, limit);
//        AggregationResults<NewsItemRatingCalculation> results = mongoTemplate.aggregate(aggregation, NewsItemRatingCalculation.class, NewsItemRatingCalculation.class);
//
//        List<NewsItemRatingCalculation> mappedResult = results.getMappedResults();
//
//        System.out.println("findOneById=" + results.getMappedResults());

Query query = new Query();
query.with(new Sort(Sort.Direction.DESC, "rating"));
query.limit(3);
List<NewsItemRatingCalculation> top = mongoTemplate.find(query, NewsItemRatingCalculation.class);
        System.out.println("findOneById=" + top.toString());
//        DatabaseFeed databaseFeed = new DatabaseFeed();
//        //check if exists db
//        MongoCollection<Document> dbCollection = databaseFeed.getMongoClient().getDatabase("feedDb").getCollection("feedRating");
//
//
//        Block<Document> printBlock = document -> System.out.println(document.entrySet().toArray()[0]);
//
//        AggregateIterable<Document> agg  = dbCollection.aggregate(
//                Arrays.asList(
//                        Aggregates.group("$feedId", Accumulators.sum("totRating", "$rating")),
//                        Aggregates.sort(Sorts.descending("totRating")),
//                        Aggregates.limit(3)
//                )
//        );
//                agg.forEach(printBlock);

        System.out.println("done");
    }
}
