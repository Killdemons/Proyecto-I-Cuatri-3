package Archivos;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PeliculaArchivo {
    public static void registro(String nombredisco, String autor, String categoria, String precio, int cantidad) {
        try {
            ArrayList pelicula = new ArrayList();
            pelicula.add(nombredisco);
            pelicula.add(autor);
            pelicula.add(categoria);
            pelicula.add(precio);
            pelicula.add(cantidad);
            File archivo = new File("Peliculas.txt");
            FileWriter escribir = new FileWriter(archivo, true);
            BufferedWriter outStream = new BufferedWriter(escribir);
            for (int k = 0; k < pelicula.size(); k++) {
                outStream.write(pelicula.get(k).toString() + ",");
            }
            outStream.close();
            JOptionPane.showMessageDialog(null, "Agregado correctamente");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido registrar el archivo" + e);
        }
    }
}
