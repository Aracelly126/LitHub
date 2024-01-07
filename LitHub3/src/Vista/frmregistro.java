package Vista;

import Utilidades.ManejoComp;

public class frmregistro extends javax.swing.JFrame {

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
        ManejoComp.crearlabel(this.lbl_izquierda, "imagenes/img_fondo2.png");
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lbl_izquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 590));

        pnl_registro.setBackground(new java.awt.Color(255, 255, 255));
        pnl_registro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_titulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(51, 51, 51));
        lbl_titulo.setText("Registro de Usuario");
        pnl_registro.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 240, 60));

        lbl_nombre.setText("Nombre:");
        pnl_registro.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        txt_nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        pnl_registro.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 120, 30));

        lbl_apellido.setText("Apellido");
        pnl_registro.add(lbl_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        txt_apellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyTyped(evt);
            }
        });
        pnl_registro.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 120, 30));

        lbl_fechaNac.setText("Fecha de Nacimiento");
        pnl_registro.add(lbl_fechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));
        pnl_registro.add(txt_fecNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 120, 30));

        lbl_tipo.setText("Tipo");
        pnl_registro.add(lbl_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        cmb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "LECTOR", "AUTOR" }));
        pnl_registro.add(cmb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 120, 30));

        lbl_pais.setText("País");
        pnl_registro.add(lbl_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        txt_pais.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnl_registro.add(txt_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 250, 30));

        lbl_correo.setText("Correo:");
        pnl_registro.add(lbl_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        txt_correo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnl_registro.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 250, 30));

        lbl_contrasenia.setText("Contraseña:");
        pnl_registro.add(lbl_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, -1, -1));

        txt_contrasenia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_contrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contraseniaActionPerformed(evt);
            }
        });
        pnl_registro.add(txt_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 250, 30));

        lbl_confContrasenia.setText("Confirmar contraseña:");
        pnl_registro.add(lbl_confContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, -1, -1));

        txt_confContrasenia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_confContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_confContraseniaActionPerformed(evt);
            }
        });
        pnl_registro.add(txt_confContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 250, 30));

        btn_registrar.setText("Registrarse");
        btn_registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });
        pnl_registro.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, -1, -1));

        lbl_inicio.setText("Ya tienes una cuenta?");
        pnl_registro.add(lbl_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, -1));

        btn_inicio.setForeground(new java.awt.Color(51, 0, 102));
        btn_inicio.setText("iniciar sesion");
        btn_inicio.setBorder(null);
        btn_inicio.setContentAreaFilled(false);
        btn_inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickIrIniciarSesion(evt);
            }
        });
        pnl_registro.add(btn_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, -1, -1));

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

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed

    }//GEN-LAST:event_btn_registrarActionPerformed

    private void txt_confContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_confContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_confContraseniaActionPerformed

    private void txt_contraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contraseniaActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) || this.txt_nombre.getText().trim().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void clickIrIniciarSesion(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickIrIniciarSesion
        // TODO add your handling code here:
    }//GEN-LAST:event_clickIrIniciarSesion

    private void txt_apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellidoKeyTyped

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
