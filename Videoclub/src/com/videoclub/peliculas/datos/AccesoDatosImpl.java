package com.videoclub.peliculas.datos;

import com.videoclub.peliculas.domain.Pelicula;
import com.videoclub.peliculas.excepciones.AccesoDatosEx;
import com.videoclub.peliculas.excepciones.EscrituraDatosEx;
import com.videoclub.peliculas.excepciones.LecturaDatosEx;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosImpl implements IAccesoDatos{

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null){
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas:" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas:" + e.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, Boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo,anexar));
            String escritura = pelicula.getNombre();
            salida.println(escritura);
            salida.close();
            System.out.println("Se ha grabado correctamente la pelicula en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new EscrituraDatosEx("Excepcion al esribir pelicula: "+ e.getMessage());
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            BufferedReader lectura = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int indice = 1;
            linea = lectura.readLine();
            while (linea != null){
                if (buscar != null && linea.equalsIgnoreCase(buscar)){
                    resultado= "Pelicula "+ buscar + " encontrada en la linea "+ indice;
                    break;
                }
                linea = lectura.readLine();
                indice++;
            }
            lectura.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar pelicula: "+ e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar pelicula: "+ e.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        PrintWriter entrada = null;
        try {
            entrada = new PrintWriter(new FileWriter(archivo));
            entrada.close();
            System.out.println("Se ha creado el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear el archivo: " + e.getMessage());
        }

    }

    @Override
    public void borrar(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        if (archivo.exists()){
            archivo.delete();
            System.out.println("Se ha eliminado el archivo.");
        }
    }
}
