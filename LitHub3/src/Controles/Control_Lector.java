/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import Mysql.Mysql;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author ASUS
 */
public class Control_Lector {

    Mysql con = new Mysql();
    Controles contr = new Controles();

    public boolean registroLectores(String Nombre, String telefono, String correoElectro, String direccion, String contraseña) {
        boolean aux = false;
        try {
            con.conectar();
            String contraEncrip = contr.Encriptar(contraseña);
            aux = con.aggUsuarios(Nombre, contraEncrip);
            if (aux) {
                aux = con.aggLector(Nombre.toUpperCase(), telefono, correoElectro, direccion, contraEncrip);
                if (aux) {
                    return true;
                }
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error al ingresar un lector nuevo" + e);

        }
        return false;
    }
}
