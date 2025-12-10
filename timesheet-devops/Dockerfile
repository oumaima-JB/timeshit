FROM  eclipse-temurin:8-jdk-alpin

WORKDIR /app

# Copier le JAR généré par Maven
ADD target/timesheet-devops-1.0.jar app.jar

# Démarrer l’application
ENTRYPOINT ["java","-jar","app.jar"]