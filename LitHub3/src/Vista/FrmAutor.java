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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private String urlPortadaLibroSubir = "";
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
        ManejoComp.crearlabel(this.lbl_btnCerrarSesion, "SYSTEM/src/ico_cerrarsesion.png");
        ManejoComp.crearlabel(this.lbl_btnSubirLibros, "SYSTEM/src/icon_SubirLibro.png");

        //--------Libros responsives
        panelLibros = new JPanel();
        pnl_LibrosAll.setLayout(new BorderLayout());
        pnl_LibrosAll.add(panelLibros, BorderLayout.CENTER);

        //--------Libros Favoritos responsives
        panelLibrosFav = new JPanel();
        pnl_LibrosAllFav.setLayout(new BorderLayout());
        pnl_LibrosAllFav.add(panelLibrosFav, BorderLayout.CENTER);
    }

    public void iniciarVentana(String correoUser) {
        this.SesionActual = GestorPrograma.buscarUsuario(correoUser);
        System.out.println("Bienvenido: " + this.SesionActual.getNombre());

        this.iniciarPnlPerfil();
        this.limpiarPnlPerfil();
        iniciarPnlTodosLibros();
        iniciarPnlLibrosFav();
        iniciarPnlSubirLibro();

        this.setVisible(true);
    }

    public void cerrarSesion() {
        this.dispose();
    }

    private void iniciarPnlPerfil() {
        ManejoComp.crearlabel(this.lbl_perImagen, "SYSTEM/usuarios/" + this.SesionActual.getCorreo() + ".png");

        this.lbl_perCorreo2.setText(this.SesionActual.getCorreo());
        this.txt_perNombre.setText(this.SesionActual.getNombre());
        this.txt_perApellido.setText(this.SesionActual.getApellido());
        this.txt_perPais.setText(this.SesionActual.getPais());
        this.lbl_perFecNac2.setText(this.SesionActual.getFecNac());
        this.lbl_perCantObras2.setText(String.valueOf(this.gestorBD.obtenerNumeroLibrosPorCorreo(this.SesionActual.getCorreo())));
    }

    public void limpiarPnlPerfil() {
        this.lbl_perCambioNombre.setText("");
        this.lbl_perCambioApellido.setText("");
        this.lbl_perCambioPais.setText("");

        this.btn_perActualizar.setEnabled(false);
    }

    private void iniciarPnlTodosLibros() {
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
                    iniciarPnlLibrosFav();
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

    private void iniciarPnlLibrosFav() {
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
                    iniciarPnlLibrosFav();
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

    private void iniciarPnlSubirLibro() {
        ManejoComp.vaciarTabla(this.tbl_misLibros, this.modelTblLibrosAutor);
        for (Libro libro : Almacen.getInstance().libros) {
            if (libro.getCorreoUsu().equals(this.SesionActual.getCorreo())) {
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

    private void mostrarDetalleLibro(Libro libro) {
        JFrame detalleFrame = new JFrame("Detalles del Libro");
        detalleFrame.setSize(300, 200);
        // Crear y agregar el panel de detalles
        DetallesLibro detallePanel = new DetallesLibro(libro.getNombre(), libro.getGenero());
        detalleFrame.add(detallePanel);

        detalleFrame.setLocationRelativeTo(null);
        detalleFrame.setVisible(true);
    }

    public void limpiarPnlLibrosAutores() {
        this.libroSeleccionado = null;
        this.urlPortadaLibroSubir = "";
        this.urlPdfAutor = "";
        ManejoComp.crearlabel(this.lbl_miLibPortada, "");
        this.lbl_miLibNombreArchivoPdf.setText("");
        this.txt_miLibCodigo.setText("");
        this.txt_miLibAutor.setText("");
        this.txt_miLibNombre.setText("");
        this.cmb_miLibGenero.setSelectedIndex(0);
        this.txt_miLibNumPags.setText("");

        this.btn_miLibGuardar.setEnabled(true);
        this.btn_miLibAgregarPortadaLibro.setEnabled(true);
        this.btn_miLibAgregarPdfLibro.setEnabled(true);
        this.btn_miLibEliminar.setEnabled(false);
        this.btn_miLibActualizar.setEnabled(false);
        this.btn_miLibNuevoCodigo.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_base = new javax.swing.JPanel();
        lbl_MensajeBienvenida = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        pnl_navBar = new javax.swing.JPanel();
        lbl_btnPerfil = new javax.swing.JLabel();
        lbl_btnLibros = new javax.swing.JLabel();
        lbl_btnFavoritos = new javax.swing.JLabel();
        lbl_btnSubirLibros = new javax.swing.JLabel();
        lbl_btnCerrarSesion = new javax.swing.JLabel();
        pnlTb_MenuAutor = new javax.swing.JTabbedPane();
        pnl_Perfil = new javax.swing.JPanel();
        lbl_MensajeSeccion1 = new javax.swing.JLabel();
        lbl_perImagen = new javax.swing.JLabel();
        btn_perAgregarNuevaFotoPerfil = new javax.swing.JButton();
        lbl_perCorreo1 = new javax.swing.JLabel();
        lbl_perCorreo2 = new javax.swing.JLabel();
        lbl_perNombre = new javax.swing.JLabel();
        txt_perNombre = new javax.swing.JTextField();
        lbl_perApellido = new javax.swing.JLabel();
        txt_perApellido = new javax.swing.JTextField();
        lbl_perPais = new javax.swing.JLabel();
        txt_perPais = new javax.swing.JTextField();
        lbl_perFecNac1 = new javax.swing.JLabel();
        lbl_perFecNac2 = new javax.swing.JLabel();
        lbl_perCantObras1 = new javax.swing.JLabel();
        lbl_perCantObras2 = new javax.swing.JLabel();
        btn_perActualizar = new javax.swing.JButton();
        btn_perDescartar = new javax.swing.JButton();
        lbl_perCambioNombre = new javax.swing.JLabel();
        lbl_perCambioApellido = new javax.swing.JLabel();
        lbl_perCambioPais = new javax.swing.JLabel();
        pnl_Libros = new javax.swing.JPanel();
        lbl_MensajeSeccion2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        pnl_LibrosAll = new javax.swing.JPanel();
        pnl_Favoritos = new javax.swing.JPanel();
        lbl_MensajeSeccion3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        pnl_LibrosAllFav = new javax.swing.JPanel();
        pnl_nuevoLibro = new javax.swing.JPanel();
        lbl_MensajeSeccion4 = new javax.swing.JLabel();
        lbl_miLibPortada = new javax.swing.JLabel();
        btn_miLibAgregarPortadaLibro = new javax.swing.JButton();
        btn_miLibAgregarPdfLibro = new javax.swing.JButton();
        lbl_miLibNombreArchivoPdf = new javax.swing.JLabel();
        btn_miLibNuevoCodigo = new javax.swing.JButton();
        lbl_miLibCodigo = new javax.swing.JLabel();
        txt_miLibCodigo = new javax.swing.JTextField();
        lbl_miLibAutor = new javax.swing.JLabel();
        txt_miLibAutor = new javax.swing.JTextField();
        lbl_miLibNombre = new javax.swing.JLabel();
        txt_miLibNombre = new javax.swing.JTextField();
        lbl_miLibGenero = new javax.swing.JLabel();
        cmb_miLibGenero = new javax.swing.JComboBox<>();
        lbl_miLibNumPags = new javax.swing.JLabel();
        txt_miLibNumPags = new javax.swing.JTextField();
        lbl_miLibSinopsis = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtSinpsis = new javax.swing.JTextArea();
        btn_miLibGuardar = new javax.swing.JButton();
        btn_miLibActualizar = new javax.swing.JButton();
        btn_miLibEliminar = new javax.swing.JButton();
        btn_miLibLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_misLibros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LibHub | Autor");
        setResizable(false);

        pnl_base.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeBienvenida.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lbl_MensajeBienvenida.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeBienvenida.setText("Iniciaste sesion como: AUTOR");
        pnl_base.add(lbl_MensajeBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 153, 153));
        jSeparator2.setForeground(new java.awt.Color(0, 153, 153));
        pnl_base.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 1200, 10));

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

        lbl_btnSubirLibros.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnSubirLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_btnSubirLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnSubirLibrosMouseClicked(evt);
            }
        });
        pnl_navBar.add(lbl_btnSubirLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 270, 50, 50));

        lbl_btnCerrarSesion.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl_navBar.add(lbl_btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 665, 50, 50));

        pnl_base.add(pnl_navBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 720));

        pnlTb_MenuAutor.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        pnl_Perfil.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Perfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeSeccion1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lbl_MensajeSeccion1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeSeccion1.setText("Seccion: Mi Perfil");
        pnl_Perfil.add(lbl_MensajeSeccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, -1, -1));

        lbl_perImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_Perfil.add(lbl_perImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 170, 210));

        btn_perAgregarNuevaFotoPerfil.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_perAgregarNuevaFotoPerfil.setText("Seleccionar foto");
        btn_perAgregarNuevaFotoPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_perAgregarNuevaFotoPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_perAgregarNuevaFotoPerfilMouseClicked(evt);
            }
        });
        pnl_Perfil.add(btn_perAgregarNuevaFotoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 170, 35));

        lbl_perCorreo1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_perCorreo1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_perCorreo1.setText("Correo:");
        pnl_Perfil.add(lbl_perCorreo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 110, 40));

        lbl_perCorreo2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_perCorreo2.setForeground(new java.awt.Color(0, 0, 0));
        lbl_perCorreo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnl_Perfil.add(lbl_perCorreo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, 180, 40));

        lbl_perNombre.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_perNombre.setForeground(new java.awt.Color(0, 0, 0));
        lbl_perNombre.setText("Nombre:");
        pnl_Perfil.add(lbl_perNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 110, 40));

        txt_perNombre.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_perNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_perNombreKeyTyped(evt);
            }
        });
        pnl_Perfil.add(txt_perNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 180, 40));

        lbl_perApellido.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_perApellido.setForeground(new java.awt.Color(0, 0, 0));
        lbl_perApellido.setText("Apellido:");
        pnl_Perfil.add(lbl_perApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 110, 40));

        txt_perApellido.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_perApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_perApellidoKeyTyped(evt);
            }
        });
        pnl_Perfil.add(txt_perApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 180, 40));

        lbl_perPais.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_perPais.setForeground(new java.awt.Color(0, 0, 0));
        lbl_perPais.setText("Pais:");
        pnl_Perfil.add(lbl_perPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 110, 40));

        txt_perPais.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_perPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_perPaisKeyTyped(evt);
            }
        });
        pnl_Perfil.add(txt_perPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 180, 40));

        lbl_perFecNac1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_perFecNac1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_perFecNac1.setText("Fecha Nac:");
        pnl_Perfil.add(lbl_perFecNac1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, 110, 40));

        lbl_perFecNac2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_perFecNac2.setForeground(new java.awt.Color(0, 0, 0));
        pnl_Perfil.add(lbl_perFecNac2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, 180, 40));

        lbl_perCantObras1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_perCantObras1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_perCantObras1.setText("Cant Obras:");
        pnl_Perfil.add(lbl_perCantObras1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 460, 110, 40));

        lbl_perCantObras2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_perCantObras2.setForeground(new java.awt.Color(0, 0, 0));
        lbl_perCantObras2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnl_Perfil.add(lbl_perCantObras2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 460, 180, 40));

        btn_perActualizar.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_perActualizar.setText("Actualizar perfil");
        btn_perActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_perActualizarMouseClicked(evt);
            }
        });
        pnl_Perfil.add(btn_perActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 630, 190, 35));

        btn_perDescartar.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_perDescartar.setText("Descartar Cambios");
        btn_perDescartar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_perDescartarMouseClicked(evt);
            }
        });
        pnl_Perfil.add(btn_perDescartar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 630, 190, 35));

        lbl_perCambioNombre.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        lbl_perCambioNombre.setForeground(new java.awt.Color(255, 102, 102));
        lbl_perCambioNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnl_Perfil.add(lbl_perCambioNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 225, 20, 20));

        lbl_perCambioApellido.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        lbl_perCambioApellido.setForeground(new java.awt.Color(255, 102, 102));
        lbl_perCambioApellido.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnl_Perfil.add(lbl_perCambioApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 285, 20, 20));

        lbl_perCambioPais.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        lbl_perCambioPais.setForeground(new java.awt.Color(255, 102, 102));
        lbl_perCambioPais.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnl_Perfil.add(lbl_perCambioPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 345, 20, 20));

        pnlTb_MenuAutor.addTab("", pnl_Perfil);

        pnl_Libros.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Libros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeSeccion2.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lbl_MensajeSeccion2.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeSeccion2.setText("Seccion: Libros");
        pnl_Libros.add(lbl_MensajeSeccion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, -1, -1));

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnl_LibrosAll.setBackground(new java.awt.Color(255, 255, 255));
        pnl_LibrosAll.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl_LibrosAll.setMinimumSize(new java.awt.Dimension(1216, 720));
        pnl_LibrosAll.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane4.setViewportView(pnl_LibrosAll);

        pnl_Libros.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 90, 1200, 620));

        pnlTb_MenuAutor.addTab("", pnl_Libros);

        pnl_Favoritos.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Favoritos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeSeccion3.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lbl_MensajeSeccion3.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeSeccion3.setText("Seccion: Mis favoritos");
        pnl_Favoritos.add(lbl_MensajeSeccion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, -1, -1));

        jScrollPane5.setBorder(null);
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnl_LibrosAllFav.setBackground(new java.awt.Color(255, 255, 255));
        pnl_LibrosAllFav.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl_LibrosAllFav.setMinimumSize(new java.awt.Dimension(1216, 720));
        pnl_LibrosAllFav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane5.setViewportView(pnl_LibrosAllFav);

        pnl_Favoritos.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 90, 1200, 620));

        pnlTb_MenuAutor.addTab("", pnl_Favoritos);

        pnl_nuevoLibro.setBackground(new java.awt.Color(255, 255, 255));
        pnl_nuevoLibro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeSeccion4.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lbl_MensajeSeccion4.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeSeccion4.setText("Seccion Agregar nuevos Libros");
        pnl_nuevoLibro.add(lbl_MensajeSeccion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, -1, -1));

        lbl_miLibPortada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_nuevoLibro.add(lbl_miLibPortada, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 170, 210));

        btn_miLibAgregarPortadaLibro.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_miLibAgregarPortadaLibro.setText("Agregar portada");
        btn_miLibAgregarPortadaLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_miLibAgregarPortadaLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_miLibAgregarPortadaLibroMouseClicked(evt);
            }
        });
        pnl_nuevoLibro.add(btn_miLibAgregarPortadaLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 170, 30));

        btn_miLibAgregarPdfLibro.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_miLibAgregarPdfLibro.setText("Agregar pdf");
        btn_miLibAgregarPdfLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_miLibAgregarPdfLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_miLibAgregarPdfLibroMouseClicked(evt);
            }
        });
        pnl_nuevoLibro.add(btn_miLibAgregarPdfLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 170, 30));
        pnl_nuevoLibro.add(lbl_miLibNombreArchivoPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 200, 30));

        btn_miLibNuevoCodigo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btn_miLibNuevoCodigo.setText("Nuevo");
        btn_miLibNuevoCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_miLibNuevoCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_miLibNuevoCodigoMouseClicked(evt);
            }
        });
        pnl_nuevoLibro.add(btn_miLibNuevoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 80, 30));

        lbl_miLibCodigo.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_miLibCodigo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_miLibCodigo.setText("Codigo:");
        pnl_nuevoLibro.add(lbl_miLibCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 120, 40));

        txt_miLibCodigo.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_miLibCodigo.setEnabled(false);
        txt_miLibCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_miLibCodigoKeyTyped(evt);
            }
        });
        pnl_nuevoLibro.add(txt_miLibCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 300, 40));

        lbl_miLibAutor.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_miLibAutor.setForeground(new java.awt.Color(0, 0, 0));
        lbl_miLibAutor.setText("Autor:");
        pnl_nuevoLibro.add(lbl_miLibAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 120, 40));

        txt_miLibAutor.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_miLibAutor.setEnabled(false);
        pnl_nuevoLibro.add(txt_miLibAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 300, 40));

        lbl_miLibNombre.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_miLibNombre.setForeground(new java.awt.Color(0, 0, 0));
        lbl_miLibNombre.setText("Nombre:");
        pnl_nuevoLibro.add(lbl_miLibNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 120, 40));

        txt_miLibNombre.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_miLibNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_miLibNombreKeyTyped(evt);
            }
        });
        pnl_nuevoLibro.add(txt_miLibNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 300, 40));

        lbl_miLibGenero.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_miLibGenero.setForeground(new java.awt.Color(0, 0, 0));
        lbl_miLibGenero.setText("Genero:");
        pnl_nuevoLibro.add(lbl_miLibGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 120, 40));

        cmb_miLibGenero.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        cmb_miLibGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Drama", "Novela", "Ficticio" }));
        pnl_nuevoLibro.add(cmb_miLibGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 300, 40));

        lbl_miLibNumPags.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_miLibNumPags.setForeground(new java.awt.Color(0, 0, 0));
        lbl_miLibNumPags.setText("Num paginas:");
        pnl_nuevoLibro.add(lbl_miLibNumPags, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 120, 40));

        txt_miLibNumPags.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_miLibNumPags.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_miLibNumPagsKeyTyped(evt);
            }
        });
        pnl_nuevoLibro.add(txt_miLibNumPags, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 300, 40));

        lbl_miLibSinopsis.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_miLibSinopsis.setForeground(new java.awt.Color(0, 0, 0));
        lbl_miLibSinopsis.setText("Sinopsis");
        pnl_nuevoLibro.add(lbl_miLibSinopsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 100, 30));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtSinpsis.setColumns(20);
        txtSinpsis.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txtSinpsis.setLineWrap(true);
        txtSinpsis.setRows(5);
        txtSinpsis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSinpsisKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(txtSinpsis);

        pnl_nuevoLibro.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, 272, 210));

        btn_miLibGuardar.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_miLibGuardar.setText("Guardar");
        btn_miLibGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_miLibGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_miLibGuardarMouseClicked(evt);
            }
        });
        pnl_nuevoLibro.add(btn_miLibGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 170, 120, 35));

        btn_miLibActualizar.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_miLibActualizar.setText("Actualizar");
        btn_miLibActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_miLibActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_miLibActualizarMouseClicked(evt);
            }
        });
        pnl_nuevoLibro.add(btn_miLibActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 220, 120, 35));

        btn_miLibEliminar.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_miLibEliminar.setText("Eliminar");
        btn_miLibEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_miLibEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_miLibEliminarMouseClicked(evt);
            }
        });
        pnl_nuevoLibro.add(btn_miLibEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 270, 120, 35));

        btn_miLibLimpiar.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_miLibLimpiar.setText("Limpiar");
        btn_miLibLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_miLibLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_miLibLimpiarMouseClicked(evt);
            }
        });
        pnl_nuevoLibro.add(btn_miLibLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 320, 120, 35));

        tbl_misLibros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_misLibros.setModel(this.modelTblLibrosAutor);
        tbl_misLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_misLibrosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_misLibros);

        pnl_nuevoLibro.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 440, 1200, 270));

        pnlTb_MenuAutor.addTab("", pnl_nuevoLibro);

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
        this.pnlTb_MenuAutor.setSelectedIndex(0);
    }//GEN-LAST:event_lbl_btnPerfilMouseClicked

    private void lbl_btnLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnLibrosMouseClicked
        this.pnlTb_MenuAutor.setSelectedIndex(1);
    }//GEN-LAST:event_lbl_btnLibrosMouseClicked

    private void lbl_btnFavoritosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnFavoritosMouseClicked
        this.pnlTb_MenuAutor.setSelectedIndex(2);
    }//GEN-LAST:event_lbl_btnFavoritosMouseClicked

    private void btn_perAgregarNuevaFotoPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_perAgregarNuevaFotoPerfilMouseClicked
        if (this.btn_perAgregarNuevaFotoPerfil.isEnabled() == false) {
            return;
        }
        this.urlPortadaAutor = GestorPrograma.seleccionarImagen();
        if (Controles.cadenaVacia(this.urlPortadaAutor)) {
            return;
        }
        ManejoComp.crearlabel(this.lbl_perImagen, this.urlPortadaAutor);
        GestorPrograma.almacenarImagenUsuarios(urlPortadaAutor, this.SesionActual.getCorreo() + ".png");

    }//GEN-LAST:event_btn_perAgregarNuevaFotoPerfilMouseClicked

    private void txt_miLibCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_miLibCodigoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_miLibCodigoKeyTyped

    private void lbl_btnSubirLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnSubirLibrosMouseClicked
        this.pnlTb_MenuAutor.setSelectedIndex(3);
    }//GEN-LAST:event_lbl_btnSubirLibrosMouseClicked

    private void btn_miLibAgregarPortadaLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_miLibAgregarPortadaLibroMouseClicked
        if (this.btn_miLibAgregarPortadaLibro.isEnabled() == false) {
            return;
        }
        this.urlPortadaLibroSubir = GestorPrograma.seleccionarImagen();
        if (Controles.cadenaVacia(this.urlPortadaLibroSubir)) {
            return;
        }
        ManejoComp.crearlabel(this.lbl_miLibPortada, this.urlPortadaLibroSubir);
        this.btn_miLibAgregarPortadaLibro.setEnabled(false);
    }//GEN-LAST:event_btn_miLibAgregarPortadaLibroMouseClicked

    private void btn_miLibAgregarPdfLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_miLibAgregarPdfLibroMouseClicked
        if (this.btn_miLibAgregarPdfLibro.isEnabled() == false) {
            return;
        }
        this.urlPdfAutor = GestorPrograma.seleccionarPDF();
        if (Controles.cadenaVacia(this.urlPdfAutor)) {
            return;
        }
        this.lbl_miLibNombreArchivoPdf.setText(this.urlPdfAutor);
        this.btn_miLibAgregarPdfLibro.setEnabled(false);
    }//GEN-LAST:event_btn_miLibAgregarPdfLibroMouseClicked

    private void btn_miLibNuevoCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_miLibNuevoCodigoMouseClicked
        if (this.btn_miLibNuevoCodigo.isEnabled() == false) {
            return;
        }
        this.txt_miLibCodigo.setText(GestorPrograma.generarCadenaNumAleatoria(10));
        this.txt_miLibAutor.setText(SesionActual.getNombre());

    }//GEN-LAST:event_btn_miLibNuevoCodigoMouseClicked

    private void txt_miLibNumPagsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_miLibNumPagsKeyTyped
        ManejoComp.txtOnlyNumbers(evt);
        ManejoComp.txtLongitudCondicion(this.txt_miLibNumPags, evt, 4);
    }//GEN-LAST:event_txt_miLibNumPagsKeyTyped

    private void txt_miLibNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_miLibNombreKeyTyped
        ManejoComp.txtLongitudCondicion(this.txt_miLibNombre, evt, 50);
    }//GEN-LAST:event_txt_miLibNombreKeyTyped

    private void tbl_misLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_misLibrosMouseClicked
        int index = this.tbl_misLibros.getSelectedRow();

        this.libroSeleccionado = GestorPrograma.buscarLibro((String) this.modelTblLibrosAutor.getValueAt(index, 0));
        //Usuario autor = GestorPrograma.buscarUsuario(this.libroSeleccionado.getCorreoUsu());

        this.txt_miLibCodigo.setText(this.libroSeleccionado.getCodigo());
        this.txt_miLibAutor.setText(this.libroSeleccionado.getCorreoUsu());
        this.txt_miLibNombre.setText(this.libroSeleccionado.getNombre());
        this.cmb_miLibGenero.setSelectedItem(this.libroSeleccionado.getGenero());
        this.txt_miLibNumPags.setText(String.valueOf(this.libroSeleccionado.getNumPag()));
        this.txtSinpsis.setText(this.libroSeleccionado.getSinopsis());

        ManejoComp.crearlabel(this.lbl_miLibPortada, "SYSTEM/libros/" + this.txt_miLibCodigo.getText() + ".png");
        //System.out.println("El codigo del libro es este para buscar y mostrar en el lbl tbLibrosAutoSubidos"+Almacen.getInstance().libros.get(index).getCodigo());
        this.btn_miLibEliminar.setEnabled(true);
        this.btn_miLibActualizar.setEnabled(true);
    }//GEN-LAST:event_tbl_misLibrosMouseClicked

    private void btn_miLibGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_miLibGuardarMouseClicked
        if (!this.btn_miLibGuardar.isEnabled()) {
            return;
        }
        if (Controles.cadenaVacia(this.txt_miLibCodigo.getText())
                || Controles.cadenaVacia(this.cmb_miLibGenero.getSelectedItem().toString())
                || Controles.cadenaVacia(this.txt_miLibNombre.getText())
                || Controles.cadenaVacia(this.txt_miLibNumPags.getText())) {
            JOptionPane.showMessageDialog(this, "Llena todos los campos primero. . .");
            return;
        }
        if (Controles.cadenaVacia(this.urlPortadaLibroSubir) || Controles.cadenaVacia(this.urlPdfAutor)) {
            JOptionPane.showMessageDialog(this, "Portada o PDF faltantes, intenta de nuevo. . .");
            return;
        }
        if (Integer.parseInt(this.txt_miLibNumPags.getText()) > 5000) {
            JOptionPane.showMessageDialog(this, "Libros con mas de 5000 paginas no aceptados");
            return;
        }
        Libro librito = new Libro(
                this.txt_miLibCodigo.getText(),
                SesionActual.getCorreo(),
                this.txt_miLibNombre.getText(),
                this.cmb_miLibGenero.getSelectedItem().toString(),
                Integer.parseInt(this.txt_miLibNumPags.getText()),
                this.txtSinpsis.getText());
        //"INSERT INTO LIBROS (CODIGO, CORREO_USU, NOMBRE, GENERO, NUM_PAG) VALUES (?, ?, ?, ?, ?)";

        this.gestorBD.agregarLibro(librito);
        Almacen.getInstance().libros.add(librito);
        GestorPrograma.almacenarImagen(this.urlPortadaLibroSubir, this.txt_miLibCodigo.getText() + ".png");
        GestorPrograma.almacenarPDF(this.urlPdfAutor, this.txt_miLibCodigo.getText() + ".pdf");

        this.iniciarPnlSubirLibro();
        this.iniciarPnlTodosLibros();
    }//GEN-LAST:event_btn_miLibGuardarMouseClicked

    private void btn_miLibActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_miLibActualizarMouseClicked
        if (!this.btn_miLibActualizar.isEnabled()) {
            return;
        }
        int index = this.tbl_misLibros.getSelectedRow();
        if (Controles.cadenaVacia(this.txt_miLibCodigo.getText())
                || Controles.cadenaVacia(this.txt_miLibNombre.getText())
                || Controles.cadenaVacia(this.cmb_miLibGenero.getSelectedItem().toString())
                || Controles.cadenaVacia(this.txt_miLibNumPags.getText())) {
            JOptionPane.showMessageDialog(this, "Llena todos los campos primero. . .");
            return;
        }
        if (Integer.parseInt(this.txt_miLibNumPags.getText()) > 5000) {
            JOptionPane.showMessageDialog(this, "Libros con mas de 5000 paginas no aceptados");
            return;
        }
        Libro librito = new Libro(
                this.txt_miLibCodigo.getText(),
                SesionActual.getCorreo(),
                this.txt_miLibNombre.getText(),
                this.cmb_miLibGenero.getSelectedItem().toString(),
                Integer.parseInt(this.txt_miLibNumPags.getText()),
                this.txtSinpsis.getText());
        this.gestorBD.actualizarLibro(librito);
        GestorPrograma.actualizarLibro(librito);
        this.iniciarPnlSubirLibro();
        this.iniciarPnlTodosLibros();
        this.btn_miLibLimpiarMouseClicked(evt);
    }//GEN-LAST:event_btn_miLibActualizarMouseClicked

    private void btn_miLibEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_miLibEliminarMouseClicked
        if (this.btn_miLibEliminar.isEnabled() == false) {
            return;
        }
        int index = this.tbl_misLibros.getSelectedRow();
        gestorBD.eliminarLibro(this.libroSeleccionado.getCodigo());

        // Eliminar el libro del almacenamiento local (Almacen)
        GestorPrograma.eliminarLibro(this.txt_miLibCodigo.getText());
        GestorPrograma.eliminarImagen(this.libroSeleccionado.getCodigo() + ".png");
        GestorPrograma.eliminarPDF(this.libroSeleccionado.getCodigo() + ".pdf");

        //eliminamos los favoritos con el codigo de ese libro
        gestorBD.eliminarFavoritosPorLibro(this.libroSeleccionado.getCodigo());
        GestorPrograma.eliminarFavoritosPorLibro(this.libroSeleccionado.getCodigo());

        this.iniciarPnlSubirLibro();
        this.iniciarPnlTodosLibros();
        this.iniciarPnlLibrosFav();
    }//GEN-LAST:event_btn_miLibEliminarMouseClicked

    private void btn_miLibLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_miLibLimpiarMouseClicked
        limpiarPnlLibrosAutores();
    }//GEN-LAST:event_btn_miLibLimpiarMouseClicked

    private void btn_perActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_perActualizarMouseClicked
        if (this.btn_perActualizar.isEnabled() == false) {
            return;
        }
        if (Controles.cadenaVacia(this.txt_perNombre.getText())
                || Controles.cadenaVacia(this.txt_perApellido.getText())
                || Controles.cadenaVacia(this.txt_perPais.getText())) {
            JOptionPane.showMessageDialog(this, "No se admiten espacios en blanco. . .");
            return;
        }
        String nuevoNombre = this.txt_perNombre.getText();
        String nuevoApellido = this.txt_perApellido.getText();
        String nuevoPais = this.txt_perPais.getText();
        this.SesionActual.setNombre(nuevoNombre);
        this.SesionActual.setApellido(nuevoApellido);
        this.SesionActual.setPais(nuevoPais);

        this.gestorBD.actualizarUsuario(this.SesionActual);
        GestorPrograma.actualizarUsuario(this.SesionActual);

        this.iniciarPnlPerfil();
        this.limpiarPnlPerfil();
    }//GEN-LAST:event_btn_perActualizarMouseClicked

    private void btn_perDescartarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_perDescartarMouseClicked
        this.iniciarPnlPerfil();
        this.limpiarPnlPerfil();
    }//GEN-LAST:event_btn_perDescartarMouseClicked

    private void txt_perNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_perNombreKeyTyped
        this.lbl_perCambioNombre.setText("\u2022");
        this.btn_perActualizar.setEnabled(true);
    }//GEN-LAST:event_txt_perNombreKeyTyped

    private void txt_perApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_perApellidoKeyTyped
        this.lbl_perCambioApellido.setText("\u2022");
        this.btn_perActualizar.setEnabled(true);
    }//GEN-LAST:event_txt_perApellidoKeyTyped

    private void txt_perPaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_perPaisKeyTyped
        this.lbl_perCambioPais.setText("\u2022");
        this.btn_perActualizar.setEnabled(true);
    }//GEN-LAST:event_txt_perPaisKeyTyped

    private void txtSinpsisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSinpsisKeyTyped
        ManejoComp.textAreaLongitudCondicion(this.txtSinpsis, evt, 200);
    }//GEN-LAST:event_txtSinpsisKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_miLibActualizar;
    private javax.swing.JButton btn_miLibAgregarPdfLibro;
    public javax.swing.JButton btn_miLibAgregarPortadaLibro;
    private javax.swing.JButton btn_miLibEliminar;
    private javax.swing.JButton btn_miLibGuardar;
    private javax.swing.JButton btn_miLibLimpiar;
    private javax.swing.JButton btn_miLibNuevoCodigo;
    private javax.swing.JButton btn_perActualizar;
    public javax.swing.JButton btn_perAgregarNuevaFotoPerfil;
    private javax.swing.JButton btn_perDescartar;
    private javax.swing.JComboBox<String> cmb_miLibGenero;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_MensajeBienvenida;
    private javax.swing.JLabel lbl_MensajeSeccion1;
    private javax.swing.JLabel lbl_MensajeSeccion2;
    private javax.swing.JLabel lbl_MensajeSeccion3;
    private javax.swing.JLabel lbl_MensajeSeccion4;
    public javax.swing.JLabel lbl_btnCerrarSesion;
    private javax.swing.JLabel lbl_btnFavoritos;
    private javax.swing.JLabel lbl_btnLibros;
    private javax.swing.JLabel lbl_btnPerfil;
    public javax.swing.JLabel lbl_btnSubirLibros;
    private javax.swing.JLabel lbl_miLibAutor;
    private javax.swing.JLabel lbl_miLibCodigo;
    private javax.swing.JLabel lbl_miLibGenero;
    private javax.swing.JLabel lbl_miLibNombre;
    private javax.swing.JLabel lbl_miLibNombreArchivoPdf;
    private javax.swing.JLabel lbl_miLibNumPags;
    private javax.swing.JLabel lbl_miLibPortada;
    private javax.swing.JLabel lbl_miLibSinopsis;
    private javax.swing.JLabel lbl_perApellido;
    private javax.swing.JLabel lbl_perCambioApellido;
    private javax.swing.JLabel lbl_perCambioNombre;
    private javax.swing.JLabel lbl_perCambioPais;
    private javax.swing.JLabel lbl_perCantObras1;
    private javax.swing.JLabel lbl_perCantObras2;
    private javax.swing.JLabel lbl_perCorreo1;
    private javax.swing.JLabel lbl_perCorreo2;
    private javax.swing.JLabel lbl_perFecNac1;
    private javax.swing.JLabel lbl_perFecNac2;
    public javax.swing.JLabel lbl_perImagen;
    private javax.swing.JLabel lbl_perNombre;
    private javax.swing.JLabel lbl_perPais;
    private javax.swing.JTabbedPane pnlTb_MenuAutor;
    private javax.swing.JPanel pnl_Favoritos;
    private javax.swing.JPanel pnl_Libros;
    private javax.swing.JPanel pnl_LibrosAll;
    private javax.swing.JPanel pnl_LibrosAllFav;
    private javax.swing.JPanel pnl_Perfil;
    private javax.swing.JPanel pnl_base;
    private javax.swing.JPanel pnl_navBar;
    private javax.swing.JPanel pnl_nuevoLibro;
    private javax.swing.JTable tbl_misLibros;
    private javax.swing.JTextArea txtSinpsis;
    private javax.swing.JTextField txt_miLibAutor;
    private javax.swing.JTextField txt_miLibCodigo;
    private javax.swing.JTextField txt_miLibNombre;
    private javax.swing.JTextField txt_miLibNumPags;
    private javax.swing.JTextField txt_perApellido;
    private javax.swing.JTextField txt_perNombre;
    private javax.swing.JTextField txt_perPais;
    // End of variables declaration//GEN-END:variables

}
