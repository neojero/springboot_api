FROM openjdk:17-jre-slim

# Exposer le port 9011
EXPOSE 9000

# Répertoire de travail dans le conteneur
WORKDIR /app

# Copie du fichier JAR de votre projet dans le conteneur
COPY api-0.0.1-SNAPSHOT.jar /app/api-0.0.1-SNAPSHOT.jar

# Commande pour exécuter le fichier JAR
CMD ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]