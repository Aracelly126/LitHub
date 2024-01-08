package Clases;

public class Favorito {

    private int codigo;
    private String nombreUsuario;
    private String codigoLibro;

    public Favorito() {
    }

    public Favorito(int codigo, String nombreUsuario, String codigoLibro) {
        this.codigo = codigo;
        this.nombreUsuario = nombreUsuario;
        this.codigoLibro = codigoLibro;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getCodigoLibro() {
        return this.codigoLibro;
    }
}
