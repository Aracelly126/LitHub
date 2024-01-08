package Vista;
import Clases.Prestamo;
import Clases.Libro;
import Clases.Usuario;
import Utilidades.ManejoComp;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FrmAdmin extends javax.swing.JFrame {
    
    private Usuario usuarioActual = new Usuario();

    private JPanel panelLibros;
    ArrayList<Usuario> usuarios = new ArrayList<>();
    private Usuario pruebausuarios = new Usuario("Steeven", "Loor", "1111", "ecuador", ""
            + "", "wechewhcb@gmail.com", "ADMIN");
    private Usuario usuario2 = new Usuario("Steeven", "Loor", "1111", "ecuador", ""
            + "", "wechewhcb@gmail.com", "ADMIN");
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

        panelLibros = new JPanel();
        panelLibros.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        pruebausuarios.setApellido("-----");
        pruebausuarios.setClave("11111");
        pruebausuarios.setCorreo("kjfeh4euwehwj@gmail.com");
        pruebausuarios.setFecNac("1/1/1");
        usuario2.setClave("ADMIN");
        usuarios.add(pruebausuarios);
        usuarios.add(usuario2);
        //mostrarLibros(autores);

        
        panelLibros.setLayout(new BorderLayout());
        lbl_btnLibros.add(panelLibros, BorderLayout.CENTER);
        ManejoComp.crearlabel(lbl_btnLibros, "imagenes/ico_libro.png");
        ManejoComp.crearlabel(lbl_btnFavoritos, "imagenes/ico_favoritos.png");
        ManejoComp.crearlabel(lbl_btnAgregarLibro, "imagenes/ico_agregar.png");
        ManejoComp.crearlabel(lbl_btnUsuario, "imagenes/ico_usuario.png");

    }

    private void mostrarLibros(ArrayList<Libro> libros) {
    panelLibros.removeAll();
    for (Libro libro : libros) {
        try {
            URL urlImagen = new URL(libro.getUrlFoto());
            Image imagen = ImageIO.read(urlImagen).getScaledInstance(100, 150, Image.SCALE_SMOOTH);
            ImageIcon iconoImagen = new ImageIcon(imagen);

            JLabel labelLibro = new JLabel(libro.getNombre(), iconoImagen, JLabel.CENTER);
            labelLibro.setHorizontalTextPosition(JLabel.CENTER);
            labelLibro.setVerticalTextPosition(JLabel.BOTTOM);

            JPanel panelLibro = new JPanel(new BorderLayout());
            panelLibro.add(labelLibro, BorderLayout.CENTER);

            panelLibro.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    mostrarDetalleLibro(libro);
                }
            });

            panelLibros.add(panelLibro);
        } catch (Exception e) {
            e.printStackTrace(); // Manejar excepciones relacionadas con la carga de imágenes
        }
    }
    panelLibros.setLocation(panelLibros.getX(), 0);

    revalidate();
    repaint();
}

    private void mostrarLibrosporAutor(ArrayList<Libro> libros) {
    panelLibros.removeAll();
   
    for (Libro libro : libros) {
        JLabel labelLibro = new JLabel(libro.getNombre());
        
        try {
            URL urlImagen = new URL(libro.getUrlPdf());
            Image imagen = ImageIO.read(urlImagen).getScaledInstance(100, 120, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(imagen);
            JLabel labelImagen = new JLabel(scaledImageIcon);

            JPanel panelLibro = new JPanel(new BorderLayout());
            panelLibro.add(labelImagen, BorderLayout.CENTER);
            panelLibro.add(labelLibro, BorderLayout.SOUTH);

           panelLibro.addMouseListener(new MouseAdapter() {
  //              @Override
 //               public void mouseClicked(MouseEvent e) {
   //                 dt.mostrarVentanaOpciones();
  //              }
            });

            panelLibros.add(panelLibro);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    panelLibros.setLocation(panelLibros.getX(), 0);
    revalidate();
    repaint();
}

    private void mostrarLibrosFavoritosUsuario(Usuario usuarios) {
    pnl_favoritos.removeAll(); // Limpia el panel para nuevos elementos

    for (Libro libro : usuario.libro) {
        // Asume que libro.getNombre() retorna el nombre del libro y libro.getImage() retorna un ImageIcon
        JLabel labelLibro = new JLabel(libro.getNombre());
        JLabel labelImagen = new JLabel();
        //labelImagen.setIcon(libro.getImage()); // Establece el icono de la imagen

        // Mejora en la presentación visual
        labelLibro.setHorizontalAlignment(JLabel.CENTER);
        labelImagen.setHorizontalAlignment(JLabel.CENTER);

        JPanel panelLibroFavorito = new JPanel(new BorderLayout());
        panelLibroFavorito.add(labelImagen, BorderLayout.CENTER);
        panelLibroFavorito.add(labelLibro, BorderLayout.SOUTH);

        // Añade un borde y un poco de espacio entre elementos
        //panelLibroFavorito.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        panelLibroFavorito.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarDetalleLibro(libro);
            }
        });

        pnl_favoritos.add(panelLibroFavorito);
    }//

    // Ajustes de layout y renderizado
    pnl_favoritos.revalidate(); // Recalcula el layout del panel
    pnl_favoritos.repaint(); // Redibuja el panel para mostrar los cambios
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        pnl_navBar = new javax.swing.JPanel();
        lbl_btnLibros = new javax.swing.JLabel();
        lbl_btnFavoritos = new javax.swing.JLabel();
        lbl_btnAgregarLibro = new javax.swing.JLabel();
        lbl_btnUsuario = new javax.swing.JLabel();
        pnl_menu = new javax.swing.JTabbedPane();
        pnl_Libro = new javax.swing.JPanel();
        pnl_usuario = new javax.swing.JPanel();
        lbNombre = new javax.swing.JLabel();
        mostrarNombre = new javax.swing.JLabel();
        lbApellido = new javax.swing.JLabel();
        mostrarApellido = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        mostrarFecha = new javax.swing.JLabel();
        lbLugar = new javax.swing.JLabel();
        mostrarLugar = new javax.swing.JLabel();
        lbNacionalida = new javax.swing.JLabel();
        lbObras = new javax.swing.JLabel();
        lbLibros = new javax.swing.JLabel();
        scrollLibros = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        btnSubirFoto = new javax.swing.JButton();
        btnGuardarFoto = new javax.swing.JButton();
        mostrarNObras = new javax.swing.JLabel();
        mostrarNacionalidad = new javax.swing.JLabel();
        lbReconocimientos = new javax.swing.JLabel();
        mostrarReconocimientos = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        pnl_favoritos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnl_agregarLibro = new javax.swing.JPanel();
        PanelPortada = new javax.swing.JPanel();
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
        txtAutor = new javax.swing.JTextField();
        lbNPaginas = new javax.swing.JLabel();
        txtNPaginar = new javax.swing.JTextField();
        lbidioam = new javax.swing.JLabel();
        txtIdioma = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnPdf = new javax.swing.JButton();
        Portada = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LibHub | Administrador");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_navBar.setBackground(new java.awt.Color(36, 35, 53));
        pnl_navBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_btnLibros.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/libros.png"))); // NOI18N
        lbl_btnLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_btnLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnLibrosMouseClicked(evt);
            }
        });
        pnl_navBar.add(lbl_btnLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 60, 60));

        lbl_btnFavoritos.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnFavoritos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FAVORITOS.png"))); // NOI18N
        lbl_btnFavoritos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_btnFavoritos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnFavoritosMouseClicked(evt);
            }
        });
        pnl_navBar.add(lbl_btnFavoritos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 60, 70));

        lbl_btnAgregarLibro.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnAgregarLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar libro.png"))); // NOI18N
        lbl_btnAgregarLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_btnAgregarLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnAgregarLibroMouseClicked(evt);
            }
        });
        pnl_navBar.add(lbl_btnAgregarLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 60, 60));

        lbl_btnUsuario.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/DALL·E 2024-01-07 18.17.07 - A simple and clean icon representing users. The icon should feature a group of abstract human figures, stylized and minimalistic, suitable for use in .png"))); // NOI18N
        lbl_btnUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_btnUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnUsuarioMouseClicked(evt);
            }
        });
        pnl_navBar.add(lbl_btnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 60, 50));

        getContentPane().add(pnl_navBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 650));

        pnl_menu.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        pnl_menu.setEnabled(false);

        pnl_Libro.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_LibroLayout = new javax.swing.GroupLayout(pnl_Libro);
        pnl_Libro.setLayout(pnl_LibroLayout);
        pnl_LibroLayout.setHorizontalGroup(
            pnl_LibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 922, Short.MAX_VALUE)
        );
        pnl_LibroLayout.setVerticalGroup(
            pnl_LibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        pnl_menu.addTab("tab4", pnl_Libro);

        pnl_usuario.setBackground(new java.awt.Color(255, 255, 255));
        pnl_usuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbNombre.setText("Nombre:");
        pnl_usuario.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 46, -1, -1));
        pnl_usuario.add(mostrarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 46, -1, -1));

        lbApellido.setText("Apellido:");
        pnl_usuario.add(lbApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 80, -1, -1));
        pnl_usuario.add(mostrarApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 80, -1, -1));

        lbFecha.setText("Fecha de Nacimiento:");
        pnl_usuario.add(lbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 114, -1, -1));
        pnl_usuario.add(mostrarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 114, -1, -1));

        lbLugar.setText("Lugar de Nacimiento:");
        pnl_usuario.add(lbLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 142, -1, -1));
        pnl_usuario.add(mostrarLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 142, -1, -1));

        lbNacionalida.setText("Nacionalidad:");
        pnl_usuario.add(lbNacionalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 163, -1, -1));

        lbObras.setText("Numero de Obras:");
        pnl_usuario.add(lbObras, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 189, -1, -1));

        lbLibros.setText("Libros publicados:");
        pnl_usuario.add(lbLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 254, -1, -1));
        pnl_usuario.add(scrollLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 276, 499, 198));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );

        pnl_usuario.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 26, 82, -1));

        btnSubirFoto.setText("Subir foto");
        btnSubirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirFotoActionPerformed(evt);
            }
        });
        pnl_usuario.add(btnSubirFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 160, -1, -1));

        btnGuardarFoto.setText("Guardar");
        pnl_usuario.add(btnGuardarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 189, 82, -1));
        pnl_usuario.add(mostrarNObras, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 189, -1, -1));
        pnl_usuario.add(mostrarNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 160, -1, -1));

        lbReconocimientos.setText("Reconocimientos:");
        pnl_usuario.add(lbReconocimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 217, -1, -1));
        pnl_usuario.add(mostrarReconocimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 217, -1, -1));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnl_usuario.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        pnl_menu.addTab("", pnl_usuario);

        pnl_favoritos.setBackground(new java.awt.Color(255, 255, 255));
        pnl_favoritos.setPreferredSize(new java.awt.Dimension(670, 638));

        jLabel2.setText("PAGINA 2");

        javax.swing.GroupLayout pnl_favoritosLayout = new javax.swing.GroupLayout(pnl_favoritos);
        pnl_favoritos.setLayout(pnl_favoritosLayout);
        pnl_favoritosLayout.setHorizontalGroup(
            pnl_favoritosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_favoritosLayout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(jLabel2)
                .addContainerGap(523, Short.MAX_VALUE))
        );
        pnl_favoritosLayout.setVerticalGroup(
            pnl_favoritosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_favoritosLayout.createSequentialGroup()
                .addContainerGap(389, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(245, 245, 245))
        );

        pnl_menu.addTab("", pnl_favoritos);

        pnl_agregarLibro.setBackground(new java.awt.Color(255, 255, 255));
        pnl_agregarLibro.setPreferredSize(new java.awt.Dimension(670, 638));

        javax.swing.GroupLayout PanelPortadaLayout = new javax.swing.GroupLayout(PanelPortada);
        PanelPortada.setLayout(PanelPortadaLayout);
        PanelPortadaLayout.setHorizontalGroup(
            PanelPortadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelPortadaLayout.setVerticalGroup(
            PanelPortadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
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

        lbAutor.setText("Autor:");

        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFecha.setPreferredSize(new java.awt.Dimension(2, 22));

        lbGenero.setText("Genero:");

        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbFechaP.setText("Fecha de Publicacion:");

        txtAutor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAutor.setPreferredSize(new java.awt.Dimension(2, 22));

        lbNPaginas.setText("Numero de paginas:");

        txtNPaginar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNPaginar.setPreferredSize(new java.awt.Dimension(2, 22));

        lbidioam.setText("Idioma:");

        txtIdioma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtIdioma.setPreferredSize(new java.awt.Dimension(2, 22));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        btnPdf.setText("PDF");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_agregarLibroLayout = new javax.swing.GroupLayout(pnl_agregarLibro);
        pnl_agregarLibro.setLayout(pnl_agregarLibroLayout);
        pnl_agregarLibroLayout.setHorizontalGroup(
            pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_agregarLibroLayout.createSequentialGroup()
                .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_agregarLibroLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnPdf)
                        .addGap(153, 153, 153)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_agregarLibroLayout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(Portada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addGap(34, 34, 34)
                        .addComponent(btnCancelar))
                    .addGroup(pnl_agregarLibroLayout.createSequentialGroup()
                        .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_agregarLibroLayout.createSequentialGroup()
                                .addContainerGap(124, Short.MAX_VALUE)
                                .addComponent(PanelPortada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(157, 157, 157))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_agregarLibroLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPortada)
                                .addGap(63, 63, 63)))
                        .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_agregarLibroLayout.createSequentialGroup()
                                    .addComponent(lbTitulo)
                                    .addGap(137, 137, 137)
                                    .addComponent(lbAutor)
                                    .addGap(149, 149, 149))
                                .addGroup(pnl_agregarLibroLayout.createSequentialGroup()
                                    .addGap(103, 103, 103)
                                    .addComponent(lbSinopsis)))
                            .addGroup(pnl_agregarLibroLayout.createSequentialGroup()
                                .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbFechaP, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(lbGenero))
                                .addGap(37, 37, 37)
                                .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbidioam)
                                    .addComponent(txtNPaginar, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(lbNPaginas)
                                    .addComponent(txtAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnl_agregarLibroLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(243, 243, 243))
        );
        pnl_agregarLibroLayout.setVerticalGroup(
            pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_agregarLibroLayout.createSequentialGroup()
                .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_agregarLibroLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(Portada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_agregarLibroLayout.createSequentialGroup()
                        .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_agregarLibroLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(PanelPortada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_agregarLibroLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbTitulo)
                                    .addComponent(lbAutor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbFechaP)
                                    .addComponent(lbNPaginas))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNPaginar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnl_agregarLibroLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(lbidioam))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_agregarLibroLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbGenero)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_agregarLibroLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPortada))))
                .addGap(145, 145, 145)
                .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_agregarLibroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE))
                    .addGroup(pnl_agregarLibroLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(lbSinopsis)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnl_agregarLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(73, 73, 73))
        );

        pnl_menu.addTab("", pnl_agregarLibro);

        getContentPane().add(pnl_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 970, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_btnLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnLibrosMouseClicked
        this.pnl_menu.setSelectedIndex(0);
        panelLibros.setLayout(new BorderLayout());
        panelLibros.add(panelLibros, BorderLayout.CENTER);
        mostrarLibros(panelLibros);


    }//GEN-LAST:event_lbl_btnLibrosMouseClicked

    private void lbl_btnFavoritosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnFavoritosMouseClicked
        this.pnl_menu.setSelectedIndex(1);
    }//GEN-LAST:event_lbl_btnFavoritosMouseClicked

    private void lbl_btnUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnUsuarioMouseClicked
        this.pnl_menu.setSelectedIndex(3);
        this.mostrarNombre.setText(pruebausuarios.getNombre());
        this.mostrarApellido.setText(pruebausuarios.getApellido());
        this.mostrarFecha.setText(pruebausuarios.getFecNac());
        this.mostrarLugar.setText(pruebausuarios.getApellido());
        this.mostrarNacionalidad.setText(pruebausuarios.getPais());
        this.mostrarNObras.setText(pruebausuarios.getTipo());
        this.mostrarReconocimientos.setText(pruebausuarios.getClave());
        JScrollPane scrollPane = new JScrollPane(panelLibros);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //this.mostrarLibrosporAutor(pruebausuarios.libro);

        this.scrollLibros.setViewportView(scrollPane);
        this.scrollLibros.revalidate();
        this.scrollLibros.repaint();
    }//GEN-LAST:event_lbl_btnUsuarioMouseClicked

    private void lbl_btnAgregarLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnAgregarLibroMouseClicked
        this.pnl_menu.setSelectedIndex(2);
    }//GEN-LAST:event_lbl_btnAgregarLibroMouseClicked

    private void btnPortadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPortadaActionPerformed
        String ruta = "";
        JFileChooser portada = new JFileChooser();
        FileNameExtensionFilter filtrar = new FileNameExtensionFilter("jpg & png", "jpg", "png");
        portada.setFileFilter(filtrar);

        int respuesta = portada.showOpenDialog(pnl_agregarLibro);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            this.lbTitulo.setText(portada.getSelectedFile().getName());
            ruta = portada.getSelectedFile().getPath();

            Image mImagen = new ImageIcon(ruta).getImage();
            ImageIcon mIcon = new ImageIcon(mImagen.getScaledInstance(Portada.getWidth(), Portada.getHeight(), Image.SCALE_SMOOTH));
            Portada.setIcon(mIcon);
        }
    }//GEN-LAST:event_btnPortadaActionPerformed

    private void mostrarDetalleLibro(Libro libro) {
        JFrame detalleFrame = new JFrame("Detalles del Libro");
        detalleFrame.setSize(300, 200);
        // Crear y agregar el panel de detalles
        Libro detallePanel = new Libro("", "", "", "", NORMAL, "", "");
        detalleFrame.add(detalleFrame);

        detalleFrame.setLocationRelativeTo(null);
        detalleFrame.setVisible(true);
    }

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        String ruta = "";
        JFileChooser pdfLibro = new JFileChooser();
        FileNameExtensionFilter filtrar = new FileNameExtensionFilter("pdf", "pdf");
        pdfLibro.setFileFilter(filtrar);

        int respuesta = pdfLibro.showOpenDialog(pnl_agregarLibro);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            ruta = pdfLibro.getSelectedFile().getAbsolutePath();
        }
    }//GEN-LAST:event_btnPdfActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombre = this.txtTitulo.getText();
        String nombre_Imagen = this.Portada.getName();
        String sinopsis = this.txtSinpsis.getText();
        String genero = (String) this.cbGenero.getSelectedItem();
        int nPaginas = Integer.parseInt(this.txtNPaginar.getText());

//        pruebaautor.agregarLibro(nombre, nombre_Imagen, sinopsis, 160, 200, genero, nPaginas);

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSubirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubirFotoActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPortada;
    private javax.swing.JLabel Portada;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarFoto;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton btnPortada;
    private javax.swing.JButton btnSubirFoto;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbAutor;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbFechaP;
    private javax.swing.JLabel lbGenero;
    private javax.swing.JLabel lbLibros;
    private javax.swing.JLabel lbLugar;
    private javax.swing.JLabel lbNPaginas;
    private javax.swing.JLabel lbNacionalida;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbObras;
    private javax.swing.JLabel lbReconocimientos;
    private javax.swing.JLabel lbSinopsis;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbidioam;
    private javax.swing.JLabel lbl_btnAgregarLibro;
    private javax.swing.JLabel lbl_btnFavoritos;
    private javax.swing.JLabel lbl_btnLibros;
    private javax.swing.JLabel lbl_btnUsuario;
    private javax.swing.JLabel mostrarApellido;
    private javax.swing.JLabel mostrarFecha;
    private javax.swing.JLabel mostrarLugar;
    private javax.swing.JLabel mostrarNObras;
    private javax.swing.JLabel mostrarNacionalidad;
    private javax.swing.JLabel mostrarNombre;
    private javax.swing.JLabel mostrarReconocimientos;
    private javax.swing.JPanel pnl_Libro;
    private javax.swing.JPanel pnl_agregarLibro;
    private javax.swing.JPanel pnl_favoritos;
    private javax.swing.JTabbedPane pnl_menu;
    private javax.swing.JPanel pnl_navBar;
    public javax.swing.JPanel pnl_usuario;
    private javax.swing.JScrollPane scrollLibros;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdioma;
    private javax.swing.JTextField txtNPaginar;
    private javax.swing.JTextArea txtSinpsis;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
