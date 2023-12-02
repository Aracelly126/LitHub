/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Almacen;

import Clases.Autor;
import Clases.Lector;
import Clases.Usuarios;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Almacen {
    private ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
    private ArrayList<Autor> aut = new ArrayList<Autor>();
    private ArrayList<Lector> lect = new ArrayList<Lector>();

    public ArrayList<Usuarios> getListaUsuarioContra() {
        return this.lista;
    }

    public void agregarUsuarios(Usuarios m) {
        this.getListaUsuarioContra().add(m);
    }

    public ArrayList<Autor> getAut() {
        return aut;
    }

    public void agregaarAutor(Autor aut) {
        this.getAut().add(aut);
    }

    public ArrayList<Lector> getLect() {
        return lect;
    }

    public void agregarLecto(Lector lect) {
        this.getLect().add(lect);
    }
    
}
