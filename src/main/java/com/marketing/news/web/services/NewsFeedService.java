package com.marketing.news.web.services;

public interface NewsFeedService {
    int saveFeed(String uri);
    int rateFeed(String id, int rating, String user);
}
