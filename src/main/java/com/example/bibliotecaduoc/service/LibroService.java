package com.example.bibliotecaduoc.service;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository repo;

    /**
     * 1. OBTENER TODOS
     * Simplemente pide la lista al repositorio.
     */
    public List<Libro> obtenerTodos() {
        return repo.obtenerTodos();
    }

    /**
     * 2. REGISTRAR (POST)
     * Lógica: Usa el ciclo del repo para ver si el ID ya existe.
     */
    public void registrar(Libro nuevo) throws Exception {
        // Buscamos si ya existe para lanzar la "papa caliente"
        if (repo.buscarPorId(nuevo.getId()) != null) {
            throw new Exception("Error: El ISBN " + nuevo.getId() + " ya está registrado.");
        }
        repo.guardar(nuevo);
    }

    /**
     * 3. EDITAR (PUT)
     * Lógica: Recorre para validar que el libro exista antes de actualizar.
     */
    public void editar(Libro editado) throws Exception {
        boolean encontrado = false;
        List<Libro> lista = repo.obtenerTodos();

        // CICLO FOR PARA VALIDAR EXISTENCIA
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(editado.getId())) {
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            throw new Exception("Error: No se puede editar un libro que no existe (ID: " + editado.getId() + ")");
        }
        repo.actualizar(editado);
    }

    /**
     * 4. BORRAR (DELETE)
     * Lógica: Valida existencia antes de proceder al borrado.
     */
    public void borrar(Integer id) throws Exception {
        if (repo.buscarPorId(id) == null) {
            throw new Exception("Error: El libro con ID " + id + " no existe para ser eliminado.");
        }
        repo.eliminar(id);
    }

    /**
     * 5. FILTRAR POR AUTOR (Operación de Procesamiento)
     * Lógica: Crea una sub-lista filtrando con un ciclo for.
     */
    public List<Libro> filtrarPorAutor(String autor) {
        List<Libro> resultados = new ArrayList<>();
        List<Libro> todos = repo.obtenerTodos();

        // CICLO FOR PARA FILTRADO MANUAL
        for (int i = 0; i < todos.size(); i++) {
            Libro l = todos.get(i);
            // Comparamos ignorando mayúsculas/minúsculas
            if (l.getAutor().equalsIgnoreCase(autor)) {
                resultados.add(l);
            }
        }
        return resultados;
    }
}