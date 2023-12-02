
package Controles;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

public class Controles {

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
    
    public void txtNotSpecialCharacters(java.awt.event.KeyEvent evt) {
        if (!Character.isLetterOrDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }

    public void txtOnlyLetters(java.awt.event.KeyEvent evt) {
        if (!Character.isAlphabetic(evt.getKeyChar())) {
            evt.consume();
        }
    }

    public void txtOnlyLettersSpaces(java.awt.event.KeyEvent evt) {
        if (!(Character.isAlphabetic(evt.getKeyChar()) || evt.getKeyChar() == ' ')) {
            evt.consume();
        }
    }

    public boolean txtOnlyNumbers(java.awt.event.KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
            return false;
        }
        return true;
    }
    
    public void colorBackgroundCmbx(JComboBox cmb, Color colorBad, Color colorGod) {
        cmb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmb.setBackground(colorGod);
            }
        });
        cmb.setBackground(colorBad);
    }

    public String claveToString(JPasswordField p) {
        char[] passwordChars = p.getPassword();
        String password = new String(passwordChars);
        return password;
    }

    public void colorBorderTxt(JTextField txt, Color colorBad, Color colorGod) {
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt.setBorder(new LineBorder(colorGod, 3));
            }
        });
        txt.setBorder(new LineBorder(colorBad, 3));
    }

    public void colorBackgroundTxt(JTextField txt, Color colorBad, Color colorGod) {
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt.setBackground(colorGod);
            }
        });
        txt.setBackground(colorBad);
    }

    public void crearVerPassword(JPasswordField pas, JToggleButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JToggleButton btn = (JToggleButton) e.getSource();
                if (btn.isSelected()) {
                    pas.setEchoChar((char) 0); // Mostrar texto sin ocultarlo
                } else {
                    pas.setEchoChar('\u2022'); // Ocultar texto
                }
            }
        });
    }

  

   
   
    

    

    
    
    

}
