package Clases;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Libro {

    private String titulo;
    private ImageIcon image;
    private String sinopsis;
    private String genero;
    private int nPaginas;
    private int codigoPdf;
    private int clave;
    private String nombrePdf;
    byte[] archivoPdf;

    public int getClave() {
        return this.clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
        //so
    }

    public Libro(String titulo, String rutaImagen, String sinopsis, int anchoPanel, int altoPanel, String genero, int nPaginas) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.image = redimensionarImagen("/imagenes/" + rutaImagen, anchoPanel, altoPanel);
        this.genero = genero;
        this.nPaginas = nPaginas;
        this.codigoPdf = nPaginas;
    }

    public Libro(String sinopsis,String genero,int numPags,int codigoPdf, String nombrePdf, byte[] archivopdf,int clave) {
        this.titulo=nombrePdf;
        this.sinopsis=sinopsis;
        this.genero=genero;
        this.nPaginas=numPags;
        this.codigoPdf = codigoPdf;
        this.nombrePdf = nombrePdf;
        this.archivoPdf = archivopdf;
        this.clave=clave;
    }

    public byte[] getArchivoPdf() {
        return this.archivoPdf;
    }

    public void setArchivoPdf(byte[] archivoPdf) {
        this.archivoPdf = archivoPdf;
    }
    

    public int getCodigoPdf() {
        return this.codigoPdf;
    }

    public void setCodigoPdf(int codigoPdf) {
        this.codigoPdf = codigoPdf;
    }

    public String getNombrePdf() {
        return this.nombrePdf;
    }

    public void setNombrePdf(String nombrePdf) {
        this.nombrePdf = nombrePdf;
    }

    

    public ImageIcon getImage() {
        return this.image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public String getNombre() {
        return this.titulo;
    }

    public void setNombre(String nombre) {
        this.titulo = nombre;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return this.sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getnPaginas() {
        return this.nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    private ImageIcon redimensionarImagen(String rutaImagen, int ancho, int alto) {
        ImageIcon imagenOriginal = new ImageIcon(getClass().getResource(rutaImagen));
        Image img = imagenOriginal.getImage();
        Image imgRedimensionada = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imgRedimensionada);
    }

}
