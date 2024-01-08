package Clases;

public class Libro {

    private String codigo;
    private String autor;
    private String nombre;
    private String genero;
    private int numPag;
    private String prestado;

    public Libro() {
    }

    public Libro(String codigo, String autor, String nombre, String genero, int numPag, String prestado) {
        this.codigo = codigo;
        this.autor = autor;
        this.nombre = nombre;
        this.genero = genero;
        this.numPag = numPag;
        this.prestado = prestado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public int getNumPag() {
        return this.numPag;
    }

    public void setPrestado(String prestado) {
        this.prestado = prestado;
    }

    public String getPrestado() {
        return this.prestado;
    }
}
