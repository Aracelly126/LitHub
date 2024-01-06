package BaseDatos;

import Clases.*;
import java.util.ArrayList;

public class Almacen {

    private static Almacen instance;

    public ArrayList<Usuario> usuarios = new ArrayList<>();
    public ArrayList<Libro> libros = new ArrayList<>();
    public ArrayList<Prestamo> prestamos = new ArrayList<>();

    private Almacen() {
    }

    public static Almacen getInstance() {
        return instance == null ? instance = new Almacen() : instance;
    }
}