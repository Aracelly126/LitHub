package BaseDatos;

import Clases.*;
import java.sql.PreparedStatement;
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

    public void cambiarClaveUsuario(String nombreUsuario, String nuevaClave) {
        if (!this.conexion.conectar()) {
            return;
        }

        try {
            String consultaUpdate = "UPDATE Usuarios SET CLAVE = ? WHERE NOMBRE = ?";
            PreparedStatement preparedStatement = this.conexion.getConexion().prepareStatement(consultaUpdate);
            preparedStatement.setString(1, nuevaClave);
            preparedStatement.setString(2, nombreUsuario);
            preparedStatement.executeUpdate();

            // Actualizar la clave en el almacenamiento local (Almacen)
            for (Usuario usuario : Almacen.getInstance().usuarios) {
                if (usuario.getNombre().equals(nombreUsuario)) {
                    usuario.setClave(nuevaClave);
                    break; // No es necesario seguir buscando
                }
            }
            preparedStatement.close();
            this.conexion.desconectar();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cambiar la clave del usuario en la base de datos");
        }
    }

}
