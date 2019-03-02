package com.marketing.news.web.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "news_item")
public class NewsItem {
    private String title;
    private String description;
    private String author;
    private Date publishedDate;
    private String link;
    private String guid;
    private String mediaContent;

    public String getMediaContent() {
        return mediaContent;
    }

    public void setMediaContent(String mediaContent) {
        this.mediaContent = mediaContent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public String toString() {
        return "FeedMessage [title=" + title + ", link=" + link + ", guid=" + guid
                + "]";
    }
}
