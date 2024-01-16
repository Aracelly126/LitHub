package Clases;

/**
 *
 * @author ASUS
 */
public class ContraseniaNueva {

    private String usuario;
    private String contraseñaNueva;

    public ContraseniaNueva() {
    }

    public ContraseniaNueva(String usuario, String contra) {
        this.usuario = usuario;
        this.contraseñaNueva = contra;

    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseñaNueva() {
        return this.contraseñaNueva;
    }

    public void setContraseñaNueva(String contraseñaNueva) {
        this.contraseñaNueva = contraseñaNueva;
    }

  
}
