package Utilidades;

import BaseDatos.GestorBD;
import Clases.Usuario;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GestorPrograma {

    private static GestorBD gestorBD = new GestorBD();

    private GestorPrograma() {

    }

    public static void crearUsuario(String nombre, String apellido, String fecNac, String tipo, String pais, String correo, String contrasenia) {
        System.out.println("se va a crear");
        Usuario newUsuario = new Usuario(nombre,
                apellido,
                Seguridad.Encriptar(contrasenia),
                pais,
                fecNac,
                correo,
                tipo);
        System.out.println("c crea");
        gestorBD.insertarUsuario(newUsuario);
    }

    public static void bloquearUsuario(String user) {
        gestorBD.cambiarClaveUsuario(user, Seguridad.Encriptar(generarCadenaNumAleatoria(10)));
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

    public static String transformarFecha(String fechaOriginal) {// EEE MMM dd HH:mm:ss z yyyy to dd/MM/yyyy
        try {
            SimpleDateFormat formatoOriginal = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            Date fecha = formatoOriginal.parse(fechaOriginal);

            SimpleDateFormat formatoNuevo = new SimpleDateFormat("dd/MM/yyyy");
            return formatoNuevo.format(fecha);
        } catch (Exception e) {
            System.out.println("Error Metodo:transformarFecha Clase:GestorPrograma\n" + e);
            return null;
        }
    }

    public static String transformarFechaInverso(String fechaOriginal) {// dd/MM/yyyy to EEE MMM dd HH:mm:ss z yyyy
        try {
            SimpleDateFormat formatoOriginal = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formatoOriginal.parse(fechaOriginal + " 00:00:00");

            SimpleDateFormat formatoNuevo = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            return formatoNuevo.format(fecha);
        } catch (Exception e) {
            System.out.println("Error Metodo:transformarFechaInverso Clase:GestorPrograma\n" + e);
            return null;
        }
    }

}
