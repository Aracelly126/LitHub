package Clases;

public class Usuario {

    private String nombre;
    private String apellido;
    private String clave;
    private String pais;
    private String fecNac;
    private String correo;
    private String tipo;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String clave, String pais, String fecNac, String correo, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
        this.pais = pais;
        this.fecNac = fecNac;
        this.correo = correo;
        this.tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return this.clave;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return this.pais;
    }

    public void setFecNac(String fecNac) {
        this.fecNac = fecNac;
    }

    public String getFecNac() {
        return this.fecNac;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }

}
