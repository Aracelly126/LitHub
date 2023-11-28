package Controles;

import Almacen.Almacen;
import Mysql.Mysql;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Base64;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Lenovo
 */
public class ControlUsuarios {

    Mysql conec = new Mysql();
    Almacen almaPermisos = new Almacen();
    public void CargarCombo(JComboBox c) {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();

        c.setModel(combo);
        try {
            conec.conectar();
            almaPermisos.getLista().clear();
            conec.seleccionarUsuarios(almaPermisos);
            for (int i = 0; i < almaPermisos.getLista().size(); i++) {
                combo.addElement(almaPermisos.getLista().get(i).getUser());
            }
        } catch (Exception e) {
            // System.out.println("Error al cargar el combo" + e);
        }
    }

    public boolean LoginClave(String user, String clave,JPasswordField txtContraseñaUser, JLabel txtMensaje) throws SQLException, UnsupportedEncodingException {
        boolean conf = false;
        int ps = 0;
        for (int i = 0; i < almaPermisos.getLista().size(); i++) {
            if (almaPermisos.getLista().get(i).getUser().equals(user)) {
                ps = i;
                break;
            }
        }
        if (almaPermisos.getLista().get(ps).getIntentos() < 3) {
            String contra = Desencriptar(almaPermisos.getLista().get(ps).getClave());
            System.out.println(contra);
            if (contra.equals(clave)) {
                conf = true;
                almaPermisos.getLista().get(ps).setIntentos(0);
                conec.conectar();
                conec.actualizarUsuarios(almaPermisos.getLista().get(ps));
            } else {
                txtMensaje.setText("Usuario o contraseña incorrectos");
                almaPermisos.getLista().get(ps).setIntentos(almaPermisos.getLista().get(ps).getIntentos() + 1);
                conec.conectar();
                conec.actualizarUsuarios(almaPermisos.getLista().get(ps));
                txtContraseñaUser.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario bloqueado.");
            txtContraseñaUser.setText("");
        }
        return conf;
    }

    public String Encriptar(String s) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
    }

    public String Desencriptar(String s) throws UnsupportedEncodingException {
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode, "utf-8");
    }

}
