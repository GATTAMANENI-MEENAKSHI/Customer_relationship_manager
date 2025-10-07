# Use OpenJDK 21 on Alpine Linux
FROM eclipse-temurin:21-jdk-alpine

VOLUME /tmp
COPY target/customer_relationship_manager-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=10000
EXPOSE 10000

ENTRYPOINT ["java","-jar","/app.jar","--server.port=${PORT}"]

