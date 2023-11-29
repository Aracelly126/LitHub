
package Clases;

/**
 *
 * @author Lenovo
 */
public class Usuarios {
     private String usuario;
    private String contraseña;
    private int intentos;

    public int getIntentos() {
        return this.intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    
    public Usuarios(String user, String clave, int intentos) {
        this.usuario = user;
        this.contraseña = clave;
        this.intentos = intentos;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
