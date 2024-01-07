package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {

    //PUERTO PARA ARACELLY
    private String puerto = "3387";
    //PUERTO PARA LOS DEMAS
    //private String puerto = "3306";

    //URL DE LA BD
    private String url = "jdbc:mysql://localhost:" + puerto + "/Biblioteca";

    //USUARIO
    private String user = "root";
    //CLAVE PARA ARACELLY
    private String clave = "";
    //CLAVE PARA LOS DEMAS
    //private String clave = "root";

    private Connection con;

    public Conexion() {

    }

    public boolean conectar() {
        try {
            con = DriverManager.getConnection(url, user, clave);
            System.out.println("Conexion a la bd establecida. . .\nMetodo: conectar Clase: Mysql");
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
