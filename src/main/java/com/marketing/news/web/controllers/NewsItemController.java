package com.marketing.news.web.controllers;


import com.marketing.news.web.models.NewsItem;
import com.marketing.news.web.services.NewsFeedService;
import com.marketing.news.web.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsItemController {

    @Autowired
    private NewsFeedService newsFeedService;

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

//    @PutMapping("/{id}/rating")
//    public String rateNews(@PathParam("id") String newsItemId, @RequestParam int rating, @RequestHeader String userId) {
//
//        System.out.println(newsItemId + " " + rating + " " + userId);
//        return "done:" + newsFeedService.rateFeed(newsItemId, rating, userId);
//    }
}
