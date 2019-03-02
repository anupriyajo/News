package com.marketing.news.web;

import com.marketing.news.web.models.Feed;
import com.marketing.news.web.models.NewsItem;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class NewsFeedParser {

    final URL url;

    @Autowired
    private DatabaseFeed databaseFeed;

    public NewsFeedParser(String feedUrl) {
        databaseFeed = new DatabaseFeed();
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
            DBCollection dbCollection = databaseFeed.getCollection("newsFeed");
            for (SyndEntry entry : syndFeed.getEntries()) {
                NewsItem message = new NewsItem();
                BasicDBObject data = new BasicDBObject();
                data.append("title", entry.getTitle());
                if(dbCollection.findOne(data) != null){
                    continue;
                }
                data.append("link", entry.getTitle());
                data.append("guid", entry.getUri());
                message.setTitle(entry.getTitle());
                message.setLink(entry.getLink());
                message.setGuid(entry.getUri());
                feed.getMessages().add(message);
                dbCollection.insert(data);
            }
        } catch (FeedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return feed;
    }
}
