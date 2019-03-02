package com.marketing.news.web;

import com.marketing.news.web.models.Feed;
import com.marketing.news.web.models.NewsItem;

public class ReadNews {
    public static void main(String[] args) {
        NewsFeedParser parser = new NewsFeedParser(
                "https://rss.nytimes.com/services/xml/rss/nyt/Technology.xml");
        Feed feed = parser.readFeed();
        for (NewsItem message : feed.getMessages()) {
            System.out.println(message);
        }
    }
}
