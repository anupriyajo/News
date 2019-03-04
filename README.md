# News

Prerequisites:
1. java (1.8)
2. maven (>=3.5.4)
3. node (>=8)
4. npm (>=3.10.10)
5. docker (>=18..*)
6. docker-compose (1.23.2)

How to run:
```
# git clone https://github.com/anupriyajo/News
# cd News
# chmod +x setup.sh
# ./setup.sh
```
ui: http://localhost:3000

api: http://localhost:9000/api

Note: initially UI will be empty as no news feed is uploaded. To upload the news feeds please run the below commands

```
curl -X POST \
  'http://localhost:9000/api/feed?uri=http://rss.nytimes.com/services/xml/rss/nyt/Europe.xml' \
  -H 'cache-control: no-cache'
```
```
curl -X POST \
  'http://localhost:9000/api/feed?uri=http://rss.nytimes.com/services/xml/rss/nyt/Technology.xml' \
  -H 'cache-control: no-cache'
```

To clean up (cleans up only containers, docker images and data are persisted):
```
# chmod +x cleanup.sh
# ./cleanup.sh
```


Task breakdown:
0. Kept on scribbling in the README
1. read the news feed(found xml/ syndfeed/ rome tools)
2. save news feed(found mongoRepository) 
3. Created the react app to get dummy data
4. Dockerize the system 
5. Skipped the admin panel but kept in mind to make the api n ui to make space for incremental enhancements.
6. Made the update api. Kept in 2 tables (Please see table reasoning)
7. Refactored the code.
8. Got top 5 newsItemIds-ratings from table
9. Got top 5 newsItems from main table
10 Saved to top feed table.
11. Api for top 5 feeds
12. Cleaning debug comments
13. Docker compose complete
14. automated scripts
  
Tools Used:
1. java for api
2. react (used)
     
Design Decision:
1. Rating calculation is kept out of cron to reduce the load on cron.
2. Kept top 5 in a table for faster processing.
3. I could use a xmlparser or rome tools library for reading the feed. I have used the library as it is the standard for rss feed parsing.

Other Decision:
1. Kept both UI and api layer in the same repository so that I could docker-compose them together. Ideally they should be in separate repos. 
2. Did not dockerize the build, only dockerized the applications
     
Improvements/Assumptions:
 1. We have just one hardcoded user. We can enhance both the db n UI to handle mutiple users.
 2. While adding new feeds we are not checking for duplicity of data. Can be done if needed as per business requirements.
 3. Meta data for each feedUrl can be saved in a separate table.
 4. Due to time constraints I have not added tests unit for either Java or React.
 5. Could have used reverse proxy/load balancer for both ui and api. This would have bypassed the corrs problem.
 6. Right now i had to allow corrs for api.
 7. Ideally cron should be in different docker container.
 8. Initially top news is empty. If the requirement arises to fetch some news in the beginning it can be taken care of.
 9. If more than 5 are top rated news are present they can be handled as per business requirements.
 10. I thought of using a button for saving the rating but since I did not have time to show a reposne of rating getting saved I have put console log for the same.
 11. Cashing the top 5 feeds in ui layer for 5 mins can be done. Invalidation the cache and hitting the api can be done as per business requirements.
 12. Swagger can be added
 13. API base uri is hard coded in the UI layer, and expects it in `localhost:9000`
 14. Data is persisted by docker volumes at location ./data
      
Architectural decisions
 1. no sql is used as it is faster and more cost effective along-with greater flexibility for unstructured data
 2. Resources(Please check the rest design)
         
Project Structure 

     mongorepository                                  model                                  table                            reason  
     
     NewsItemRatingCalculationRepository.java        NewsItemRatingCalculation.java         news_item                         To save all items of news feed
     NewsItemRatingRepository.java                   NewsItemRating.java                    news_item_rating                  To save the rating when the user rates. Needed for future to keep track of ratings per user
     NewsItemRepository.java                         NewsItem.java                          news_item_rating_calculation      To keep aggregate ratings for each newsItem rated. Saves time for cron
     TopNewsItemRepository.java                      TopNewsItem.java                       top_news_items                    To save top 5 feeds
     
Api structure

    Controller                                      api                                 function

    NewsFeedController.java      
                                               POST /api/feed                              saves the feed from the rss url provided
    NewsItemController.java
                                               GET /api/news                               shows all items that are saved using "/api/feed" in news_item
                                               PUT /api/news/{id}/rating                   updates the rating in news_item_rating_calculation and adds in news_item_rating 
                                               GET /api/news/popular                       shows top 5 (or less) feeds
                                               


               
               
          
