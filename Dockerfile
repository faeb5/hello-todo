FROM payara/micro:5.181
COPY ./target/hello-todo.war ${DEPLOY_DIR}
