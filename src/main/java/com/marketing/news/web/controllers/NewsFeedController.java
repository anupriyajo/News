package com.marketing.news.web.controllers;

import com.marketing.news.web.services.NewsFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feed")
public class NewsFeedController {

    @Autowired
    private NewsFeedService newsFeedService;

    @PostMapping
    public int saveFeed(@RequestParam String uri) {

        return newsFeedService.saveFeed(uri);
    }

}
