# Biblioteca Duoc

Sistema web de gestión bibliotecaria desarrollado con **HTML, CSS y JavaScript puro**. Funciona 100% en el navegador sin backend — los datos se guardan en **localStorage** y persisten entre visitas.

Demo en GitHub Pages: **https://lukasavilaponce.github.io/Biblioteca_Duoc/**

## Funcionalidades

### Login
- Autenticación simulada con dos perfiles: **Administrador** y **Bibliotecario**.
- Credenciales de prueba incluidas en pantalla.

### Dashboard
- Contadores en tiempo real: total de libros, disponibles, prestados y géneros.
- Gráfico de barras por género con porcentajes.
- Feed de actividad reciente (préstamos y devoluciones).

### Catálogo de libros
- Tarjetas visuales con título, autor, género, año y estado.
- CRUD completo: agregar, editar y eliminar libros.
- Préstamo (registra nombre y fecha) y devolución con un clic.
- Buscador en vivo por título o autor.
- Filtros por estado (Todos / Disponibles / Prestados) y por género.

### Historial de préstamos
- Tabla con todos los préstamos activos y devueltos.
- Devolución directa desde la tabla.

### Usuarios (solo Administrador)
- Vista de los usuarios registrados en el sistema con sus roles.

### General
- 12 libros de ejemplo precargados.
- Datos persistentes en localStorage.
- Diseño responsive (escritorio y móvil).
- Sidebar colapsable en pantallas pequeñas.
- Notificaciones toast en cada acción.

## Credenciales de prueba

| Usuario | Contraseña | Perfil |
|---------|------------|--------|
| `admin` | `1234` | Administrador |
| `biblio` | `1234` | Bibliotecario |

## Tecnologías

| Tecnología | Uso |
|------------|-----|
| HTML5 | Estructura |
| CSS3 | Diseño responsive, animaciones |
| JavaScript | Lógica CRUD, navegación SPA, filtros |
| localStorage | Persistencia de datos |
| Google Fonts (Nunito) | Tipografía |

## Cómo usarlo

### Opción 1 — GitHub Pages
Visita: **https://lukasavilaponce.github.io/Biblioteca_Duoc/**

### Opción 2 — Local
1. Clona el repositorio:
   ```bash
   git clone https://github.com/LukasAvilaPonce/Biblioteca_Duoc.git
   ```
2. Abre `index.html` en tu navegador. No necesitas servidor ni instalación.

## Estructura

```
Biblioteca_Duoc/
├── index.html       # Aplicación completa (CSS y JS inline)
├── README.md        # Este archivo
└── src/             # API REST original (Java/Spring Boot, referencia)
```

## Autor

**Lukas Ávila** — Estudiante de Ingeniería en Informática, Duoc UC
- lukas.avila2002@gmail.com
- [GitHub](https://github.com/LukasAvilaPonce)
