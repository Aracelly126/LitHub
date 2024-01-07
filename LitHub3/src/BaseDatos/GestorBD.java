package BaseDatos;

import Clases.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorBD {

    private Conexion conexion = new Conexion();

    public ArrayList<?> SELECT(String tipo) {//consulta a todos los datos de una tabla especificada
        if (this.conexion.conectar() == false) {
            return null;
        }

        ArrayList<Object> entidades = new ArrayList<>();
        try {
            Statement statement = this.conexion.getConexion().createStatement();
            String consultaSQL = "SELECT * FROM " + tipo;
            ResultSet resultSetEntidades = statement.executeQuery(consultaSQL);

            switch (tipo) {
                case "USUARIOS":
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
                        entidades.add(usuario);
                    }
                    break;

                case "LIBROS":
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
                        entidades.add(libro);
                    }
                    break;

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
                        entidades.add(prestamo);
                    }
                    break;
            }
            statement.close();
            this.conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error Metodo:SELECT Clase:ManejoBD Tabla:" + tipo + "\n" + e);
        }

        return entidades;
    }
}
