package com.example.bibliotecaduoc.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    @NotNull(message = "El código ISBN es obligatorio")
    private Integer id;

    @NotBlank(message = "El título no puede estar en blanco")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    @Min(value = 1, message = "El libro debe tener al menos 1 página")
    private int paginas;

    @Min(value = 1800, message = "El año no puede ser anterior a 1800")
    private int anioPublicacion;
}