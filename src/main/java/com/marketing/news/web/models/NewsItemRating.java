package com.marketing.news.web.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "news_item_rating")
public class NewsItemRating {

    private String userId;
    private int rating;
    private String newsItemId;

    public void setNewsItemId(String newsItemId) {
        this.newsItemId = newsItemId;
    }

    @Override
    public String toString() {
        /* TODO: add rest of the parameters */
        return "NewsItemRating [userId=" + userId + ", rating=" + rating + ", newsItemId=" + newsItemId + "]";
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
