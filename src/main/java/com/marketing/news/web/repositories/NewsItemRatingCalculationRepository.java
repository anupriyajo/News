package com.marketing.news.web.repositories;


import com.marketing.news.web.models.NewsItemRatingCalculation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsItemRatingCalculationRepository extends MongoRepository<NewsItemRatingCalculation, String> {

//    @Query("{newsItemId:'?0'}")
//    NewsItemRatingCalculation findByNewsItemId(String newsItemId);
}
