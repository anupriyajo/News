FROM    openjdk:8u191-jre-alpine
RUN     mkdir /app
COPY    ./target/news-0.0.1-SNAPSHOT.jar /app
WORKDIR /app
EXPOSE  8080
CMD     ["java", "-jar", "news-0.0.1-SNAPSHOT.jar "]

# docker build -t news-feed:latest .
# docker run -d -p 8001:8080 news-feed:latest
