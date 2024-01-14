package BaseDatos;

import Clases.*;
import java.util.ArrayList;

public class Almacen {

    private static Almacen instance;

    public ArrayList<Usuario> usuarios = new ArrayList<>();
    public ArrayList<Libro> libros = new ArrayList<>();
    public ArrayList<Favorito> favoritos = new ArrayList<>();

    private Almacen() {
    }

    public static Almacen getInstance() {
        if (instance == null) {
            instance = new Almacen();
        }
        return instance;
    }
}
