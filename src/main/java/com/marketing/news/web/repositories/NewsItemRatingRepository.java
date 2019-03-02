package com.marketing.news.web.repositories;

import com.marketing.news.web.models.NewsItemRating;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsItemRatingRepository extends MongoRepository<NewsItemRating, String> {
}
