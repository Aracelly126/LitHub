package Utilidades;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ManejoComp {

    private ManejoComp() {
        // Private constructor to prevent instantiation
    }

   public static boolean crearlabel(JLabel label, String urlImg) {
    if (urlImg != null && !urlImg.isEmpty()) {
        label.setIcon(redimensionarImagen(urlImg, label.getWidth(), label.getHeight()));
        return true;
    } else {
        label.setIcon(null);  // Limpiar la imagen del JLabel
        return false;
    }
}


    public static void crearPanel(JPanel panel, String nombreImg) {
        ImageIcon imagen = redimensionarImagen(nombreImg, panel.getWidth(), panel.getHeight());

        JLabel label = new JLabel(imagen);
        label.setOpaque(false);

        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);

        panel.add(label, BorderLayout.CENTER);

        panel.revalidate();
        panel.repaint();
    }

    public static ImageIcon redimensionarImagen(String rutaImagen, int ancho, int alto) {
        ImageIcon imagenIcon = new ImageIcon(rutaImagen);
        Image imagen = imagenIcon.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        if (imagenRedimensionada == null) {
            System.out.println("Sin imagen");
        }
        return new ImageIcon(imagenRedimensionada);
    }

    public static void crearVerPassword(JPasswordField pas, JToggleButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JToggleButton btn = (JToggleButton) e.getSource();
                if (btn.isSelected()) {
                    pas.setEchoChar((char) 0);
                } else {
                    pas.setEchoChar('\u2022');
                }
            }
        });
        pas.setEchoChar('\u2022');
    }

    public static void vaciarTabla(JTable tbl, DefaultTableModel modelito) {
        int count = tbl.getRowCount();
        for (int i = count; i > 0; i--) {
            modelito.removeRow(i - 1);
        }
    }

    public static void txtNotSpecialCharacters(java.awt.event.KeyEvent evt) {
        if (!Character.isLetterOrDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }

    public static void txtOnlyLetters(java.awt.event.KeyEvent evt) {
        if (!Character.isAlphabetic(evt.getKeyChar())) {
            evt.consume();
        }
    }

    public static void txtOnlyLettersSpaces(java.awt.event.KeyEvent evt) {
        if (!(Character.isAlphabetic(evt.getKeyChar()) || evt.getKeyChar() == ' ')) {
            evt.consume();
        }
    }

    public static boolean txtOnlyNumbers(java.awt.event.KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
            return false;
        }
        return true;
    }

    public static void txtOnlyDoubles(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == '.')) {
            evt.consume();
        }
    }

    public static void txtTypingNumsDec(JTextField txt, java.awt.event.KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if (!(caracter >= '0' && caracter <= '9') && caracter != '.') {
            evt.consume();
        }
        if (txt.getText().contains(".") && caracter == '.') {
            evt.consume();
        }
        if (txt.getText().contains(".")) {
            if (txt.getText().length() > txt.getText().indexOf(".") + 2) {
                evt.consume();
            }
            if (!(txt.getText().matches("^\\d+(\\.\\d{0,1})?$"))) {
                evt.consume();
            }
        }
    }

    public static void txtOnlyLettersSpacesCondicion(KeyEvent evt, int num) {
        char keyChar = evt.getKeyChar();

        if (!Character.isAlphabetic(keyChar) && keyChar != KeyEvent.VK_SPACE) {
            evt.consume();
        } else if (keyChar == KeyEvent.VK_SPACE) {
            if (textContainsMultipleSpaces(evt, num)) {
                evt.consume();
            }
        }
    }

    public static void txtNoEspecialsCharacterSpace(KeyEvent evt, int num) {
        char keyChar = evt.getKeyChar();

        if (!Character.isLetter(keyChar) && !Character.isWhitespace(keyChar) && !Character.isDigit(keyChar)) {
            evt.consume();
        } else if (Character.isWhitespace(keyChar)) {
            if (textContainsMultipleSpaces(evt, num)) {
                evt.consume();
            }
        }
    }

    private static boolean textContainsMultipleSpaces(KeyEvent evt, int num) {
        String text = ((JTextField) evt.getSource()).getText();
        int spaceCount = 0;
        boolean previousSpace = false;

        for (char c : text.toCharArray()) {
            if (c == ' ') {
                if (previousSpace) {
                    return true;
                }
                spaceCount++;
                previousSpace = true;
            } else {
                previousSpace = false;
            }
        }

        return spaceCount >= num;
    }

    public static int StringToInt(JTextField txt) {
        try {
            int resultado = Integer.parseInt(txt.getText().trim());
            return resultado;
        } catch (Exception e) {
            return 0;
        }
    }

    public static double StringToDouble(JTextField txt) {
        try {
            double resultado = Double.parseDouble(txt.getText().trim());

            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            String resultadoFormateado = decimalFormat.format(resultado);

            return Double.parseDouble(resultadoFormateado);
        } catch (Exception e) {
            return 0;
        }
    }

    public static void txtLongitudCondicion(JTextField jtextfield, KeyEvent evt, int longitud) {
        String cadena = jtextfield.getText();
        if (cadena.length() >= longitud) {
            evt.consume();
        }
    }

    public static void colorBorderTxt(JTextField txt, Color colorBad, Color colorGod) {
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt.setBorder(new LineBorder(colorGod, 3));
            }
        });
        txt.setBorder(new LineBorder(colorBad, 3));
    }

    public static void colorBorderPassword(JPasswordField passwordField, Color colorBad, Color colorGood) {
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordField.setBorder(new LineBorder(colorGood, 3));
            }
        });
        passwordField.setBorder(new LineBorder(colorBad, 3));
    }

    public static void colorBorderCajaFecha(JDateChooser dateChooser, Color colorBad, Color colorGood) {
        dateChooser.getDateEditor().addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                dateChooser.setBorder(new LineBorder(colorGood, 2));
            }
        });
        dateChooser.setBorder(new LineBorder(colorBad, 3));
    }

    public static String claveToString(JPasswordField p) {
        char[] passwordChars = p.getPassword();
        return new String(passwordChars);
    }

    public static ImageIcon imageTopIcon(String ruta) {
        try {
            return new ImageIcon(ruta);
        } catch (Exception e) {
            System.out.println("Error Metodo:imageToIcon Clase:ManejoComp Ruta:" + ruta + "\n" + e);
            return null;
        }
    }

}
