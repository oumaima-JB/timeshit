# Utiliser une image légère avec Java 8
FROM eclipse-temurin:8-jdk-alpine


# Exposer le port de l’application Spring Boot
EXPOSE 8089

# Copier le fichier JAR généré dans le conteneur
ADD target/timesheet-0.0.1-SNAPSHOT.jar app.jar

# Démarrer l’application

ENTRYPOINT ["java", "-jar", "app.jar"]
