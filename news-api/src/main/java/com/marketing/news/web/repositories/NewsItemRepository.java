package com.marketing.news.web.repositories;

import com.marketing.news.web.models.NewsItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NewsItemRepository extends MongoRepository<NewsItem, String> {

    @Query("{_id: { $in: ?0 } })")
    List<NewsItem> findByIds(List<String> newsItemId);

}
