/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mysql;

import Almacen.Almacen;
import Clases.Libro;
import Clases.LoginMysql;
import Clases.Usuarios;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Mysql extends LoginMysql {

    private static final String url = "jdbc:mysql://localhost:3306/Biblioteca?autoReconnect=true&useSSL=false";//jbdc java data base conexion
    private static final String driver = "com.mysql.cj.jdbc.Driver";//para hacer  conexciones de redes
    public static Connection con;
    public static ResultSet rs;//me permite capturar todo lo que me devuelva 0 lineas hasta 100lineas
    public static PreparedStatement ps;
    private static final String user = "root";
    private static final String clave = "root";

    @Override
    public boolean conectar() {//libreria conecxion
        boolean aux;
        con = null;//se pone null por que reseteamos .sino hacemos eso la tarjeta de red se hace lenta
        super.setUser("root");
        super.setClave("root");
        try {
            Class.forName(driver);//me devuelve sql
            con = (Connection) DriverManager.getConnection(url, super.getUser(), super.getClave());//hacemos conexion
            if (con != null) {
                System.out.println("Se conecto");
                return aux = true;
            } else {
                JOptionPane.showMessageDialog(null, "No existe conexión con la base de datos");
                return aux = false;
            }
        } catch (ClassNotFoundException e) {//catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos");
            return aux = false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos");
            return aux = false;
        }
    }

    public void seleccionarUsuarios(Almacen almaPermisos) {
        try {
            ps = con.prepareStatement("select * from usuarios");
            rs = ps.executeQuery();
            int intento = 0;

            while (rs.next()) {
                String usuario = rs.getString("usuario");
                String Clave = rs.getString("contraseña");
                if (rs.getString("intentos") == null) {
                    intento = 0;
                } else {
                    intento = Integer.parseInt(rs.getString("intentos"));
                }
                Usuarios perm = new Usuarios(usuario, Clave, intento);
                almaPermisos.agregarUsuarios(perm);
            }
        } catch (SQLException ex) {
            //System.out.println(ex);
        }
    }

    public void actualizarUsuarios(Usuarios p) throws SQLException {
        try {
            boolean aux = conectar();
            if (aux == true) {
                String query = "UPDATE usuarios SET intentos = ? WHERE usuario = ?";
                PreparedStatement ps = con.prepareStatement(query);

                ps.setInt(1, p.getIntentos());
                ps.setString(2, p.getUsuario());
                ps.executeUpdate();
            } else {
                JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos");

            }

        } catch (SQLException e) {
            // Manejo de excepciones
            System.out.println("Fallos en la actualización" + e);

        }
    }

    public boolean aggAutores(String Nombre, String apellido, String pais, String fechaNac, int numObras, String correoElectro, String contraseña) {
        boolean aux;
        try {
            Statement st = con.createStatement();
            String query = "INSERT INTO autor (nombre, apellido, pais, fechaNac,numeroObras,correoElectro,contraseña) VALUES ('" + Nombre + "', '" + apellido + "', '" + pais + "', '" + fechaNac + "', '" + numObras + "','" + correoElectro + "','" + contraseña + "')";
            st.executeUpdate(query);
            return aux = true;
        } catch (SQLException ex) {
            if (ex instanceof SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "Ya existe este autor, por favor ingrese otro nombre.");
                return aux = false;
            }
            return aux = false;
        }
    }

    public boolean aggUsuarios(String Nombre, String contraseña) {
        boolean aux = true;
        try {
            Statement st = con.createStatement();
            String query = "INSERT INTO usuarios (usuario, contraseña, intentos)VALUES ('" + Nombre + "', '" + contraseña + "',0)";
            st.executeUpdate(query);
            return aux = true;
        } catch (SQLException ex) {
            if (ex instanceof SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "No se pudo registrar en la lista de usuarios. Por favor, cambie su nombre");
                return aux = false;
            }
            return aux = false;
        }
    }

    public boolean aggLector(String Nombre, String telefono, String correoElc, String direccion, String contraseña) {
        boolean aux = true;
        try {
            Statement st = con.createStatement();
            String query = "INSERT INTO lector (nombre, telefono, correoElectro, direccion,contraseña) VALUES ('" + Nombre + "', '" + telefono + "', '" + correoElc + "', '" + direccion + "', '" + contraseña + "')";
            st.executeUpdate(query);
            return aux = true;
        } catch (SQLException ex) {
            if (ex instanceof SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "Ya existe este Lector , por favor ingrese otro nombre.");
                return aux = false;
            }
            return aux = false;
        }
    }

    public ArrayList<Libro> bajarLibro() {
        try {
            ps = con.prepareStatement("select * from Libro");
            rs = ps.executeQuery();

            while (rs.next()) {
                Blob imagen = rs.getBlob(8);
                byte[] pdf = rs.getBytes(7);
                InputStream bos = new ByteArrayInputStream(pdf);
//-------datos pdf transformalos
                int tamanoInput = bos.available(b);
                byte[] datosPDF = new byte[tamanoInput];
                bos.read(datosPDF, 0, tamanoInput);

                OutputStream out = new FileOutputStream("new.pdf");
                out.write(datosPDF);
                //--------Transforma los datos imagen----
                byte[] data = imagen.getBytes(1, (int) imagen.length());
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (IOException e) {
                    Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, e);
                }
                
                ArrayList<Libro> listaLibros=new ArrayList<>();
                
            }
        } catch (SQLException ex) {
            //System.out.println(ex);
        }
    }
}
