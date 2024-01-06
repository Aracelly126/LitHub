package BaseDatos;

import Clases.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejoBD {

    private Conexion conexion = new Conexion();

    public ArrayList<?> SELECT(String tipo) {
        if (this.conexion.conectar() == false) {
            return null;
        }

        try {
            Statement statement = this.conexion.getConexion().createStatement();
            String consultaSQL = "SELECT * FROM " + tipo;
            ResultSet resultSetEntidades = statement.executeQuery(consultaSQL);
            
            switch (tipo) {
                case "USUARIOS":
                    ArrayList<Usuario> usuarios = new ArrayList<>();
                    while (resultSetEntidades.next()) {
                        Usuario usuario = new Usuario(
                                resultSetEntidades.getString("NOMBRE"),
                                resultSetEntidades.getString("APELLIDO"),
                                resultSetEntidades.getString("CLAVE"),
                                resultSetEntidades.getString("PAIS"),
                                resultSetEntidades.getString("FEC_NAC"),
                                resultSetEntidades.getString("CORREO"),
                                resultSetEntidades.getString("TIPO")
                        );
                        usuarios.add(usuario);
                    }
                    statement.close();
                    this.conexion.desconectar();
                    return usuarios;

                case "LIBROS":
                    ArrayList<Libro> libros = new ArrayList<>();
                    while (resultSetEntidades.next()) {
                        Libro libro = new Libro(
                                resultSetEntidades.getString("CODIGO"),
                                resultSetEntidades.getString("AUTOR"),
                                resultSetEntidades.getString("NOMBRE"),
                                resultSetEntidades.getString("GENERO"),
                                resultSetEntidades.getInt("NUM_PAG"),
                                resultSetEntidades.getString("URL_FOTO"),
                                resultSetEntidades.getString("URL_PDF")
                        );
                        libros.add(libro);
                    }
                    statement.close();
                    this.conexion.desconectar();
                    return libros;

                case "PRESTAMOS":
                    ArrayList<Prestamo> prestamos = new ArrayList<>();
                    while (resultSetEntidades.next()) {
                        Prestamo prestamo = new Prestamo(
                                resultSetEntidades.getInt("CODIGO"),
                                resultSetEntidades.getString("COD_LIB"),
                                resultSetEntidades.getString("NOM_USU"),
                                resultSetEntidades.getString("FEC_INI"),
                                resultSetEntidades.getString("FEC_DEV"),
                                resultSetEntidades.getString("ESTADO")
                        );
                        prestamos.add(prestamo);
                    }
                    statement.close();
                    this.conexion.desconectar();
                    return prestamos;
            }
        } catch (Exception e) {
            System.out.println("Error Metodo:SELECT Clase:ManejoBD Tabla:"+tipo+"\n"+e);
        }

        return null;
    }
}
