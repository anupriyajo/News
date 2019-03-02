package com.marketing.news.web.repositories;

import com.marketing.news.web.models.TopNewsItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopNewsItemRepository extends MongoRepository<TopNewsItem, String> {
}
