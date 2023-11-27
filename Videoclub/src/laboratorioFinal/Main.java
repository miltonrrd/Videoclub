package laboratorioFinal;

import com.videoclub.peliculas.negocio.CatalogoPeliculasImpl;
import com.videoclub.peliculas.negocio.ICatalogoPeliculas;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static int opcion = 1;
    public static ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
    String nombreArchivo = "C:\\Users\\milto\\OneDrive\\Escritorio\\Cursos\\Backend-JAVA\\Videoclub";

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        while (opcion != 0){
            System.out.println("******************************");
            System.out.println("           MENÚ");
            System.out.println("******************************");
            System.out.println("Elige opción:");
            System.out.println("1.-Iniciar catálogo peliculas.");
            System.out.println("2.-Agregar pelicula.");
            System.out.println("3.-Listar peliculas.");
            System.out.println("4.-Buscar pelicula.");
            System.out.println("0.-Salir.");

            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Ingrese la pelicula que desea cargar:");
                    String pelicula = scanner.nextLine();
                    catalogo.agregarPelicula(pelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Ingrese la pelicula que desea buscar:");
                    pelicula = scanner.nextLine();
                    catalogo.buscarPelicula(pelicula);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Ingrese un valor correcto");
            }
        }
    }
}