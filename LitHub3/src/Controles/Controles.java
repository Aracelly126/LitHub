/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Controles {
    
     public String Encriptar(String s) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
    }

    public String Desencriptar(String s) throws UnsupportedEncodingException {
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode, "utf-8");
    }
    
    public boolean validarCedula(String cedula) {
        if (!cedula.matches("[0-9]{10}")) {
            return false;
        }
        int tercerdigito = Integer.parseInt(cedula.substring(2, 3));
        if (!(tercerdigito < 6)) {
            return false;
        }
        int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int verificador = Integer.parseInt(cedula.substring(9, 10));
        int suma = 0;
        int digito;

        for (int i = 0; i < (cedula.length() - 1); i++) {
            digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
            suma += ((digito % 10) + (digito / 10));
        }

        if (suma % 10 != 0 || suma % 10 != verificador && 10 - (suma % 10) != verificador) {
            return false;
        }

        return true;
    }

}
