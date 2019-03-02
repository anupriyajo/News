package com.marketing.news.web.services;

import com.marketing.news.web.models.NewsItem;
import com.marketing.news.web.models.NewsItemRating;
import com.marketing.news.web.repositories.NewsItemRatingRepository;
import com.marketing.news.web.repositories.NewsItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsItemRepository newsItemRepository;

    @Autowired
    private NewsItemRatingRepository newsItemRatingRepository;

    @Override
    public List<NewsItem> getAllNews() {
        return newsItemRepository.findAll();
    }

    @Override
    public NewsItemRating rateFeed(String newsItemId, int rating, String userId) {
        NewsItemRating newsItemRating = new NewsItemRating();
        newsItemRating.setUserId(userId);
        newsItemRating.setRating(rating);
        newsItemRating.setNewsItemId(newsItemId);
        System.out.println("rating: " + newsItemRating.toString());
        newsItemRatingRepository.save(newsItemRating);
        return newsItemRating;
    }

}
