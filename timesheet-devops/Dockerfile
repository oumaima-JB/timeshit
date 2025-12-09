FROM eclipse-temurin:8-jdk-alpine
WORKDIR /app

ARG JAR_FILE
COPY target/${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]
