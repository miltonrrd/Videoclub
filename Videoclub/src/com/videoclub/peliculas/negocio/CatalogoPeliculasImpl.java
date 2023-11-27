package com.videoclub.peliculas.negocio;

import com.videoclub.peliculas.datos.AccesoDatosImpl;
import com.videoclub.peliculas.datos.IAccesoDatos;
import com.videoclub.peliculas.domain.Pelicula;
import com.videoclub.peliculas.excepciones.AccesoDatosEx;
import com.videoclub.peliculas.excepciones.LecturaDatosEx;

import java.util.ArrayList;
import java.util.List;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas{

    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl(){
        this.datos = new AccesoDatosImpl();
    }
    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        Boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula,NOMBRE_RECURSO,anexar);
        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso de datos");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            List<Pelicula> peliculas = datos.listar(NOMBRE_RECURSO);
            for (var pelicula: peliculas) {
                System.out.println(pelicula.toString());
            }
        } catch (LecturaDatosEx e) {
            System.out.println("Error de acceso de datos");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (LecturaDatosEx e) {
            System.out.println("Error de acceso de datos");
            e.printStackTrace(System.out);
        }
        System.out.println("Resultado = " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx e) {
            System.out.println("Error al iniciar catalogo de peliculas");
            e.printStackTrace(System.out);
        }
    }
}
