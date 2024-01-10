package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {

    private String puerto = "3415";

    private String url = "jdbc:mysql://localhost:" + puerto + "/biblioteca";

    private String user = "root";
    private String clave = "";

    private Connection con;

    public Conexion() {

    }

    public boolean conectar() {
        try {
            con = DriverManager.getConnection(url, user, clave);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la BD, intentalo despues. . .");
            System.out.println("Conexion a la bd fallida. . .\nMetodo: conectar Clase: Mysql\n" + e);
            return false;
        }
        return true;
    }

    public Connection getConexion() {
        return this.con;
    }

    public void desconectar() {
        try {
            this.con.close();
        } catch (Exception e) {
            System.out.println("Error al desconectar la BD. . .\nMetodo: desconectar Clase: Mysql\n" + e);
        }
    }
}
