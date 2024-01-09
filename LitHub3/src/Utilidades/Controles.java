package Utilidades;

import BaseDatos.Almacen;
import Clases.Usuario;
import static Utilidades.GestorPrograma.bloquearUsuario;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controles {

    public static int intentosIngresos = 0;

    private Controles() {
        // Private constructor to prevent instantiation
    }

    public static boolean intentoLogueo() {
        intentosIngresos = intentosIngresos + 1;
        if (intentosIngresos == 3) {
            intentosIngresos = 0;
            return true;
        }
        return false;
    }

    public static int credenciales(String user, String contrasenia) {
        boolean UserExiste = false;
        for (Usuario usuario : Almacen.getInstance().usuarios) {
            String correo = usuario.getCorreo();
            String clave = usuario.getClave();
            if (GestorPrograma.buscarUsuario(correo) != null) {
                UserExiste = true;
                if (clave.equals(Seguridad.Encriptar(contrasenia))) {
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
        }
        //Si las credenciales son incorrectas empieza un contador para bloquearlo
        if (Controles.intentoLogueo() == true && Controles.cadenaVacia(user) == false && UserExiste == true) {
            bloquearUsuario(user);
            return 0;//Si el usuario se bloquea regresa 0
        }
        return -1;//Si las credenciales son incorrectas devuelve -1
    }

    public static boolean cadenaVacia(String cadena) {
        return cadena.isBlank() || cadena.isEmpty();
    }

    public static boolean correoElectronico(String email) {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean cedula(String ced) {
        int a, e, i, o, cont, j, u = 0, y = 0, r = 0, s = 0;
        double z = 0, k = 100000000;
        String ced1 = null;
        ced = ced.trim();
        try {
            ced1 = ced.substring(0, 9);        //*1 *2 *3 *4 *5 *6 *7 *8 *9
            cont = ced1.length();
            //--------------------------------------
            a = Integer.parseInt(ced.substring(0, 2));           //*1 *2
            e = Integer.parseInt(ced.substring(2, 3));           //*3
            i = Integer.parseInt(ced.substring(3, 9));           //*4 *5 *6 *7 *8 *9
            o = Integer.parseInt(ced.substring(9, 10));          //*10
            //--------------------------------------
        } catch (Exception w) {
            return false;
        }
        if (a >= 0 && a <= 24) {
            if (e >= 0 && e < 6) {
                for (j = 0; j < cont; j++) {
                    if (j % 2 == 0) {
                        y = 2;
                    } else {
                        y = 1;
                    }
                    ced1 = ced.substring(j, j + 1);
                    z = Integer.parseInt(ced1);
                    u = (int) (z * y);
                    if (u >= 10) {
                        u = u - 9;
                    }
                    r = r + u;
                }
                s = r;
                //System.out.println(z+"   "+y+"    "+u+"    "+r);
                for (j = 0; s % 10 != 0; j++) {
                    s = s + 1;
                }
                r = s - r;
                //System.out.println(r);
                if (r == 10) {
                    r = 0;
                }
                return r == o;
            }
        }
        return false;
    }
}
