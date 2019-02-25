package com.marketing.news.web;

public class FeedMessage {
    String title;
  //  String description;
    String link;
    String guid;

    public String getTitle() {
        return title;
    }

//    public FeedMessage(String title, String link, String guid) {
//        this.title = title;
//     //   this.description = description;
//        this.link = link;
//        this.guid = guid;
//    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

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
