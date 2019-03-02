package com.marketing.news.web.services;

import com.marketing.news.web.models.NewsItem;
import com.marketing.news.web.repositories.NewsItemRepository;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

@Service
public class NewsFeedServiceImpl implements NewsFeedService {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private NewsItemRepository newsItemRepository;

    @Override
    public int saveFeed(String feedUrl) {
        int count = 0;
        try {
            URL url = new URL(feedUrl);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed syndFeed = input.build(new XmlReader(url));

            for (SyndEntry entry : syndFeed.getEntries()) {
                NewsItem newsItem = new NewsItem();

                /*if(dbCollection.findOne(data) != null){
                    continue;
                }*/

                newsItem.setTitle(entry.getTitle());
                newsItem.setLink(entry.getLink());
                newsItem.setGuid(entry.getUri());
                System.out.println("saving: " + newsItem.toString());
                newsItemRepository.save(newsItem);
            }
            count = syndFeed.getEntries().size();
        } catch (FeedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
