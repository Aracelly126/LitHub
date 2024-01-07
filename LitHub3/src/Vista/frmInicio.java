package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class frmInicio extends javax.swing.JFrame {

    private JPanel panelLibros;
//    ArrayList<Autor> autores = new ArrayList<>();
//    private Autor pruebaautor = new Autor("Steeven");
//    private Autor autor2 = new Autor("Paul");
//    Libro libro;
    String ruta;
    private FileInputStream fis;
    private int longitudBytes;
//    private Mysql mi = new Mysql();

    public frmInicio() {
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
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        this.setLocationRelativeTo(null);

        panelLibros = new JPanel();
        panelLibros.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
//        pruebaautor.agregarLibro("Cada Historia cuenta", "cover.jpg", "Es un libro ", 160, 200, "drama", 320);
//        autor2.agregarLibro("48 leyes del poder", "descarga.jpg", "Libro sobre leyes", 160, 200, "motivacion", 450);
//        autores.add(pruebaautor);
//        autores.add(autor2);
//        mostrarLibros(autores);

        libros.setLayout(new BorderLayout());
        libros.add(panelLibros, BorderLayout.CENTER);

    }

//    private void mostrarLibros(ArrayList<Autor> autores) {
//        panelLibros.removeAll();
//        for (Autor autor : autores) {
//
//            for (Libro libro : autor.libros) {
//                JLabel labelLibro = new JLabel(libro.getNombre());
//                JLabel labelImagen = new JLabel(libro.getImage());
//
//                JPanel panelLibro = new JPanel(new BorderLayout());
//                panelLibro.add(labelImagen, BorderLayout.CENTER);
//                panelLibro.add(labelLibro, BorderLayout.SOUTH);
//
//                panelLibro.addMouseListener(new MouseAdapter() {
//                    @Override
//                    public void mouseClicked(MouseEvent e) {
//                        mostrarDetalleLibro(libro);
//                    }
//                });
//
//                panelLibros.add(panelLibro);
//            }
//        }
//        panelLibros.setLocation(panelLibros.getX(), 0);
//
//        revalidate();
//        repaint();
//    }

//    private void mostrarLibrosFavoritosUsuario(Usuarios usuario) {
//        panel_favoritos.removeAll();
//
//        for (Libro libro : usuario.librosFavoritos) {
//            JLabel labelLibro = new JLabel(libro.getNombre());
//            JLabel labelImagen = new JLabel(libro.getImage());
//
//            JPanel panelLibrofavorito = new JPanel(new BorderLayout());
//            panelLibrofavorito.add(labelImagen, BorderLayout.CENTER);
//            panelLibrofavorito.add(labelLibro, BorderLayout.SOUTH);
//
//            panelLibrofavorito.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    mostrarDetalleLibro(libro);
//                }
//            });
//
//            panel_favoritos.add(panelLibrofavorito);
//        }
//
//        panel_favoritos.setLocation(panel_favoritos.getX(), 0);
//
//        revalidate();
//        repaint();
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barra = new javax.swing.JPanel();
        panel_libros1 = new javax.swing.JPanel();
        img_icon1 = new javax.swing.JLabel();
        panel_favoritos = new javax.swing.JPanel();
        img_guardado = new javax.swing.JLabel();
        panel_mas = new javax.swing.JPanel();
        img_masicon = new javax.swing.JLabel();
        panel_libros = new javax.swing.JPanel();
        img_icon = new javax.swing.JLabel();
        barra_label = new javax.swing.JLabel();
        Menu_Inicio = new javax.swing.JTabbedPane();
        libros = new javax.swing.JPanel();
        favoritos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Mas = new javax.swing.JPanel();
        PanelPortada = new javax.swing.JPanel();
        Portada = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        lbSinopsis = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSinpsis = new javax.swing.JTextArea();
        btnPortada = new javax.swing.JButton();
        lbAutor = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lbGenero = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox<>();
        lbFechaP = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        lbNPaginas = new javax.swing.JLabel();
        txtNPaginar = new javax.swing.JTextField();
        lbidioam = new javax.swing.JLabel();
        txtIdioma = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnPdf = new javax.swing.JButton();
        Perfil = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_libros1.setBackground(new java.awt.Color(36, 35, 53));
        panel_libros1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img_icon1.setBackground(new java.awt.Color(36, 35, 53));
        img_icon1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Desktop\\estructura clases\\LitHub\\LitHub3\\src\\imagenes\\usuario_2.png")); // NOI18N
        img_icon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img_icon1MouseClicked(evt);
            }
        });
        panel_libros1.add(img_icon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        barra.add(panel_libros1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 30, 30));

        panel_favoritos.setBackground(new java.awt.Color(36, 35, 53));
        panel_favoritos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img_guardado.setBackground(new java.awt.Color(36, 35, 53));
        img_guardado.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Desktop\\estructura clases\\LitHub\\LitHub3\\src\\imagenes\\favoritos.png")); // NOI18N
        img_guardado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img_guardadoMouseClicked(evt);
            }
        });
        panel_favoritos.add(img_guardado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        barra.add(panel_favoritos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 30, 30));

        panel_mas.setBackground(new java.awt.Color(36, 35, 53));
        panel_mas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img_masicon.setBackground(new java.awt.Color(36, 35, 53));
        img_masicon.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Desktop\\estructura clases\\LitHub\\LitHub3\\src\\imagenes\\mas_v2.png")); // NOI18N
        img_masicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img_masiconMouseClicked(evt);
            }
        });
        panel_mas.add(img_masicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        barra.add(panel_mas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 30, 30));

        panel_libros.setBackground(new java.awt.Color(36, 35, 53));
        panel_libros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img_icon.setBackground(new java.awt.Color(36, 35, 53));
        img_icon.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Desktop\\estructura clases\\LitHub\\LitHub3\\src\\imagenes\\libro_color.png")); // NOI18N
        img_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img_iconMouseClicked(evt);
            }
        });
        panel_libros.add(img_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        barra.add(panel_libros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 30, 30));

        barra_label.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Desktop\\estructura clases\\LitHub\\LitHub3\\src\\imagenes\\barra_menu.png")); // NOI18N
        barra.add(barra_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 540));

        getContentPane().add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 540));

        Menu_Inicio.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        Menu_Inicio.setEnabled(false);

        libros.setBackground(new java.awt.Color(255, 255, 255));
        libros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Menu_Inicio.addTab("", libros);

        favoritos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("PAGINA 2");

        javax.swing.GroupLayout favoritosLayout = new javax.swing.GroupLayout(favoritos);
        favoritos.setLayout(favoritosLayout);
        favoritosLayout.setHorizontalGroup(
            favoritosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(favoritosLayout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(jLabel2)
                .addContainerGap(347, Short.MAX_VALUE))
        );
        favoritosLayout.setVerticalGroup(
            favoritosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, favoritosLayout.createSequentialGroup()
                .addContainerGap(274, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(245, 245, 245))
        );

        Menu_Inicio.addTab("", favoritos);

        Mas.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelPortadaLayout = new javax.swing.GroupLayout(PanelPortada);
        PanelPortada.setLayout(PanelPortadaLayout);
        PanelPortadaLayout.setHorizontalGroup(
            PanelPortadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Portada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelPortadaLayout.setVerticalGroup(
            PanelPortadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Portada, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
        );

        lbTitulo.setText("Titulo:");

        txtTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTitulo.setPreferredSize(new java.awt.Dimension(2, 22));

        lbSinopsis.setText("Sinopsis:");

        txtSinpsis.setColumns(20);
        txtSinpsis.setRows(5);
        jScrollPane1.setViewportView(txtSinpsis);

        btnPortada.setText("Seleccionar Portada");
        btnPortada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPortadaActionPerformed(evt);
            }
        });

        lbAutor.setText("Clave");

        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFecha.setPreferredSize(new java.awt.Dimension(2, 22));

        lbGenero.setText("Genero:");

        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "_______", "Novela", "Romance", "Aventura", "Cuento", "Manga", "Ciencia Ficción", "Relato Corto", "Fantasia", "Manga", "Poesia", "Drama" }));

        lbFechaP.setText("Fecha de Publicacion:");

        txtClave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtClave.setPreferredSize(new java.awt.Dimension(2, 22));

        lbNPaginas.setText("Numero de paginas:");

        txtNPaginar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNPaginar.setPreferredSize(new java.awt.Dimension(2, 22));

        lbidioam.setText("Idioma:");

        txtIdioma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtIdioma.setPreferredSize(new java.awt.Dimension(2, 22));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar_icon.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar_icon.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pdf_icon.png"))); // NOI18N
        btnPdf.setText("PDF");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MasLayout = new javax.swing.GroupLayout(Mas);
        Mas.setLayout(MasLayout);
        MasLayout.setHorizontalGroup(
            MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MasLayout.createSequentialGroup()
                .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MasLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(btnGuardar)
                        .addGap(34, 34, 34)
                        .addComponent(btnCancelar))
                    .addGroup(MasLayout.createSequentialGroup()
                        .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MasLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnPortada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(PanelPortada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(MasLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(btnPdf)))
                        .addGap(26, 26, 26)
                        .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSinopsis)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MasLayout.createSequentialGroup()
                                    .addComponent(lbTitulo)
                                    .addGap(137, 137, 137)
                                    .addComponent(lbAutor)
                                    .addGap(149, 149, 149))
                                .addGroup(MasLayout.createSequentialGroup()
                                    .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbFechaP, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addComponent(lbGenero)
                                        .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(37, 37, 37)
                                    .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbidioam)
                                        .addComponent(txtNPaginar, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                        .addComponent(lbNPaginas)
                                        .addComponent(txtClave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtIdioma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        MasLayout.setVerticalGroup(
            MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MasLayout.createSequentialGroup()
                .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MasLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTitulo)
                            .addComponent(lbAutor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFechaP)
                            .addComponent(lbNPaginas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNPaginar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(MasLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lbidioam))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MasLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbGenero))))
                    .addGroup(MasLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(PanelPortada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MasLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnPortada))
                    .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MasLayout.createSequentialGroup()
                        .addComponent(lbSinopsis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(MasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(73, 73, 73))
        );

        Menu_Inicio.addTab("", Mas);

        Perfil.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("PAGINA PERFIL 3");

        javax.swing.GroupLayout PerfilLayout = new javax.swing.GroupLayout(Perfil);
        Perfil.setLayout(PerfilLayout);
        PerfilLayout.setHorizontalGroup(
            PerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PerfilLayout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(jLabel3)
                .addContainerGap(337, Short.MAX_VALUE))
        );
        PerfilLayout.setVerticalGroup(
            PerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PerfilLayout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(219, 219, 219))
        );

        Menu_Inicio.addTab("", Perfil);

        getContentPane().add(Menu_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void img_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_iconMouseClicked
//        // TODO add your handling code here:
//        Menu_Inicio.setSelectedIndex(0);
//        libros.setLayout(new BorderLayout());
//        libros.add(panelLibros, BorderLayout.CENTER);
//        mostrarLibros(autores);
    }//GEN-LAST:event_img_iconMouseClicked

    private void img_guardadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_guardadoMouseClicked
        // TODO add your handling code here:
        Menu_Inicio.setSelectedIndex(1);
    }//GEN-LAST:event_img_guardadoMouseClicked

    private void img_icon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_icon1MouseClicked
        // TODO add your handling code here:
        Menu_Inicio.setSelectedIndex(3);
    }//GEN-LAST:event_img_icon1MouseClicked

    private void img_masiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_masiconMouseClicked
        // TODO add your handling code here:
        Menu_Inicio.setSelectedIndex(2);
    }//GEN-LAST:event_img_masiconMouseClicked

    private void btnPortadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPortadaActionPerformed
        JFileChooser se = new JFileChooser();
        se.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = se.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {

                fis = new FileInputStream(se.getSelectedFile());
                this.longitudBytes = (int) se.getSelectedFile().length();
                Image icono = ImageIO.read(se.getSelectedFile()).getScaledInstance(this.Portada.getWidth(), this.Portada.getHeight(), Image.SCALE_DEFAULT);
                this.Portada.setIcon(new ImageIcon(icono));
                this.Portada.updateUI();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error en el primer catch");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error en el segundo catch");
            }
        }
    }//GEN-LAST:event_btnPortadaActionPerformed

//    private void mostrarDetalleLibro(Libro libro) {
//        JFrame detalleFrame = new JFrame("Detalles del Libro");
//        detalleFrame.setSize(300, 200);
//        // Crear y agregar el panel de detalles
//        DetallesLibro detallePanel = new DetallesLibro(libro.getImage(), libro.getNombre(), libro.getSinopsis());
//        detalleFrame.add(detallePanel);
//
//        detalleFrame.setLocationRelativeTo(null);
//        detalleFrame.setVisible(true);
//    }

    private byte[] leerContenidoPDF(String ruta) {
        try (InputStream input = new FileInputStream(ruta)) {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
            return output.toByteArray();
        } catch (IOException ex) {
            System.out.println("Error al leer el contenido del PDF: " + ex.getMessage());
            return null;
        }
    }
    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed

        JFileChooser pdfLibro = new JFileChooser();
        FileNameExtensionFilter filtrar = new FileNameExtensionFilter("pdf", "pdf");
        pdfLibro.setFileFilter(filtrar);
        int respuesta = pdfLibro.showOpenDialog(Mas);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            ruta = pdfLibro.getSelectedFile().getAbsolutePath();
        }
    }//GEN-LAST:event_btnPdfActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

//        String nombre = this.txtTitulo.getText();
//        String sinopsis = this.txtSinpsis.getText();
//        String genero = (String) this.cbGenero.getSelectedItem();
//        int clave = Integer.parseInt(this.txtClave.getText());
//        int nPaginas = Integer.parseInt(this.txtNPaginar.getText());
//        byte[] contenidoPdf = leerContenidoPDF(ruta);
//        libro = new Libro(sinopsis, genero, nPaginas, nPaginas, nombre, contenidoPdf, clave);
//        try {
//            agregarLibroBase(libro);
//        } catch (SQLException ex) {
//            Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas cancelar?", "Mensaje",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            Menu_Inicio.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Mas;
    private javax.swing.JTabbedPane Menu_Inicio;
    private javax.swing.JPanel PanelPortada;
    private javax.swing.JPanel Perfil;
    private javax.swing.JLabel Portada;
    private javax.swing.JPanel barra;
    private javax.swing.JLabel barra_label;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton btnPortada;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JPanel favoritos;
    private javax.swing.JLabel img_guardado;
    private javax.swing.JLabel img_icon;
    private javax.swing.JLabel img_icon1;
    private javax.swing.JLabel img_masicon;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAutor;
    private javax.swing.JLabel lbFechaP;
    private javax.swing.JLabel lbGenero;
    private javax.swing.JLabel lbNPaginas;
    private javax.swing.JLabel lbSinopsis;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbidioam;
    private javax.swing.JPanel libros;
    private javax.swing.JPanel panel_favoritos;
    private javax.swing.JPanel panel_libros;
    private javax.swing.JPanel panel_libros1;
    private javax.swing.JPanel panel_mas;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdioma;
    private javax.swing.JTextField txtNPaginar;
    private javax.swing.JTextArea txtSinpsis;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
//public void agregarLibroBase(Libro libro) throws SQLException {
//
//        try {
//            boolean aux = mi.conectar();
//            if (aux == true) {
//                String query = "INSERT INTO Libro (sinopsis,genero,numPags,nombreLi,codigopdf, nombrepdf, archivopdf,foto,clave) VALUES(?,?,?,?,?, ?, ?,?,?);";
//                PreparedStatement ps = con.prepareStatement(query);
//                ps.setString(1, libro.getSinopsis());
//                ps.setString(2, libro.getGenero());
//                ps.setInt(3, libro.getnPaginas());
//                ps.setString(4, libro.getNombre());
//                ps.setInt(5, libro.getCodigoPdf());
//                ps.setString(6, libro.getNombrePdf());
//                ps.setBytes(7, libro.getArchivoPdf());
//                ps.setBlob(8, fis, longitudBytes);
//                ps.setInt(9, libro.getClave());
//                ps.executeUpdate();
//            } else {
//                JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos");
//
//            }
//
//        } catch (SQLException e) {
//            // Manejo de excepciones
//            System.out.println("Fallos en la actualización" + e);
//
//        }
//    }
}
