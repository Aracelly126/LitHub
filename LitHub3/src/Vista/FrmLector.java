package Vista;

import Clases.Usuario;
import Utilidades.GestorPrograma;
import Utilidades.InfoLibros;
import Utilidades.ManejoComp;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;

public class FrmLector extends javax.swing.JFrame {

    private Usuario SesionActual = new Usuario();

    public FrmLector() {
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
            java.util.logging.Logger.getLogger(FrmLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        this.setLocationRelativeTo(null);

        ManejoComp.crearlabel(this.lbl_btnPerfil, "SYSTEM/src/ico_usuario.png");
        ManejoComp.crearlabel(this.lbl_btnLibros, "SYSTEM/src/ico_libro.png");
        ManejoComp.crearlabel(this.lbl_btnFavoritos, "SYSTEM/src/ico_favoritos.png");
        ManejoComp.crearlabel(this.lbl_btnPrestamos, "SYSTEM/src/ico_prestamo.png");
        ManejoComp.crearlabel(this.lbl_btnCerrarSesion, "SYSTEM/src/ico_cerrarsesion.png");
    }

    public void iniciarVentana(String correoUser) {
        this.SesionActual = GestorPrograma.buscarUsuario(correoUser);
        System.out.println("Bienvenido: " + this.SesionActual.getNombre());

        this.setVisible(true);
    }

    public void cerrarSesion() {
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_base = new javax.swing.JPanel();
        pnl_navBar = new javax.swing.JPanel();
        lbl_btnPerfil = new javax.swing.JLabel();
        lbl_btnLibros = new javax.swing.JLabel();
        lbl_btnFavoritos = new javax.swing.JLabel();
        lbl_btnPrestamos = new javax.swing.JLabel();
        lbl_btnCerrarSesion = new javax.swing.JLabel();
        pnlTb_Menu = new javax.swing.JTabbedPane();
        pnl_Libros = new javax.swing.JPanel();
        pnl_Favoritos = new javax.swing.JPanel();
        lbl_MensajeSeccion3 = new javax.swing.JLabel();
        pnl_Prestamos = new javax.swing.JPanel();
        PanelImg = new javax.swing.JPanel();
        lbNombreLibro = new javax.swing.JLabel();
        lbAutorLibro = new javax.swing.JLabel();
        mostrarAutor = new javax.swing.JLabel();
        lbGenero = new javax.swing.JLabel();
        mostrarGenero = new javax.swing.JLabel();
        lbNumPaginas = new javax.swing.JLabel();
        mostrarNumPaginas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        pnl_Perfil = new javax.swing.JPanel();
        lbl_MensajeSeccion1 = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbApellido = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        lbCorreo = new javax.swing.JLabel();
        lbPais = new javax.swing.JLabel();
        lbFechaNacimiento = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LibHub | Lector");
        setPreferredSize(new java.awt.Dimension(1000, 6500));
        setResizable(false);

        pnl_base.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_navBar.setBackground(new java.awt.Color(36, 35, 53));
        pnl_navBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_btnPerfil.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnPerfilMouseClicked(evt);
            }
        });
        pnl_navBar.add(lbl_btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 60, 50, 50));

        lbl_btnLibros.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_btnLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnLibrosMouseClicked(evt);
            }
        });
        pnl_navBar.add(lbl_btnLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 130, 50, 50));

        lbl_btnFavoritos.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnFavoritos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_btnFavoritos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnFavoritosMouseClicked(evt);
            }
        });
        pnl_navBar.add(lbl_btnFavoritos, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 200, 50, 50));

        lbl_btnPrestamos.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnPrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_btnPrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnPrestamosMouseClicked(evt);
            }
        });
        pnl_navBar.add(lbl_btnPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 270, 50, 50));

        lbl_btnCerrarSesion.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl_navBar.add(lbl_btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 665, 50, 50));

        pnl_base.add(pnl_navBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 720));

        pnlTb_Menu.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        pnl_Libros.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Libros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlTb_Menu.addTab("", pnl_Libros);

        pnl_Favoritos.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Favoritos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeSeccion3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_MensajeSeccion3.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeSeccion3.setText("Seccion Favoritos");
        pnl_Favoritos.add(lbl_MensajeSeccion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, -1, -1));

        pnlTb_Menu.addTab("", pnl_Favoritos);

        pnl_Prestamos.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Prestamos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout PanelImgLayout = new javax.swing.GroupLayout(PanelImg);
        PanelImg.setLayout(PanelImgLayout);
        PanelImgLayout.setHorizontalGroup(
            PanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        PanelImgLayout.setVerticalGroup(
            PanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        pnl_Prestamos.add(PanelImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 130, 170));

        lbNombreLibro.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbNombreLibro.setText("NOMBRE");
        pnl_Prestamos.add(lbNombreLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        lbAutorLibro.setText("Autor:");
        pnl_Prestamos.add(lbAutorLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        mostrarAutor.setText("jLabel3");
        pnl_Prestamos.add(mostrarAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));

        lbGenero.setText("Genero:");
        pnl_Prestamos.add(lbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        mostrarGenero.setText("jLabel6");
        pnl_Prestamos.add(mostrarGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        lbNumPaginas.setText("Numero de Paginas:");
        pnl_Prestamos.add(lbNumPaginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        mostrarNumPaginas.setText("jLabel8");
        pnl_Prestamos.add(mostrarNumPaginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, -1, -1));

        jLabel1.setText("Sinopsis:");
        pnl_Prestamos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        pnl_Prestamos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 400, 110));

        pnlTb_Menu.addTab("", pnl_Prestamos);

        pnl_Perfil.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Perfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeSeccion1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_MensajeSeccion1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeSeccion1.setText("Seccion: Perfil");
        pnl_Perfil.add(lbl_MensajeSeccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        lbNombre.setText("Nombre:");
        pnl_Perfil.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        lbApellido.setText("Apellido:");
        pnl_Perfil.add(lbApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        txtNombre1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNombre1.setEnabled(false);
        pnl_Perfil.add(txtNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 95, 120, 25));

        lbCorreo.setText("Correo:");
        pnl_Perfil.add(lbCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        lbPais.setText("Pais:");
        pnl_Perfil.add(lbPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        lbFechaNacimiento.setText("Fecha de Nacimiento:");
        pnl_Perfil.add(lbFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        txtPais.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPais.setEnabled(false);
        pnl_Perfil.add(txtPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 215, 120, 25));

        txtCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCorreo.setEnabled(false);
        pnl_Perfil.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 177, 170, 25));

        txtApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtApellido.setEnabled(false);
        pnl_Perfil.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 137, 120, 25));

        txtFechaNacimiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFechaNacimiento.setEnabled(false);
        pnl_Perfil.add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 255, 120, 25));
        pnl_Perfil.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 670, 200));

        jLabel5.setText("Libros Prestados:");
        pnl_Perfil.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, -1, -1));

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnl_Perfil.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 76, -1));

        jButton2.setText("Guardar");
        pnl_Perfil.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, -1, -1));

        pnlTb_Menu.addTab("", pnl_Perfil);

        pnl_base.add(pnlTb_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 1250, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnPerfilMouseClicked
        this.pnlTb_Menu.setSelectedIndex(3);
    }//GEN-LAST:event_lbl_btnPerfilMouseClicked

    private void lbl_btnLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnLibrosMouseClicked
        this.pnlTb_Menu.setSelectedIndex(0);
        InfoLibros inf = new InfoLibros();
        JPanel panelLibros = new JPanel();
        panelLibros.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        inf.mostrarLibros(panelLibros,PanelImg,lbNombreLibro, mostrarAutor, mostrarGenero, mostrarNumPaginas, pnlTb_Menu);
        
        this.pnl_Libros.setLayout(new BorderLayout());
        this.pnl_Libros.add(panelLibros, BorderLayout.CENTER);
        
        this.pnl_Libros.revalidate();
        this.pnl_Libros.repaint();
    }//GEN-LAST:event_lbl_btnLibrosMouseClicked

    private void lbl_btnFavoritosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnFavoritosMouseClicked
        this.pnlTb_Menu.setSelectedIndex(1);
    }//GEN-LAST:event_lbl_btnFavoritosMouseClicked

    private void lbl_btnPrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnPrestamosMouseClicked
        //this.pnlTb_Menu.setSelectedIndex(2);
    }//GEN-LAST:event_lbl_btnPrestamosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelImg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbAutorLibro;
    private javax.swing.JLabel lbCorreo;
    private javax.swing.JLabel lbFechaNacimiento;
    private javax.swing.JLabel lbGenero;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNombreLibro;
    private javax.swing.JLabel lbNumPaginas;
    private javax.swing.JLabel lbPais;
    private javax.swing.JLabel lbl_MensajeSeccion1;
    private javax.swing.JLabel lbl_MensajeSeccion3;
    public javax.swing.JLabel lbl_btnCerrarSesion;
    private javax.swing.JLabel lbl_btnFavoritos;
    private javax.swing.JLabel lbl_btnLibros;
    private javax.swing.JLabel lbl_btnPerfil;
    private javax.swing.JLabel lbl_btnPrestamos;
    private javax.swing.JLabel mostrarAutor;
    private javax.swing.JLabel mostrarGenero;
    private javax.swing.JLabel mostrarNumPaginas;
    private javax.swing.JTabbedPane pnlTb_Menu;
    private javax.swing.JPanel pnl_Favoritos;
    private javax.swing.JPanel pnl_Libros;
    private javax.swing.JPanel pnl_Perfil;
    private javax.swing.JPanel pnl_Prestamos;
    private javax.swing.JPanel pnl_base;
    private javax.swing.JPanel pnl_navBar;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtPais;
    // End of variables declaration//GEN-END:variables
}
