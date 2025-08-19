package com.fedeheinrich.literalura.principal;
import com.fedeheinrich.literalura.model.DatosLibro;
import com.fedeheinrich.literalura.model.Libro;
import com.fedeheinrich.literalura.repository.ILibroRepository;
import com.fedeheinrich.literalura.service.ConsumoAPI;
import com.fedeheinrich.literalura.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {

    // Atribut
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private static final String URL_BASE = "https://gutendex.com/books";
    private List<DatosLibro> datosLibros = new ArrayList<>();
    private Scanner teclado = new Scanner();
    private ILibroRepository repositorio;
    private List<Libro> libros;

    // Constructor
    public Principal(ILibroRepository repositorio){
        this.repositorio = repositorio;
    }

    // Metodo principal que muestra el menú y gestiona las opciones
    public void mostrarMenu(){
        var opcion = -1;
        while (opcion!=0){
            var textoMenu = """
                    1. Buscar libro por titulo (SE REGISTRA EN LA BASE DE DATOS)
                    2. Listar libros registrados
                    3. Listar autores registrados
                    4. Listar autores vivos en un determinado año
                    5. Listar libros por idioma
                    0. Salir
                    """;
            System.out.println(textoMenu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }


    }
    //
    private DatosLibro getDatosLibro(){
        System.out.println("Ingrese el título del libro que desea buscar:");
        String titulo = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + titulo.replace("", "+"));
        System.out.println(json);
        DatosLibro datosLibro = conversor.obtenerDatos(json, DatosLibro.class);
        return datosLibro;
    }

    private void buscarLibroPorTitulo() {
        DatosLibro datosLibro = getDatosLibro();
        Libro libro = new Libro(datosLibro);
        repositorio.save(libro);
        System.out.println(datosLibro);
        }

    private void listarLibrosRegistrados() {
        libros = repositorio.findAll();
        libros.stream().sorted(Comparator.comparing(Libro::getTitulo)).forEach(System.out::println);
    }
    private void listarAutoresRegistrados() {

    }

    private void listarLibrosPorIdioma() {
    }

    private void listarAutoresVivos() {
    }

}