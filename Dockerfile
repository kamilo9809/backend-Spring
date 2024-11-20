FROM openjdk:21-slim

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Instalar netcat (nc)
RUN apt-get update && \
    apt-get install -y netcat-openbsd && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Copia el archivo JAR generado a /app en el contenedor
COPY target/backen-project-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que corre la aplicación Spring Boot (default: 8080)
EXPOSE 8080

# Copia el script wait-for-it.sh
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Establece el perfil activo de Spring Boot
ENV SPRING_PROFILES_ACTIVE=dev

# Comando para ejecutar la app Spring Boot después de esperar por MySQL
ENTRYPOINT ["/wait-for-it.sh", "db-mysql:3306", "--", "java", "-jar", "app.jar"]
