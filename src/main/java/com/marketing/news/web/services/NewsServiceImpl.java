package com.marketing.news.web.services;

import com.marketing.news.web.models.NewsItem;
import com.marketing.news.web.models.NewsItemRating;
import com.marketing.news.web.models.NewsItemRatingCalculation;
import com.marketing.news.web.models.TopNewsItem;
import com.marketing.news.web.repositories.NewsItemRatingCalculationRepository;
import com.marketing.news.web.repositories.NewsItemRatingRepository;
import com.marketing.news.web.repositories.NewsItemRepository;
import com.marketing.news.web.repositories.TopNewsItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsItemRepository newsItemRepository;

    @Autowired
    private NewsItemRatingRepository newsItemRatingRepository;

    @Autowired
    private NewsItemRatingCalculationRepository newsItemRatingCalculationRepository;

    @Autowired
    private TopNewsItemRepository topNewsItemRepository;

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

        // adding rating to calculation table

        updateRatingCalculationTable(newsItemId, rating);
        System.out.println("rating: " + newsItemRating.toString());
        newsItemRatingRepository.save(newsItemRating);
        return newsItemRating;
    }

    @Override
    public List<TopNewsItem> getPopularNews() {
        return topNewsItemRepository.findAll();
    }

    private void updateRatingCalculationTable(String newsItemId, int rating) {
         NewsItemRatingCalculation newsItemRatingCalculation = newsItemRatingCalculationRepository.findById(newsItemId).orElse(new NewsItemRatingCalculation());
         newsItemRatingCalculation.setTotalUsersRated(newsItemRatingCalculation.getTotalUsersRated() + 1);
         newsItemRatingCalculation.setTotalRating(newsItemRatingCalculation.getTotalRating() + rating);
         newsItemRatingCalculationRepository.save(newsItemRatingCalculation);
         System.out.println("rating updated : " + newsItemRatingCalculation.toString());
    }

}
