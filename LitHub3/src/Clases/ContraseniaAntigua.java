package Clases;

/**
 *
 * @author ASUS
 */
public class ContraseniaAntigua {

    private String usuario;
    private String contraseñaAntigua;

    public ContraseniaAntigua() {
    }

    public ContraseniaAntigua(String usuario, String contra) {
        this.usuario = usuario;
        this.contraseñaAntigua = contra;

    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseñaAntigua() {
        return this.contraseñaAntigua;
    }

    public void setContraseñaAntigua(String contraseñaAntigua) {
        this.contraseñaAntigua = contraseñaAntigua;
    }


}
