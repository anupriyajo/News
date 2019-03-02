package com.marketing.news.web.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "top_news_items")
public class TopNewsItem extends NewsItem {

}
