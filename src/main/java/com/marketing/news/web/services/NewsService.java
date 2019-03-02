package com.marketing.news.web.services;

import com.marketing.news.web.models.NewsItem;
import java.util.List;

public interface NewsService {
    List<NewsItem> getAllNews();
}
