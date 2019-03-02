package com.marketing.news.web.controllers;

import com.marketing.news.web.services.TopFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cron/feed")
public class TopFeedController {

    @Autowired
    private TopFeedService topFeedService;

    @PostMapping("/topFeeds")
    public String getTopFeed(@RequestParam int count) {

        return "done:" + topFeedService.getTopFeed(count);
    }

}
