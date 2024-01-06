package Clases;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Libro {

    private String titulo;
    private ImageIcon image;
    private String sinopsis;
    private String genero;
    private int nPaginas;

    public Libro(String nombre, String rutaImagen, String sinopsis,int anchoPanel, int altoPanel) {
        this.titulo = nombre;
        this.sinopsis = sinopsis;
        this.image = redimensionarImagen("/imagenes/" + rutaImagen, anchoPanel, altoPanel);
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
