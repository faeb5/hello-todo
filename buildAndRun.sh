#!/bin/sh
mvn clean package && docker build -t org.example/hello-todo .
docker rm -f hello-todo || true && docker run -d -p 8080:8080 --name hello-todo org.example/hello-todo
