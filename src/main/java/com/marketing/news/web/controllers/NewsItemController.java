package com.marketing.news.web.controllers;

import com.marketing.news.web.models.NewsItem;
import com.marketing.news.web.models.NewsItemRating;
import com.marketing.news.web.models.TopNewsItem;
import com.marketing.news.web.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsItemController {

    @Autowired
    private NewsService newsService;

    @CrossOrigin
    @GetMapping
    public List<NewsItem> getAllNews() {
        return newsService.getAllNews();
    }

    @CrossOrigin
    @PutMapping(path = "/{id}/rating")
    public NewsItemRating rateNews(@PathVariable("id") String newsItemId, @RequestParam int rating, @RequestHeader String userId) {
        return newsService.rateFeed(newsItemId, rating, userId);
    }

    @CrossOrigin
    @GetMapping(path = "/popular")
    public List<TopNewsItem> getPopularNews() {
        return newsService.getPopularNews();
    }
}
