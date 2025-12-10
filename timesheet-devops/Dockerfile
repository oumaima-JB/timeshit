# Utiliser une image légère avec Java 8
FROM eclipse-temurin:8-jdk-alpine

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Exposer le port de l’application Spring Boot
EXPOSE 8082

# Copier le fichier JAR généré dans le conteneur
ARG JAR_FILE
COPY ${JAR_FILE} app.jar

# Démarrer l’application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
