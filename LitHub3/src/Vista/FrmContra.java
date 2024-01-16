package Vista;

import BaseDatos.Almacen;
import Clases.ContraseniaAntigua;
import Clases.ContraseniaNueva;
import Clases.Usuario;
import Main.Main;
import Utilidades.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FrmContra extends javax.swing.JFrame {

    private FrmIniciarSesion frmIniciar = new FrmIniciarSesion();
    private Seguridad seguridad = new Seguridad();

    public FrmContra() {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmContra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        this.setLocationRelativeTo(null);
        ManejoComp.crearlabel(this.lbl_izquierda, "SYSTEM/src/img_fondo1.png");
        ManejoComp.crearlabel(this.lbl_logoCam, "SYSTEM/src/img_logo.png");
        ManejoComp.crearVerPassword(txt_contraseniaUnaVezMas, btn_verContraseniaCam);
        String usuario = Almacen.getInstance().contraseniaAnti.get(0).getUsuario();
        this.txt_correoCam.setText(usuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_izquierda = new javax.swing.JLabel();
        pnl_derechaContra = new javax.swing.JPanel();
        lbl_logoCam = new javax.swing.JLabel();
        lbl_correoCamb = new javax.swing.JLabel();
        txt_correoCam = new javax.swing.JTextField();
        lbl_contrasenia = new javax.swing.JLabel();
        txt_contraseniaCam = new javax.swing.JPasswordField();
        btn_verContraseniaCam = new javax.swing.JToggleButton();
        btn_Aceptar = new javax.swing.JButton();
        lbl_registroCorreo = new javax.swing.JLabel();
        btn_IniciarSesion = new javax.swing.JButton();
        txt_contraseniaUnaVezMas = new javax.swing.JPasswordField();
        lbl_escribeprimeravez = new javax.swing.JLabel();
        lbl_otravez = new javax.swing.JLabel();
        lbl_parrafo3 = new javax.swing.JLabel();
        lbl_parrafo2 = new javax.swing.JLabel();
        lbl_contrasenia4 = new javax.swing.JLabel();
        lblbaseDerecha = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LibHib | Iniciar Sesion");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lbl_izquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 540));

        pnl_derechaContra.setBackground(new java.awt.Color(255, 255, 255));
        pnl_derechaContra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnl_derechaContra.add(lbl_logoCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 120, 120));

        lbl_correoCamb.setForeground(new java.awt.Color(0, 0, 0));
        lbl_correoCamb.setText("Correo:");
        pnl_derechaContra.add(lbl_correoCamb, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 208, -1, 32));

        txt_correoCam.setEditable(false);
        txt_correoCam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_correoCam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_correoCamKeyTyped(evt);
            }
        });
        pnl_derechaContra.add(txt_correoCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 208, 190, 30));

        lbl_contrasenia.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_contrasenia.setForeground(new java.awt.Color(0, 0, 0));
        lbl_contrasenia.setText("Recuperación de la contraseña");
        pnl_derechaContra.add(lbl_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 176, -1, -1));

        txt_contraseniaCam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_contraseniaCam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contraseniaCamKeyTyped(evt);
            }
        });
        pnl_derechaContra.add(txt_contraseniaCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 352, 190, 30));

        btn_verContraseniaCam.setText("Ver");
        btn_verContraseniaCam.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl_derechaContra.add(btn_verContraseniaCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 420, 55, 20));

        btn_Aceptar.setText("Aceptar");
        btn_Aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AceptarMouseClicked(evt);
            }
        });
        pnl_derechaContra.add(btn_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 464, -1, -1));

        lbl_registroCorreo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_registroCorreo.setText("Ya te llego el correo?");
        pnl_derechaContra.add(lbl_registroCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        btn_IniciarSesion.setForeground(new java.awt.Color(51, 0, 102));
        btn_IniciarSesion.setText("Iniciar Sesion");
        btn_IniciarSesion.setBorder(null);
        btn_IniciarSesion.setContentAreaFilled(false);
        btn_IniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_IniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_IniciarSesionMouseClicked(evt);
            }
        });
        pnl_derechaContra.add(btn_IniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 512, -1, -1));

        txt_contraseniaUnaVezMas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_contraseniaUnaVezMas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contraseniaUnaVezMasKeyTyped(evt);
            }
        });
        pnl_derechaContra.add(txt_contraseniaUnaVezMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 416, 190, 30));

        lbl_escribeprimeravez.setForeground(new java.awt.Color(0, 0, 0));
        lbl_escribeprimeravez.setText("Escribe la última contraseña:");
        pnl_derechaContra.add(lbl_escribeprimeravez, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));

        lbl_otravez.setForeground(new java.awt.Color(0, 0, 0));
        lbl_otravez.setText("Otra vez:");
        pnl_derechaContra.add(lbl_otravez, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 395, -1, -1));

        lbl_parrafo3.setForeground(new java.awt.Color(0, 0, 0));
        lbl_parrafo3.setText("haber utilizado para esta aplicación.");
        pnl_derechaContra.add(lbl_parrafo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 272, 240, -1));

        lbl_parrafo2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_parrafo2.setForeground(new java.awt.Color(204, 0, 0));
        lbl_parrafo2.setText("\n\n");
        pnl_derechaContra.add(lbl_parrafo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 304, 240, -1));

        lbl_contrasenia4.setForeground(new java.awt.Color(0, 0, 0));
        lbl_contrasenia4.setText("Escribe la última contraseña que recuerdes");
        pnl_derechaContra.add(lbl_contrasenia4, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 256, -1, -1));

        lblbaseDerecha.setBackground(new java.awt.Color(255, 255, 255));
        lblbaseDerecha.setForeground(new java.awt.Color(255, 0, 0));
        pnl_derechaContra.add(lblbaseDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 540));

        getContentPane().add(pnl_derechaContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 380, 540));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AceptarMouseClicked
        String contraseñaAntiguaUser = "";
        String contraseñaNueva = "";
        String contraseniaAntigua = ManejoComp.claveToString(this.txt_contraseniaCam);
        String contraseniaAntigua2 = ManejoComp.claveToString(this.txt_contraseniaUnaVezMas);
        for (int i = 0; i < Almacen.getInstance().contraseniaAnti.size(); i++) {
          if (this.txt_correoCam.getText().equals(Almacen.getInstance().contraseniaAnti.get(i).getUsuario())) {
              System.out.println("Usuario tomado "+Almacen.getInstance().contraseniaAnti.get(i).getUsuario());
              System.out.println("contra tomada: "+Almacen.getInstance().contraseniaAnti.get(i).getContraseñaAntigua());
                contraseñaAntiguaUser =Almacen.getInstance().contraseniaAnti.get(i).getContraseñaAntigua();
                break;
            }  
        }
        for (int i = 0; i < Almacen.getInstance().contraseniaNueva.size(); i++) {
            if (this.txt_correoCam.getText().equals(Almacen.getInstance().contraseniaNueva.get(i).getUsuario())) {
                contraseñaNueva=Almacen.getInstance().contraseniaNueva.get(i).getContraseñaNueva();
                break;
            }
        }
        if (contraseniaAntigua.equals(contraseniaAntigua2)) {
            System.out.println("La contraseña Antiguia del almacen es esta: "+contraseñaAntiguaUser);
            System.out.println("La contraseña Antiguia tomada es es esta: "+contraseniaAntigua);
            System.out.println("La contraseña nueva del almacen es esta:"+contraseñaNueva);
            if (contraseñaAntiguaUser.equals(contraseniaAntigua)) {
                System.out.println("La contraseña nueva es paso ultimo:" + contraseñaNueva);
                this.btn_Aceptar.setEnabled(false);
                seguridad.crearEmail(this.txt_correoCam,contraseñaNueva);
                seguridad.enviarMensaje();
                Almacen.getInstance().contraseniaAnti.clear();
                Almacen.getInstance().contraseniaNueva.clear();
                Almacen.getInstance().usuarios.clear();
                Main.arrancarBDContraNueva();
            } else {
                this.lbl_parrafo2.setText("No coinciden con la contraseña antigua");
            }
        } else {
            this.lbl_parrafo2.setText("Las contraseñas no coinciden.Vuelve a ingresar");
        }

    }//GEN-LAST:event_btn_AceptarMouseClicked

    private void btn_IniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_IniciarSesionMouseClicked
        this.frmIniciar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_IniciarSesionMouseClicked

    private void txt_contraseniaCamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contraseniaCamKeyTyped
//        this.lbl_mensaje.setText("");
        ManejoComp.txtLongitudCondicion(this.txt_contraseniaCam, evt, 20);
    }//GEN-LAST:event_txt_contraseniaCamKeyTyped

    private void txt_contraseniaUnaVezMasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contraseniaUnaVezMasKeyTyped
        ManejoComp.txtLongitudCondicion(this.txt_contraseniaCam, evt, 20);
    }//GEN-LAST:event_txt_contraseniaUnaVezMasKeyTyped

    private void txt_correoCamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_correoCamKeyTyped
//        String usuario=Almacen.getInstance().contraseñas.get(0).getUsuario();
//        this.txt_correo.setText(usuario);
    }//GEN-LAST:event_txt_correoCamKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Aceptar;
    private javax.swing.JButton btn_IniciarSesion;
    private javax.swing.JToggleButton btn_verContraseniaCam;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lbl_contrasenia;
    private javax.swing.JLabel lbl_contrasenia4;
    private javax.swing.JLabel lbl_correoCamb;
    private javax.swing.JLabel lbl_escribeprimeravez;
    private javax.swing.JLabel lbl_izquierda;
    private javax.swing.JLabel lbl_logoCam;
    private javax.swing.JLabel lbl_otravez;
    private javax.swing.JLabel lbl_parrafo2;
    private javax.swing.JLabel lbl_parrafo3;
    private javax.swing.JLabel lbl_registroCorreo;
    private javax.swing.JLabel lblbaseDerecha;
    private javax.swing.JPanel pnl_derechaContra;
    private javax.swing.JPasswordField txt_contraseniaCam;
    private javax.swing.JPasswordField txt_contraseniaUnaVezMas;
    private javax.swing.JTextField txt_correoCam;
    // End of variables declaration//GEN-END:variables
}
