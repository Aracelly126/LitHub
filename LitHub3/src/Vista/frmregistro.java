package Vista;

import BaseDatos.Conexion;
import Utilidades.Controles;
import Utilidades.GestorPrograma;
import Utilidades.ManejoComp;
import java.awt.Color;

public class frmregistro extends javax.swing.JFrame {

    private Conexion con = new Conexion();

    public frmregistro() {
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
            java.util.logging.Logger.getLogger(frmregistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmregistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmregistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmregistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        this.setLocationRelativeTo(null);

        ManejoComp.crearVerPassword(this.txt_contrasenia, this.btn_verContrasenia);
        ManejoComp.crearVerPassword(this.txt_confContrasenia, this.btn_verConfContrasenia);
        ManejoComp.crearlabel(this.lbl_izquierda, "SYSTEM/src/img_fondo2.png");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_izquierda = new javax.swing.JLabel();
        pnl_registro = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        lbl_apellido = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        lbl_fechaNac = new javax.swing.JLabel();
        txt_fecNac = new com.toedter.calendar.JDateChooser();
        lbl_tipo = new javax.swing.JLabel();
        cmb_tipo = new javax.swing.JComboBox<>();
        lbl_pais = new javax.swing.JLabel();
        txt_pais = new javax.swing.JTextField();
        lbl_correo = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        lbl_contrasenia = new javax.swing.JLabel();
        txt_contrasenia = new javax.swing.JPasswordField();
        lbl_confContrasenia = new javax.swing.JLabel();
        txt_confContrasenia = new javax.swing.JPasswordField();
        btn_registrar = new javax.swing.JButton();
        lbl_inicio = new javax.swing.JLabel();
        btn_inicio = new javax.swing.JButton();
        btn_verConfContrasenia = new javax.swing.JToggleButton();
        btn_verContrasenia = new javax.swing.JToggleButton();
        lbl_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LibHub | Registrarme");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lbl_izquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 590));

        pnl_registro.setBackground(new java.awt.Color(255, 255, 255));
        pnl_registro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_titulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(51, 51, 51));
        lbl_titulo.setText("Registro de Usuario");
        pnl_registro.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 240, 60));

        lbl_nombre.setForeground(new java.awt.Color(0, 0, 0));
        lbl_nombre.setText("Nombre:");
        pnl_registro.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        txt_nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        pnl_registro.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 120, 30));

        lbl_apellido.setForeground(new java.awt.Color(0, 0, 0));
        lbl_apellido.setText("Apellido");
        pnl_registro.add(lbl_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        txt_apellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyTyped(evt);
            }
        });
        pnl_registro.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 120, 30));

        lbl_fechaNac.setForeground(new java.awt.Color(0, 0, 0));
        lbl_fechaNac.setText("Fecha de Nacimiento");
        pnl_registro.add(lbl_fechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        txt_fecNac.setDateFormatString("dd/MM/yyyy");
        txt_fecNac.setMaxSelectableDate(new java.util.Date(1262235600000L));
        pnl_registro.add(txt_fecNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 120, 30));

        lbl_tipo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_tipo.setText("Tipo");
        pnl_registro.add(lbl_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        cmb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "LECTOR", "AUTOR" }));
        pnl_registro.add(cmb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 120, 30));

        lbl_pais.setForeground(new java.awt.Color(0, 0, 0));
        lbl_pais.setText("País");
        pnl_registro.add(lbl_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        txt_pais.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_pais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_paisKeyTyped(evt);
            }
        });
        pnl_registro.add(txt_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 250, 30));

        lbl_correo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_correo.setText("Correo:");
        pnl_registro.add(lbl_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        txt_correo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_correoKeyTyped(evt);
            }
        });
        pnl_registro.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 250, 30));

        lbl_contrasenia.setForeground(new java.awt.Color(0, 0, 0));
        lbl_contrasenia.setText("Contraseña:");
        pnl_registro.add(lbl_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, -1, -1));

        txt_contrasenia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_contrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contraseniaKeyTyped(evt);
            }
        });
        pnl_registro.add(txt_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 250, 30));

        lbl_confContrasenia.setForeground(new java.awt.Color(0, 0, 0));
        lbl_confContrasenia.setText("Confirmar contraseña:");
        pnl_registro.add(lbl_confContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, -1, -1));

        txt_confContrasenia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_confContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_confContraseniaKeyTyped(evt);
            }
        });
        pnl_registro.add(txt_confContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 250, 30));

        btn_registrar.setText("Registrarse");
        btn_registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_registrarMouseClicked(evt);
            }
        });
        pnl_registro.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, -1, -1));

        lbl_inicio.setForeground(new java.awt.Color(0, 0, 0));
        lbl_inicio.setText("Ya tienes una cuenta?");
        pnl_registro.add(lbl_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        btn_inicio.setForeground(new java.awt.Color(51, 0, 102));
        btn_inicio.setText("iniciar sesion");
        btn_inicio.setBorder(null);
        btn_inicio.setContentAreaFilled(false);
        btn_inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_registro.add(btn_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, -1, -1));

        btn_verConfContrasenia.setText("Ver");
        btn_verConfContrasenia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_registro.add(btn_verConfContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 445, 55, 20));

        btn_verContrasenia.setText("Ver");
        btn_verContrasenia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_registro.add(btn_verContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 385, 55, 20));

        getContentPane().add(pnl_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 510, 590));
        getContentPane().add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_registrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registrarMouseClicked
        if (this.con.conectar() == false) {
            this.con.desconectar();
            return;
        }
        String nombre = this.txt_nombre.getText();
        String apellido = this.txt_apellido.getText();
        String fecNac;
        try {
            fecNac = GestorPrograma.transformarFecha(this.txt_fecNac.getDate().toString());
        } catch (Exception e) {
            fecNac = "";
        }
        String tipo = this.cmb_tipo.getSelectedItem().toString();
        String pais = this.txt_pais.getText();
        String correo = this.txt_correo.getText();
        String contrasenia1 = ManejoComp.claveToString(this.txt_contrasenia);
        String contrasenia2 = ManejoComp.claveToString(this.txt_confContrasenia);

        boolean aux = true;
        if (Controles.cadenaVacia(nombre)) {
            ManejoComp.colorBorderTxt(this.txt_nombre, Color.RED, Color.GREEN);
            aux = false;
        }
        if (Controles.cadenaVacia(apellido)) {
            ManejoComp.colorBorderTxt(this.txt_apellido, Color.RED, Color.GREEN);
            aux = false;
        }
        if (Controles.cadenaVacia(fecNac)) {
            ManejoComp.colorBorderCajaFecha(this.txt_fecNac, Color.RED, Color.GREEN);
            aux = false;
        }
        if (Controles.cadenaVacia(pais)) {
            ManejoComp.colorBorderTxt(this.txt_pais, Color.RED, Color.GREEN);
            aux = false;
        }
        if (Controles.cadenaVacia(correo) || Controles.correoElectronico(correo) == false || GestorPrograma.buscarUsuario(correo) != null) {
            ManejoComp.colorBorderTxt(this.txt_correo, Color.RED, Color.GREEN);
            aux = false;
        }
        if (Controles.cadenaVacia(contrasenia1)) {
            ManejoComp.colorBorderPassword(this.txt_contrasenia, Color.RED, Color.GREEN);
            aux = false;
        }
        if (Controles.cadenaVacia(contrasenia2) || contrasenia2.equals(contrasenia1) == false) {
            ManejoComp.colorBorderPassword(this.txt_confContrasenia, Color.RED, Color.GREEN);
            aux = false;
        }
        if (aux == false) {
            this.con.desconectar();
            return;
        }
        GestorPrograma.crearUsuario(nombre, apellido, fecNac, tipo, pais, correo, contrasenia1);
        this.con.desconectar();
    }//GEN-LAST:event_btn_registrarMouseClicked

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        ManejoComp.txtLongitudCondicion(this.txt_nombre, evt, 20);
        ManejoComp.txtOnlyLetters(evt);
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyTyped
        ManejoComp.txtLongitudCondicion(this.txt_apellido, evt, 20);
        ManejoComp.txtOnlyLetters(evt);
    }//GEN-LAST:event_txt_apellidoKeyTyped

    private void txt_paisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_paisKeyTyped
        ManejoComp.txtLongitudCondicion(this.txt_nombre, evt, 20);
        ManejoComp.txtOnlyLetters(evt);
    }//GEN-LAST:event_txt_paisKeyTyped

    private void txt_correoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_correoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_correoKeyTyped

    private void txt_contraseniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contraseniaKeyTyped
        ManejoComp.txtLongitudCondicion(this.txt_contrasenia, evt, 20);
    }//GEN-LAST:event_txt_contraseniaKeyTyped

    private void txt_confContraseniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_confContraseniaKeyTyped
        ManejoComp.txtLongitudCondicion(this.txt_contrasenia, evt, 20);
    }//GEN-LAST:event_txt_confContraseniaKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_inicio;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JToggleButton btn_verConfContrasenia;
    private javax.swing.JToggleButton btn_verContrasenia;
    private javax.swing.JComboBox<String> cmb_tipo;
    private javax.swing.JLabel lbl_apellido;
    private javax.swing.JLabel lbl_confContrasenia;
    private javax.swing.JLabel lbl_contrasenia;
    private javax.swing.JLabel lbl_correo;
    private javax.swing.JLabel lbl_fechaNac;
    private javax.swing.JLabel lbl_fondo;
    private javax.swing.JLabel lbl_inicio;
    private javax.swing.JLabel lbl_izquierda;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_pais;
    private javax.swing.JLabel lbl_tipo;
    private javax.swing.JLabel lbl_titulo;
    public javax.swing.JPanel pnl_registro;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JPasswordField txt_confContrasenia;
    private javax.swing.JPasswordField txt_contrasenia;
    private javax.swing.JTextField txt_correo;
    private com.toedter.calendar.JDateChooser txt_fecNac;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_pais;
    // End of variables declaration//GEN-END:variables
}
