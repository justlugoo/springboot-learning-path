# Panel Admin API

API REST para gestión de usuarios con autenticación JWT, autorización por roles y operaciones CRUD completas. Proyecto diseñado para aprender Spring Security, arquitectura en capas y buenas prácticas en aplicaciones empresariales.

## Stack Tecnológico

Java 25, Spring Boot 4.0.0, Spring Security, JWT, PostgreSQL, Maven, Docker

## Arquitectura

```
┌─────────────┐
│ Controller  │ ← REST endpoints y validación de entrada
├─────────────┤
│  Service    │ ← Lógica de negocio y reglas de autorización
├─────────────┤
│ Repository  │ ← Acceso a base de datos con JPA
├─────────────┤
│   Model     │ ← Entidades y relaciones
└─────────────┘

Componentes adicionales:
• DTO: Objetos de transferencia request/response
• Security: Filtros JWT y configuración de seguridad
• Exception: Manejo centralizado de errores
```

## Roles y Permisos

**USER** - Gestión de perfil propio y consulta básica de usuarios

**MODERATOR** - Gestión de usuarios con restricciones (no puede eliminar ni cambiar roles)

**ADMIN** - Control total del sistema

## Endpoints

### Públicos
```
POST   /api/auth/register          Registrar usuario
POST   /api/auth/login             Iniciar sesión
```

### USER (Autenticados)
```
GET    /api/profile                Ver perfil propio
PUT    /api/profile                Actualizar perfil
PUT    /api/profile/password       Cambiar contraseña
DELETE /api/profile                Eliminar cuenta
GET    /api/users                  Listar usuarios (datos básicos)
GET    /api/users/{id}             Ver usuario (datos públicos)
```

### MODERATOR
```
GET    /api/users                  Listar usuarios (datos completos)
GET    /api/users/{id}             Ver usuario completo
PUT    /api/users/{id}             Actualizar usuario
PATCH  /api/users/{id}/status      Activar/Desactivar usuario
GET    /api/users/search           Buscar usuarios
GET    /api/users/stats            Ver estadísticas
```

### ADMIN
```
POST   /api/users                  Crear usuario
PUT    /api/users/{id}             Actualizar usuario
DELETE /api/users/{id}             Eliminar usuario
PATCH  /api/users/{id}/role        Cambiar rol
POST   /api/users/bulk             Crear usuarios en lote
DELETE /api/users/bulk             Eliminar usuarios en lote

+ Todos los endpoints de MODERATOR
```

## Configuración

### Base de Datos
```sql
CREATE DATABASE panel_admin_db;
```

### Variables de Entorno
```properties
DB_URL=jdbc:postgresql://localhost:5432/panel_admin_db
DB_USERNAME=usuario
DB_PASSWORD=contraseña
JWT_SECRET=clave_secreta_segura
JWT_EXPIRATION=86400000
```

## Ejecución

```bash
mvn clean install
mvn spring-boot:run
```

Aplicación disponible en `http://localhost:8080`

## Ejemplo de Uso

Registro:
```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"username": "john", "email": "john@example.com", "password": "pass123"}'
```

Login:
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username": "john", "password": "pass123"}'
```

Acceso protegido:
```bash
curl -X GET http://localhost:8080/api/profile \
  -H "Authorization: Bearer {token}"
```

---

**Autor**: Mauricio Lugo | **Versión**: 0.0.1-SNAPSHOT