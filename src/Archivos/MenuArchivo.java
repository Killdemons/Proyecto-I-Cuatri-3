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
            ArrayList compra = new ArrayList();
            compra.add(nombre);
            compra.add(cedula);
            compra.add(correo);
            compra.add(namedisc);
            compra.add(cantidad);
            compra.add(tipo);
            compra.add(actual);
            File archivo = new File("Compras.txt");
            FileWriter escribir = new FileWriter(archivo, true);
            BufferedWriter outStream = new BufferedWriter(escribir);
            for (int k = 0; k < compra.size(); k++) {
                outStream.write(compra.get(k).toString() + "-");
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
            ArrayList preorden = new ArrayList();
            preorden.add(username);
            preorden.add(correo);
            preorden.add(nombredisco);
            preorden.add(cantidad);
            preorden.add(costo);
            preorden.add(actual);
            preorden.add(tipo);
            File archivo = new File("Preordenes.txt");
            FileWriter escribir = new FileWriter(archivo, true);
            BufferedWriter outStream = new BufferedWriter(escribir);
            for (int k = 0; k < preorden.size(); k++) {
                outStream.write(preorden.get(k).toString() + "-");
            }
            outStream.close();
        } catch (IOException e) {
            System.out.println("No se ha podido registrar el archivo" + e);
        }
    }
    public static String search(){
        String inString = "";
        try {
            File archivo = new File("Preordenes.txt");
            FileReader leer = new FileReader(archivo);
            BufferedReader inStream = new BufferedReader(leer);
            inString = inStream.readLine();
            inStream.close();
        } catch (IOException e) {
            System.out.println("No se ha podido leer el archivo" + e);
        }
        return inString;
    }
    public static void regmod(ArrayList preorden){
        try {
            File archivo = new File("Preordenes.txt");
            archivo.delete();
            FileWriter escribir = new FileWriter(archivo, true);
            BufferedWriter outStream = new BufferedWriter(escribir);
            for (int k = 0; k < preorden.size(); k++) {
                outStream.write(preorden.get(k).toString() + "-");
            }
            outStream.close();
        } catch (IOException e) {
            System.out.println("No se ha podido registrar el archivo" + e);
        }
    }
}
