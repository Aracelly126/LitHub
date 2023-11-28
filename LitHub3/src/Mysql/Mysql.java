/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mysql;

import Clases.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Mysql extends Login {

    private static final String url = "jdbc:mysql://localhost:3306/proyecto?autoReconnect=true&useSSL=false";//jbdc java data base conexion
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
            // System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos");
            return aux = false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos");
            return aux = false;
        }
    }

    public void seleccionarUsuarios(AlmacenPermisos almaPermisos) {
        try {
            ps = con.prepareStatement("select * from login");
            rs = ps.executeQuery();
            int intento = 0;
            while (rs.next()) {
                String User = rs.getString("usuario");
                String Clave = rs.getString("contraseña");
                if (rs.getString("intentos") == null) {
                    intento = 0;
                } else {
                    intento = Integer.parseInt(rs.getString("intentos"));
                }
                Permisos perm = new Permisos(User, Clave, intento);
                almaPermisos.AgregarPermisosArray(perm);
            }
        } catch (SQLException ex) {
            //System.out.println(ex);
        }
    }

}
