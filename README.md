# Biblioteca Duoc — API REST

API REST para gestión de libros desarrollada con **Java 21** y **Spring Boot 4.0.5**. Permite registrar, consultar, actualizar, eliminar y buscar libros por autor mediante endpoints RESTful con validación de datos.

## Características

- **CRUD completo de libros** — crear, listar, actualizar y eliminar.
- **Búsqueda por autor** — filtrado por nombre de autor (case-insensitive).
- **Validación de datos** — Jakarta Validation (`@NotNull`, `@NotBlank`, `@Min`) con respuesta detallada por campo en caso de error.
- **Manejo de errores** — excepciones de negocio (ISBN duplicado, libro inexistente) con códigos HTTP apropiados (400, 404).
- **Datos precargados** — 10 libros de prueba generados automáticamente al iniciar (`@PostConstruct`).
- **Almacenamiento en memoria** — `ArrayList` como repositorio (sin base de datos externa).

## Stack / Tecnologías

| Tecnología | Versión |
|------------|---------|
| Java | 21 |
| Spring Boot | 4.0.5 |
| Spring Web MVC | (incluido en starter) |
| Jakarta Validation | (incluido en starter) |
| Lombok | — |
| Maven | Wrapper incluido |

> **Nota:** No se utiliza base de datos. Los datos viven en memoria y se reinician con cada arranque de la aplicación.

## Modelo — `Libro`

| Campo | Tipo | Validación |
|-------|------|------------|
| `id` | `Integer` | `@NotNull` — ISBN obligatorio |
| `titulo` | `String` | `@NotBlank` — no puede estar vacío |
| `autor` | `String` | `@NotBlank` — obligatorio |
| `paginas` | `int` | `@Min(1)` — al menos 1 página |
| `anioPublicacion` | `int` | `@Min(1800)` — no anterior a 1800 |

## Endpoints

Base: `/api/v1/libros`

| Método | Ruta | Descripción | Código éxito |
|--------|------|-------------|--------------|
| `GET` | `/api/v1/libros` | Listar todos los libros | `200 OK` |
| `POST` | `/api/v1/libros` | Registrar un libro nuevo | `201 Created` |
| `PUT` | `/api/v1/libros` | Actualizar un libro existente | `200 OK` |
| `DELETE` | `/api/v1/libros/{id}` | Eliminar un libro por ID | `204 No Content` |
| `GET` | `/api/v1/libros/buscar?autor=X` | Buscar libros por autor | `200 OK` |

### Ejemplo de JSON (POST / PUT)

```json
{
  "id": 101,
  "titulo": "Programación en Java 21",
  "autor": "Autor Ejemplo",
  "paginas": 350,
  "anioPublicacion": 2025
}
```

### Errores

| Caso | Código | Respuesta |
|------|--------|-----------|
| ISBN duplicado | `400 Bad Request` | `"Error: El ISBN 101 ya está registrado."` |
| Libro no encontrado (PUT/DELETE) | `404 Not Found` | `"Error: No se puede editar un libro que no existe (ID: 99)"` |
| Validación fallida | `400 Bad Request` | `{"titulo": "El título no puede estar en blanco", ...}` |

## Estructura del proyecto

```
src/main/java/com/example/bibliotecaduoc/
├── BibliotecaduocApplication.java      # Clase principal
├── controller/
│   └── LibroController.java            # Endpoints REST + manejo de errores
├── model/
│   └── Libro.java                      # Entidad con validaciones
├── repository/
│   └── LibroRepository.java            # Almacenamiento en memoria (ArrayList)
└── service/
    └── LibroService.java               # Lógica de negocio
```

## Cómo ejecutarlo

1. Asegúrate de tener **Java 21** instalado.
2. Clona o descarga el proyecto.
3. Ejecuta con el Maven Wrapper incluido:
   ```bash
   ./mvnw spring-boot:run
   ```
   En Windows:
   ```cmd
   mvnw.cmd spring-boot:run
   ```
4. La API estará disponible en `http://localhost:8080/api/v1/libros`.
5. Prueba los endpoints con **Postman**, **curl** o cualquier cliente HTTP.

## Autor

**Lukas Ávila** — Estudiante de Ingeniería en Informática, Duoc UC
- lukas.avila2002@gmail.com
- [GitHub](https://github.com/LukasAvilaPonce)
