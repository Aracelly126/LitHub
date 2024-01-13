package Clases;

public class Favorito {

    private String codigo;
    private String correoUsuario;
    private String codigoLibro;

    public Favorito() {
    }

    public Favorito(String codigo, String nombreUsuario, String codigoLibro) {
        this.codigo = codigo;
        this.correoUsuario = nombreUsuario;
        this.codigoLibro = codigoLibro;
    }

    public Favorito(String nombreUsuario, String codigoLibro) {
        this.correoUsuario = nombreUsuario;
        this.codigoLibro = codigoLibro;
    }
    

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getCodigoLibro() {
        return this.codigoLibro;
    }

    public String getCorreoUsuario() {
        return this.correoUsuario;
    }
    public void setCorreoUsuario(String coreoUsuario) {
        this.correoUsuario = coreoUsuario;
    }
    
}
