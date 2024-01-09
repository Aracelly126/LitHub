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
                                resultSetEntidades.getString("CORREO"),
                                resultSetEntidades.getString("NOMBRE"),
                                resultSetEntidades.getString("APELLIDO"),
                                resultSetEntidades.getString("CLAVE"),
                                resultSetEntidades.getString("PAIS"),
                                resultSetEntidades.getString("FEC_NAC"),
                                resultSetEntidades.getString("TIPO")
                        );
                        entidades.add(usuario);
                    }
                    break;

                case "LIBROS":
                    while (resultSetEntidades.next()) {
                        Libro libro = new Libro(
                                resultSetEntidades.getString("CODIGO"),
                                resultSetEntidades.getString("CORREO_USU"),
                                resultSetEntidades.getString("NOMBRE"),
                                resultSetEntidades.getString("GENERO"),
                                resultSetEntidades.getInt("NUM_PAG"),
                                resultSetEntidades.getString("PRESTADO")
                        );
                        entidades.add(libro);
                    }
                    break;

                case "PRESTAMOS":
                    ArrayList<Prestamo> prestamos = new ArrayList<>();
                    while (resultSetEntidades.next()) {
                        Prestamo prestamo = new Prestamo(
                                resultSetEntidades.getString("CODIGO"),
                                resultSetEntidades.getString("COD_LIB"),
                                resultSetEntidades.getString("CORREO_USU"),
                                resultSetEntidades.getString("FEC_INI"),
                                resultSetEntidades.getString("FEC_DEV"),
                                resultSetEntidades.getString("ESTADO")
                        );
                        entidades.add(prestamo);
                    }
                    break;
                case "FAVORITOS":
                    ArrayList<Favorito> favoritos = new ArrayList<>();
                    while (resultSetEntidades.next()) {
                        Favorito favorito = new Favorito(
                                resultSetEntidades.getString("CODIGO"),
                                resultSetEntidades.getString("CORREO_USU"),
                                resultSetEntidades.getString("COD_LIB")
                        );
                        entidades.add(favorito);
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
        } catch (Exception e) {
            this.con.desconectar();
            System.out.println("Error Metodo:insertarUsuario Clase:GestorBD Usuario:" + usuario.getNombre() + "\n" + e);
        }
    }

    public void cambiarClaveUsuario(String corrreoUsuario, String nuevaClave) {
        if (!this.con.conectar()) {
            this.con.desconectar();
            return;
        }

        try {
            String consultaUpdate = "UPDATE Usuarios SET CLAVE = ? WHERE CORREO = ?";
            PreparedStatement preparedStatement = this.con.getConexion().prepareStatement(consultaUpdate);
            preparedStatement.setString(1, nuevaClave);
            preparedStatement.setString(2, corrreoUsuario);
            preparedStatement.executeUpdate();

            for (Usuario usuario : Almacen.getInstance().usuarios) {
                if (usuario.getNombre().equals(corrreoUsuario)) {
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

    public void agregarLibro(Libro libro) {
        if (this.con.conectar() == false) {
            this.con.desconectar();
            return;
        }
        try {
            // Insertar el libro en la base de datos
            String consultaInsert = "INSERT INTO LIBROS (CODIGO, CORREO_USU, NOMBRE, GENERO, NUM_PAG) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.con.getConexion().prepareStatement(consultaInsert);
            preparedStatement.setString(1, libro.getCodigo());
            preparedStatement.setString(2, libro.getCorreoUsu());
            preparedStatement.setString(3, libro.getNombre());
            preparedStatement.setString(4, libro.getGenero());
            preparedStatement.setInt(5, libro.getNumPag());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            this.con.desconectar();
        } catch (Exception e) {
            this.con.desconectar();
            System.out.println("Error en el Método:insertarLibro Clase:GestorBD\n" + e);
        }
    }

    public void actualizarLibro(Libro libro) {
        if (this.con.conectar() == false) {
            this.con.desconectar();
            return;
        }
        try {
            String consultaUpdate = "UPDATE Libros SET CORREO_USU = ?, NOMBRE = ?, GENERO = ?, NUM_PAG = ?, PRESTADO = ? WHERE CODIGO = ?";
            PreparedStatement preparedStatement = this.con.getConexion().prepareStatement(consultaUpdate);
            preparedStatement.setString(1, libro.getCorreoUsu());
            preparedStatement.setString(2, libro.getNombre());
            preparedStatement.setString(3, libro.getGenero());
            preparedStatement.setInt(4, libro.getNumPag());
            preparedStatement.setString(5, "NO");  // Asignar 'NO' como valor predeterminado para PRESTADO
            preparedStatement.setString(6, libro.getCodigo());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            this.con.desconectar();
        } catch (Exception e) {
            this.con.desconectar();
            System.out.println("Error en el Método: actualizarLibro Clase: GestorBD\n" + e);
        }
    }

    public void eliminarLibro(String codigoLibro) {
        if (this.con.conectar() == false) {
            this.con.desconectar();
            return;
        }
        try {
            // Eliminar el libro de la base de datos
            String consultaDelete = "DELETE FROM Libros WHERE CODIGO = ?";
            PreparedStatement preparedStatement = this.con.getConexion().prepareStatement(consultaDelete);
            preparedStatement.setString(1, codigoLibro);
            int rowsAffected = preparedStatement.executeUpdate();

            // Verificar si se eliminó el libro
            if (rowsAffected > 0) {
                System.out.println("Libro eliminado correctamente de la base de datos");
            } else {
                System.out.println("No se encontró el libro con el código especificado en la base de datos");
            }

            preparedStatement.close();
            this.con.desconectar();
        } catch (Exception e) {
            this.con.desconectar();
            System.out.println("Error en el Método: eliminarLibro Clase: GestorBD\n" + e);
        }
    }

    public void eliminarPrestamosPorLibro(String codigoLibro) {
        if (this.con.conectar() == false) {
            this.con.desconectar();
            return;
        }
        try {
            // Eliminar los préstamos asociados al libro de la base de datos
            String consultaDelete = "DELETE FROM Prestamos WHERE COD_LIB = ?";
            PreparedStatement preparedStatement = this.con.getConexion().prepareStatement(consultaDelete);
            preparedStatement.setString(1, codigoLibro);
            int rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
            this.con.desconectar();
        } catch (Exception e) {
            this.con.desconectar();
            System.out.println("Error en el Método: eliminarPrestamosPorLibro Clase: GestorBD\n" + e);
        }
    }

    public void eliminarFavoritosPorLibro(String codigoLibro) {
        if (this.con.conectar() == false) {
            this.con.desconectar();
            return;
        }

        try {
            // Eliminar los registros de Favoritos asociados al libro de la base de datos
            String consultaDelete = "DELETE FROM Favoritos WHERE COD_LIB = ?";
            PreparedStatement preparedStatement = this.con.getConexion().prepareStatement(consultaDelete);
            preparedStatement.setString(1, codigoLibro);
            int rowsAffected = preparedStatement.executeUpdate();

            // Verificar si se eliminaron favoritos
            if (rowsAffected > 0) {
                System.out.println("Favoritos asociados al libro con código " + codigoLibro + " eliminados de la base de datos");
            } else {
                System.out.println("No se encontraron favoritos asociados al libro en la base de datos");
            }

            preparedStatement.close();
            this.con.desconectar();
        } catch (Exception e) {
            this.con.desconectar();
            System.out.println("Error en el Método: eliminarFavoritosPorLibro Clase: GestorBD\n" + e);
        }
    }

}
