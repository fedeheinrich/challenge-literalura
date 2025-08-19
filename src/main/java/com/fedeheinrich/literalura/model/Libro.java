package com.fedeheinrich.literalura.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, FetchType.EAGER)
    private List<Autor> autores;
    private List<String> idiomas;
    private Double descargas;

    // Constructores
    public Libro(){}

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.autores = datosLibro.autores().stream(); // continuar acá
        this.idiomas = datosLibro.idiomas();
        this.descargas = datosLibro.descargas();
    }

    // getters
    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public List<Autor> getAutores() {
        return autores;
    }
    public List<String> getIdiomas() {
        return idiomas;
    }
    public Double getDescargas() {
        return descargas;
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }
    public void setDescargas(Double descargas) {
        this.descargas = descargas;
    }

    // Métodos
    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", idiomas=" + idiomas +
                ", descargas=" + descargas +
                '}';
    }

}
