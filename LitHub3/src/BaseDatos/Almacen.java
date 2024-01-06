package BaseDatos;

import Clases.*;
import java.util.ArrayList;

public class Almacen {

    private static Almacen instance;

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Libro> libros = new ArrayList<>();
    private ArrayList<Prestamo> prestamos = new ArrayList<>();

    private Almacen() {
    }

    public static Almacen getInstance() {
        return instance == null ? instance = new Almacen() : instance;
    }
}