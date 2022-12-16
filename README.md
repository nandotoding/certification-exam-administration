
# Certification Exam Administration

A REST API mini project using JAVA Spring Boot and PostgreSQL DB.


Find the ERD in the same folder of this file.


## Requirements

This API was developed in order to meet certain requirements.

1. This project implements **Inversion of Control** principle, specifically in use of Dependency Injection, by registering the methods to Spring Container as Beans using Annotation based configuration and Java class based configuration.
2. This project uses **JAVA stream** in mapping and filtering collections. This can be found at `src/main/java/com/test/certificationexamadministration/service/implementation/ScoreServiceImpl.java`.
3. In order to meet the requirements, this project uses some **Native Queries** instead of JPA Repository built in methods. This can be found at `src/main/java/com/test/certificationexamadministration/repository`.


## Quick Example in how to use this API

### Environmet config variables 

`src/main/resources/application.properties`

`HOST` : Database HOST

`PORT` : Database PORT

`DB_NAME` : Database Name

`DB_USERNAME` : Database Username

`DB_PASSWORD` : Database Password

### Steps

1. Open Swagger UI at `http://{HOST}:{PORT}/swagger-ui/index.html`
2. Insert some data into `users` database table at `/users` endpoint.
3. Insert some data into `exam_levels` database table at `/exam-levels` endpoint.
4. Insert some data into `exam_modules` database table at `/exam_modules` endpoint. This table has a foreign key from `exam_levels` table.
5. Insert some data into `exam_attempts` database table at `/exam_attempts`endpoint. This table has two foreign keys from `users` and `exam_modules` table.
6. Insert some data into `scores` database table at `/scores` endpoint. This table has a foreign key from `exam_attempts` table.
7. Get Exam Score Report from `/scores/report` endpoint.
8. Try other features/methods at various endpoints.

Step 2 to 7 is necessary and must be in order because of entity relations.