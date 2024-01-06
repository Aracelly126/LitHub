package Clases;

import java.util.ArrayList;

public class Autor {
    String Nombre;
    String Apellido;
    String Fecha_Nacimiento;
    String Lugar_Nacimiento;
    String Nacionalidad;
    int Obras_Literarias;
    String Reconocimientos;
    public ArrayList<Libro> libros = new ArrayList<Libro>();
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public String getLugar_Nacimiento() {
        return Lugar_Nacimiento;
    }

    public void setLugar_Nacimiento(String Lugar_Nacimiento) {
        this.Lugar_Nacimiento = Lugar_Nacimiento;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public int getObras_Literarias() {
        return Obras_Literarias;
    }

    public void setObras_Literarias(int Obras_Literarias) {
        this.Obras_Literarias = Obras_Literarias;
    }

    public String getReconocimientos() {
        return Reconocimientos;
    }

    public void setReconocimientos(String Reconocimientos) {
        this.Reconocimientos = Reconocimientos;
    }

    public Autor(String nombre) {
        this.Nombre = nombre;
    }

    public void agregarLibro(String titulo, String imagen, String sinopsis,int ancho, int alto,String genero,int nPaginas) {
        Libro libro = new Libro(titulo, imagen, sinopsis, ancho, alto,genero,nPaginas);
        libros.add(libro);
    }

    
    
    
}
