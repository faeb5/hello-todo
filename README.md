# Build
mvn clean package && docker build -t org.example/hello-todo .

# RUN

docker compose -f compose.yaml down || true && docker compose -f compose.yaml up -d
