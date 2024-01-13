package Vista;

import BaseDatos.Almacen;
import BaseDatos.GestorBD;
import Clases.Favorito;
import Clases.Libro;
import Clases.Usuario;
import Utilidades.Controles;
import Utilidades.DetallesLibro;
import Utilidades.GestorPrograma;
import Utilidades.ManejoComp;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class FrmAutor extends javax.swing.JFrame {

    private Usuario SesionActual = new Usuario();
    private GestorBD gestorBD = new GestorBD();

    private String[] tblLibrosTitulosAutor = {"CODIGO", "NOMBRE", "GENERO", "NUMERO PAGS"};
    private DefaultTableModel modelTblLibrosAutor = new DefaultTableModel(tblLibrosTitulosAutor, 0);
    private String urlPortadaAutor = "";
    private String urlPortadaAutorSubir = "";
    private String urlPdfAutor = "";
    private JPanel panelLibros;
    private JPanel panelLibrosFav;

    private Libro libroSeleccionado;

    public FrmAutor() {
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
            java.util.logging.Logger.getLogger(FrmAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        this.setLocationRelativeTo(null);

        ManejoComp.crearlabel(this.lbl_btnPerfil, "SYSTEM/src/ico_usuario.png");
        ManejoComp.crearlabel(this.lbl_btnLibros, "SYSTEM/src/ico_libro.png");
        ManejoComp.crearlabel(this.lbl_btnFavoritos, "SYSTEM/src/ico_favoritos.png");
        ManejoComp.crearlabel(this.lbl_btnPrestamos, "SYSTEM/src/ico_prestamo.png");
        ManejoComp.crearlabel(this.lbl_btnCerrarSesion, "SYSTEM/src/ico_cerrarsesion.png");
        ManejoComp.crearlabel(this.lbl_btnSubirLibros, "SYSTEM/src/icon_SubirLibro.png");

        panelLibros = new JPanel();
        pnl_LibrosAll.setLayout(new BorderLayout());
        pnl_LibrosAll.add(panelLibros, BorderLayout.CENTER);

        //--------Libros Favoritos
        panelLibrosFav = new JPanel();
        pnl_LibrosAllFav.setLayout(new BorderLayout());
        pnl_LibrosAllFav.add(panelLibrosFav, BorderLayout.CENTER);
    }

    public void iniciarVentana(String correoUser) {
        this.lbl_portadaLibroAutores.setIcon(null);
        this.SesionActual = GestorPrograma.buscarUsuario(correoUser);
        System.out.println("Bienvenido: " + this.SesionActual.getNombre());
        iniciarPnlLibrosAutor();
        inicialPnlAutor(this.SesionActual);
        iniciarPnlTodosLibros(this.SesionActual);

        iniciarPnlLibrosFav(SesionActual);

        this.setVisible(true);
    }

    private void iniciarPnlLibrosFav(Usuario SesionActual) {
        int numeroDeColumnas = 4; // Por ejemplo, 3 columnas
        panelLibrosFav.setLayout(new GridLayout(0, numeroDeColumnas));
        panelLibrosFav.removeAll();
        int i = 1;
        for (Favorito fav : Almacen.getInstance().favoritos) {
            if (fav.getCorreoUsuario().equals(this.SesionActual.getCorreo())) {
                JLabel labelLibro = new JLabel(String.valueOf(i));
                labelLibro.setHorizontalAlignment(JLabel.CENTER); // Centrar el texto
                JLabel labelImagen = new JLabel(ManejoComp.redimensionarImagen("SYSTEM/libros/" + fav.getCodigoLibro() + ".png", 160, 200));
                // Crear panel para el libro
                JPanel panelLibroFav = new JPanel(new BorderLayout());
                panelLibroFav.add(labelImagen, BorderLayout.CENTER);

                // Crear panel para botones y label de descripción
                JPanel panelBotones = new JPanel(new FlowLayout());

                // Botón para agregar a favoritos
                JButton btnFavoritos = new JButton("Eliminar de Favoritos");
                btnFavoritos.addActionListener(e -> {
                    this.gestorBD.eliminarFavoritosPorLibro(fav.getCodigoLibro());
                    Almacen.getInstance().favoritos.remove(fav);
                    JOptionPane.showMessageDialog(panelLibroFav, " Ha sido eliminado tu libro de favoritos.");
                    iniciarPnlLibrosFav(SesionActual);
                });
                JLabel lblDescripcion = new JLabel("Leer Ahora");
                lblDescripcion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                lblDescripcion.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        GestorPrograma.abrirPDF("SYSTEM/libros/" + fav.getCodigoLibro() + ".pdf");
                    }
                });

                // Añadir botón y label al panel de botones
                panelBotones.add(lblDescripcion);

                // Añadir botón y label al panel de botones
                panelBotones.add(btnFavoritos);

                // Crear un panel secundario para agrupar el label del libro y los botones
                JPanel panelInferior = new JPanel(new BorderLayout());
                panelInferior.add(labelLibro, BorderLayout.NORTH);
                panelInferior.add(panelBotones, BorderLayout.SOUTH);

                // Añadir el panel inferior al panel del libro
                panelLibroFav.add(panelInferior, BorderLayout.SOUTH);

                panelLibrosFav.add(panelLibroFav);
                i++;
            }
            panelLibrosFav.setLocation(panelLibrosFav.getX(), 0);

            revalidate();
            repaint();
        }

    }

    private void iniciarPnlTodosLibros(Usuario SesionActual) {
        int numeroDeColumnas = 4; // Por ejemplo, 3 columnas
        panelLibros.setLayout(new GridLayout(0, numeroDeColumnas));
        panelLibros.removeAll();
        for (Libro libro : Almacen.getInstance().libros) {
            JLabel labelLibro = new JLabel(libro.getNombre().toUpperCase());
            labelLibro.setHorizontalAlignment(JLabel.CENTER); // Centrar el texto
            JLabel labelImagen = new JLabel(ManejoComp.redimensionarImagen("SYSTEM/libros/" + libro.getCodigo() + ".png", 160, 200));

            // Crear panel para el libro
            JPanel panelLibro = new JPanel(new BorderLayout());
            panelLibro.add(labelImagen, BorderLayout.CENTER);

            // Crear panel para botones y label de descripción
            JPanel panelBotones = new JPanel(new FlowLayout());

            // Botón para agregar a favoritos
            JButton btnFavoritos = new JButton("Agregar a Favoritos");
            btnFavoritos.addActionListener(e -> {
                Favorito fav = new Favorito(this.SesionActual.getCorreo(), libro.getCodigo());
                Favorito favoritoBuscado = GestorPrograma.buscarFavorito(libro.getCodigo(), this.SesionActual.getCorreo());
                if (favoritoBuscado == null) {
                    this.gestorBD.agregarLibroFavoritos(fav);
                    Almacen.getInstance().favoritos.add(fav);
                    JOptionPane.showMessageDialog(panelLibro, libro.getNombre() + " ha sido agregado a favoritos.");
                    iniciarPnlLibrosFav(SesionActual);
                    return;
                }
                JOptionPane.showMessageDialog(panelLibro, libro.getNombre().toUpperCase() + " ya lo tienes en favoritos.");

            });

            // Label para mostrar descripción
            JLabel lblDescripcion = new JLabel("Ver Descripción");
            lblDescripcion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            lblDescripcion.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    mostrarDetalleLibro(libro);
                }
            });

            // Añadir botón y label al panel de botones
            panelBotones.add(btnFavoritos);
            panelBotones.add(lblDescripcion);

            // Crear un panel secundario para agrupar el label del libro y los botones
            JPanel panelInferior = new JPanel(new BorderLayout());
            panelInferior.add(labelLibro, BorderLayout.NORTH);
            panelInferior.add(panelBotones, BorderLayout.SOUTH);

            // Añadir el panel inferior al panel del libro
            panelLibro.add(panelInferior, BorderLayout.SOUTH);

            panelLibros.add(panelLibro);
        }
        panelLibros.setLocation(panelLibros.getX(), 0);

        revalidate();
        repaint();
    }

    private void mostrarDetalleLibro(Libro libro) {
        JFrame detalleFrame = new JFrame("Detalles del Libro");
        detalleFrame.setSize(300, 200);
        // Crear y agregar el panel de detalles
        DetallesLibro detallePanel = new DetallesLibro(libro.getNombre(), libro.getGenero());
        detalleFrame.add(detallePanel);

        detalleFrame.setLocationRelativeTo(null);
        detalleFrame.setVisible(true);
    }

    private void inicialPnlAutor(Usuario user) {
        this.lbl_autoNombreSalida.setText(user.getNombre().toUpperCase());
        this.lbl_autoApellSalida1.setText(user.getApellido().toUpperCase());
        this.lbl_autoFechaNacSalida4.setText(user.getFecNac());
        this.lbl_autoCantObrasSalida2.setText("12");
        this.lbl_autoPaisSalida3.setText(user.getPais().toUpperCase());
        boolean aux2 = ManejoComp.crearlabel(this.lbl_libPortadaAutor, "SYSTEM/Autores/" + user.getCorreo() + ".png");
        if (aux2 == false) {
            btn_libAgregarPortadaAutor.setEnabled(false);
        }

    }

    private void iniciarPnlLibrosAutor() {
        ManejoComp.vaciarTabla(this.tbl_librosAutor, this.modelTblLibrosAutor);
        for (Libro libro : Almacen.getInstance().libros) {
            if (libro.getCorreoUsu().equals(this.SesionActual.getCorreo())) {
//                System.out.println("CORREO RELACIONADO CON EL LIBRO " + libro.getCorreoUsu() + SesionActual.getCorreo());
                String[] registro = {
                    libro.getCodigo(),
                    libro.getNombre(),
                    libro.getGenero(),
                    String.valueOf(libro.getNumPag())
                };
                this.modelTblLibrosAutor.addRow(registro);
            }
        }
        limpiarPnlLibrosAutores();
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
        lbl_btnSubirLibros = new javax.swing.JLabel();
        pnlTb_MenuAutor = new javax.swing.JTabbedPane();
        pnl_Libros = new javax.swing.JPanel();
        lbl_MensajeSeccion2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        pnl_LibrosAll = new javax.swing.JPanel();
        pnl_Prestamos = new javax.swing.JPanel();
        lbl_MensajeSeccion4 = new javax.swing.JLabel();
        pnl_Perfil = new javax.swing.JPanel();
        lbl_MensajeSeccion1 = new javax.swing.JLabel();
        lbl_libPortadaAutor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_librosAutor = new javax.swing.JTable();
        btn_libAgregarPortadaAutor = new javax.swing.JButton();
        lbl_autoNombreSalida = new javax.swing.JLabel();
        lbl_autoApellido = new javax.swing.JLabel();
        lbl_autoPais = new javax.swing.JLabel();
        lbl_autoCantObras = new javax.swing.JLabel();
        lbl_autoFechaNac = new javax.swing.JLabel();
        lbl_Obras = new javax.swing.JLabel();
        lbl_MensajeBienvenida = new javax.swing.JLabel();
        lbl_autoNombre1 = new javax.swing.JLabel();
        lbl_autoApellSalida1 = new javax.swing.JLabel();
        lbl_autoCantObrasSalida2 = new javax.swing.JLabel();
        lbl_autoPaisSalida3 = new javax.swing.JLabel();
        lbl_autoFechaNacSalida4 = new javax.swing.JLabel();
        lbl_portadaLibroAutores = new javax.swing.JLabel();
        lbl_Libro = new javax.swing.JLabel();
        pnl_subirLibrosAutor = new javax.swing.JPanel();
        lbl_MensajeSeccion5 = new javax.swing.JLabel();
        lbl_libPortadaAuto = new javax.swing.JLabel();
        btn_libAgregarPortadaAuto = new javax.swing.JButton();
        btn_libAgregarPdfAuto = new javax.swing.JButton();
        lbl_libCodigoAuto = new javax.swing.JLabel();
        txt_nombreAutor = new javax.swing.JTextField();
        lbl_libAutor = new javax.swing.JLabel();
        lbl_libNombre = new javax.swing.JLabel();
        txt_libNombreAuto = new javax.swing.JTextField();
        lbl_libGenero = new javax.swing.JLabel();
        lbl_libNumPags = new javax.swing.JLabel();
        txt_libNumPagsAuto = new javax.swing.JTextField();
        btn_libGuardarAutor = new javax.swing.JButton();
        btn_libActualizarAuto = new javax.swing.JButton();
        btn_libEliminarAuto = new javax.swing.JButton();
        btn_libLimpiarAuto = new javax.swing.JButton();
        lbl_libNombreArchivoPdf = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_librosAutoSubidos = new javax.swing.JTable();
        btn_libNuevoCodigo = new javax.swing.JButton();
        cmb_libGenerosAutor = new javax.swing.JComboBox<>();
        txt_libCodigoAutor = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtSinpsis = new javax.swing.JTextArea();
        lbl_libNumPags1 = new javax.swing.JLabel();
        pnl_Favoritos = new javax.swing.JPanel();
        lbl_MensajeSeccion3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        pnl_LibrosAllFav = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LibHub | Autor");
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

        lbl_btnSubirLibros.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnSubirLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_btnSubirLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnSubirLibrosMouseClicked(evt);
            }
        });
        pnl_navBar.add(lbl_btnSubirLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 340, 50, 50));

        pnl_base.add(pnl_navBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 720));

        pnlTb_MenuAutor.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        pnl_Libros.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Libros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeSeccion2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_MensajeSeccion2.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeSeccion2.setText("Seccion: Libros");
        pnl_Libros.add(lbl_MensajeSeccion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 153, 153));
        pnl_Libros.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 64, 1184, -1));

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnl_LibrosAll.setBackground(new java.awt.Color(255, 255, 255));
        pnl_LibrosAll.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl_LibrosAll.setMinimumSize(new java.awt.Dimension(1216, 720));
        pnl_LibrosAll.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane4.setViewportView(pnl_LibrosAll);

        pnl_Libros.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 80, 1200, 640));

        pnlTb_MenuAutor.addTab("", pnl_Libros);

        pnl_Prestamos.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Prestamos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeSeccion4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_MensajeSeccion4.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeSeccion4.setText("Seccion: Prestamos");
        pnl_Prestamos.add(lbl_MensajeSeccion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, -1, -1));

        pnlTb_MenuAutor.addTab("", pnl_Prestamos);

        pnl_Perfil.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Perfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeSeccion1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_MensajeSeccion1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeSeccion1.setText("Seccion: Perfil");
        pnl_Perfil.add(lbl_MensajeSeccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, -1, -1));

        lbl_libPortadaAutor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_Perfil.add(lbl_libPortadaAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 80, 170, 210));

        tbl_librosAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_librosAutor.setModel(this.modelTblLibrosAutor);
        tbl_librosAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_librosAutorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_librosAutor);

        pnl_Perfil.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 1104, 320));

        btn_libAgregarPortadaAutor.setText("Agregar portada");
        btn_libAgregarPortadaAutor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_libAgregarPortadaAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_libAgregarPortadaAutorMouseClicked(evt);
            }
        });
        btn_libAgregarPortadaAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_libAgregarPortadaAutorActionPerformed(evt);
            }
        });
        pnl_Perfil.add(btn_libAgregarPortadaAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 304, 170, 30));

        lbl_autoNombreSalida.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_autoNombreSalida.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoNombreSalida.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_autoNombreSalida.setToolTipText("");
        pnl_Perfil.add(lbl_autoNombreSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 96, 176, 30));

        lbl_autoApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_autoApellido.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoApellido.setText("Apellido:");
        pnl_Perfil.add(lbl_autoApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 144, 80, 30));

        lbl_autoPais.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_autoPais.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoPais.setText("Pais:");
        pnl_Perfil.add(lbl_autoPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 96, 80, 30));

        lbl_autoCantObras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_autoCantObras.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoCantObras.setText("Cant Obras:");
        pnl_Perfil.add(lbl_autoCantObras, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 192, 80, 30));

        lbl_autoFechaNac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_autoFechaNac.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoFechaNac.setText("Fecha Nac:");
        pnl_Perfil.add(lbl_autoFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 144, 80, 32));

        lbl_Obras.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_Obras.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Obras.setText("Mi biblioteca");
        pnl_Perfil.add(lbl_Obras, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 288, -1, -1));

        lbl_MensajeBienvenida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_MensajeBienvenida.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeBienvenida.setText("Iniciaste sesion como: AUTOR");
        pnl_Perfil.add(lbl_MensajeBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 16, -1, -1));

        lbl_autoNombre1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_autoNombre1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoNombre1.setText("Nombre:");
        pnl_Perfil.add(lbl_autoNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 96, 80, 30));

        lbl_autoApellSalida1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_autoApellSalida1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoApellSalida1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_autoApellSalida1.setToolTipText("");
        pnl_Perfil.add(lbl_autoApellSalida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 144, 176, 30));

        lbl_autoCantObrasSalida2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_autoCantObrasSalida2.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoCantObrasSalida2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_autoCantObrasSalida2.setToolTipText("");
        pnl_Perfil.add(lbl_autoCantObrasSalida2, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 192, 160, 30));

        lbl_autoPaisSalida3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_autoPaisSalida3.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoPaisSalida3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_autoPaisSalida3.setToolTipText("");
        pnl_Perfil.add(lbl_autoPaisSalida3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 96, 176, 30));

        lbl_autoFechaNacSalida4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_autoFechaNacSalida4.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoFechaNacSalida4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_autoFechaNacSalida4.setToolTipText("");
        pnl_Perfil.add(lbl_autoFechaNacSalida4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 144, 176, 30));

        lbl_portadaLibroAutores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_Perfil.add(lbl_portadaLibroAutores, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 64, 208, 256));

        lbl_Libro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_Libro.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Libro.setText("Libro:");
        pnl_Perfil.add(lbl_Libro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1024, 32, -1, -1));

        pnlTb_MenuAutor.addTab("", pnl_Perfil);

        pnl_subirLibrosAutor.setBackground(new java.awt.Color(255, 255, 255));
        pnl_subirLibrosAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_subirLibrosAutorMouseClicked(evt);
            }
        });
        pnl_subirLibrosAutor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeSeccion5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_MensajeSeccion5.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeSeccion5.setText("Seccion Agregar nuevos Libros");
        pnl_subirLibrosAutor.add(lbl_MensajeSeccion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, -1, -1));

        lbl_libPortadaAuto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_subirLibrosAutor.add(lbl_libPortadaAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 170, 210));

        btn_libAgregarPortadaAuto.setText("Agregar portada");
        btn_libAgregarPortadaAuto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_libAgregarPortadaAuto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_libAgregarPortadaAutoMouseClicked(evt);
            }
        });
        pnl_subirLibrosAutor.add(btn_libAgregarPortadaAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 170, 30));

        btn_libAgregarPdfAuto.setText("Agregar pdf");
        btn_libAgregarPdfAuto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_libAgregarPdfAuto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_libAgregarPdfAutoMouseClicked(evt);
            }
        });
        pnl_subirLibrosAutor.add(btn_libAgregarPdfAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 170, 30));

        lbl_libCodigoAuto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_libCodigoAuto.setForeground(new java.awt.Color(0, 0, 0));
        lbl_libCodigoAuto.setText("Codigo:");
        pnl_subirLibrosAutor.add(lbl_libCodigoAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 100, 30));

        txt_nombreAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_nombreAutor.setEnabled(false);
        pnl_subirLibrosAutor.add(txt_nombreAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 128, 300, 30));

        lbl_libAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_libAutor.setForeground(new java.awt.Color(0, 0, 0));
        lbl_libAutor.setText("Autor:");
        pnl_subirLibrosAutor.add(lbl_libAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 100, 30));

        lbl_libNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_libNombre.setForeground(new java.awt.Color(0, 0, 0));
        lbl_libNombre.setText("Nombre:");
        pnl_subirLibrosAutor.add(lbl_libNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 100, 30));

        txt_libNombreAuto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_libNombreAuto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_libNombreAutoKeyTyped(evt);
            }
        });
        pnl_subirLibrosAutor.add(txt_libNombreAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 300, 30));

        lbl_libGenero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_libGenero.setForeground(new java.awt.Color(0, 0, 0));
        lbl_libGenero.setText("Genero:");
        pnl_subirLibrosAutor.add(lbl_libGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 100, 30));

        lbl_libNumPags.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_libNumPags.setForeground(new java.awt.Color(0, 0, 0));
        lbl_libNumPags.setText("Num paginas:");
        pnl_subirLibrosAutor.add(lbl_libNumPags, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 100, 30));

        txt_libNumPagsAuto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_libNumPagsAuto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_libNumPagsAutoKeyTyped(evt);
            }
        });
        pnl_subirLibrosAutor.add(txt_libNumPagsAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 300, 30));

        btn_libGuardarAutor.setText("Guardar");
        btn_libGuardarAutor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_libGuardarAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_libGuardarAutorMouseClicked(evt);
            }
        });
        pnl_subirLibrosAutor.add(btn_libGuardarAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 80, 100, 30));

        btn_libActualizarAuto.setText("Actualizar");
        btn_libActualizarAuto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_libActualizarAuto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_libActualizarAutoMouseClicked(evt);
            }
        });
        pnl_subirLibrosAutor.add(btn_libActualizarAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 128, 100, 30));

        btn_libEliminarAuto.setText("Eliminar");
        btn_libEliminarAuto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_libEliminarAuto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_libEliminarAutoMouseClicked(evt);
            }
        });
        pnl_subirLibrosAutor.add(btn_libEliminarAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 176, 100, 30));

        btn_libLimpiarAuto.setText("Limpiar");
        btn_libLimpiarAuto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_libLimpiarAuto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_libLimpiarAutoMouseClicked(evt);
            }
        });
        pnl_subirLibrosAutor.add(btn_libLimpiarAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 224, 100, 30));
        pnl_subirLibrosAutor.add(lbl_libNombreArchivoPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 200, 30));

        tbl_librosAutoSubidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_librosAutoSubidos.setModel(this.modelTblLibrosAutor);
        tbl_librosAutoSubidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_librosAutoSubidosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_librosAutoSubidos);

        pnl_subirLibrosAutor.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 368, 890, 270));

        btn_libNuevoCodigo.setText("Nuevo");
        btn_libNuevoCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_libNuevoCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_libNuevoCodigoMouseClicked(evt);
            }
        });
        pnl_subirLibrosAutor.add(btn_libNuevoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 70, 30));

        cmb_libGenerosAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Drama", "Novela", "Ficticio" }));
        pnl_subirLibrosAutor.add(cmb_libGenerosAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 300, 30));

        txt_libCodigoAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_libCodigoAutor.setEnabled(false);
        txt_libCodigoAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_libCodigoAutorKeyTyped(evt);
            }
        });
        pnl_subirLibrosAutor.add(txt_libCodigoAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 300, 30));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtSinpsis.setColumns(20);
        txtSinpsis.setLineWrap(true);
        txtSinpsis.setRows(5);
        jScrollPane3.setViewportView(txtSinpsis);

        pnl_subirLibrosAutor.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(752, 80, 272, 224));

        lbl_libNumPags1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_libNumPags1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_libNumPags1.setText("Sinopsis");
        pnl_subirLibrosAutor.add(lbl_libNumPags1, new org.netbeans.lib.awtextra.AbsoluteConstraints(752, 48, 100, 30));

        pnlTb_MenuAutor.addTab("", pnl_subirLibrosAutor);

        pnl_Favoritos.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Favoritos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeSeccion3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_MensajeSeccion3.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeSeccion3.setText("Seccion Favoritos");
        pnl_Favoritos.add(lbl_MensajeSeccion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 16, -1, -1));
        pnl_Favoritos.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 64, 1216, 80));

        jScrollPane5.setBorder(null);
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnl_LibrosAllFav.setBackground(new java.awt.Color(255, 255, 255));
        pnl_LibrosAllFav.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl_LibrosAllFav.setMinimumSize(new java.awt.Dimension(1216, 720));
        pnl_LibrosAllFav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane5.setViewportView(pnl_LibrosAllFav);

        pnl_Favoritos.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 64, 1200, 640));

        pnlTb_MenuAutor.addTab("", pnl_Favoritos);

        pnl_base.add(pnlTb_MenuAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 1250, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnPerfilMouseClicked
        this.pnlTb_MenuAutor.setSelectedIndex(2);
    }//GEN-LAST:event_lbl_btnPerfilMouseClicked

    private void lbl_btnLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnLibrosMouseClicked
        this.pnlTb_MenuAutor.setSelectedIndex(0);
    }//GEN-LAST:event_lbl_btnLibrosMouseClicked

    private void lbl_btnPrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnPrestamosMouseClicked
        this.pnlTb_MenuAutor.setSelectedIndex(1);
    }//GEN-LAST:event_lbl_btnPrestamosMouseClicked

    private void lbl_btnFavoritosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnFavoritosMouseClicked
        this.pnlTb_MenuAutor.setSelectedIndex(4);
    }//GEN-LAST:event_lbl_btnFavoritosMouseClicked

    private void btn_libAgregarPortadaAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_libAgregarPortadaAutorMouseClicked
        if (this.btn_libAgregarPortadaAutor.isEnabled() == false) {
            return;
        }
        this.urlPortadaAutor = GestorPrograma.seleccionarImagen();
        if (Controles.cadenaVacia(this.urlPortadaAutor)) {
            return;
        }
        ManejoComp.crearlabel(this.lbl_libPortadaAutor, this.urlPortadaAutor);
        this.btn_libAgregarPortadaAutor.setEnabled(false);
        GestorPrograma.almacenarImagenAutores(urlPortadaAutor, this.SesionActual.getCorreo() + ".png");

    }//GEN-LAST:event_btn_libAgregarPortadaAutorMouseClicked

    private void btn_libAgregarPortadaAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_libAgregarPortadaAutorActionPerformed

    }//GEN-LAST:event_btn_libAgregarPortadaAutorActionPerformed

    private void tbl_librosAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_librosAutorMouseClicked
        int index = this.tbl_librosAutor.getSelectedRow();
        String codigoLibro = this.tbl_librosAutor.getModel().getValueAt(index, 0).toString();
        //System.out.println("El codigo del Libro atrapado de la tabla de que esta en Perfil de autor es: "+codigoLibro);
        ManejoComp.crearlabel(this.lbl_portadaLibroAutores, "SYSTEM/libros/" + codigoLibro + ".png");
    }//GEN-LAST:event_tbl_librosAutorMouseClicked

    private void txt_libCodigoAutorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_libCodigoAutorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_libCodigoAutorKeyTyped

    private void lbl_btnSubirLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnSubirLibrosMouseClicked
        this.pnlTb_MenuAutor.setSelectedIndex(3);

    }//GEN-LAST:event_lbl_btnSubirLibrosMouseClicked

    private void pnl_subirLibrosAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_subirLibrosAutorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pnl_subirLibrosAutorMouseClicked

    private void btn_libAgregarPortadaAutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_libAgregarPortadaAutoMouseClicked
        if (this.btn_libAgregarPortadaAuto.isEnabled() == false) {
            return;
        }
        this.urlPortadaAutorSubir = GestorPrograma.seleccionarImagen();
        if (Controles.cadenaVacia(this.urlPortadaAutorSubir)) {
            return;
        }
        ManejoComp.crearlabel(this.lbl_libPortadaAuto, this.urlPortadaAutorSubir);
        this.btn_libAgregarPortadaAuto.setEnabled(false);
    }//GEN-LAST:event_btn_libAgregarPortadaAutoMouseClicked

    private void btn_libAgregarPdfAutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_libAgregarPdfAutoMouseClicked
        if (this.btn_libAgregarPdfAuto.isEnabled() == false) {
            return;
        }
        this.urlPdfAutor = GestorPrograma.seleccionarPDF();
        this.lbl_libNombreArchivoPdf.setText(this.urlPdfAutor);
        this.btn_libAgregarPdfAuto.setEnabled(false);
    }//GEN-LAST:event_btn_libAgregarPdfAutoMouseClicked

    private void btn_libNuevoCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_libNuevoCodigoMouseClicked
        if (this.btn_libNuevoCodigo.isEnabled() == false) {
            return;
        }
        this.txt_libCodigoAutor.setText(GestorPrograma.generarCadenaNumAleatoria(10));
        this.txt_nombreAutor.setText(SesionActual.getNombre());

    }//GEN-LAST:event_btn_libNuevoCodigoMouseClicked

    private void txt_libNumPagsAutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_libNumPagsAutoKeyTyped
        ManejoComp.txtOnlyNumbers(evt);
        ManejoComp.txtLongitudCondicion(this.txt_libNumPagsAuto, evt, 4);
    }//GEN-LAST:event_txt_libNumPagsAutoKeyTyped

    private void txt_libNombreAutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_libNombreAutoKeyTyped
        ManejoComp.txtLongitudCondicion(this.txt_libNombreAuto, evt, 50);
    }//GEN-LAST:event_txt_libNombreAutoKeyTyped

    private void tbl_librosAutoSubidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_librosAutoSubidosMouseClicked
        int index = this.tbl_librosAutoSubidos.getSelectedRow();

        this.libroSeleccionado = GestorPrograma.buscarLibro((String) this.modelTblLibrosAutor.getValueAt(index, 0));
        //Usuario autor = GestorPrograma.buscarUsuario(this.libroSeleccionado.getCorreoUsu());

        this.cmb_libGenerosAutor.setSelectedItem(this.libroSeleccionado.getGenero());
        this.txt_libNombreAuto.setText(this.libroSeleccionado.getNombre());
        this.txt_libNumPagsAuto.setText(String.valueOf(this.libroSeleccionado.getNumPag()));
        this.txt_libCodigoAutor.setText(this.libroSeleccionado.getCodigo());
        this.txt_nombreAutor.setText(this.libroSeleccionado.getCorreoUsu());

        ManejoComp.crearlabel(this.lbl_libPortadaAuto, "SYSTEM/libros/" + this.txt_libCodigoAutor.getText() + ".png");
        //System.out.println("El codigo del libro es este para buscar y mostrar en el lbl tbLibrosAutoSubidos"+Almacen.getInstance().libros.get(index).getCodigo());
        this.btn_libEliminarAuto.setEnabled(true);
        this.btn_libActualizarAuto.setEnabled(true);
    }//GEN-LAST:event_tbl_librosAutoSubidosMouseClicked
    public void limpiarPnlLibrosAutores() {
        this.libroSeleccionado = null;
        this.urlPortadaAutorSubir = "";
        this.urlPdfAutor = "";
        ManejoComp.crearlabel(this.lbl_libPortadaAuto, "");
        this.lbl_libNombreArchivoPdf.setText("");
        this.txt_libCodigoAutor.setText("");
        this.txt_nombreAutor.setText("");
        this.txt_libNombreAuto.setText("");
        this.cmb_libGenerosAutor.setSelectedIndex(0);
        this.txt_libNumPagsAuto.setText("");

        this.btn_libGuardarAutor.setEnabled(true);
        this.btn_libAgregarPortadaAuto.setEnabled(true);
        this.btn_libAgregarPdfAuto.setEnabled(true);
        this.btn_libEliminarAuto.setEnabled(false);
        this.btn_libActualizarAuto.setEnabled(false);
        this.btn_libNuevoCodigo.setEnabled(true);
    }
    private void btn_libGuardarAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_libGuardarAutorMouseClicked
        if (!this.btn_libGuardarAutor.isEnabled()) {
            return;
        }
        if (Controles.cadenaVacia(this.txt_libCodigoAutor.getText())
                || Controles.cadenaVacia(this.cmb_libGenerosAutor.getSelectedItem().toString())
                || Controles.cadenaVacia(this.txt_libNombreAuto.getText())
                || Controles.cadenaVacia(this.txt_libNumPagsAuto.getText())) {
            JOptionPane.showMessageDialog(this, "Llena todos los campos primero. . .");
            return;
        }
        if (Controles.cadenaVacia(this.urlPortadaAutorSubir) || Controles.cadenaVacia(this.urlPdfAutor)) {
            JOptionPane.showMessageDialog(this, "Portada o PDF faltantes, intenta de nuevo. . .");
            return;
        }
        if (Integer.parseInt(this.txt_libNumPagsAuto.getText()) > 5000) {
            JOptionPane.showMessageDialog(this, "Libros con mas de 5000 paginas no aceptados");
            return;
        }
        Libro librito = new Libro(
                this.txt_libCodigoAutor.getText(),
                SesionActual.getCorreo(),
                this.txt_libNombreAuto.getText(),
                this.cmb_libGenerosAutor.getSelectedItem().toString(),
                Integer.parseInt(this.txt_libNumPagsAuto.getText()),
                "NO");
        //"INSERT INTO LIBROS (CODIGO, CORREO_USU, NOMBRE, GENERO, NUM_PAG) VALUES (?, ?, ?, ?, ?)";

        this.gestorBD.agregarLibro(librito);
        Almacen.getInstance().libros.add(librito);
        GestorPrograma.almacenarImagen(this.urlPortadaAutorSubir, this.txt_libCodigoAutor.getText() + ".png");
        GestorPrograma.almacenarPDF(this.urlPdfAutor, this.txt_libCodigoAutor.getText() + ".pdf");

        this.iniciarPnlLibrosAutor();
        this.iniciarPnlTodosLibros(SesionActual);
    }//GEN-LAST:event_btn_libGuardarAutorMouseClicked

    private void btn_libActualizarAutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_libActualizarAutoMouseClicked
        if (!this.btn_libActualizarAuto.isEnabled()) {
            return;
        }
        int index = this.tbl_librosAutoSubidos.getSelectedRow();
        if (Controles.cadenaVacia(this.txt_libCodigoAutor.getText())
                || Controles.cadenaVacia(this.txt_libNombreAuto.getText())
                || Controles.cadenaVacia(this.cmb_libGenerosAutor.getSelectedItem().toString())
                || Controles.cadenaVacia(this.txt_libNumPagsAuto.getText())) {
            JOptionPane.showMessageDialog(this, "Llena todos los campos primero. . .");
            return;
        }
        if (Integer.parseInt(this.txt_libNumPagsAuto.getText()) > 5000) {
            JOptionPane.showMessageDialog(this, "Libros con mas de 5000 paginas no aceptados");
            return;
        }
        Libro librito = new Libro(
                this.txt_libCodigoAutor.getText(),
                SesionActual.getCorreo(),
                this.txt_libNombreAuto.getText(),
                this.cmb_libGenerosAutor.getSelectedItem().toString(),
                Integer.parseInt(this.txt_libNumPagsAuto.getText()),
                "NO");
        gestorBD.actualizarLibro(librito);
        Almacen.getInstance().libros.set(index, librito);
        this.iniciarPnlLibrosAutor();
        this.iniciarPnlTodosLibros(this.SesionActual);
        this.btn_libLimpiarAutoMouseClicked(evt);
    }//GEN-LAST:event_btn_libActualizarAutoMouseClicked

    private void btn_libEliminarAutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_libEliminarAutoMouseClicked
        if (this.btn_libEliminarAuto.isEnabled() == false) {
            return;
        }
        int index = this.tbl_librosAutoSubidos.getSelectedRow();
        gestorBD.eliminarLibro(this.libroSeleccionado.getCodigo());
        
        // Eliminar el libro del almacenamiento local (Almacen)
        GestorPrograma.eliminarLibro(this.txt_libCodigoAutor.getText());
        GestorPrograma.eliminarImagen(this.libroSeleccionado.getCodigo() + ".png");
        GestorPrograma.eliminarPDF(this.libroSeleccionado.getCodigo() + ".pdf");

        //eliminamos los prestamos con el codigo de ese libro
        gestorBD.eliminarPrestamosPorLibro(this.libroSeleccionado.getCodigo());
        GestorPrograma.eliminarPrestamosPorLibro(this.libroSeleccionado.getCodigo());

        //eliminamos los favoritos con el codigo de ese libro
        gestorBD.eliminarFavoritosPorLibro(this.libroSeleccionado.getCodigo());
        GestorPrograma.eliminarFavoritosPorLibro(this.libroSeleccionado.getCodigo());

        this.iniciarPnlLibrosAutor();
        this.iniciarPnlTodosLibros(SesionActual);
        this.iniciarPnlLibrosFav(SesionActual);
    }//GEN-LAST:event_btn_libEliminarAutoMouseClicked

    private void btn_libLimpiarAutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_libLimpiarAutoMouseClicked
        limpiarPnlLibrosAutores();
    }//GEN-LAST:event_btn_libLimpiarAutoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_libActualizarAuto;
    private javax.swing.JButton btn_libAgregarPdfAuto;
    public javax.swing.JButton btn_libAgregarPortadaAuto;
    public javax.swing.JButton btn_libAgregarPortadaAutor;
    private javax.swing.JButton btn_libEliminarAuto;
    private javax.swing.JButton btn_libGuardarAutor;
    private javax.swing.JButton btn_libLimpiarAuto;
    private javax.swing.JButton btn_libNuevoCodigo;
    private javax.swing.JComboBox<String> cmb_libGenerosAutor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_Libro;
    private javax.swing.JLabel lbl_MensajeBienvenida;
    private javax.swing.JLabel lbl_MensajeSeccion1;
    private javax.swing.JLabel lbl_MensajeSeccion2;
    private javax.swing.JLabel lbl_MensajeSeccion3;
    private javax.swing.JLabel lbl_MensajeSeccion4;
    private javax.swing.JLabel lbl_MensajeSeccion5;
    private javax.swing.JLabel lbl_Obras;
    private javax.swing.JLabel lbl_autoApellSalida1;
    private javax.swing.JLabel lbl_autoApellido;
    private javax.swing.JLabel lbl_autoCantObras;
    private javax.swing.JLabel lbl_autoCantObrasSalida2;
    private javax.swing.JLabel lbl_autoFechaNac;
    private javax.swing.JLabel lbl_autoFechaNacSalida4;
    private javax.swing.JLabel lbl_autoNombre1;
    private javax.swing.JLabel lbl_autoNombreSalida;
    private javax.swing.JLabel lbl_autoPais;
    private javax.swing.JLabel lbl_autoPaisSalida3;
    public javax.swing.JLabel lbl_btnCerrarSesion;
    private javax.swing.JLabel lbl_btnFavoritos;
    private javax.swing.JLabel lbl_btnLibros;
    private javax.swing.JLabel lbl_btnPerfil;
    private javax.swing.JLabel lbl_btnPrestamos;
    public javax.swing.JLabel lbl_btnSubirLibros;
    private javax.swing.JLabel lbl_libAutor;
    private javax.swing.JLabel lbl_libCodigoAuto;
    private javax.swing.JLabel lbl_libGenero;
    private javax.swing.JLabel lbl_libNombre;
    private javax.swing.JLabel lbl_libNombreArchivoPdf;
    private javax.swing.JLabel lbl_libNumPags;
    private javax.swing.JLabel lbl_libNumPags1;
    private javax.swing.JLabel lbl_libPortadaAuto;
    public javax.swing.JLabel lbl_libPortadaAutor;
    public javax.swing.JLabel lbl_portadaLibroAutores;
    private javax.swing.JTabbedPane pnlTb_MenuAutor;
    private javax.swing.JPanel pnl_Favoritos;
    private javax.swing.JPanel pnl_Libros;
    private javax.swing.JPanel pnl_LibrosAll;
    private javax.swing.JPanel pnl_LibrosAllFav;
    private javax.swing.JPanel pnl_Perfil;
    private javax.swing.JPanel pnl_Prestamos;
    private javax.swing.JPanel pnl_base;
    private javax.swing.JPanel pnl_navBar;
    private javax.swing.JPanel pnl_subirLibrosAutor;
    private javax.swing.JTable tbl_librosAutoSubidos;
    private javax.swing.JTable tbl_librosAutor;
    private javax.swing.JTextArea txtSinpsis;
    private javax.swing.JTextField txt_libCodigoAutor;
    private javax.swing.JTextField txt_libNombreAuto;
    private javax.swing.JTextField txt_libNumPagsAuto;
    private javax.swing.JTextField txt_nombreAutor;
    // End of variables declaration//GEN-END:variables

}
