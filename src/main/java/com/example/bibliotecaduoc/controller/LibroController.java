package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService service;

    /**
     * 1. LISTAR TODOS (GET)
     * Retorna la lista completa desde el repositorio.
     */
    @GetMapping
    public ResponseEntity<List<Libro>> listarTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    /**
     * 2. CREAR (POST)
     * @Valid activa las reglas del modelo (ISBN obligatorio, etc.)
     */
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Libro nuevo) {
        try {
            service.registrar(nuevo);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (Exception e) {
            // Atrapa el error de "ISBN ya existe"
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 3. ACTUALIZAR (PUT)
     * Busca por ID y reemplaza los datos.
     */
    @PutMapping
    public ResponseEntity<?> actualizar(@Valid @RequestBody Libro editado) {
        try {
            service.editar(editado);
            return ResponseEntity.ok(editado);
        } catch (Exception e) {
            // Si el ID no existe, retorna 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    /**
     * 4. ELIMINAR (DELETE)
     * Recibe el ID por la URL.
     * @author FL
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            service.borrar(id);
            // 204 No Content es el éxito estándar para borrar
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    /**
     * 5. BUSCAR POR AUTOR (GET con Parámetro)
     * Ejemplo: /api/v1/libros/buscar?autor=Cervantes
     */
    @GetMapping("/buscar")
    public ResponseEntity<List<Libro>> buscarPorAutor(@RequestParam String autor) {
        return ResponseEntity.ok(service.filtrarPorAutor(autor));
    }

    /**
     * MANEJADOR DE ERRORES DE VALIDACIÓN
     * Este método atrapa los fallos de @Valid antes de entrar a los métodos.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> manejarErroresValidacion(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errores.put(error.getField(), error.getDefaultMessage());
        }
        return errores;
    }
}