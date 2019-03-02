package com.marketing.news.web.controllers;

import com.marketing.news.web.models.NewsItem;
import com.marketing.news.web.models.NewsItemRating;
import com.marketing.news.web.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsItemController {

    @Autowired
    private NewsService newsService;
/*
    @GetMapping("/{id}/rating")
    public String getRating(@PathParam("id") String newsItemId, @RequestParam int rating) {

        System.out.println(newsItemId + " " + rating + " ");
        return "done:" + newsFeedService.rateFeed(newsItemId, rating);
    }
*/
    @GetMapping
    public List<NewsItem> getAllNews() {
        return newsService.getAllNews();
    }

    @PutMapping(path = "/{id}/rating")
    public NewsItemRating rateNews(@PathVariable("id") String newsItemId, @RequestParam int rating, @RequestHeader String userId) {

        return newsService.rateFeed(newsItemId, rating, userId);
    }
}
