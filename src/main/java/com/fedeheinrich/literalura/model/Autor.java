package com.fedeheinrich.literalura.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.DateTimeException;

@Entity
@Table(name = "autores")
public class Autor() {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private LocalDate fechaNacimiento;

    // Constructores
    public Autor(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Autor() {
        // Constructor por defecto
    }

    // Getters
    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    // Setters
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // Metodos
    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
