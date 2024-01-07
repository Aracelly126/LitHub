package Utilidades;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Seguridad {
    private static final String LLAVE = "LLAVESITA";

    private static SecretKeySpec CrearClave(String llave) {
        try {
            byte[] cadena = llave.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(cadena, "AES");
            return secretKeySpec;
        } catch (Exception e) {
            return null;
        }
    }

    // Encriptar
    public static String Encriptar(String encriptar) {
        try {
            SecretKeySpec secretKeySpec = CrearClave(LLAVE);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] cadena = encriptar.getBytes("UTF-8");
            byte[] encriptada = cipher.doFinal(cadena);
            Base64.Encoder encoder = Base64.getEncoder();
            String cadena_encriptada = encoder.encodeToString(encriptada);
            return cadena_encriptada;

        } catch (Exception e) {
            return "";
        }
    }

    // Des-encriptación
    public static String Desencriptar(String desencriptar) {
        try {
            SecretKeySpec secretKeySpec = CrearClave(LLAVE);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] cadena = decoder.decode(desencriptar);
            byte[] desencriptacioon = cipher.doFinal(cadena);
            String cadena_desencriptada = new String(desencriptacioon);
            return cadena_desencriptada;
        } catch (Exception e) {
            return "";
        }
    }
}
