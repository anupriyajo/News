package com.marketing.news.web;

import java.util.ArrayList;
import java.util.List;

public class Feed {
    final String title;
    final String link;
    final String description;
    final String language;
    final String copyright;

    final List<FeedMessage> entries = new ArrayList<>();

    public Feed(String title, String link, String description, String language, String copyright) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.copyright = copyright;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public String getCopyright() {
        return copyright;
    }

    public List<FeedMessage> getMessages() {
        return entries;
    }
}
