package Vista;

import BaseDatos.*;
import Utilidades.*;
import java.awt.Color;

public class FrmIniciarSesion extends javax.swing.JFrame {

    private Conexion con = new Conexion();

    private frmregistro frmRegistro = new frmregistro();
    private FrmAdmin frmAdmin = new FrmAdmin();
    private FrmAutor frmAutor = new FrmAutor();
    private FrmLector frmLector = new FrmLector();

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

        this.frmRegistro.btn_inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setVisible(true);
                frmRegistro.dispose();
            }
        });
        this.frmAdmin.lbl_btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setVisible(true);
                frmAdmin.cerrarSesion();
            }
        });
        this.frmAutor.lbl_btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setVisible(true);
                frmAutor.cerrarSesion();
            }
        });
        this.frmLector.lbl_btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setVisible(true);
                frmLector.cerrarSesion();
            }
        });

        ManejoComp.crearlabel(this.lbl_izquierda, "SYSTEM/src/img_fondo1.png");
        ManejoComp.crearlabel(this.lbl_logo, "SYSTEM/src/img_logo.png");
        ManejoComp.crearlabel(this.lb_informacion, "SYSTEM/src/information_icon.png");
        ManejoComp.crearVerPassword(txt_contrasenia, btn_verContrasenia);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_izquierda = new javax.swing.JLabel();
        pnl_derecha = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        lbl_correo = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        lbl_contrasenia = new javax.swing.JLabel();
        txt_contrasenia = new javax.swing.JPasswordField();
        btn_verContrasenia = new javax.swing.JToggleButton();
        lbl_mensaje = new javax.swing.JLabel();
        btn_iniciarSesion = new javax.swing.JButton();
        lbl_registro = new javax.swing.JLabel();
        btn_registro = new javax.swing.JButton();
        lblbaseDerecha = new javax.swing.JLabel();
        lb_informacion = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LibHib | Iniciar Sesion");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lbl_izquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 540));

        pnl_derecha.setBackground(new java.awt.Color(255, 255, 255));
        pnl_derecha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnl_derecha.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 120, 120));

        lbl_correo.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_correo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_correo.setText("Correo:");
        pnl_derecha.add(lbl_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, 30));

        txt_correo.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_correo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_correoKeyTyped(evt);
            }
        });
        pnl_derecha.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 190, 40));

        lbl_contrasenia.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_contrasenia.setForeground(new java.awt.Color(0, 0, 0));
        lbl_contrasenia.setText("Contraseña:");
        pnl_derecha.add(lbl_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, 30));

        txt_contrasenia.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_contrasenia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_contrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contraseniaKeyTyped(evt);
            }
        });
        pnl_derecha.add(txt_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 190, 40));

        btn_verContrasenia.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btn_verContrasenia.setText("Ver");
        btn_verContrasenia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl_derecha.add(btn_verContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, 20));

        lbl_mensaje.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbl_mensaje.setForeground(new java.awt.Color(255, 0, 0));
        pnl_derecha.add(lbl_mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 240, 30));

        btn_iniciarSesion.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_iniciarSesion.setText("Iniciar Sesion");
        btn_iniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_iniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_iniciarSesionMouseClicked(evt);
            }
        });
        pnl_derecha.add(btn_iniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, -1, 35));

        lbl_registro.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbl_registro.setForeground(new java.awt.Color(0, 0, 0));
        lbl_registro.setText("No tienes una cuenta?");
        pnl_derecha.add(lbl_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, 30));

        btn_registro.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btn_registro.setForeground(new java.awt.Color(51, 0, 102));
        btn_registro.setText("Registrarse");
        btn_registro.setBorder(null);
        btn_registro.setContentAreaFilled(false);
        btn_registro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_registro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_registroMouseClicked(evt);
            }
        });
        pnl_derecha.add(btn_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, -1, 30));

        lblbaseDerecha.setBackground(new java.awt.Color(255, 255, 255));
        lblbaseDerecha.setForeground(new java.awt.Color(255, 0, 0));
        pnl_derecha.add(lblbaseDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 540));

        lb_informacion.setText("jLabel1");
        lb_informacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_informacionMouseClicked(evt);
            }
        });
        pnl_derecha.add(lb_informacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 500, 30, 30));

        getContentPane().add(pnl_derecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 380, 540));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_iniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_iniciarSesionMouseClicked
        if (this.con.conectar() == false) {
            return;
        }
        String correo = this.txt_correo.getText();
        String contrasenia = ManejoComp.claveToString(this.txt_contrasenia);
        int tipo = Controles.credenciales(correo, contrasenia);
        switch (tipo) {
            case -1://si las credenciales son incorrectas
                this.lbl_mensaje.setText("Correo y/o Clave incorrectas");
                ManejoComp.colorBorderTxt(this.txt_correo, Color.RED, Color.GREEN);
                ManejoComp.colorBorderTxt(this.txt_contrasenia, Color.RED, Color.GREEN);
                break;
            case 0:// Usuario Bloqueado
                this.lbl_mensaje.setText("Cuenta Bloqueado, contacta a soporte. . .");
                ManejoComp.colorBorderTxt(this.txt_correo, Color.RED, Color.GREEN);
                ManejoComp.colorBorderTxt(this.txt_contrasenia, Color.RED, Color.GREEN);
                break;
            case 1:// ADMIN
                this.frmAdmin.iniciarVentana(correo);
                this.dispose();
                break;
            case 2:// AUTOR     
                this.frmAutor.iniciarVentana(correo);
                this.dispose();
                break;
            case 3:// LECTOR
                this.frmLector.iniciarVentana(correo);
                this.dispose();
                break;
        }
        this.con.desconectar();
    }//GEN-LAST:event_btn_iniciarSesionMouseClicked

    private void btn_registroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registroMouseClicked
        this.frmRegistro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_registroMouseClicked

    private void txt_correoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_correoKeyTyped
        this.lbl_mensaje.setText("");
        ManejoComp.txtLongitudCondicion(this.txt_correo, evt, 30);
    }//GEN-LAST:event_txt_correoKeyTyped

    private void txt_contraseniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contraseniaKeyTyped
        this.lbl_mensaje.setText("");
        ManejoComp.txtLongitudCondicion(this.txt_contrasenia, evt, 20);
    }//GEN-LAST:event_txt_contraseniaKeyTyped

    private void lb_informacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_informacionMouseClicked
        // TODO add your handling code here:
        FrmInformacion inf = new FrmInformacion();
        inf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lb_informacionMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_iniciarSesion;
    private javax.swing.JButton btn_registro;
    private javax.swing.JToggleButton btn_verContrasenia;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lb_informacion;
    private javax.swing.JLabel lbl_contrasenia;
    private javax.swing.JLabel lbl_correo;
    private javax.swing.JLabel lbl_izquierda;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_mensaje;
    private javax.swing.JLabel lbl_registro;
    private javax.swing.JLabel lblbaseDerecha;
    private javax.swing.JPanel pnl_derecha;
    private javax.swing.JPasswordField txt_contrasenia;
    private javax.swing.JTextField txt_correo;
    // End of variables declaration//GEN-END:variables
}
