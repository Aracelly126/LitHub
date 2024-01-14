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
        
        iniciarPnlPerfil();
        iniciarPnlTodosLibros();
        iniciarPnlLibrosFav();

        this.setVisible(true);
    }

    public void cerrarSesion() {
        this.dispose();
    }
    
    private void iniciarPnlPerfil() {
        this.lbl_autoNombreSalida.setText(this.SesionActual.getNombre().toUpperCase());
        this.lbl_autoApellSalida1.setText(this.SesionActual.getApellido().toUpperCase());
        this.lbl_autoFechaNacSalida4.setText(this.SesionActual.getFecNac());
        this.lbl_autoCantObrasSalida2.setText("12");
        this.lbl_autoPaisSalida3.setText(this.SesionActual.getPais().toUpperCase());
        boolean aux2 = ManejoComp.crearlabel(this.lbl_libPortadaAutor, "SYSTEM/Autores/" + this.SesionActual.getCorreo() + ".png");
        if (aux2 == false) {
            btn_libAgregarPortadaAutor.setEnabled(false);
        }

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
    private void mostrarDetalleLibro(Libro libro) {
        JFrame detalleFrame = new JFrame("Detalles del Libro");
        detalleFrame.setSize(300, 200);
        // Crear y agregar el panel de detalles
        DetallesLibro detallePanel = new DetallesLibro(libro.getNombre(), libro.getGenero());
        detalleFrame.add(detallePanel);

        detalleFrame.setLocationRelativeTo(null);
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
        lbl_libPortadaAutor = new javax.swing.JLabel();
        btn_libAgregarPortadaAutor = new javax.swing.JButton();
        lbl_autoCantObras = new javax.swing.JLabel();
        lbl_autoApellido = new javax.swing.JLabel();
        lbl_autoNombre1 = new javax.swing.JLabel();
        lbl_autoNombreSalida = new javax.swing.JLabel();
        lbl_autoApellSalida1 = new javax.swing.JLabel();
        lbl_autoFechaNac = new javax.swing.JLabel();
        lbl_autoPais = new javax.swing.JLabel();
        lbl_autoPaisSalida3 = new javax.swing.JLabel();
        lbl_autoFechaNacSalida4 = new javax.swing.JLabel();
        lbl_autoCantObrasSalida2 = new javax.swing.JLabel();
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

        lbl_MensajeBienvenida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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

        lbl_MensajeSeccion1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_MensajeSeccion1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MensajeSeccion1.setText("Seccion: Mi Perfil");
        pnl_Perfil.add(lbl_MensajeSeccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, -1, -1));

        lbl_libPortadaAutor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_Perfil.add(lbl_libPortadaAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 170, 210));

        btn_libAgregarPortadaAutor.setText("Agregar foto de perfil");
        btn_libAgregarPortadaAutor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_libAgregarPortadaAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_libAgregarPortadaAutorMouseClicked(evt);
            }
        });
        pnl_Perfil.add(btn_libAgregarPortadaAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 170, 30));

        lbl_autoCantObras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_autoCantObras.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoCantObras.setText("Cant Obras:");
        pnl_Perfil.add(lbl_autoCantObras, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 80, 30));

        lbl_autoApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_autoApellido.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoApellido.setText("Apellido:");
        pnl_Perfil.add(lbl_autoApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 80, 30));

        lbl_autoNombre1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_autoNombre1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoNombre1.setText("Nombre:");
        pnl_Perfil.add(lbl_autoNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 80, 30));

        lbl_autoNombreSalida.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_autoNombreSalida.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoNombreSalida.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_autoNombreSalida.setToolTipText("");
        pnl_Perfil.add(lbl_autoNombreSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 180, 30));

        lbl_autoApellSalida1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_autoApellSalida1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoApellSalida1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_autoApellSalida1.setToolTipText("");
        pnl_Perfil.add(lbl_autoApellSalida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 180, 30));

        lbl_autoFechaNac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_autoFechaNac.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoFechaNac.setText("Fecha Nac:");
        pnl_Perfil.add(lbl_autoFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 80, 32));

        lbl_autoPais.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_autoPais.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoPais.setText("Pais:");
        pnl_Perfil.add(lbl_autoPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, 80, 30));

        lbl_autoPaisSalida3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_autoPaisSalida3.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoPaisSalida3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_autoPaisSalida3.setToolTipText("");
        pnl_Perfil.add(lbl_autoPaisSalida3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, 180, 30));

        lbl_autoFechaNacSalida4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_autoFechaNacSalida4.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoFechaNacSalida4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_autoFechaNacSalida4.setToolTipText("");
        pnl_Perfil.add(lbl_autoFechaNacSalida4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 190, 180, 30));

        lbl_autoCantObrasSalida2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_autoCantObrasSalida2.setForeground(new java.awt.Color(0, 0, 0));
        lbl_autoCantObrasSalida2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_autoCantObrasSalida2.setToolTipText("");
        pnl_Perfil.add(lbl_autoCantObrasSalida2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 180, 30));

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

        pnl_Libros.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 80, 1200, 630));

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
        InfoLibros inf = new InfoLibros();
        JPanel panelLibros = new JPanel();
        panelLibros.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        //inf.mostrarLibros(panelLibros,PanelImg,lbNombreLibro, mostrarAutor, mostrarGenero, mostrarNumPaginas, pnlTb_Menu);

        this.pnl_Libros.setLayout(new BorderLayout());
        this.pnl_Libros.add(panelLibros, BorderLayout.CENTER);

        this.pnl_Libros.revalidate();
        this.pnl_Libros.repaint();
    }//GEN-LAST:event_lbl_btnLibrosMouseClicked

    private void lbl_btnFavoritosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnFavoritosMouseClicked
        this.pnlTb_Menu.setSelectedIndex(2);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_libAgregarPortadaAutor;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_MensajeBienvenida;
    private javax.swing.JLabel lbl_MensajeSeccion1;
    private javax.swing.JLabel lbl_MensajeSeccion2;
    private javax.swing.JLabel lbl_MensajeSeccion3;
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
    public javax.swing.JLabel lbl_libPortadaAutor;
    private javax.swing.JTabbedPane pnlTb_Menu;
    private javax.swing.JPanel pnl_Favoritos;
    private javax.swing.JPanel pnl_Libros;
    private javax.swing.JPanel pnl_LibrosAll;
    private javax.swing.JPanel pnl_LibrosAllFav;
    private javax.swing.JPanel pnl_Perfil;
    private javax.swing.JPanel pnl_base;
    private javax.swing.JPanel pnl_navBar;
    // End of variables declaration//GEN-END:variables
}
