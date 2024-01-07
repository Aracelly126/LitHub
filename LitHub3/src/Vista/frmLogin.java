package Vista;

import BaseDatos.Almacen;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class frmLogin extends javax.swing.JFrame {

    public frmLogin() {
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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        complemento = new javax.swing.JPanel();
        imagen_complemento = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btIniciarSesion = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        txtMensaje = new javax.swing.JLabel();
        label_usuario = new javax.swing.JLabel();
        label_contraseña = new javax.swing.JLabel();
        label_registro = new javax.swing.JLabel();
        btnregistro = new javax.swing.JButton();
        label_autor = new javax.swing.JLabel();
        btnregistroautor = new javax.swing.JButton();
        lblMensajeErroresLogin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagen_complemento.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Desktop\\estructura clases\\LitHub\\LitHub3\\src\\imagenes\\complemento.png")); // NOI18N

        javax.swing.GroupLayout complementoLayout = new javax.swing.GroupLayout(complemento);
        complemento.setLayout(complementoLayout);
        complementoLayout.setHorizontalGroup(
            complementoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complementoLayout.createSequentialGroup()
                .addComponent(imagen_complemento, javax.swing.GroupLayout.PREFERRED_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );
        complementoLayout.setVerticalGroup(
            complementoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complementoLayout.createSequentialGroup()
                .addComponent(imagen_complemento, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(complemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 540));

        loginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Desktop\\estructura clases\\LitHub\\LitHub3\\src\\imagenes\\Sin título-1.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        loginPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 40, -1, -1));

        btIniciarSesion.setText("iniciar Sesion");
        btIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarSesionActionPerformed(evt);
            }
        });
        loginPanel.add(btIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        txtUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        loginPanel.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 190, 30));

        txtContraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyTyped(evt);
            }
        });
        loginPanel.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 190, 30));
        loginPanel.add(txtMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 220, 30));

        label_usuario.setText("Usuario:");
        loginPanel.add(label_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        label_contraseña.setText("Contraseña:");
        loginPanel.add(label_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        label_registro.setText("No tienes una cuenta?");
        loginPanel.add(label_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        btnregistro.setForeground(new java.awt.Color(51, 0, 102));
        btnregistro.setText("Registrarse");
        btnregistro.setBorder(null);
        btnregistro.setContentAreaFilled(false);
        btnregistro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistroActionPerformed(evt);
            }
        });
        loginPanel.add(btnregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, -1, -1));

        label_autor.setText("Eres autor?");
        loginPanel.add(label_autor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 505, -1, -1));

        btnregistroautor.setForeground(new java.awt.Color(51, 0, 102));
        btnregistroautor.setText("Registrarse como autor");
        btnregistroautor.setBorder(null);
        btnregistroautor.setContentAreaFilled(false);
        btnregistroautor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loginPanel.add(btnregistroautor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 505, -1, -1));

<<<<<<< HEAD
        lblMensajeErroresLogin.setForeground(new java.awt.Color(255, 0, 0));
        lblMensajeErroresLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_login.jpg"))); // NOI18N
        loginPanel.add(lblMensajeErroresLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 540));

        jLabel3.setText("jLabel3");
        loginPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 190, 30));
=======
        panelLogin.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Desktop\\estructura clases\\LitHub\\LitHub3\\src\\imagenes\\fondo_login.jpg")); // NOI18N
        loginPanel.add(panelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 540));
>>>>>>> main

        getContentPane().add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 380, 540));

        fondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Desktop\\estructura clases\\LitHub\\LitHub3\\src\\imagenes\\fondo_login.jpg")); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarSesionActionPerformed
//        // TODO add your handling code here:
//        try {
//            boolean aux2 = conec.conectar();
//            if (aux2 == true) {
//                btIniciarSesion.setEnabled(true);
//                if (txtContraseña.getText().isEmpty() || txtUsuario.getText().isEmpty()) {
//                    txtMensaje.setText("Ingrese la contraseña o el usuario");
//                } else {
//                    boolean aux = cntUsuarios.loginUsuarioYClave(this.txtUsuario.getText(), this.txtContraseña.getText(), almaPermisos, txtContraseña, txtUsuario, txtMensaje);
//                    if ((aux == true)) {
//                        txtMensaje.setText("Contraseña correcta");
//                        JOptionPane.showMessageDialog(null, "¡Bienvenido, " + this.txtUsuario.getText() + "!");
//                        this.dispose();
//                        frmInicio inicio = new frmInicio();
//                        inicio.setVisible(true);
//                    }
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "¡Comprueba tu conexion y vuelva a ingresar a la aplicación");
//                btIniciarSesion.setEnabled(false);
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("linea botton" + ex);
//            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btIniciarSesionActionPerformed

    private void btnregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistroActionPerformed
        // TODO add your handling code here:
        frmregistro registro = new frmregistro();
        registro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnregistroActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) || this.txtUsuario.getText().trim().length() >= 10) {
            evt.consume();
        }
        this.lblMensajeErroresLogin.setText("");
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyTyped
        this.lblMensajeErroresLogin.setText("");
    }//GEN-LAST:event_txtContraseñaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIniciarSesion;
    private javax.swing.JButton btnregistro;
    private javax.swing.JButton btnregistroautor;
    private javax.swing.JPanel complemento;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel imagen_complemento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label_autor;
    private javax.swing.JLabel label_contraseña;
    private javax.swing.JLabel label_registro;
    private javax.swing.JLabel label_usuario;
    private javax.swing.JLabel lblMensajeErroresLogin;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JLabel txtMensaje;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
