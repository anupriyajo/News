package com.marketing.news.web;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsRatingFacade {

    //public static int PRETTY_PRINT_INDENT_FACTOR = 4;

// http://localhost:8080/updateRating?feedId=5c7714652e33f442374fd532&rating=4&userId=anu

    @RequestMapping("/updateRating")
    public void updateRating(@RequestParam(value = "feedId") String feedId, @RequestParam(value = "rating") int rating, @RequestParam(value = "userId") String userId) {
        DatabaseFeed databaseFeed = new DatabaseFeed();
        DBCollection dbCollection =  databaseFeed.getCollection("feedRating");
        BasicDBObject data = new BasicDBObject();
        data.append("feedId", feedId);
        data.append("rating", rating);
        data.append("userId", userId);
        // check if user has given rating
        dbCollection.insert(data);
//        String path = "https://rss.nytimes.com/services/xml/rss/nyt/Technology.xml";
//         return processXML2JSON(path);
        System.out.println(data.toString()+ " done ");
    }

//    private String processXML2JSON(String xmlDocPath) throws JSONException {
//
//        String jsonPrettyPrintString="";
//        try {
//            URL url = new URL(xmlDocPath);
//            InputStream is = url.openStream();
//            int ptr = 0;
//            StringBuilder builder = new StringBuilder();
//            while ((ptr = is.read()) != -1) {
//                builder.append((char) ptr);
//            }
//            String XML_STRING = builder.toString();
//            JSONObject xmlJSONObj = XML.toJSONObject(XML_STRING);
//            jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
//            System.out.println("PRINTING STRING :::::::::::::::::::::" + jsonPrettyPrintString);
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        return jsonPrettyPrintString;
//    }

//    private void insertToMongo(String jsonString){
//        Document doc = Document.parse(jsonString);
//        mongoTemplate.insert(doc, "foo");
//    }
}