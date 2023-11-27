package com.videoclub.peliculas.datos;

import com.videoclub.peliculas.domain.Pelicula;

import java.util.List;

public class AccesoDatosImpl implements IAccesoDatos{
    @Override
    public boolean existe(String nombreArchivo) {
        return false;
    }

    @Override
    public List<Pelicula> listar(String nombre) {
        return null;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, Boolean anexar) {

    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        return null;
    }

    @Override
    public void crear(String nombreArchivo) {

    }

    @Override
    public void borrar(String nombreArchivo) {

    }
}
