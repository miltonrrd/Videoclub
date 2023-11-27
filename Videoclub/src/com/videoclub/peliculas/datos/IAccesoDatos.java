package com.videoclub.peliculas.datos;

import com.videoclub.peliculas.domain.Pelicula;

import java.util.List;

public interface IAccesoDatos {
    public boolean existe(String nombreArchivo);
    public List<Pelicula> listar(String nombre);
    public void escribir(Pelicula pelicula, String nombreArchivo, Boolean anexar);
    public String buscar(String nombreArchivo, String buscar);
    public void crear(String nombreArchivo);
    public void borrar(String nombreArchivo);

}
