package com.marketing.news.web;

import java.util.ArrayList;
import java.util.List;

public class Feed {
     String title;
     String link;
     String description;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setEntries(List<FeedMessage> entries) {
        this.entries = entries;
    }

    String language;
     String copyright;

    List<FeedMessage> entries = new ArrayList<>();

//    public Feed(String title, String link, String description, String language, String copyright) {
//        this.title = title;
//        this.link = link;
//        this.description = description;
//        this.language = language;
//        this.copyright = copyright;
//    }

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
