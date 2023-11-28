
package Clases;

/**
 *
 * @author Lenovo
 */
public class Usuarios {
     private String user;
    private String clave;
    private int intentos;

    public int getIntentos() {
        return this.intentos;
    }

    public Usuarios(String user, String clave, int intentos) {
        this.user = user;
        this.clave = clave;
        this.intentos = intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public Usuarios(String user, String clave) {
        this.user = user;
        this.clave = clave;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    } 
    
}
