package Clases;

public class Libro {

    private String codigo;
    private String autor;
    private String nombre;
    private String genero;
    private int numPag;
    private String urlFoto;
    private String urlPdf;

    public Libro(String codigo, String autor, String nombre, String genero, int numPag, String urlFoto, String urlPdf) {
        this.codigo = codigo;
        this.autor = autor;
        this.nombre = nombre;
        this.genero = genero;
        this.numPag = numPag;
        this.urlFoto = urlFoto;
        this.urlPdf = urlPdf;
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

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getUrlFoto() {
        return this.urlFoto;
    }

    public void setUrlPdf(String urlPdf) {
        this.urlPdf = urlPdf;
    }

    public String getUrlPdf() {
        return this.urlPdf;
    }

}
