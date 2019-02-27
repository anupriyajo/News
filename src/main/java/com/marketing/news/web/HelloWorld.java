package com.marketing.news.web;

import com.oracle.javafx.jmx.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.bson.Document;
import java.io.InputStream;
import java.net.URL;

@RestController
public class HelloWorld {

    public static int PRETTY_PRINT_INDENT_FACTOR = 4;

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value = "name") String name) {
        String path = "https://rss.nytimes.com/services/xml/rss/nyt/Technology.xml";
         return processXML2JSON(path);
    }

    private String processXML2JSON(String xmlDocPath) throws JSONException {

        String jsonPrettyPrintString="";
        try {
            URL url = new URL(xmlDocPath);
            InputStream is = url.openStream();
            int ptr = 0;
            StringBuilder builder = new StringBuilder();
            while ((ptr = is.read()) != -1) {
                builder.append((char) ptr);
            }
            String XML_STRING = builder.toString();
            JSONObject xmlJSONObj = XML.toJSONObject(XML_STRING);
            jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println("PRINTING STRING :::::::::::::::::::::" + jsonPrettyPrintString);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return jsonPrettyPrintString;
    }

    private void insertToMongo(String jsonString){
        Document doc = Document.parse(jsonString);
        mongoTemplate.insert(doc, "foo");
    }
}