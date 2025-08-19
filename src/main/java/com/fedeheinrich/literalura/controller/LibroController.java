package com.fedeheinrich.literalura.controller;

import com.fedeheinrich.literalura.dto.LibroDTO;
import com.fedeheinrich.literalura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class LibroController {
    @Autowired
    private LibroService servicio;

    @GetMapping
    public List<LibroDTO> obtenerLibros() {
        return servicio.obtenerLibros();
    }
}
