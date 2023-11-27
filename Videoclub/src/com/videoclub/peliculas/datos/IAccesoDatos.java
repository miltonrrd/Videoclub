package com.videoclub.peliculas.datos;

import com.videoclub.peliculas.domain.Pelicula;
import com.videoclub.peliculas.excepciones.AccesoDatosEx;
import com.videoclub.peliculas.excepciones.EscrituraDatosEx;
import com.videoclub.peliculas.excepciones.LecturaDatosEx;

import java.util.List;

public interface IAccesoDatos {
    boolean existe(String nombreArchivo)throws AccesoDatosEx;
    List<Pelicula> listar(String nombreArchivo)throws LecturaDatosEx;
    void escribir(Pelicula pelicula, String nombreArchivo, Boolean anexar)throws EscrituraDatosEx;
    String buscar(String nombreArchivo, String buscar)throws LecturaDatosEx;
    void crear(String nombreArchivo)throws AccesoDatosEx;
    void borrar(String nombreArchivo)throws AccesoDatosEx;

}
