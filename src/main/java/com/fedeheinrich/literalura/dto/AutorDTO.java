package com.fedeheinrich.literalura.dto;

import java.time.LocalDate;

public record AutorDTO(
    Long id,
    String nombre,
    LocalDate fechaNacimiento
) {
}

