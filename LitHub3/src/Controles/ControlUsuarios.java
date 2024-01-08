package Controles;

import Almacen.Almacen;
import Mysql.Mysql;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Base64;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo
 */
public class ControlUsuarios {

    Mysql conec = new Mysql();
    Controles contr= new Controles();
  public boolean loginUsuarioYClave(String user, String clave, Almacen almaPermisos, JPasswordField txtContraseña,JTextField txtUsuario, JLabel txtMensaje) throws SQLException, UnsupportedEncodingException {
    boolean conf = false;
    int ps = -1;
    conec.conectar();
    almaPermisos.getListaUsuarioContra().clear();
    conec.seleccionarUsuarios(almaPermisos);

    // Buscar el usuario
    for (int i = 0; i < almaPermisos.getListaUsuarioContra().size(); i++) {
        if (almaPermisos.getListaUsuarioContra().get(i).getUsuario().toUpperCase().equals(user.toUpperCase())) {
            ps = i;
            break;
        }
    }
    if (ps != -1) {
        if (almaPermisos.getListaUsuarioContra().get(ps).getIntentos() < 3) {
            String contra = contr.Desencriptar(almaPermisos.getListaUsuarioContra().get(ps).getContraseña());
            System.out.println(contra);

            if (contra.equals(clave)) {
                conf = true;
                almaPermisos.getListaUsuarioContra().get(ps).setIntentos(0);
                conec.conectar();
                conec.actualizarUsuarios(almaPermisos.getListaUsuarioContra().get(ps));
            } else {
                txtMensaje.setText("contraseña incorrecta");
                almaPermisos.getListaUsuarioContra().get(ps).setIntentos(almaPermisos.getListaUsuarioContra().get(ps).getIntentos() + 1);
                conec.conectar();
                conec.actualizarUsuarios(almaPermisos.getListaUsuarioContra().get(ps));
                txtContraseña.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario bloqueado.");
            txtContraseña.setText("");
        }
    } else {
        txtMensaje.setText("Usuario incorrecto");
        txtUsuario.setText("");
        txtContraseña.setText("");
    }

    return conf;
}


   

}
