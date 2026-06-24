package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.Libro;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {
    private List<Libro> estanteria = new ArrayList<>();

    @PostConstruct
    public void cargarDatosIniciales() {
        // RELLENADO DINÁMICO CON FOR
        for (int i = 1; i <= 10; i++) {
            String AutorDinamico = (i % 2 == 0) ? "Sergio Gomez" : "Autor Duoc";
            Libro temp = new Libro(i,"Libro Spring Boot 6, tomo "+i,AutorDinamico,100 * i,2020+i);
            estanteria.add(temp);
        }
        System.out.println(">>> [INFO] Se han cargado " + estanteria.size() + " libros de prueba.");
    }


    public List<Libro> obtenerTodos() {
        return estanteria;
    }

    public Libro buscarPorId(Integer id) {
        // RECORRIDO MANUAL CON FOR
        for (int i = 0; i < estanteria.size(); i++) {
            if (estanteria.get(i).getId().equals(id)) {
                return estanteria.get(i);
            }
        }
        return null;
    }

    public void guardar(Libro l) {
        estanteria.add(l);
    }

    public void actualizar(Libro editado) {
        for (int i = 0; i < estanteria.size(); i++) {
            if (estanteria.get(i).getId().equals(editado.getId())) {
                estanteria.set(i, editado);
                break;
            }
        }
    }

    public void eliminar(Integer id) {
        for (int i = 0; i < estanteria.size(); i++) {
            if (estanteria.get(i).getId().equals(id)) {
                estanteria.remove(i);
                break;
            }
        }
    }
}