package com.marketing.news.web.services;

import com.marketing.news.web.models.NewsItem;
import com.marketing.news.web.models.NewsItemRating;
import com.marketing.news.web.models.TopNewsItem;
import java.util.List;

public interface NewsService {
    List<NewsItem> getAllNews();
    NewsItemRating rateFeed(String newsItemId, int rating, String userId);
    List<TopNewsItem> getPopularNews();
}
