package Utilidades;

import BaseDatos.Almacen;
import BaseDatos.GestorBD;
import Clases.Usuario;

public class GestorPrograma {

    private static GestorBD gestorBD = new GestorBD();

    private GestorPrograma() {

    }

    public static int compCredenciales(String user, String contrasenia) {
        for (Usuario usuario : Almacen.getInstance().usuarios) {
            String nombre = usuario.getNombre();
            String clave = usuario.getClave();
            if (nombre.equals(user) && clave.equals(contrasenia)) {
                switch (usuario.getTipo()) {
                    case "ADMIN":
                        return 1;
                    case "AUTOR":
                        return 2;
                    case "LECTOR":
                        return 3;
                }
                Controles.intentosIngresos = 0;
            }
        }
        //Si las credenciales son incorrectas empieza un contador para bloquearlo
        if (Controles.intentoLogueo() == true
                && Controles.cadenaVacia(user) == false
                && Controles.cadenaVacia(contrasenia) == false) {
            bloquearUsuario(user);
        }
        return -1;//Si las credenciales son incorrectas devuelve -1
    }

    public static void bloquearUsuario(String user) {
        gestorBD.cambiarClaveUsuario(user, generarCadenaNumAleatoria(10));
    }

    public static String generarCadenaNumAleatoria(int longitud) {
        String caracteres = "0123456789";
        StringBuilder sb = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++) {
            int index = (int) (Math.random() * caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }

}
