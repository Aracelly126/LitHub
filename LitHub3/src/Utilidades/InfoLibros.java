/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import BaseDatos.GestorBD;
import Clases.Libro;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author thexe
 */
public class InfoLibros {

    private GestorBD gestorBD = new GestorBD();

    public void mostrarLibros(JPanel panelLibros, JPanel PanelImg, JLabel lbNombre, JLabel lbAutor, JLabel lbGenero, JLabel lbNumPaginas, JTabbedPane Menu) {
        panelLibros.removeAll();

        ArrayList<Libro> todosLosLibros = gestorBD.obtenerTodosLosLibros();

        for (Libro libro : todosLosLibros) {
            JLabel labelLibro = new JLabel(libro.getNombre());
            JLabel labelImagen = new JLabel(this.obtenerImagenLibroDesdeBaseDeDatos(libro.getCodigo(), 130, 170));
            System.out.println(libro.getCodigo());
            JPanel panelLibro = new JPanel(new BorderLayout());
            panelLibro.add(labelImagen, BorderLayout.CENTER);
            panelLibro.add(labelLibro, BorderLayout.SOUTH);

            panelLibro.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    mostrarInformacionLibro(libro, PanelImg, libro.getCodigo(), lbAutor, lbNombre, lbGenero, lbNumPaginas, Menu);
                }
            });

            panelLibros.add(panelLibro);
        }

        panelLibros.setLocation(panelLibros.getX(), 0);

        panelLibros.revalidate();
        panelLibros.repaint();
    }


    private ImageIcon obtenerImagenLibroDesdeBaseDeDatos(String codigoLibro, int ancho, int alto) {
        String rutaImagen = "SYSTEM/libros/" + codigoLibro + ".png";
        ImageIcon iconoOriginal = new ImageIcon(rutaImagen);

        Image imagenOriginal = iconoOriginal.getImage();
        Image imagenRedimensionada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

        return new ImageIcon(imagenRedimensionada);
    }

    private void mostrarInformacionLibro(Libro libro, JPanel Imagen2, String codigoLibro, JLabel labelAutor, JLabel labelNombre, JLabel labelGenero, JLabel labelNumPaginas, JTabbedPane Menu) {
        Imagen2.removeAll();
        labelAutor.setText("Autor");
        JLabel nuevaImagen = new JLabel(obtenerImagenLibroDesdeBaseDeDatos(codigoLibro, 130, 170));
        Imagen2.add(nuevaImagen, BorderLayout.CENTER);
        labelNombre.setText(libro.getNombre());
        labelGenero.setText(libro.getGenero());
        labelNumPaginas.setText(String.valueOf(libro.getNumPag()));

        Menu.setSelectedIndex(2);
        Imagen2.revalidate();
        Imagen2.repaint();
    }

}
