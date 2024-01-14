package Clases;

public class Libro {

    private String codigo;
    private String CORREO_USU;
    private String nombre;
    private String genero;
    private int numPag;
    private String sinopsis;

    public Libro() {
    }

    public Libro(String codigo, String correo_usu, String nombre, String genero, int numPag, String sinopsis) {
        this.codigo = codigo;
        this.CORREO_USU = correo_usu;
        this.nombre = nombre;
        this.genero = genero;
        this.numPag = numPag;
        this.sinopsis = sinopsis;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCorreoUsu(String autor) {
        this.CORREO_USU = autor;
    }

    public String getCorreoUsu() {
        return this.CORREO_USU;
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

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getSinopsis() {
        return this.sinopsis;
    }

    @Override
    public String toString() {
        return "Libro{" + "codigo=" + codigo + ", CORREO_USU=" + CORREO_USU + ", nombre=" + nombre + ", genero=" + genero + ", numPag=" + numPag + ", sinopsis=" + sinopsis + '}';
    }

}
