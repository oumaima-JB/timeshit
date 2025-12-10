FROM eclipse-temurin:8-jdk-alpine
WORKDIR /app
EXPOSE 8083

ARG JAR_FILE
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]
