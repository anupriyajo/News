package com.marketing.news.web;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class NewsFeedParser {

    final URL url;

    public NewsFeedParser(String feedUrl) {
        try {
            this.url = new URL(feedUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public Feed readFeed() {
        Feed feed = null;
        try {
            feed = new Feed();
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed syndFeed = input.build(new XmlReader(url));
            feed.setTitle(syndFeed.getTitle());
            for (SyndEntry entry : syndFeed.getEntries()) {
                FeedMessage message = new FeedMessage();
                message.setTitle(entry.getTitle());
                message.setLink(entry.getLink());
                message.setGuid(entry.getUri());
                feed.getMessages().add(message);
            }
        } catch (FeedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return feed;
    }
}
