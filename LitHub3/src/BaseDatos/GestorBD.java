package BaseDatos;

import Clases.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorBD {

    private Conexion con = new Conexion();

    public ArrayList<?> SELECT(String tipo) {//consulta a todos los datos de una tabla especificada
        if (this.con.conectar() == false) {
            this.con.desconectar();
            return null;
        }

        ArrayList<Object> entidades = new ArrayList<>();
        try {
            Statement statement = this.con.getConexion().createStatement();
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
            this.con.desconectar();
        } catch (Exception e) {
            this.con.desconectar();
            System.out.println("Error Metodo:SELECT Clase:ManejoBD Tabla:" + tipo + "\n" + e);
        }

        return entidades;
    }

    public void insertarUsuario(Usuario usuario) {
        if (this.con.conectar() == false) {
            this.con.desconectar();
            return;
        }
        System.out.println("c va a insertar");
        try {
            // Insertar el usuario en la base de datos
            String consultaInsert = "INSERT INTO USUARIOS (NOMBRE, APELLIDO, CLAVE, PAIS, FEC_NAC, CORREO, TIPO) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.con.getConexion().prepareStatement(consultaInsert);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getApellido());
            preparedStatement.setString(3, usuario.getClave());
            preparedStatement.setString(4, usuario.getPais());
            preparedStatement.setString(5, usuario.getFecNac());
            preparedStatement.setString(6, usuario.getCorreo());
            preparedStatement.setString(7, usuario.getTipo());
            preparedStatement.executeUpdate();

            // Insertar el usuario en el almacenamiento local (Almacen)
            Almacen.getInstance().usuarios.add(usuario);

            preparedStatement.close();
            this.con.desconectar();
            System.out.println("c inserta");
        } catch (Exception e) {
            this.con.desconectar();
            System.out.println("Error Metodo:insertarUsuario Clase:GestorBD Usuario:" + usuario.getNombre() + "\n" + e);
        }
    }

    public void cambiarClaveUsuario(String nombreUsuario, String nuevaClave) {
        if (!this.con.conectar()) {
            this.con.desconectar();
            return;
        }

        try {
            String consultaUpdate = "UPDATE Usuarios SET CLAVE = ? WHERE NOMBRE = ?";
            PreparedStatement preparedStatement = this.con.getConexion().prepareStatement(consultaUpdate);
            preparedStatement.setString(1, nuevaClave);
            preparedStatement.setString(2, nombreUsuario);
            preparedStatement.executeUpdate();

            for (Usuario usuario : Almacen.getInstance().usuarios) {
                if (usuario.getNombre().equals(nombreUsuario)) {
                    usuario.setClave(nuevaClave);
                    break;
                }
            }
            preparedStatement.close();
            this.con.desconectar();
        } catch (Exception e) {
            this.con.desconectar();
            System.out.println("Error Metodo:cambiarClaveUsuario Clase:GestorBD\n" + e);
            System.out.println("Error al cambiar la clave del usuario en la base de datos");
        }
    }

}
