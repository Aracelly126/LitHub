package Vista;

<<<<<<< HEAD
import Almacen.Almacen;
import Controles.ControlUsuarios;
import Controles.Control_Lector;
import java.awt.BorderLayout;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
=======
import BaseDatos.Almacen;
import BaseDatos.Conexion;
import Clases.Usuario;
import Utilidades.Controles;
import Utilidades.GestorPrograma;
import Utilidades.ManejoComp;
import java.awt.Color;
import javax.swing.JOptionPane;
>>>>>>> copiaSeguridad

/**
 *
 * @author thexe
 */
public class frmregistro extends javax.swing.JFrame {

    Almacen almaPermisos = new Almacen();
    Control_Lector contLector = new Control_Lector();

    public frmregistro() {

        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelUsuario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        label_nombre = new javax.swing.JLabel();
        textnombre = new javax.swing.JTextField();
        label_correo = new javax.swing.JLabel();
        textcorreo = new javax.swing.JTextField();
        label_contra = new javax.swing.JLabel();
        textcontra = new javax.swing.JPasswordField();
        label_confirmar = new javax.swing.JLabel();
        textconfirmar = new javax.swing.JPasswordField();
        btnregistrar = new javax.swing.JButton();
        label_direccion = new javax.swing.JLabel();
        textdireccion = new javax.swing.JTextField();
        label_telefono = new javax.swing.JLabel();
        texttelefono = new javax.swing.JTextField();
        label_inicio = new javax.swing.JLabel();
        label_autor = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        imagen = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelUsuario.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Registro de Usuario");

        label_nombre.setText("Nombre:");

        textnombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label_correo.setText("Correo:");

        textcorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label_contra.setText("Contraseña:");

        textcontra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textcontra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textcontraActionPerformed(evt);
            }
        });

        label_confirmar.setText("Confirmar contraseña:");

        textconfirmar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textconfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textconfirmarActionPerformed(evt);
            }
        });

        btnregistrar.setText("Registrarse");
        btnregistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });

        label_direccion.setText("Direccion:");

        textdireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label_telefono.setText("Telefono:");

        texttelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label_inicio.setText("Ya tienes una cuenta?");

        label_autor.setText("Eres autor?");

        jButton1.setForeground(new java.awt.Color(51, 0, 102));
        jButton1.setText("Registrarse como autor");
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setForeground(new java.awt.Color(51, 0, 102));
        jButton2.setText("iniciar sesion");
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelUsuarioLayout = new javax.swing.GroupLayout(PanelUsuario);
        PanelUsuario.setLayout(PanelUsuarioLayout);
        PanelUsuarioLayout.setHorizontalGroup(
            PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(label_nombre)
                .addGap(82, 82, 82)
                .addComponent(label_telefono))
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(textnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(texttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(label_correo))
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(textcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(label_direccion))
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(textdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(label_contra))
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(textcontra, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(label_confirmar))
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(textconfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(btnregistrar))
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(label_inicio)
                .addGap(5, 5, 5)
                .addComponent(jButton2))
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(label_autor)
                .addGap(4, 4, 4)
                .addComponent(jButton1))
        );
        PanelUsuarioLayout.setVerticalGroup(
            PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_nombre)
                    .addComponent(label_telefono))
                .addGap(4, 4, 4)
                .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(label_correo)
                .addGap(4, 4, 4)
                .addComponent(textcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(label_direccion)
                .addGap(4, 4, 4)
                .addComponent(textdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(label_contra)
                .addGap(4, 4, 4)
                .addComponent(textcontra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(label_confirmar)
                .addGap(4, 4, 4)
                .addComponent(textconfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnregistrar)
                .addGap(28, 28, 28)
                .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_inicio)
                    .addComponent(jButton2))
                .addGap(9, 9, 9)
                .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_autor)
                    .addComponent(jButton1)))
        );

        getContentPane().add(PanelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 510, 576));

        imagen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_registro_1.png"))); // NOI18N
        imagen.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 540));

        getContentPane().add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 540));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_login.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        contLector.registroLectores(this.textnombre.getText(), this.texttelefono.getText(), this.textcorreo.getText(), this.textdireccion.getText(), this.textcontra.getText());
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void textconfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textconfirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textconfirmarActionPerformed

    private void textcontraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textcontraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textcontraActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        frmLogin login = new frmLogin();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PanelAutor autor = new PanelAutor();
        autor.setSize(510, 650);
        autor.setLocation(0, 0);

        this.PanelUsuario.removeAll();
        this.PanelUsuario.add(autor, BorderLayout.CENTER);
        this.PanelUsuario.revalidate();
        this.PanelUsuario.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmregistro().setVisible(true);
            }
        });
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

<<<<<<< HEAD
=======
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

>>>>>>> copiaSeguridad
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel PanelUsuario;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_autor;
    private javax.swing.JLabel label_confirmar;
    private javax.swing.JLabel label_contra;
    private javax.swing.JLabel label_correo;
    private javax.swing.JLabel label_direccion;
    private javax.swing.JLabel label_inicio;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_telefono;
    private javax.swing.JPasswordField textconfirmar;
    private javax.swing.JPasswordField textcontra;
    private javax.swing.JTextField textcorreo;
    private javax.swing.JTextField textdireccion;
    private javax.swing.JTextField textnombre;
    private javax.swing.JTextField texttelefono;
    // End of variables declaration//GEN-END:variables
}
