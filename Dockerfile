FROM payara/micro:5.182
COPY ./target/hello-todo.war ${DEPLOY_DIR}
