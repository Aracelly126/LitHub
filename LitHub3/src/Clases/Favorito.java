package Clases;

public class Favorito {

    private String codigo;
    private String nombreUsuario;
    private String codigoLibro;

    public Favorito() {
    }

    public Favorito(String codigo, String nombreUsuario, String codigoLibro) {
        this.codigo = codigo;
        this.nombreUsuario = nombreUsuario;
        this.codigoLibro = codigoLibro;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
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
