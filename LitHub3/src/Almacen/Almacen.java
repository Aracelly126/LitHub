/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Almacen;

import Clases.Usuarios;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Almacen {
    private ArrayList<Usuarios> user = new ArrayList<Usuarios>();

    public ArrayList<Usuarios> getLista() {
        return user;
    }

    public void agregarUsuarios(Usuarios user) {
        this.user.add(user);
    }
    
}
