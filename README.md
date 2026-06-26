# Biblioteca Duoc

Aplicación web de gestión de libros desarrollada con **HTML, CSS y JavaScript puro**. Funciona 100% en el navegador sin necesidad de backend — los datos se guardan en **localStorage** y persisten entre visitas.

Publicada en GitHub Pages: **https://lukasavilaponce.github.io/bibliotecaduoc/**

## Funcionalidades

- **Catálogo visual** — libros mostrados en tarjetas con título, autor, género, año y estado (Disponible / Prestado).
- **Agregar libros** — formulario para registrar nuevos libros.
- **Editar y eliminar** — modificar datos o quitar libros del catálogo.
- **Préstamo y devolución** — prestar un libro registrando quién se lo lleva y la fecha; devolver con un clic.
- **Buscador en vivo** — filtra por título o autor mientras se escribe.
- **Filtros** — por estado (Todos / Disponibles / Prestados) y por género.
- **Contadores** — total de libros, disponibles y prestados en tiempo real.
- **6 libros de ejemplo** precargados la primera vez.
- **Datos persistentes** — todo se guarda en localStorage del navegador.

## Tecnologías

| Tecnología | Uso |
|------------|-----|
| HTML5 | Estructura y semántica |
| CSS3 | Diseño responsivo, tarjetas, animaciones |
| JavaScript | Lógica de la aplicación, CRUD, filtros |
| localStorage | Persistencia de datos en el navegador |
| Google Fonts (Nunito) | Tipografía |

## Cómo usarlo

### Opción 1 — GitHub Pages
Visita directamente: **https://lukasavilaponce.github.io/bibliotecaduoc/**

### Opción 2 — Local
1. Clona el repositorio:
   ```bash
   git clone https://github.com/LukasAvilaPonce/bibliotecaduoc.git
   ```
2. Abre `index.html` en tu navegador. No necesitas servidor ni instalación.

## Estructura del proyecto

```
bibliotecaduoc/
├── index.html          # Aplicación web completa (CSS y JS inline)
├── README.md           # Este archivo
└── src/                # Código fuente del API REST original (Java/Spring Boot)
```

> **Nota:** La carpeta `src/` contiene una versión anterior del proyecto como API REST en Java 21 / Spring Boot. Se conserva como referencia.

## Autor

**Lukas Ávila** — Estudiante de Ingeniería en Informática, Duoc UC
- lukas.avila2002@gmail.com
- [GitHub](https://github.com/LukasAvilaPonce)
