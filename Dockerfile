# Utilisation d'une image de base OpenJDK pour exécuter l'application Java
FROM arnfi1150/17-jdk-alpine

# positionne le répertoire de travail /app
#WORKDIR /app

# copy le jar dans le repertoire
#ADD package.jar appapi.jar

# expose le port à l'exterieur du conteneur
EXPOSE 9000

# Commande pour exécuter l'application Spring Boot lorsque le conteneur démarre
CMD ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]