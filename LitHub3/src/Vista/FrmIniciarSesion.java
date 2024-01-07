package Vista;

import BaseDatos.*;
import Utilidades.*;
import java.awt.Color;

public class FrmIniciarSesion extends javax.swing.JFrame {

    private FrmRegistro registro = new FrmRegistro();
    private Conexion con = new Conexion();

    public FrmIniciarSesion() {
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
            java.util.logging.Logger.getLogger(FrmIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        this.setLocationRelativeTo(null);

        this.registro.btn_inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setVisible(true);
                registro.dispose();
            }
        });
        
        ManejoComp.crearlabel(this.lbl_izquierda, "imagenes/img_fondo1.png");
        ManejoComp.crearlabel(this.lbl_logo, "imagenes/img_logo.png");
        ManejoComp.crearVerPassword(txt_contrasenia, btn_verContrasenia);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_izquierda = new javax.swing.JLabel();
        pnl_derecha = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        lbl_contrasenia = new javax.swing.JLabel();
        txt_contrasenia = new javax.swing.JPasswordField();
        btn_verContrasenia = new javax.swing.JToggleButton();
        lbl_mensaje = new javax.swing.JLabel();
        btn_iniciarSesion = new javax.swing.JButton();
        lbl_registro = new javax.swing.JLabel();
        btn_registro = new javax.swing.JButton();
        lblbaseDerecha = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LibHib | Iniciar Sesion");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lbl_izquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 540));

        pnl_derecha.setBackground(new java.awt.Color(255, 255, 255));
        pnl_derecha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnl_derecha.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 120, 120));

        lbl_usuario.setText("Usuario:");
        pnl_derecha.add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        txt_usuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyTyped(evt);
            }
        });
        pnl_derecha.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 190, 30));

        lbl_contrasenia.setText("Contraseña:");
        pnl_derecha.add(lbl_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        txt_contrasenia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_contrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contraseniaKeyTyped(evt);
            }
        });
        pnl_derecha.add(txt_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 190, 30));

        btn_verContrasenia.setText("Ver");
        btn_verContrasenia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_derecha.add(btn_verContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 265, 55, 20));

        lbl_mensaje.setForeground(new java.awt.Color(255, 0, 0));
        pnl_derecha.add(lbl_mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 240, 30));

        btn_iniciarSesion.setText("iniciar Sesion");
        btn_iniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_iniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_iniciarSesionMouseClicked(evt);
            }
        });
        pnl_derecha.add(btn_iniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        lbl_registro.setText("No tienes una cuenta?");
        pnl_derecha.add(lbl_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        btn_registro.setForeground(new java.awt.Color(51, 0, 102));
        btn_registro.setText("Registrarse");
        btn_registro.setBorder(null);
        btn_registro.setContentAreaFilled(false);
        btn_registro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_registro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_registroMouseClicked(evt);
            }
        });
        pnl_derecha.add(btn_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, -1, -1));

        lblbaseDerecha.setBackground(new java.awt.Color(255, 255, 255));
        lblbaseDerecha.setForeground(new java.awt.Color(255, 0, 0));
        pnl_derecha.add(lblbaseDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 540));

        getContentPane().add(pnl_derecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 380, 540));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_iniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_iniciarSesionMouseClicked
        if (this.con.conectar() == false) {
            this.con.desconectar();
            return;
        }
        String usuario = this.txt_usuario.getText();
        String contrasenia = ManejoComp.claveToString(this.txt_contrasenia);

        int tipo = Controles.credenciales(usuario, contrasenia);
        switch (tipo) {
            case -1://si las credenciales son incorrectas
                this.lbl_mensaje.setText("Usuario y/o Clave incorrectas");
                ManejoComp.colorBorderTxt(this.txt_usuario, Color.RED, Color.GREEN);
                ManejoComp.colorBorderTxt(this.txt_contrasenia, Color.RED, Color.GREEN);
                break;
            case 0:// Usuario Bloqueado
                this.lbl_mensaje.setText("Usuario Bloqueado, contacta a soporte. . .");
                ManejoComp.colorBorderTxt(this.txt_usuario, Color.RED, Color.GREEN);
                ManejoComp.colorBorderTxt(this.txt_contrasenia, Color.RED, Color.GREEN);
                break;
            case 1:// ADMIN
                System.out.println("Bienvenido ADMIN "+usuario);
                break;
            case 2:// AUTOR        
                System.out.println("Bienvenido AUTOR "+usuario);
                break;
            case 3:// LECTOR
                System.out.println("Bienvenido LECTOR "+usuario);
                break;
        }
        this.con.desconectar();
    }//GEN-LAST:event_btn_iniciarSesionMouseClicked

    private void btn_registroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registroMouseClicked
        this.registro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_registroMouseClicked

    private void txt_usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyTyped
        this.lbl_mensaje.setText("");
        ManejoComp.txtLongitudCondicion(this.txt_usuario, evt, 20);
        ManejoComp.txtOnlyLetters(evt);
    }//GEN-LAST:event_txt_usuarioKeyTyped

    private void txt_contraseniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contraseniaKeyTyped
        this.lbl_mensaje.setText("");
        ManejoComp.txtLongitudCondicion(this.txt_contrasenia, evt, 20);
    }//GEN-LAST:event_txt_contraseniaKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_iniciarSesion;
    private javax.swing.JButton btn_registro;
    private javax.swing.JToggleButton btn_verContrasenia;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lbl_contrasenia;
    private javax.swing.JLabel lbl_izquierda;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_mensaje;
    private javax.swing.JLabel lbl_registro;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JLabel lblbaseDerecha;
    private javax.swing.JPanel pnl_derecha;
    private javax.swing.JPasswordField txt_contrasenia;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
