package Vista;

import BaseDatos.Almacen;
import BaseDatos.GestorBD;
import Clases.Favorito;
import Clases.Libro;
import Clases.Usuario;
import Utilidades.Controles;
import Utilidades.DetallesLibro;
import Utilidades.GestorPrograma;
import Utilidades.InfoLibros;
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

public class FrmLector extends javax.swing.JFrame {

    private Usuario SesionActual = new Usuario();
    private GestorBD gestorBD = new GestorBD();

    private String urlPortadaAutor = "";
    private String urlPortadaAutorSubir = "";
    private JPanel panelLibros;
    private JPanel panelLibrosFav;

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

        panelLibros = new JPanel();
        pnl_LibrosAll.setLayout(new BorderLayout());
        pnl_LibrosAll.add(panelLibros, BorderLayout.CENTER);

        //--------Libros Favoritos
        panelLibrosFav = new JPanel();
        pnl_LibrosAllFav.setLayout(new BorderLayout());
        pnl_LibrosAllFav.add(panelLibrosFav, BorderLayout.CENTER);

        ManejoComp.crearlabel(this.lbl_btnPerfil, "SYSTEM/src/ico_usuario.png");
        ManejoComp.crearlabel(this.lbl_btnLibros, "SYSTEM/src/ico_libro.png");
        ManejoComp.crearlabel(this.lbl_btnFavoritos, "SYSTEM/src/ico_favoritos.png");
        ManejoComp.crearlabel(this.lbl_btnCerrarSesion, "SYSTEM/src/ico_cerrarsesion.png");
    }

    public void iniciarVentana(String correoUser) {
        this.SesionActual = GestorPrograma.buscarUsuario(correoUser);
        System.out.println("Bienvenido: " + this.SesionActual.getNombre());

        this.iniciarPnlPerfil();
        this.limpiarPnlPerfil();
        iniciarPnlTodosLibros();
        iniciarPnlLibrosFav();

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
                    this.gestorBD.eliminarFavoritosPorLibro(fav.getCodigoLibro(), this.SesionActual.getCorreo());
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

    private void mostrarDetalleLibro(Libro libro) {
        JFrame detalleFrame = new JFrame("Detalles del Libro");
        detalleFrame.setSize(300, 200);
        // Crear y agregar el panel de detalles
        DetallesLibro detallePanel = new DetallesLibro(libro.getNombre(), libro.getSinopsis());
        detalleFrame.add(detallePanel);

        detalleFrame.setLocationRelativeTo(this);
        detalleFrame.setVisible(true);
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
        lbl_btnCerrarSesion = new javax.swing.JLabel();
        pnlTb_Menu = new javax.swing.JTabbedPane();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LibHub | Lector");
        setResizable(false);

        pnl_base.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeBienvenida.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lbl_MensajeBienvenida.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeBienvenida.setText("Iniciaste sesion como: LECTOR");
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

        lbl_btnCerrarSesion.setBackground(new java.awt.Color(36, 35, 53));
        lbl_btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl_navBar.add(lbl_btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 665, 50, 50));

        pnl_base.add(pnl_navBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 720));

        pnlTb_Menu.setTabPlacement(javax.swing.JTabbedPane.LEFT);

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
        pnl_Perfil.add(lbl_perCorreo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 110, 40));

        lbl_perCorreo2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_perCorreo2.setForeground(new java.awt.Color(0, 0, 0));
        lbl_perCorreo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnl_Perfil.add(lbl_perCorreo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 180, 40));

        lbl_perNombre.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_perNombre.setForeground(new java.awt.Color(0, 0, 0));
        lbl_perNombre.setText("Nombre:");
        pnl_Perfil.add(lbl_perNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 110, 40));

        txt_perNombre.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_perNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_perNombreKeyTyped(evt);
            }
        });
        pnl_Perfil.add(txt_perNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 180, 40));

        lbl_perApellido.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_perApellido.setForeground(new java.awt.Color(0, 0, 0));
        lbl_perApellido.setText("Apellido:");
        pnl_Perfil.add(lbl_perApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 110, 40));

        txt_perApellido.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_perApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_perApellidoKeyTyped(evt);
            }
        });
        pnl_Perfil.add(txt_perApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, 180, 40));

        lbl_perPais.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_perPais.setForeground(new java.awt.Color(0, 0, 0));
        lbl_perPais.setText("Pais:");
        pnl_Perfil.add(lbl_perPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 110, 40));

        txt_perPais.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txt_perPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_perPaisKeyTyped(evt);
            }
        });
        pnl_Perfil.add(txt_perPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 380, 180, 40));

        lbl_perFecNac1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_perFecNac1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_perFecNac1.setText("Fecha Nac:");
        pnl_Perfil.add(lbl_perFecNac1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 110, 40));

        lbl_perFecNac2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_perFecNac2.setForeground(new java.awt.Color(0, 0, 0));
        pnl_Perfil.add(lbl_perFecNac2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 440, 180, 40));

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
        pnl_Perfil.add(lbl_perCambioNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 260, 20, 20));

        lbl_perCambioApellido.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        lbl_perCambioApellido.setForeground(new java.awt.Color(255, 102, 102));
        lbl_perCambioApellido.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnl_Perfil.add(lbl_perCambioApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 320, 20, 20));

        lbl_perCambioPais.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        lbl_perCambioPais.setForeground(new java.awt.Color(255, 102, 102));
        lbl_perCambioPais.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnl_Perfil.add(lbl_perCambioPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 380, 20, 20));

        pnlTb_Menu.addTab("", pnl_Perfil);

        pnl_Libros.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Libros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeSeccion2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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

        pnlTb_Menu.addTab("", pnl_Libros);

        pnl_Favoritos.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Favoritos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MensajeSeccion3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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

        pnlTb_Menu.addTab("", pnl_Favoritos);

        pnl_base.add(pnlTb_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 1250, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_base, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pnl_base, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_perActualizar;
    public javax.swing.JButton btn_perAgregarNuevaFotoPerfil;
    private javax.swing.JButton btn_perDescartar;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_MensajeBienvenida;
    private javax.swing.JLabel lbl_MensajeSeccion1;
    private javax.swing.JLabel lbl_MensajeSeccion2;
    private javax.swing.JLabel lbl_MensajeSeccion3;
    public javax.swing.JLabel lbl_btnCerrarSesion;
    private javax.swing.JLabel lbl_btnFavoritos;
    private javax.swing.JLabel lbl_btnLibros;
    private javax.swing.JLabel lbl_btnPerfil;
    private javax.swing.JLabel lbl_perApellido;
    private javax.swing.JLabel lbl_perCambioApellido;
    private javax.swing.JLabel lbl_perCambioNombre;
    private javax.swing.JLabel lbl_perCambioPais;
    private javax.swing.JLabel lbl_perCorreo1;
    private javax.swing.JLabel lbl_perCorreo2;
    private javax.swing.JLabel lbl_perFecNac1;
    private javax.swing.JLabel lbl_perFecNac2;
    public javax.swing.JLabel lbl_perImagen;
    private javax.swing.JLabel lbl_perNombre;
    private javax.swing.JLabel lbl_perPais;
    private javax.swing.JTabbedPane pnlTb_Menu;
    private javax.swing.JPanel pnl_Favoritos;
    private javax.swing.JPanel pnl_Libros;
    private javax.swing.JPanel pnl_LibrosAll;
    private javax.swing.JPanel pnl_LibrosAllFav;
    private javax.swing.JPanel pnl_Perfil;
    private javax.swing.JPanel pnl_base;
    private javax.swing.JPanel pnl_navBar;
    private javax.swing.JTextField txt_perApellido;
    private javax.swing.JTextField txt_perNombre;
    private javax.swing.JTextField txt_perPais;
    // End of variables declaration//GEN-END:variables
}
