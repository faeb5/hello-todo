#!/bin/sh
mvn clean package && docker build -t org.example/hello-todo:latest .
docker stop hello-todo || true && docker run --rm -d -p 8080:8080 --name hello-todo org.example/hello-todo:latest 
