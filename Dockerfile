FROM openjdk:21-slim

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Instalar netcat y dockerize
RUN apt-get update && \
    apt-get install -y netcat-openbsd curl && \
    curl -sSL https://github.com/jwilder/dockerize/releases/download/v0.6.1/dockerize-linux-amd64-v0.6.1.tar.gz | tar xz -C /usr/local/bin && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Copia el archivo JAR generado a /app en el contenedor
COPY target/backen-project-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que corre la aplicación Spring Boot (default: 8080)
EXPOSE 8080

# # # Copia el script wait-for-it.sh
# COPY wait-for-it.sh /wait-for-it.sh
# RUN chmod +x /wait-for-it.sh

# Establece el perfil activo de Spring Boot
ENV SPRING_PROFILES_ACTIVE=dev

# Comando para ejecutar la app Spring Boot después de esperar por MySQL
# ENTRYPOINT ["java", "-jar", "app.jar"]
ENTRYPOINT ["dockerize", "-wait", "tcp://db-mysql:3306", "-timeout", "30s", "java", "-jar", "app.jar"]

