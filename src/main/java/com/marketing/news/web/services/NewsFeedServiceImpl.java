package com.marketing.news.web.services;

import com.marketing.news.web.models.NewsItem;
import com.marketing.news.web.repositories.NewsItemRepository;
import com.rometools.rome.feed.synd.SyndCategory;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.jdom2.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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

               // Not checking for duplicity of data. Can be done if needed
                settingNewsItemDetails(entry, newsItem);

                settingCategories(entry, newsItem);

                settingForeignMarkup(entry, newsItem);

                newsItemRepository.save(newsItem);
            }
            count = syndFeed.getEntries().size();
        } catch (FeedException | IOException exception) {
            LOG.error(exception.toString());
        }
        return count;
    }

    private void settingNewsItemDetails(SyndEntry entry, NewsItem newsItem) {
        newsItem.setTitle(entry.getTitle());
        newsItem.setLink(entry.getLink());
        newsItem.setGuid(entry.getUri());
        newsItem.setDescription(entry.getDescription().getValue());
        newsItem.setAuthor(entry.getAuthor());
        newsItem.setPublishedDate(entry.getPublishedDate());
    }

    private void settingCategories(SyndEntry entry, NewsItem newsItem) {
        List<String> categories = new ArrayList<>();
        for(SyndCategory category : entry.getCategories()){
            categories.add(category.getName());
        }
        newsItem.setCategories(categories);
    }

    private void settingForeignMarkup(SyndEntry entry, NewsItem newsItem) {
        List<Element> foreignMarkup = entry.getForeignMarkup();
        for( Element element :foreignMarkup) {
            String property = element.getName();
            switch(property){
                case "content" :
                    newsItem.setMediaContent(element.getAttributeValue("url"));
                    break;
                case "link" :
                    newsItem.setAtomLink(element.getAttributeValue("href"));
                case "credit" :
                    newsItem.setMediaCredit(element.getValue());
                case "description" :
                    newsItem.setMediaDescription(element.getValue());
            }
        }
    }
}
