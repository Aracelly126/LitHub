package Controles;

import Mysql.Mysql;
import java.io.UnsupportedEncodingException;

public class ControlAutores {

    Mysql con = new Mysql();
    Controles contr = new Controles();

    public boolean registroAutores(String Nombre, String apellido, String pais, String fechaNac, int numerObras, String correoElectro, String contraseña) {
        boolean aux = false;
        try {
            con.conectar();
            String contraEncrip = contr.Encriptar(contraseña);
            aux = con.aggUsuarios(Nombre, contraEncrip);
            if (aux) {
                aux = con.aggAutores(Nombre.toUpperCase(), apellido.toUpperCase(), pais, fechaNac, numerObras, correoElectro, contraEncrip);
                if (aux) {
                    return true;
                }
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error al ingresar un autor nuevo" + e);
        }
        return aux;
    }
}
