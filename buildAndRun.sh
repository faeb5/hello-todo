#!/bin/sh
mvn clean package
docker compose -f compose.yaml down || true && docker compose -f compose.yaml up -d
