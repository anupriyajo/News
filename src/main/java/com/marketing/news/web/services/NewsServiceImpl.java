package com.marketing.news.web.services;

import com.marketing.news.web.models.NewsItem;
import com.marketing.news.web.repositories.NewsItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsItemRepository newsItemRepository;

    @Override
    public List<NewsItem> getAllNews() {
        return newsItemRepository.findAll();
    }
}
