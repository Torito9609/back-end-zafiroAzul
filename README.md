
# Back-end Zafiro Azul — API REST (Spring Boot)

Proyecto de práctica para aprender los fundamentos de Spring Boot construyendo una API REST conectada a base de datos (MySQL en local).

## Objetivo
- Entender estructura típica de un backend con Spring Boot
- Practicar capas (controller/service/repository)
- Conectar con BD (CRUD)
- Integración local con frontend (cuando aplica)

## Stack (nivel básico)
- Java
- Spring Boot (REST)
- MySQL (local)
- Maven

## Cómo ejecutar (guía general)
1. Configura la BD en MySQL (schema/usuario)
2. Ajusta `application.properties`:
   - URL
   - usuario
   - contraseña
3. Ejecuta:
```bash
./mvnw spring-boot:run
