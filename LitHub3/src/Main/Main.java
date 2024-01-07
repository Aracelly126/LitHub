package Main;

import BaseDatos.*;
import Clases.*;
import Vista.frmLogin;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        arrancarBD();
        
        frmLogin login =  new frmLogin();
        login.setVisible(true);
    }
    
    public static void arrancarBD(){
        GestorBD mbd = new GestorBD();
        
        Almacen.getInstance().usuarios = (ArrayList<Usuario>) mbd.SELECT("USUARIOS");
        Almacen.getInstance().libros = (ArrayList<Libro>) mbd.SELECT("LIBROS");
        Almacen.getInstance().prestamos = (ArrayList<Prestamo>) mbd.SELECT("PRESTAMOS");
    }
}
