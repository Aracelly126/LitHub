package Vista;

import Clases.Usuario;
import Utilidades.GestorPrograma;
import Utilidades.ManejoComp;

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
        lbl_MensajeBienvenida = new javax.swing.JLabel();
        pnlTb_Menu = new javax.swing.JTabbedPane();
        pnl_Perfil = new javax.swing.JPanel();
        lbl_MensajeSeccion1 = new javax.swing.JLabel();
        pnl_Libros = new javax.swing.JPanel();
        lbl_MensajeSeccion2 = new javax.swing.JLabel();
        pnl_Favoritos = new javax.swing.JPanel();
        lbl_MensajeSeccion3 = new javax.swing.JLabel();
        pnl_Prestamos = new javax.swing.JPanel();
        lbl_MensajeSeccion4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LibHub | Lector");
        setResizable(false);

        pnl_base.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_navBar.setBackground(new java.awt.Color(36, 35, 53));
        pnl_navBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_btnPerfil.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnPerfilMouseClicked(evt);
            }
        });
        pnl_navBar.add(lbl_btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 60, 50, 50));

        lbl_btnLibros.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_btnLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnLibrosMouseClicked(evt);
            }
        });
        pnl_navBar.add(lbl_btnLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 130, 50, 50));

        lbl_btnFavoritos.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnFavoritos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_btnFavoritos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnFavoritosMouseClicked(evt);
            }
        });
        pnl_navBar.add(lbl_btnFavoritos, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 200, 50, 50));

        lbl_btnPrestamos.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnPrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_btnPrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnPrestamosMouseClicked(evt);
            }
        });
        pnl_navBar.add(lbl_btnPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 270, 50, 50));

        lbl_btnCerrarSesion.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_navBar.add(lbl_btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 665, 50, 50));

        pnl_base.add(pnl_navBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 720));

        lbl_MensajeBienvenida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_MensajeBienvenida.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeBienvenida.setText("Iniciaste sesion como: LECTOR");
        pnl_base.add(lbl_MensajeBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        pnlTb_Menu.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        pnl_Perfil.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Perfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeSeccion1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_MensajeSeccion1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeSeccion1.setText("Seccion: Perfil");
        pnl_Perfil.add(lbl_MensajeSeccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, -1, -1));

        pnlTb_Menu.addTab("", pnl_Perfil);

        pnl_Libros.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Libros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeSeccion2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_MensajeSeccion2.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeSeccion2.setText("Seccion Libros");
        pnl_Libros.add(lbl_MensajeSeccion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, -1, -1));

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

        lbl_MensajeSeccion4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_MensajeSeccion4.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeSeccion4.setText("Seccion Prestamos");
        pnl_Prestamos.add(lbl_MensajeSeccion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, -1, -1));

        pnlTb_Menu.addTab("", pnl_Prestamos);

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
        this.pnlTb_Menu.setSelectedIndex(0);
    }//GEN-LAST:event_lbl_btnPerfilMouseClicked

    private void lbl_btnLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnLibrosMouseClicked
        this.pnlTb_Menu.setSelectedIndex(1);
    }//GEN-LAST:event_lbl_btnLibrosMouseClicked

    private void lbl_btnFavoritosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnFavoritosMouseClicked
        this.pnlTb_Menu.setSelectedIndex(2);
    }//GEN-LAST:event_lbl_btnFavoritosMouseClicked

    private void lbl_btnPrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnPrestamosMouseClicked
        this.pnlTb_Menu.setSelectedIndex(3);
    }//GEN-LAST:event_lbl_btnPrestamosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_MensajeBienvenida;
    private javax.swing.JLabel lbl_MensajeSeccion1;
    private javax.swing.JLabel lbl_MensajeSeccion2;
    private javax.swing.JLabel lbl_MensajeSeccion3;
    private javax.swing.JLabel lbl_MensajeSeccion4;
    public javax.swing.JLabel lbl_btnCerrarSesion;
    private javax.swing.JLabel lbl_btnFavoritos;
    private javax.swing.JLabel lbl_btnLibros;
    private javax.swing.JLabel lbl_btnPerfil;
    private javax.swing.JLabel lbl_btnPrestamos;
    private javax.swing.JTabbedPane pnlTb_Menu;
    private javax.swing.JPanel pnl_Favoritos;
    private javax.swing.JPanel pnl_Libros;
    private javax.swing.JPanel pnl_Perfil;
    private javax.swing.JPanel pnl_Prestamos;
    private javax.swing.JPanel pnl_base;
    private javax.swing.JPanel pnl_navBar;
    // End of variables declaration//GEN-END:variables
}
