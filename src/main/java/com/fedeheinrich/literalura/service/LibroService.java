package com.fedeheinrich.literalura.service;

import com.fedeheinrich.literalura.dto.LibroDTO;
import com.fedeheinrich.literalura.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroService {
    @Autowired
    private ILibroRepository repository;

    public List<LibroDTO> obtenerLibros(){
        return convierteDatos(repository.findAll());
    }

}
