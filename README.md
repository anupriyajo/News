# News
marketing news
i could use a xmlparser or rome tools library. I have used the library as it is the standard for rss feed parsing
Task breakdown

    // 3. ui showing feeds and giving rating //
    // 2. composite query
    // 1. docker //
    // 6. admin panel - optional
    // 4. refractor for pllication props . folders etc //
    // 6. readme task breakdown
    // 5. tests -- must have
    // 7. swagger -- good to have
    
    assumption:
    //one time cron for setting initial users
    
    
    ************************************************
    architectural desicion
    1.no sql reason
    2. division of api newsfeed, newsitem as resource
  
    
    improvements
    1. could have used reverse proxy/ loda balancer for both ui and api this would have bypassed the corrs problem. Right now i had to allow corrs for api.
    
    desigm desicion
      1. rating calculation is kept out of cron
      2. kept top 5 in  a table for faster processing
      
      improvements
      
      casshing the top 5 in ui layer for 5 mins than invalidation the cache and hitting as per business requirements 
    
    java for api
     react (used)
     mongorepository
     rest api design
     table design for db
     
    task breakdown
    run full application
   
    run individual parts of application
    
    
    due to time constraints i have not added tests unit 
    1. save news feed : 
     a) reading the xml 
