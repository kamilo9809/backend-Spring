# Proyecto Backend en Spring Boot

Este es un proyecto de backend desarrollado con Spring Boot y Maven. Proporciona una API REST para la gestión de usuarios y roles, utilizando Hibernate para la persistencia en base de datos y Spring Security para la autenticación y autorización.

## Tabla de Contenidos
- [Características](#características)
- [Tecnologías Usadas](#tecnologías-usadas)
- [Configuración del Entorno](#configuración-del-entorno)
- [Instalación](#instalación)
- [Ejecución del Proyecto](#ejecución-del-proyecto)
- [Endpoints de la API](#endpoints-de-la-api)
- [Contribuciones](#contribuciones)

---

## Características
- **Autenticación**: Soporte para autenticación y autorización con Spring Security.
- **Gestión de Usuarios y Roles**: API para crear, actualizar y eliminar usuarios, y asignarles roles.
- **Configuración de CORS**: Soporte para solicitudes desde distintos orígenes.
- **Base de Datos Relacional**: Persistencia de datos utilizando Hibernate con JPA.

## Tecnologías Usadas
- **Java 21**
- **Spring Boot 3**
- **Maven**
- **Spring Security**
- **Hibernate / JPA**
- **Base de Datos (MySQL / PostgreSQL)**

## Configuración del Entorno

1. **Java 17**: Asegúrate de tener Java 17 instalado.
2. **Base de Datos**: Configura tu base de datos en `application.properties`.
3. **Maven**: El proyecto usa Maven para la gestión de dependencias. Puedes instalar Maven desde [aquí](https://maven.apache.org/).

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/tu-repositorio.git
   cd tu-repositorio

2. Configura el archivo src/main/resources/application.properties:

# Configuración de la Base de Datos
spring.datasource.url=jdbc:mysql://localhost:3306/Antivirus_db
spring.datasource.username=fundacion_antivirus
spring.datasource.password=Antivirus
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración de JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Configuración de Seguridad
spring.security.user.name=admin
spring.security.user.password=admin123
Crea la Base de Datos y Usuario en MySQL: Ejecuta el siguiente comando en tu consola de MySQL para crear la base de datos, el usuario y otorgarle permisos:

sql
Copiar código
CREATE DATABASE Antivirus_db;

CREATE USER 'fundacion_antivirus'@'localhost' IDENTIFIED BY 'Antivirus';

GRANT ALL PRIVILEGES ON Antivirus_db.* TO 'fundacion_antivirus'@'localhost';

FLUSH PRIVILEGES;
Instala las dependencias:

bash
Copiar código
mvn clean install
Ejecución del Proyecto
Para ejecutar el proyecto en un entorno de desarrollo:

bash
Copiar código
mvn spring-boot:run
La API estará disponible en http://localhost:8080.

## Endpoints de la API

| Método | Endpoint             | Descripción                        |
|--------|----------------------|------------------------------------|
| POST   | /api/auth/register    | Registro de nuevos usuarios       |
| POST   | /api/auth/login       | Autenticación de usuario          |
| GET    | /api/users            | Obtener lista de usuarios         |
| GET    | /api/users/{id}       | Obtener un usuario específico     |
| PUT    | /api/users/{id}       | Actualizar usuario                |
| DELETE | /api/users/{id}       | Eliminar usuario                  |


# Contribuciones
Las contribuciones son bienvenidas. Si deseas contribuir:

Haz un fork del proyecto.
Crea una nueva rama (git checkout -b feature/nueva-funcionalidad).
Realiza tus cambios y haz commit (git commit -m 'Agrega nueva funcionalidad').
Sube tus cambios (git push origin feature/nueva-funcionalidad).
Abre un Pull Request.

## Postman

