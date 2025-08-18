package com.fedeheinrich.literalura.controllers;
import com.fedeheinrich.literalura.services.ConsumoAPI;
import com.fedeheinrich.literalura.services.ConvierteDatos;
import java.util.Scanner;

public class Principal {

    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private static final String URL_BASE = "https://gutendex.com/books";
    private Scanner teclado = new Scanner();

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
}
