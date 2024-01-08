package Vista;

import BaseDatos.Almacen;
import BaseDatos.GestorBD;
import Clases.*;
import Utilidades.Controles;
import Utilidades.GestorPrograma;
import Utilidades.ManejoComp;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FrmAdmin extends javax.swing.JFrame {

    private Usuario usuarioActual = new Usuario();
    private GestorBD gestorBD = new GestorBD();

    private String[] tblLibrosTitulos = {"CODIGO", "AUTOR", "NOMBRE", "GENERO", "NUMERO PAGS"};
    private DefaultTableModel modelTblLibros = new DefaultTableModel(tblLibrosTitulos, 0);
    private String urlPortada = "";
    private String urlPdf = "";

    public FrmAdmin() {
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
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        this.setLocationRelativeTo(null);

        ManejoComp.crearlabel(lbl_btnLibros, "SYSTEM/src/ico_libro.png");
        ManejoComp.crearlabel(lbl_btnUsuarios, "SYSTEM/src/ico_usuario.png");
        ManejoComp.crearlabel(lbl_btnCerrarSesion, "SYSTEM/src/ico_cerrarsesion.png");

        //<editor-fold defaultstate="collapsed" desc="DISEÑO PESTANIA LIBROS">      
        this.tbl_libros.getColumnModel().getColumn(0).setPreferredWidth(1);
        this.tbl_libros.getColumnModel().getColumn(0).setResizable(false);
        this.tbl_libros.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.tbl_libros.getColumnModel().getColumn(1).setResizable(false);
        this.tbl_libros.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.tbl_libros.getColumnModel().getColumn(2).setResizable(false);
        this.tbl_libros.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.tbl_libros.getColumnModel().getColumn(3).setResizable(false);
        this.tbl_libros.getColumnModel().getColumn(4).setPreferredWidth(1);
        this.tbl_libros.getColumnModel().getColumn(4).setResizable(false);
        DefaultTableCellRenderer cellRenderer1 = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                        row, column);
                // Establecer el alto personalizado para todas las filas
                table.setRowHeight(row, 25); // 50 es el alto deseado en píxeles
                return component;
            }
        };
        // Asignar el renderizador de celdas personalizado a todas las columnas
        for (int i = 0; i < this.tbl_libros.getColumnCount(); i++) {
            this.tbl_libros.getColumnModel().getColumn(i).setCellRenderer(cellRenderer1);
        }
        //</editor-fold>
    }

    public void iniciarVentana(String nombreUser) {
        this.usuarioActual = GestorPrograma.buscarUsuario(nombreUser);

        llenarTablaLibros();

        this.setVisible(true);
    }

    public void cerrarSesion() {
        this.dispose();
    }

    public void llenarTablaLibros() {
        ManejoComp.vaciarTabla(this.tbl_libros, this.modelTblLibros);
        for (Libro libro : Almacen.getInstance().libros) {
            String[] registro = {
                libro.getCodigo(),
                libro.getAutor(),
                libro.getNombre(),
                libro.getGenero(),
                String.valueOf(libro.getNumPag())
            };
            this.modelTblLibros.addRow(registro);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_base = new javax.swing.JPanel();
        pnl_navBar = new javax.swing.JPanel();
        lbl_btnLibros = new javax.swing.JLabel();
        lbl_btnUsuarios = new javax.swing.JLabel();
        lbl_btnCerrarSesion = new javax.swing.JLabel();
        lbl_MensajeBienvenida = new javax.swing.JLabel();
        pnlTb_Menu = new javax.swing.JTabbedPane();
        pnl_Libros = new javax.swing.JPanel();
        lbl_MensajeSeccion1 = new javax.swing.JLabel();
        lbl_libPortada = new javax.swing.JLabel();
        btn_libAgregarPortada = new javax.swing.JButton();
        btn_libAgregarPdf = new javax.swing.JButton();
        lbl_libCodigo = new javax.swing.JLabel();
        txt_libCodigo = new javax.swing.JTextField();
        lbl_libAutor = new javax.swing.JLabel();
        txt_libAutor = new javax.swing.JTextField();
        lbl_libNombre = new javax.swing.JLabel();
        txt_libNombre = new javax.swing.JTextField();
        lbl_libGenero = new javax.swing.JLabel();
        txt_libGenero = new javax.swing.JTextField();
        lbl_libNumPags = new javax.swing.JLabel();
        txt_libNumPags = new javax.swing.JTextField();
        btn_libGuardar = new javax.swing.JButton();
        btn_libActualizar = new javax.swing.JButton();
        btn_libEliminar = new javax.swing.JButton();
        btn_libLimpiar = new javax.swing.JButton();
        lbl_nombreArchivoPdf = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_libros = new javax.swing.JTable();
        btn_libNuevoCodigo = new javax.swing.JButton();
        pnl_Usuarios = new javax.swing.JPanel();
        lbl_MensajeSeccion2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LibHub | Administrador");
        setResizable(false);
        setSize(new java.awt.Dimension(890, 600));

        pnl_base.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_navBar.setBackground(new java.awt.Color(36, 35, 53));
        pnl_navBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_btnLibros.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_btnLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnLibrosMouseClicked(evt);
            }
        });
        pnl_navBar.add(lbl_btnLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 60, 50, 50));

        lbl_btnUsuarios.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnUsuariosMouseClicked(evt);
            }
        });
        pnl_navBar.add(lbl_btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 130, 50, 50));

        lbl_btnCerrarSesion.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_navBar.add(lbl_btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 590, 50, 50));

        pnl_base.add(pnl_navBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 650));

        lbl_MensajeBienvenida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_MensajeBienvenida.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeBienvenida.setText("Iniciaste sesion como: ADMINISTRADOR");
        pnl_base.add(lbl_MensajeBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        pnlTb_Menu.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        pnl_Libros.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Libros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeSeccion1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_MensajeSeccion1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeSeccion1.setText("Seccion Libros");
        pnl_Libros.add(lbl_MensajeSeccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, -1, -1));

        lbl_libPortada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_Libros.add(lbl_libPortada, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 170, 210));

        btn_libAgregarPortada.setText("Agregar portada");
        btn_libAgregarPortada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_libAgregarPortadaMouseClicked(evt);
            }
        });
        pnl_Libros.add(btn_libAgregarPortada, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 170, 30));

        btn_libAgregarPdf.setText("Agregar pdf");
        btn_libAgregarPdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_libAgregarPdfMouseClicked(evt);
            }
        });
        pnl_Libros.add(btn_libAgregarPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 170, 30));

        lbl_libCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_libCodigo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_libCodigo.setText("Codigo:");
        pnl_Libros.add(lbl_libCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 100, 30));

        txt_libCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_libCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_libCodigoKeyTyped(evt);
            }
        });
        pnl_Libros.add(txt_libCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 200, 30));

        lbl_libAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_libAutor.setForeground(new java.awt.Color(0, 0, 0));
        lbl_libAutor.setText("Autor:");
        pnl_Libros.add(lbl_libAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 100, 30));

        txt_libAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnl_Libros.add(txt_libAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 200, 30));

        lbl_libNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_libNombre.setForeground(new java.awt.Color(0, 0, 0));
        lbl_libNombre.setText("Nombre:");
        pnl_Libros.add(lbl_libNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 100, 30));

        txt_libNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnl_Libros.add(txt_libNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 200, 30));

        lbl_libGenero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_libGenero.setForeground(new java.awt.Color(0, 0, 0));
        lbl_libGenero.setText("Genero:");
        pnl_Libros.add(lbl_libGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 100, 30));

        txt_libGenero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnl_Libros.add(txt_libGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 200, 30));

        lbl_libNumPags.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_libNumPags.setForeground(new java.awt.Color(0, 0, 0));
        lbl_libNumPags.setText("Num paginas:");
        pnl_Libros.add(lbl_libNumPags, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 100, 30));

        txt_libNumPags.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnl_Libros.add(txt_libNumPags, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 200, 30));

        btn_libGuardar.setText("Guardar");
        btn_libGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_libGuardarMouseClicked(evt);
            }
        });
        pnl_Libros.add(btn_libGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 100, -1));

        btn_libActualizar.setText("Actualizar");
        btn_libActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_libActualizarMouseClicked(evt);
            }
        });
        pnl_Libros.add(btn_libActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 100, -1));

        btn_libEliminar.setText("Eliminar");
        btn_libEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_libEliminarMouseClicked(evt);
            }
        });
        pnl_Libros.add(btn_libEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 100, -1));

        btn_libLimpiar.setText("Limpiar");
        btn_libLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_libLimpiarMouseClicked(evt);
            }
        });
        pnl_Libros.add(btn_libLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 100, -1));
        pnl_Libros.add(lbl_nombreArchivoPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 200, 30));

        tbl_libros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_libros.setModel(this.modelTblLibros);
        tbl_libros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_librosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_libros);

        pnl_Libros.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 890, 270));

        btn_libNuevoCodigo.setText("Nuevo");
        btn_libNuevoCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_libNuevoCodigoMouseClicked(evt);
            }
        });
        pnl_Libros.add(btn_libNuevoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 70, 30));

        pnlTb_Menu.addTab("", pnl_Libros);

        pnl_Usuarios.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Usuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeSeccion2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_MensajeSeccion2.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeSeccion2.setText("Seccion Usuarios");
        pnl_Usuarios.add(lbl_MensajeSeccion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, -1, -1));

        pnlTb_Menu.addTab("", pnl_Usuarios);

        pnl_base.add(pnlTb_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 970, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_base, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_btnLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnLibrosMouseClicked
        this.pnlTb_Menu.setSelectedIndex(0);
    }//GEN-LAST:event_lbl_btnLibrosMouseClicked

    private void lbl_btnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnUsuariosMouseClicked
        this.pnlTb_Menu.setSelectedIndex(1);
    }//GEN-LAST:event_lbl_btnUsuariosMouseClicked

    private void tbl_librosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_librosMouseClicked
        int index = this.tbl_libros.getSelectedRow();
        ManejoComp.crearlabel(this.lbl_libPortada, "SYSTEM/libros/"+Almacen.getInstance().libros.get(index).getCodigo() + ".png");
    }//GEN-LAST:event_tbl_librosMouseClicked

    private void btn_libAgregarPortadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_libAgregarPortadaMouseClicked
        this.urlPortada = GestorPrograma.seleccionarImagen();
    }//GEN-LAST:event_btn_libAgregarPortadaMouseClicked

    private void btn_libAgregarPdfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_libAgregarPdfMouseClicked
        this.urlPdf = GestorPrograma.seleccionarPDF();
    }//GEN-LAST:event_btn_libAgregarPdfMouseClicked

    private void btn_libGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_libGuardarMouseClicked
        if (!this.btn_libGuardar.isEnabled()) {
            return;
        }
        if (Controles.cadenaVacia(this.txt_libCodigo.getText())
                || Controles.cadenaVacia(this.txt_libAutor.getText())
                || Controles.cadenaVacia(this.txt_libNombre.getText())
                || Controles.cadenaVacia(this.txt_libGenero.getText())
                || Controles.cadenaVacia(this.txt_libNumPags.getText())) {
            JOptionPane.showMessageDialog(this, "Llena todos los campos primero. . .");
            return;
        }
        if (Controles.cadenaVacia(this.urlPortada) || Controles.cadenaVacia(this.urlPdf)) {
            JOptionPane.showMessageDialog(this, "Portada o PDF faltantes, intenta de nuevo. . .");
            return;
        }
        Libro librito = new Libro(
                this.txt_libCodigo.getText(),
                this.txt_libAutor.getText(),
                this.txt_libNombre.getText(),
                this.txt_libGenero.getText(),
                Integer.parseInt(this.txt_libNumPags.getText()));
        this.gestorBD.insertarLibro(librito);
        GestorPrograma.almacenarImagen(this.urlPortada, this.txt_libCodigo.getText() + ".png");
        GestorPrograma.almacenarPDF(this.urlPdf, this.txt_libCodigo.getText() + ".pdf");

    }//GEN-LAST:event_btn_libGuardarMouseClicked

    private void btn_libActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_libActualizarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_libActualizarMouseClicked

    private void btn_libEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_libEliminarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_libEliminarMouseClicked

    private void btn_libLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_libLimpiarMouseClicked
        this.llenarTablaLibros();
        ManejoComp.crearlabel(this.lbl_libPortada, "");
        this.urlPortada = "";
        this.urlPdf = "";
        this.txt_libCodigo.setText("");
        this.txt_libAutor.setText("");
        this.txt_libNombre.setText("");
        this.txt_libGenero.setText("");
        this.txt_libNumPags.setText("");
    }//GEN-LAST:event_btn_libLimpiarMouseClicked

    private void btn_libNuevoCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_libNuevoCodigoMouseClicked
        this.txt_libCodigo.setText(GestorPrograma.generarCadenaNumAleatoria(10));
    }//GEN-LAST:event_btn_libNuevoCodigoMouseClicked

    private void txt_libCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_libCodigoKeyTyped
        ManejoComp.txtLongitudCondicion(this.txt_libCodigo, evt, 10);
    }//GEN-LAST:event_txt_libCodigoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_libActualizar;
    private javax.swing.JButton btn_libAgregarPdf;
    private javax.swing.JButton btn_libAgregarPortada;
    private javax.swing.JButton btn_libEliminar;
    private javax.swing.JButton btn_libGuardar;
    private javax.swing.JButton btn_libLimpiar;
    private javax.swing.JButton btn_libNuevoCodigo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_MensajeBienvenida;
    private javax.swing.JLabel lbl_MensajeSeccion1;
    private javax.swing.JLabel lbl_MensajeSeccion2;
    public javax.swing.JLabel lbl_btnCerrarSesion;
    private javax.swing.JLabel lbl_btnLibros;
    private javax.swing.JLabel lbl_btnUsuarios;
    private javax.swing.JLabel lbl_libAutor;
    private javax.swing.JLabel lbl_libCodigo;
    private javax.swing.JLabel lbl_libGenero;
    private javax.swing.JLabel lbl_libNombre;
    private javax.swing.JLabel lbl_libNumPags;
    private javax.swing.JLabel lbl_libPortada;
    private javax.swing.JLabel lbl_nombreArchivoPdf;
    private javax.swing.JTabbedPane pnlTb_Menu;
    private javax.swing.JPanel pnl_Libros;
    private javax.swing.JPanel pnl_Usuarios;
    private javax.swing.JPanel pnl_base;
    private javax.swing.JPanel pnl_navBar;
    private javax.swing.JTable tbl_libros;
    private javax.swing.JTextField txt_libAutor;
    private javax.swing.JTextField txt_libCodigo;
    private javax.swing.JTextField txt_libGenero;
    private javax.swing.JTextField txt_libNombre;
    private javax.swing.JTextField txt_libNumPags;
    // End of variables declaration//GEN-END:variables
}
