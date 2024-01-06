/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Almacen;

import Clases.Usuarios;
import java.util.ArrayList;

public class Almacen {
    private ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
    

    public ArrayList<Usuarios> getListaUsuarioContra() {
        return this.lista;
    }

    public void agregarUsuarios(Usuarios m) {
        this.getListaUsuarioContra().add(m);
    }
    

    
}
