package com.marketing.news.web;

public class ReadNews {
    public static void main(String[] args) {
        NewsFeedParser parser = new NewsFeedParser(
                "https://rss.nytimes.com/services/xml/rss/nyt/Technology.xml");
        Feed feed = parser.readFeed();
        System.out.println(feed);
        for (FeedMessage message : feed.getMessages()) {
            System.out.println(message);
        }
    }
}
