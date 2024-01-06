/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author thexe
 */
public class DetallesLibro extends JPanel {

    public DetallesLibro(ImageIcon imagen,String titulo, String descripcion) {
        setLayout(new BorderLayout());

        // Agrega etiquetas o componentes para mostrar la información detallada del libro
        JLabel labelImagen = new JLabel(imagen);
        JLabel labelTitulo = new JLabel("Título: " + titulo);
        JLabel labelDescripcion = new JLabel("Descripción: " + descripcion);
        
        
        add(labelImagen, BorderLayout.CENTER);
        add(labelTitulo, BorderLayout.NORTH);
        add(labelDescripcion, BorderLayout.CENTER);
    }

}
