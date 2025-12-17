# Spring Boot Demo - Task API

Este proyecto es una API REST básica para la gestión de tareas (To-Do list), desarrollada como parte de mi ruta de aprendizaje en Spring Boot utilizando **Java 25**.

## Características Técnicas
- **Java 25**: Uso de `void main()` de instancia y `records` para modelos de datos ligeros.
- **Spring Web**: Implementación de controladores REST con mapeos para GET, POST, PUT y DELETE.
- **Persistencia en Memoria**: Uso de un `HashMap` y `AtomicLong` en la capa de repositorio para simular una base de datos.

## Estructura del Proyecto
- `Task.java`: Modelo de datos definido como un `record` de Java.
- `TaskRepository.java`: Capa de persistencia que gestiona el almacenamiento de las tareas.
- `TaskController.java`: Define los endpoints bajo la ruta `/tasks`.

## Endpoints Principales
- `GET /tasks`: Lista todas las tareas.
- `POST /tasks`: Crea una nueva tarea (recibe un título).
- `PUT /tasks/{id}`: Actualiza el estado o título de una tarea existente.
- `DELETE /tasks/{id}`: Elimina una tarea por su ID.
