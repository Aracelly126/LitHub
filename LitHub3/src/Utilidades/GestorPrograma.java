package Utilidades;

import BaseDatos.Almacen;
import BaseDatos.GestorBD;
import Clases.*;
import java.awt.HeadlessException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class GestorPrograma {

    private static GestorBD gestorBD = new GestorBD();

    private GestorPrograma() {

    }

    public static Usuario buscarUsuario(String correo) {
        for (Usuario usuario : Almacen.getInstance().usuarios) {
            if (usuario.getCorreo().equals(correo)) {
                return usuario;
            }
        }
        return null;
    }

    public static Libro buscarLibro(String codigo) {
        for (Libro libro : Almacen.getInstance().libros) {
            if (libro.getCodigo().equals(codigo)) {
                return libro;
            }
        }
        return null;
    }

    public static Favorito buscarFavorito(String codigo, String correo) {
        for (Favorito favorito : Almacen.getInstance().favoritos) {
            if (favorito.getCodigoLibro().equals(codigo) && favorito.getCorreoUsuario().equals(correo)) {
                return favorito;
            }
        }
        return null;
    }

    public static void agregarNuevoUsuario(String correo, String nombre, String apellido, String fecNac, String tipo, String pais, String contrasenia) {
        Usuario newUsuario = new Usuario(
                correo,
                nombre,
                apellido,
                Seguridad.Encriptar(contrasenia),
                pais,
                fecNac,
                tipo);
        gestorBD.insertarUsuario(newUsuario);
        Almacen.getInstance().usuarios.add(newUsuario);
    }

    public static void bloquearUsuario(String user) {
        gestorBD.cambiarClaveUsuario(user, Seguridad.Encriptar(generarCadenaNumAleatoria(10)));
    }

    public static String generarCadenaNumAleatoria(int longitud) {
        String caracteres = "0123456789";
        StringBuilder sb = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++) {
            int index = (int) (Math.random() * caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }

    public static String transformarFecha(String fechaOriginal) {// EEE MMM dd HH:mm:ss z yyyy to dd/MM/yyyy
        try {
            SimpleDateFormat formatoOriginal = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            Date fecha = formatoOriginal.parse(fechaOriginal);

            SimpleDateFormat formatoNuevo = new SimpleDateFormat("dd/MM/yyyy");
            return formatoNuevo.format(fecha);
        } catch (Exception e) {
            System.out.println("Error Metodo:transformarFecha Clase:GestorPrograma\n" + e);
            return null;
        }
    }

    public static Date transformarFechaInverso(String fechaOriginal) {
        try {
            SimpleDateFormat formatoOriginal = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formatoOriginal.parse(fechaOriginal + " 00:00:00");

            SimpleDateFormat formatoNuevo = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            String fechaFormateada = formatoNuevo.format(fecha);
            return formatoNuevo.parse(fechaFormateada);
        } catch (Exception e) {
            System.out.println("Error Metodo:transformarFechaInverso Clase:TuClase\n" + e);
            return null;
        }
    }

    public static String seleccionarImagen() {
        String rutaImagen = "";
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setDialogTitle("Seleccionar imagen de portada");
            FileNameExtensionFilter filtrado = new FileNameExtensionFilter("Solo archivos .PNG .JPG", "png", "jpg");
            jFileChooser.setFileFilter(filtrado);

            int opcion = jFileChooser.showOpenDialog(null);

            if (opcion != JFileChooser.APPROVE_OPTION) {
                //JOptionPane.showMessageDialog(null, "Tienes que elegir una imagen\nOperacion cancelada");
                return "";
            }
            rutaImagen = jFileChooser.getSelectedFile().getPath();
        } catch (HeadlessException e) {
            System.out.println("Error Metodo:seleccionarImagen Clase:GestorPrograma\n" + e);
        }
        return rutaImagen;
    }

    public static String seleccionarPDF() {
        String rutaPDF = "";
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setDialogTitle("Seleccionar archivo PDF");
            FileNameExtensionFilter filtrado = new FileNameExtensionFilter("Archivos PDF", "pdf");
            jFileChooser.setFileFilter(filtrado);

            int opcion = jFileChooser.showOpenDialog(null);

            if (opcion != JFileChooser.APPROVE_OPTION) {
                return "";
            }

            rutaPDF = jFileChooser.getSelectedFile().getPath();
        } catch (HeadlessException e) {
            System.out.println("Error Metodo:seleccionarPdf Clase:GestorPrograma\n" + e);
        }
        return rutaPDF;
    }

    public static void almacenarPortadaLibro(String urlImagen, String nombreArchivoDestino) {
        try {
            Path origenPath = Paths.get(urlImagen);
            Path destinoPath = Paths.get("SYSTEM/libros/", nombreArchivoDestino);

            // Verificar si ya existe un archivo con el mismo nombre en la carpeta destino
            if (Files.exists(destinoPath)) {
                // Si existe, eliminar el archivo anterior
                Files.delete(destinoPath);
                System.out.println("Archivo anterior eliminado: " + destinoPath.toString());
            }

            // Copiar el archivo a la carpeta destino
            Files.copy(origenPath, destinoPath);

            System.out.println("Imagen almacenada con éxito en: " + destinoPath.toString());
        } catch (Exception e) {
            System.out.println("Error Metodo:almacenarImagen Clase:GestorPrograma urlImagen:" + urlImagen + "\n" + e);
        }
    }

    public static void almacenarPDF(String rutaPDF, String nombreArchivoDestino) {
        try {
            Path origenPath = Paths.get(rutaPDF);
            Path destinoPath = Paths.get("SYSTEM/libros/", nombreArchivoDestino);

            Files.copy(origenPath, destinoPath);

            System.out.println("PDF almacenado con éxito en: " + destinoPath.toString());
        } catch (Exception e) {
            System.out.println("Error Metodo:almacenarPDF Clase:GestorPrograma rutaPDF:" + rutaPDF + "\n" + e);
        }
    }

    public static void eliminarImagen(String nombreArchivo) {
        try {
            Path path = Paths.get("SYSTEM/libros/", nombreArchivo);
            Files.deleteIfExists(path);

            System.out.println("Imagen eliminada con éxito: " + path.toString());
        } catch (Exception e) {
            System.out.println("Error en el Método: eliminarImagen Clase: GestorPrograma nombreArchivo:" + nombreArchivo + "\n" + e);
        }
    }

    public static void eliminarPDF(String nombreArchivo) {
        try {
            Path path = Paths.get("SYSTEM/libros/", nombreArchivo);

            // Eliminar el archivo de la carpeta destino
            Files.deleteIfExists(path);

            System.out.println("PDF eliminado con éxito: " + path.toString());
        } catch (Exception e) {
            System.out.println("Error en el Método: eliminarPDF Clase: GestorPrograma nombreArchivo:" + nombreArchivo + "\n" + e);
        }
    }

    public static void eliminarFavoritosPorLibro(String codigoLibro) {
        ArrayList<Favorito> nuevosFavoritos = new ArrayList<>();

        for (Favorito favorito : Almacen.getInstance().favoritos) {
            if (!favorito.getCodigoLibro().equals(codigoLibro)) {
                nuevosFavoritos.add(favorito);
            }
        }

        // Asignar la nueva lista de favoritos a la lista principal
        Almacen.getInstance().favoritos = nuevosFavoritos;

        System.out.println("Favoritos asociados al libro con código " + codigoLibro + " eliminados del almacen.");
    }

    public static void eliminarLibrosPorAutor(String correo) {
        ArrayList<Libro> nuevosLibros = new ArrayList<>();

        for (Libro libro : Almacen.getInstance().libros) {
            if (!libro.getCorreoUsu().equals(correo)) {
                nuevosLibros.add(libro);
            }

        }

        Almacen.getInstance().libros = nuevosLibros;

    }

    public static void almacenarImagenUsuarios(String urlImagen, String nombreArchivoDestino) {
        try {
            Path origenPath = Paths.get(urlImagen);
            Path destinoPath = Paths.get("SYSTEM/usuarios/", nombreArchivoDestino);

            // Verificar si ya existe un archivo con el mismo nombre en la carpeta destino
            if (Files.exists(destinoPath)) {
                // Si existe, eliminar el archivo anterior
                Files.delete(destinoPath);
                System.out.println("Archivo anterior eliminado: " + destinoPath.toString());
            }

            // Copiar el nuevo archivo a la carpeta destino
            Files.copy(origenPath, destinoPath);

            System.out.println("Imagen almacenada con éxito en: " + destinoPath.toString());
        } catch (Exception e) {
            System.out.println("Error Metodo:almacenarImagen Clase:GestorPrograma urlImagen:" + urlImagen + "\n" + e);
        }
    }

    public static void abrirPDF(String rutaArchivo) {
        try {
            File archivoPDF = new File(rutaArchivo);
            if (archivoPDF.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(archivoPDF);
                } else {
                    System.out.println("No se puede abrir el archivo PDF, el escritorio no es compatible.");
                }
            } else {
                System.out.println("El archivo no existe.");
            }
        } catch (IOException ex) {
            System.out.println("Error al abrir el archivo PDF: " + ex.getMessage());
        }
    }

    public static void eliminarLibro(String codigo) {
        for (int i = 0; i < Almacen.getInstance().libros.size(); i++) {
            if (Almacen.getInstance().libros.get(i).getCodigo().equals(codigo)) {
                Almacen.getInstance().libros.remove(i);
                break;
            }
        }

    }

    public static void actualizarUsuario(Usuario nuevoUsuario) {
        // Iterar sobre la lista de usuarios
        for (int i = 0; i < Almacen.getInstance().usuarios.size(); i++) {
            Usuario usuarioActual = Almacen.getInstance().usuarios.get(i);

            // Verificar si el correo del usuario actual es igual al correo del nuevo usuario
            if (usuarioActual.getCorreo().equals(nuevoUsuario.getCorreo())) {
                // Reemplazar el usuario antiguo con el nuevo usuario
                Almacen.getInstance().usuarios.set(i, nuevoUsuario);

                JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito.");
                return; // Salir del bucle una vez actualizado
            }
        }
    }

    public static void actualizarLibro(Libro nuevoLibro) {
        // Iterar sobre la lista de libros
        for (int i = 0; i < Almacen.getInstance().libros.size(); i++) {
            Libro libroActual = Almacen.getInstance().libros.get(i);

            // Verificar si el código del libro actual es igual al código del nuevo libro
            if (libroActual.getCodigo().equals(nuevoLibro.getCodigo())) {
                // Reemplazar el libro antiguo con el nuevo libro
                Almacen.getInstance().libros.set(i, nuevoLibro);

                JOptionPane.showMessageDialog(null, "Libro actualizado con éxito.");
                return; // Salir del bucle una vez actualizado
            }
        }
    }

}
