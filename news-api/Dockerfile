FROM openjdk:8-alpine

# Required for starting application up.
RUN apk update && apk add bash


ENV PROJECT_HOME /opt/app

RUN mkdir -p $PROJECT_HOME

COPY target/news-0.0.1-SNAPSHOT.jar $PROJECT_HOME/news-0.0.1-SNAPSHOT.jar

WORKDIR $PROJECT_HOME

CMD ["java", "-Dspring.data.mongodb.uri=mongodb://newsapp-mongo:27017/news-db", "-jar", "./news-0.0.1-SNAPSHOT.jar"]

