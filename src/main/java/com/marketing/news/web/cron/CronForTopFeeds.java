package com.marketing.news.web.cron;

import com.marketing.news.web.models.NewsItem;
import com.marketing.news.web.models.NewsItemRatingCalculation;
import com.marketing.news.web.models.TopNewsItem;
import com.marketing.news.web.repositories.NewsItemRatingCalculationRepository;
import com.marketing.news.web.repositories.NewsItemRepository;
import com.marketing.news.web.repositories.TopNewsItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CronForTopFeeds {

    @Autowired
    private TopNewsItemRepository topNewsItemRepository;

    @Autowired
    private NewsItemRepository newsItemRepository;

    @Autowired
    private NewsItemRatingCalculationRepository newsItemRatingCalculationRepository;

    @Scheduled(fixedRate = 300000)
    public void topRatingServiceMethod() {
        List<String> topFeedIds = getTopFeedsIds(5);
        setTopFeeds(topFeedIds);
    }

    private void setTopFeeds(List<String>  topFeedIds) {
        List<NewsItem> newsItems = newsItemRepository.findByIds(topFeedIds);
        topNewsItemRepository.deleteAll();
        for(NewsItem newsItem :newsItems){
            TopNewsItem topNewsItem = new TopNewsItem();
            copyBeans(newsItem, topNewsItem);
            topNewsItemRepository.save(topNewsItem);
        }
    }

    private void copyBeans(NewsItem newsItem, TopNewsItem topNewsItem) {
        topNewsItem.setAtomLink(newsItem.getAtomLink());
        topNewsItem.setCategories(newsItem.getCategories());
        topNewsItem.setDescription(newsItem.getDescription());
        topNewsItem.setGuid(newsItem.getGuid());
        topNewsItem.setTitle(newsItem.getTitle());
        topNewsItem.setAuthor(newsItem.getAuthor());
        topNewsItem.setMediaContent(newsItem.getMediaContent());
        topNewsItem.setMediaCredit(newsItem.getMediaCredit());
        topNewsItem.setLink(newsItem.getLink());
        topNewsItem.setPublishedDate(newsItem.getPublishedDate());
        topNewsItem.setMediaDescription(newsItem.getMediaDescription());
    }

    private  List<String> getTopFeedsIds(int count) {
        List<String> topFeedIds = new ArrayList<>();
        List<NewsItemRatingCalculation> newsItemRatingCalculations= newsItemRatingCalculationRepository.findAll(new Sort(Sort.Direction.DESC, "averageRating"));
        for (int i = 0; i < count ; i++ ) {
            topFeedIds.add(newsItemRatingCalculations.get(i).getNewsItemId());;
        }
        return topFeedIds;
    }
}
