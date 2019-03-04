package com.marketing.news.web.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "news_item_rating_calculation")
public class NewsItemRatingCalculation {

    @Id
    private String newsItemId;
    private int totalUsersRated;
    private int totalRating;
    private float averageRating;


    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    public int getTotalUsersRated() {
        return totalUsersRated;
    }

    public void setTotalUsersRated(int totalUsersRated) {
        this.totalUsersRated = totalUsersRated;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

    public String getNewsItemId() {
        return newsItemId;
    }

    public void setNewsItemId(String newsItemId) {
        this.newsItemId = newsItemId;
    }
}
