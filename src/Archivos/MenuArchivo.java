package Archivos;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MenuArchivo {
    public static void compras(String nombre, String cedula, String correo, String namedisc, int cantidad, String tipo) {
        try {
            Date fecha = new Date();
            String actual = new SimpleDateFormat("dd/MM/yyyy").format(fecha);
            ArrayList musica = new ArrayList();
            musica.add(nombre);
            musica.add(cedula);
            musica.add(correo);
            musica.add(namedisc);
            musica.add(cantidad);
            musica.add(tipo);
            musica.add(actual);
            File archivo = new File("Compras.txt");
            FileWriter escribir = new FileWriter(archivo, true);
            BufferedWriter outStream = new BufferedWriter(escribir);
            for (int k = 0; k < musica.size(); k++) {
                outStream.write(musica.get(k).toString() + "-");
            }
            outStream.close();
        } catch (IOException e) {
            System.out.println("No se ha podido registrar el archivo" + e);
        }
    }
    public static void preorden(String username,String correo, String nombredisco, String tipo, int cantidad, int costo) {
        try {
            Date fecha = new Date();
            String actual = new SimpleDateFormat("dd/MM/yyyy").format(fecha);
            ArrayList musica = new ArrayList();
            musica.add(username);
            musica.add(correo);
            musica.add(nombredisco);
            musica.add(cantidad);
            musica.add(costo);
            musica.add(actual);
            musica.add(tipo);
            File archivo = new File("Preordenes.txt");
            FileWriter escribir = new FileWriter(archivo, true);
            BufferedWriter outStream = new BufferedWriter(escribir);
            for (int k = 0; k < musica.size(); k++) {
                outStream.write(musica.get(k).toString() + "-");
            }
            outStream.close();
        } catch (IOException e) {
            System.out.println("No se ha podido registrar el archivo" + e);
        }
    }   
}
