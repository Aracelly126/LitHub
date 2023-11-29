
package Clases;

/**
 *
 * @author Lenovo
 */
public class LoginMysql {
    private String usuario;
    private String clave;

    public String getUser() {
        return this.usuario;
    }

    public void setUser(String user) {
        this.usuario = user;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void insertar() {//HACER EL INSERT

    }

    public void seleccionar() {

    }
    public boolean conectar(){
        boolean aux=true;
        return aux;
    }
}
