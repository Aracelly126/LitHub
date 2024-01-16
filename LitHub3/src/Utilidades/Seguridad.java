package Utilidades;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Seguridad {

    private static final String LLAVE = "LLAVESITA";

    private static String emailFrom = "lithubprogramadores@gmail.com";
    private static String contraseñaFrom = "xldw ibkk gotk qcqy";
    private String emailTo;
    private String asunto;
    private String contenido;
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;

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

    public void crearEmail(JTextField txt_correoCam, String contraNueva) {
        emailTo = txt_correoCam.getText().trim();
        System.out.println(emailTo);
         asunto = "Recuperación de contraseña \"LitHub\"";
        contenido = "Estimado/a Usuario su nueva clave es: "+contraNueva+". Gracias por utilizar Lithub";
// Simple mail transier protocolo
        mProperties = new Properties();
        
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mProperties);

        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));//Remitente
            mCorreo.setSubject(asunto);
            mCorreo.setText(contenido, "ISO-8859-1", "html");

        } catch (AddressException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensaje() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, contraseñaFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
            JOptionPane.showMessageDialog(null, "Se ha enviado la contraseña nueva a tu correo");

        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void envioContraseñaCorreo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
