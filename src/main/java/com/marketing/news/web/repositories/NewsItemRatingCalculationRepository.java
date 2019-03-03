package com.marketing.news.web.repositories;


import com.marketing.news.web.models.NewsItemRatingCalculation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsItemRatingCalculationRepository extends MongoRepository<NewsItemRatingCalculation, String> {

    @Query(sort = "{ averageRating : -1 }")
    List<NewsItemRatingCalculation> findAll();
}
