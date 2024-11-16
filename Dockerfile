# Usar una imagen base de Tomcat
FROM tomcat:10.1-jdk21-temurin

# Eliminar las aplicaciones predeterminadas de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copiar el archivo .war generado en el directorio webapps de Tomcat
COPY target/backen-project-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/app.war

# Exponer el puerto en el que se ejecutará Tomcat
EXPOSE 8080