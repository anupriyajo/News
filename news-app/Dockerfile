FROM node:8

RUN npm install -g http-server

ENV PROJECT_HOME /opt/www

RUN mkdir -p $PROJECT_HOME

COPY build/ $PROJECT_HOME/

WORKDIR $PROJECT_HOME

CMD ["http-server", "-p", "8080"]