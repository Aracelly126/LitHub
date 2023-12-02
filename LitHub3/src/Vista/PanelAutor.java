
package Vista;

import Controles.ControlAutores;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;


public class PanelAutor extends javax.swing.JPanel {

   ControlAutores contr = new ControlAutores();
    public PanelAutor() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        label_nombre = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        label_apellido = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        label_pais = new javax.swing.JLabel();
        comboPais = new javax.swing.JComboBox<>();
        label_provincia = new javax.swing.JLabel();
        comboProvincia = new javax.swing.JComboBox<>();
        label_fecha = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        label_obras = new javax.swing.JLabel();
        txtobras = new javax.swing.JTextField();
        label_correo = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        label_contra = new javax.swing.JLabel();
        txtcontra = new javax.swing.JPasswordField();
        label_confirmar = new javax.swing.JLabel();
        txtconfirmar = new javax.swing.JPasswordField();
        btnregistrar = new javax.swing.JButton();
        label_inicio = new javax.swing.JLabel();
        btniniciarsesion = new javax.swing.JButton();
        label_autor = new javax.swing.JLabel();
        btnregistroautor = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Registro de Autores");

        label_nombre.setText("Nombre:");

        label_apellido.setText("Apellido:");

        label_pais.setText("País:");

        comboPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ecuador", "Peru", "Mexico", "Bolivia", "Argentina" }));
        comboPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPaisActionPerformed(evt);
            }
        });

        label_provincia.setText("Provincia:");

        comboProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tungurahua", "El Oro", "Guayas", " " }));

        label_fecha.setText("Fecha nacimiento:");

        label_obras.setText("Número de Obras");

        label_correo.setText("Correo:");

        label_contra.setText("Contraseña:");

        label_confirmar.setText("Confirmar contraseña:");

        btnregistrar.setText("Registrar");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });

        label_inicio.setText("Ya tienes una cuenta?");

        btniniciarsesion.setForeground(new java.awt.Color(51, 0, 102));
        btniniciarsesion.setText("iniciar sesion");
        btniniciarsesion.setBorder(null);
        btniniciarsesion.setContentAreaFilled(false);
        btniniciarsesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btniniciarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniniciarsesionActionPerformed(evt);
            }
        });

        label_autor.setText("No eres autor?");

        btnregistroautor.setForeground(new java.awt.Color(51, 0, 102));
        btnregistroautor.setText("Registrarse como usuario");
        btnregistroautor.setBorder(null);
        btnregistroautor.setContentAreaFilled(false);
        btnregistroautor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnregistroautor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistroautorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(label_nombre)
                        .addGap(102, 102, 102)
                        .addComponent(label_apellido))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(label_pais)
                        .addGap(122, 122, 122)
                        .addComponent(label_provincia))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(comboPais, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(comboProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(label_fecha)
                        .addGap(47, 47, 47)
                        .addComponent(label_obras))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtobras, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(label_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(label_contra))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(txtcontra, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(label_confirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(txtconfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(btnregistrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(label_inicio)
                        .addGap(5, 5, 5)
                        .addComponent(btniniciarsesion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(label_autor)
                        .addGap(6, 6, 6)
                        .addComponent(btnregistroautor)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_nombre)
                    .addComponent(label_apellido))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_pais)
                    .addComponent(label_provincia))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboPais, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_fecha)
                    .addComponent(label_obras))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtobras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(label_correo)
                .addGap(4, 4, 4)
                .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(label_contra)
                .addGap(4, 4, 4)
                .addComponent(txtcontra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(label_confirmar)
                .addGap(4, 4, 4)
                .addComponent(txtconfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnregistrar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_inicio)
                    .addComponent(btniniciarsesion))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_autor)
                    .addComponent(btnregistroautor)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btniniciarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniniciarsesionActionPerformed
        // TODO add your handling code here:
        frmLector registro = new frmLector();
        frmLogin login = new frmLogin();
        login.setVisible(true);
        this.setVisible(false);
        registro.dispose();
    }//GEN-LAST:event_btniniciarsesionActionPerformed

    private void btnregistroautorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistroautorActionPerformed
        // TODO add your handling code here:
        frmLector registro = new frmLector();
        registro.PanelUsuario.setSize(510,540);
        registro.PanelUsuario.setLocation(0,0);
        
        this.removeAll();
        this.add(registro.PanelUsuario,BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
        
    }//GEN-LAST:event_btnregistroautorActionPerformed

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        boolean aux;
        aux=contr.registroAutores(this.txtnombre.getText(), 
                this.txtapellido
                .getText(),this.comboPais.getSelectedItem().toString(), this.txtfecha.getText(),Integer.parseInt(this.txtobras.getText()),this.txtcorreo.getText(), this.txtcontra.getText());
        if (aux) {
            JOptionPane.showMessageDialog(null, "Autor registrado con éxito"+aux);
             this.txtnombre.setText("");
             this.txtapellido.setText("");
            this.txtcontra.setText("");
            this.txtconfirmar.setText("");
            this.txtcorreo.setText("");
            this.txtfecha.setText("");
            this.txtobras.setText("");
        }
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void comboPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPaisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btniniciarsesion;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton btnregistroautor;
    public javax.swing.JComboBox<String> comboPais;
    private javax.swing.JComboBox<String> comboProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_apellido;
    private javax.swing.JLabel label_autor;
    private javax.swing.JLabel label_confirmar;
    private javax.swing.JLabel label_contra;
    private javax.swing.JLabel label_correo;
    private javax.swing.JLabel label_fecha;
    private javax.swing.JLabel label_inicio;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_obras;
    private javax.swing.JLabel label_pais;
    private javax.swing.JLabel label_provincia;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JPasswordField txtconfirmar;
    private javax.swing.JPasswordField txtcontra;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtobras;
    // End of variables declaration//GEN-END:variables
}
