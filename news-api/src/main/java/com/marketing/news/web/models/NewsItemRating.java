package com.marketing.news.web.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "news_item_rating")
public class NewsItemRating {

    private String userId;
    private int rating;
    private String newsItemId;

    public String getNewsItemId() {
        return newsItemId;
    }

    public void setNewsItemId(String newsItemId) {
        this.newsItemId = newsItemId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        /*TODO Can add all attributes*/
        return "NewsItemRating [userId=" + userId + ", rating=" + rating + ", newsItemId=" + newsItemId + "]";
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
