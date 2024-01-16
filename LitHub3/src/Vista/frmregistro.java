package Vista;

import BaseDatos.Almacen;
import BaseDatos.Conexion;
import Clases.Usuario;
import Utilidades.Controles;
import Utilidades.GestorPrograma;
import Utilidades.ManejoComp;
import java.awt.Color;
import javax.swing.JOptionPane;

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
    
    public void limpiarPanel(){
        this.txt_nombre.setText("");
        this.txt_apellido.setText("");
        this.cmb_tipo.setSelectedIndex(0);
        this.txt_pais.setText("");
        this.txt_correo.setText("");
        this.txt_contrasenia.setText("");
        this.txt_confContrasenia.setText("");
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

        lbl_titulo.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(51, 51, 51));
        lbl_titulo.setText("Registro de Usuario");
        pnl_registro.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 220, 40));

        lbl_nombre.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_nombre.setForeground(new java.awt.Color(0, 0, 0));
        lbl_nombre.setText("Nombre:");
        pnl_registro.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 90, -1));

        txt_nombre.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        pnl_registro.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 130, 40));

        lbl_apellido.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_apellido.setForeground(new java.awt.Color(0, 0, 0));
        lbl_apellido.setText("Apellido");
        pnl_registro.add(lbl_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 90, -1));

        txt_apellido.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_apellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyTyped(evt);
            }
        });
        pnl_registro.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 150, 40));

        lbl_fechaNac.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_fechaNac.setForeground(new java.awt.Color(0, 0, 0));
        lbl_fechaNac.setText("Fecha de Nac");
        pnl_registro.add(lbl_fechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 120, -1));

        txt_fecNac.setMaxSelectableDate(new java.util.Date(1262235600000L));
        pnl_registro.add(txt_fecNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 130, 40));

        lbl_tipo.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_tipo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_tipo.setText("Tipo");
        pnl_registro.add(lbl_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 60, -1));

        cmb_tipo.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        cmb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "LECTOR", "AUTOR" }));
        pnl_registro.add(cmb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 150, 40));

        lbl_pais.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_pais.setForeground(new java.awt.Color(0, 0, 0));
        lbl_pais.setText("País");
        pnl_registro.add(lbl_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 60, -1));

        txt_pais.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_pais.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_pais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_paisKeyTyped(evt);
            }
        });
        pnl_registro.add(txt_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 290, 40));

        lbl_correo.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_correo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_correo.setText("Correo:");
        pnl_registro.add(lbl_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 90, -1));

        txt_correo.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_correo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_correoKeyTyped(evt);
            }
        });
        pnl_registro.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 290, 40));

        lbl_contrasenia.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_contrasenia.setForeground(new java.awt.Color(0, 0, 0));
        lbl_contrasenia.setText("Contraseña:");
        pnl_registro.add(lbl_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 120, -1));

        txt_contrasenia.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_contrasenia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_contrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contraseniaKeyTyped(evt);
            }
        });
        pnl_registro.add(txt_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 290, 40));

        lbl_confContrasenia.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_confContrasenia.setForeground(new java.awt.Color(0, 0, 0));
        lbl_confContrasenia.setText("Confirmar contraseña:");
        pnl_registro.add(lbl_confContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 210, -1));

        txt_confContrasenia.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_confContrasenia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_confContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_confContraseniaKeyTyped(evt);
            }
        });
        pnl_registro.add(txt_confContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 290, 40));

        btn_registrar.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_registrar.setText("Registrarse");
        btn_registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_registrarMouseClicked(evt);
            }
        });
        pnl_registro.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 540, 150, 35));

        lbl_inicio.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbl_inicio.setForeground(new java.awt.Color(0, 0, 0));
        lbl_inicio.setText("Ya tienes una cuenta?");
        pnl_registro.add(lbl_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        btn_inicio.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btn_inicio.setForeground(new java.awt.Color(51, 0, 102));
        btn_inicio.setText("iniciar sesion");
        btn_inicio.setBorder(null);
        btn_inicio.setContentAreaFilled(false);
        btn_inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inicioActionPerformed(evt);
            }
        });
        pnl_registro.add(btn_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, -1, -1));

        btn_verConfContrasenia.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btn_verConfContrasenia.setText("Ver");
        btn_verConfContrasenia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl_registro.add(btn_verConfContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, 60, 20));

        btn_verContrasenia.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btn_verContrasenia.setText("Ver");
        btn_verContrasenia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl_registro.add(btn_verContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 60, 20));

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
        GestorPrograma.agregarNuevoUsuario( correo, nombre, apellido, fecNac, tipo, pais, contrasenia1);
        this.con.desconectar();
        JOptionPane.showMessageDialog(this, "Nuevo " + this.cmb_tipo.getSelectedItem().toString() + " creado. . .");
        this.limpiarPanel();
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
        ManejoComp.txtLongitudCondicion(this.txt_pais, evt, 20);
        ManejoComp.txtOnlyLetters(evt);
    }//GEN-LAST:event_txt_paisKeyTyped

    private void txt_correoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_correoKeyTyped
        ManejoComp.txtLongitudCondicion(this.txt_correo, evt, 30);
    }//GEN-LAST:event_txt_correoKeyTyped

    private void txt_contraseniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contraseniaKeyTyped
        ManejoComp.txtLongitudCondicion(this.txt_contrasenia, evt, 15);
    }//GEN-LAST:event_txt_contraseniaKeyTyped

    private void txt_confContraseniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_confContraseniaKeyTyped
        ManejoComp.txtLongitudCondicion(this.txt_contrasenia, evt, 15);
    }//GEN-LAST:event_txt_confContraseniaKeyTyped

    private void btn_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_inicioActionPerformed

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
