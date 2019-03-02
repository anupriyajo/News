package com.marketing.news.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CronForTopFeeds {

    private static final Logger log = LoggerFactory.getLogger(CronForTopFeeds.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //@Scheduled(fixedRate = 5000)
    public void demoServiceMethod()
    {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}
