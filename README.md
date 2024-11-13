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
- [Postman](#postman)

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
- **Base de Datos (MySQL)**

## Configuración del Entorno

1. **Java 21**: Asegúrate de tener Java 21 instalado.
2. **Base de Datos**: Configura tu base de datos en `application.properties`.
3. **Maven**: El proyecto usa Maven para la gestión de dependencias. Puedes instalar Maven desde [aquí](https://maven.apache.org/).

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/kamilo9809/backend-Spring.git
   
   cd tu-repositorio
   ```

2. Configura el archivo src/main/resources/application.properties:
# Configuración de la Base de Datos
```java
spring.datasource.url=jdbc:mysql://localhost:3306/reto_backend
spring.datasource.username=fundacion_antivirus
spring.datasource.password=Antivirus
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

# Configuración de JPA
```java
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

# Configuración de Seguridad
```java
spring.security.user.name=admin
spring.security.user.password=admin123
```

# Crea la Base de Datos y Usuario en MySQL: 

Ejecuta el siguiente comando en tu consola de MySQL para crear la base de datos, el usuario y otorgarle permisos:


```sql
CREATE DATABASE reto_backend;

CREATE USER 'fundacion_antivirus'@'localhost' IDENTIFIED BY 'Antivirus';

GRANT ALL PRIVILEGES ON reto_backend.* TO 'fundacion_antivirus'@'localhost';

FLUSH PRIVILEGES;
```

## Instala las dependencias:

```bash
mvn clean install
```

## Ejecución del Proyecto

Para ejecutar el proyecto en un entorno de desarrollo:

```bash
mvn spring-boot:run
La API estará disponible en http://localhost:8080.
```

## Endpoints de la API

| Método | Endpoint                      | Descripción                        |
|--------|-------------------------------|------------------------------------|
| POST   | /api/auth/register             | Registro de nuevos usuarios       |
| POST   | /api/auth/Authenticate         | Autenticación de usuario          |
| GET    | /api/users                     | Obtener lista de usuarios         |
| GET    | /api/users/{id}                | Obtener un usuario específico     |
| PUT    | /api/users/{id}/{idRole}       | Actualizar usuario                |
| DELETE | /api/users/{id}                | Eliminar usuario                  |
| GET    | /api/roles                     | Obtener lista de roles            |
| GET    | /api/roles/{id}                | Obtener un rol específico         |
| POST   | /api/roles                     | Crear un nuevo rol                |
| PUT    | /api/roles/{id}                | Actualizar rol                    |
| DELETE | /api/roles/{id}                | Eliminar rol                      |
| GET    | /api/categories_opportunities  | Obtener lista de categorías de oportunidades |
| GET    | /api/categories_opportunities/{id} | Obtener una categoría de oportunidad específica |
| POST   | /api/categories_opportunities  | Crear una nueva categoría de oportunidad |
| PUT    | /api/categories_opportunities/{id} | Actualizar una categoría de oportunidad |
| DELETE | /api/categories_opportunities/{id} | Eliminar una categoría de oportunidad |
| GET    | /api/opportunities             | Obtener lista de oportunidades    |
| GET    | /api/opportunities/{id}        | Obtener una oportunidad específica|
| POST   | /api/opportunities             | Crear una nueva oportunidad       |
| PUT    | /api/opportunities/{id}        | Actualizar una oportunidad        |
| DELETE | /api/opportunities/{id}        | Eliminar una oportunidad          |
| GET    | /api/status_opportunities      | Obtener lista de estados de oportunidades |
| GET    | /api/status_opportunities/{id} | Obtener un estado de oportunidad específico |
| POST   | /api/status_opportunities      | Crear un nuevo estado de oportunidad |
| PUT    | /api/status_opportunities/{id} | Actualizar estado de oportunidad  |
| DELETE | /api/status_opportunities/{id} | Eliminar estado de oportunidad    |
| GET    | /api/type_opportunities        | Obtener lista de tipos de oportunidades |
| GET    | /api/type_opportunities/{id}   | Obtener un tipo de oportunidad específico |
| POST   | /api/type_opportunities        | Crear un nuevo tipo de oportunidad |
| PUT    | /api/type_opportunities/{id}   | Actualizar un tipo de oportunidad |
| DELETE | /api/type_opportunities/{id}   | Eliminar un tipo de oportunidad   |
| GET    | /api/user_oportunities         | Obtener oportunidades de usuario  |
| GET    | /api/bootcamps                 | Obtener lista de bootcamps        |
| GET    | /api/bootcamps/{id}            | Obtener un bootcamp específico    |
| POST   | /api/bootcamps                 | Crear un nuevo bootcamp           |
| PUT    | /api/bootcamps/{id}            | Actualizar un bootcamp            |
| DELETE | /api/bootcamps/{id}            | Eliminar un bootcamp              |
| GET    | /api/costs_bootcamps           | Obtener lista de costos de bootcamps |
| GET    | /api/costs_bootcamps/{id}      | Obtener un costo de bootcamp específico |
| POST   | /api/costs_bootcamps           | Crear un nuevo costo de bootcamp  |
| PUT    | /api/costs_bootcamps/{id}      | Actualizar un costo de bootcamp   |
| DELETE | /api/costs_bootcamps/{id}      | Eliminar un costo de bootcamp     |
| GET    | /api/descriptions_bootcamps    | Obtener lista de descripciones de bootcamps |
| GET    | /api/descriptions_bootcamps/{id} | Obtener una descripción de bootcamp específica |
| POST   | /api/descriptions_bootcamps    | Crear una nueva descripción de bootcamp |
| PUT    | /api/descriptions_bootcamps/{id} | Actualizar una descripción de bootcamp |
| DELETE | /api/descriptions_bootcamps/{id} | Eliminar una descripción de bootcamp |
| GET    | /api/status_bootcamps          | Obtener lista de estados de bootcamps |
| GET    | /api/status_bootcamps/{id}     | Obtener un estado de bootcamp específico |
| POST   | /api/status_bootcamps          | Crear un nuevo estado de bootcamp |
| PUT    | /api/status_bootcamps/{id}     | Actualizar un estado de bootcamp  |
| DELETE | /api/status_bootcamps/{id}     | Eliminar un estado de bootcamp    |
| GET    | /api/topics_bootcamps          | Obtener lista de temas de bootcamps |
| GET    | /api/topics_bootcamps/{id}     | Obtener un tema de bootcamp específico |
| POST   | /api/topics_bootcamps          | Crear un nuevo tema de bootcamp   |
| PUT    | /api/topics_bootcamps/{id}     | Actualizar un tema de bootcamp    |
| DELETE | /api/topics_bootcamps/{id}     | Eliminar un tema de bootcamp      |
| GET    | /api/user_bootcamps            | Obtener bootcamps de usuario      |
| GET    | /api/ubications_institutions   | Obtener lista de ubicaciones de instituciones |
| GET    | /api/ubications_institutions/{id} | Obtener una ubicación de institución específica |
| POST   | /api/ubications_institutions   | Crear una nueva ubicación de institución |
| PUT    | /api/ubications_institutions/{id} | Actualizar una ubicación de institución |
| DELETE | /api/ubications_institutions/{id} | Eliminar una ubicación de institución |
| GET    | /api/status_institutions       | Obtener lista de estados de instituciones |
| GET    | /api/status_institutions/{id}  | Obtener un estado de institución específico |
| POST   | /api/status_institutions       | Crear un nuevo estado de institución |
| PUT    | /api/status_institutions/{id}  | Actualizar estado de institución  |
| DELETE | /api/status_institutions/{id}  | Eliminar estado de institución    |
| GET    | /api/institutions              | Obtener lista de instituciones    |
| GET    | /api/institutions/{id}         | Obtener una institución específica |
| POST   | /api/institutions              | Crear una nueva institución       |
| PUT    | /api/institutions/{id}         | Actualizar una institución        |
| DELETE | /api/institutions/{id}         | Eliminar una institución          |
| GET    | /api/institute_opportunities   | Obtener lista de oportunidades por institución |
| GET    | /api/institute_opportunities/{id} | Obtener una oportunidad por institución específica |
| POST   | /api/institute_opportunities   | Crear una nueva oportunidad por institución |
| PUT    | /api/institute_opportunities/{id} | Actualizar una oportunidad por institución |
| DELETE | /api/institute_opportunities/{id} | Eliminar una oportunidad por institución |
| GET    | /api/institute_bootcamps       | Obtener lista de bootcamps por institución |
| GET    | /api/institute_bootcamps/{id}  | Obtener un bootcamp por institución específico |
| POST   | /api/institute_bootcamps       | Crear un nuevo bootcamp por institución |
| PUT    | /api/institute_bootcamps/{id}  | Actualizar un bootcamp por institución |
| DELETE | /api/institute_bootcamps/{id}  | Eliminar un bootcamp por institución |
| GET    | /api/userauth                  | Obtener lista de usuarios autenticados |
| GET    | /api/userauth/{id}             | Obtener un usuario autenticado específico |
| POST   | /api/userauth                  | Crear un nuevo usuario autenticado |
| PUT    | /api/userauth/{id}             | Actualizar un usuario autenticado |
| DELETE | /api/userauth/{id}             | Eliminar un usuario autenticado   |



# Contribuciones
Las contribuciones son bienvenidas. Si deseas contribuir:

# Haz un fork del proyecto.

### Crea una nueva rama (
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
   ).
### Realiza tus cambios y haz commit (
   ```bash
   git commit -m 'Agrega nueva funcionalidad'
   ```
   ).
### Sube tus cambios (
   ```bash
   git push origin feature/nueva-funcionalidad
   ```
   ).

### Abre un Pull Request.

## Postman

[Toca este enlace para que puedas hacer las pruebas en un entorno postman](https://app.getpostman.com/join-team?invite_code=710f31ce1d29e38f84633fdc69b0b0a8&target_code=a4bf62fa68328a929a13aedc36b7fbed)