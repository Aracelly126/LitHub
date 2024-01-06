package Clases;

import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Autor {

    String nombre;
    public ArrayList<Libro> libros = new ArrayList<Libro>();

    public Autor(String nombre) {
        this.nombre = nombre;
    }

    public void agregarLibro(String titulo, String imagen, String sinopsis,int ancho, int alto) {
        Libro libro = new Libro(titulo, imagen, sinopsis, ancho, alto);
        libros.add(libro);
    }

}
