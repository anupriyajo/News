package com.marketing.news.web.repositories;

import com.marketing.news.web.models.NewsItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsItemRepository extends MongoRepository<NewsItem, String> {

}
