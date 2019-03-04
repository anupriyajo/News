#!/bin/bash

mvn clean package -f news-api/pom.xml

npm --prefix news-app install
npm --prefix news-app run build

docker-compose up -d
