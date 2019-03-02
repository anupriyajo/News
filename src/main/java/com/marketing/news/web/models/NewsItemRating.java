package com.marketing.news.web.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rating")
public class NewsItemRating {

    private String user;
    private int rating;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "NewsItemRating [user=" + user + ", rating=" + rating + ", id=" + id + "]";
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
