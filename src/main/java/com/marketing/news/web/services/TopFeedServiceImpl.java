package com.marketing.news.web.services;

import com.marketing.news.web.models.NewsItem;
import com.marketing.news.web.models.NewsItemRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service
public class TopFeedServiceImpl implements TopFeedService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public int getTopFeed(int count) {
        getTopFiveFeeds(count);
        return 0;
    }

    public List<NewsItem> getTopFiveFeeds(int count) {

        Aggregation agg = newAggregation(
                //match(Criteria.where("_id").lt(count)),
                group("id").count().as("total"),
                project("total").and("id").previousOperation(),
                sort(Sort.Direction.DESC, "total")

        );

        //Convert the aggregation result into a List
        AggregationResults<NewsItem> groupResults
                = mongoTemplate.aggregate(agg, NewsItemRating.class, NewsItem.class);
        List<NewsItem> result = groupResults.getMappedResults();

        return result;

    }
}
