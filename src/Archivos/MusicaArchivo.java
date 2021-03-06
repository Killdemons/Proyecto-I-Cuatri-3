package Archivos;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MusicaArchivo {
    public static void registro(String nombredisco, String autor, String categoria, String precio, ArrayList canciones, int cantidad) {
        try {
            ArrayList musica = new ArrayList();
            musica.add(nombredisco);
            musica.add(autor);
            musica.add(categoria);
            musica.add(precio);
            musica.add(canciones);
            musica.add(cantidad);
            File archivo = new File("Musica.txt");
            FileWriter escribir = new FileWriter(archivo, true);
            BufferedWriter outStream = new BufferedWriter(escribir);
            for (int k = 0; k < musica.size(); k++) {
                outStream.write(musica.get(k).toString() + "-");
            }
            outStream.close();
            JOptionPane.showMessageDialog(null, "Agregado correctamente");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido registrar el archivo" + e);
        }
    }
    public String search() {
        String inString = "";
        try {
            File archivo = new File("Musica.txt");
            FileReader leer = new FileReader(archivo);
            BufferedReader inStream = new BufferedReader(leer);
            inString = inStream.readLine();
            inStream.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido leer el archivo" + e);
        }
        return inString;
    }
    public static void regmod(ArrayList musica) {
        try {
            File archivo = new File("Musica.txt");
            archivo.delete();
            FileWriter escribir = new FileWriter(archivo, true);
            BufferedWriter outStream = new BufferedWriter(escribir);
            for (int k = 0; k < musica.size(); k++) {
                outStream.write(musica.get(k).toString() + "-");
            }
            outStream.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido registrar el archivo" + e);
        }
    }
}
